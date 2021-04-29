package stunning.palm.tree.f;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
	public RobotRoomCleaner() {}
	
    Set<String> visited = new HashSet<>();
    //up,right,down,left
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    Robot robot;
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        helper(0,0,0);
    }
    
    private void helper(int i, int j, int d){
        robot.clean();
        visited.add(i+","+j);
        
        for(int k=0;k<4;k++){
            int newd = (d+k)%4;
            String key = i+dirs[newd][0] + "," + (j+dirs[newd][1]);
            if(!visited.contains(key) && robot.move()){
                helper(i+dirs[newd][0], j+dirs[newd][1], newd);
                goBack();
            }
            robot.turnRight();
        }
    }
    
    private void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

interface Robot{
	public void turnRight();
	public void turnLeft();
	public boolean move();
	public void clean();
}
