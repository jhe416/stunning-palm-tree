package stunning.palm.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Cache {
    Map<String, Map<String, Data>> cacheMap = new HashMap<>();
    TreeMap<Integer, Map<String, Map<String, Data>>> backup = new TreeMap<>();

    public int backup(int timestamp) {
        int res = 0;
        Map<String, Map<String, Data>> newCacheMap = new HashMap<>();
        for (Map.Entry<String, Map<String, Data>> entry : cacheMap.entrySet()) {
            String key = entry.getKey();
            Map<String, Data> backupMap = new HashMap<>();
            for(var dataEntry : entry.getValue().entrySet()) {
                String dataKey = dataEntry.getKey();
                Data dataValue = dataEntry.getValue();
                if (dataValue.expiresAt != null && dataValue.expiresAt <= timestamp) {
                    continue;
                }
                backupMap.put(dataKey, new Data(dataValue.value, dataValue.expiresAt));
                res++;
            }
            newCacheMap.put(key, backupMap);
        }

        backup.put(timestamp, newCacheMap);
        return res;
    }

    public void restore(int timestamp, int oldTimestampString) {
        int floorKey = backup.floorKey(oldTimestampString);
        Map<String, Map<String, Data>> map = backup.get(floorKey);
        for (Map.Entry<String, Map<String, Data>> entry : map.entrySet()) {
            Map<String, Data> dataMap = entry.getValue();
            for (Map.Entry<String, Data> dataEntry : dataMap.entrySet()) {
                Data dataValue = dataEntry.getValue();
                if (dataValue.expiresAt != null) {
                    dataValue.expiresAt = (dataValue.expiresAt - floorKey) + timestamp;
                }
            }
        }
        cacheMap = map;
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.cacheMap.put("A", new HashMap<>());
        cache.cacheMap.get("A").put("D", new Data("E", 4));

        int backupTime = 3;
        int size = cache.backup(backupTime);
        System.out.println("Backup size at time " + backupTime + ": " + size);

        cache.cacheMap.get("A").put("B", new Data("C", 11));

        backupTime = 5;
        size = cache.backup(backupTime);
        System.out.println("Backup size at time " + backupTime + ": " + size);

        cache.restore(10, 4);
        cache.cacheMap.forEach((k, v) -> {
            v.forEach((dataKey, dataValue) -> {
                System.out.println("Key: " + k + ", Data Key: " + dataKey + ", Value: " + dataValue.value + ", Expires At: " + dataValue.expiresAt);
            });
        });

    }
}

class Data {
    String value;
    Integer expiresAt;

    public Data(String value, Integer expiresAt) {
        this.value = value;
        this.expiresAt = expiresAt;
    }
}
