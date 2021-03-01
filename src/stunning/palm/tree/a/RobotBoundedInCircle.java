package stunning.palm.tree.a;

/*
 * use degree to track directions and if pos return to 0 or the direction not pointing to north (0) return true;
 * otherwise false;
 * 
 * Time O(n)
 * space constant
 */
public class RobotBoundedInCircle {
	public RobotBoundedInCircle() {}

	public boolean isRobotBounded(String instructions) {
		int[] pos = {0,0};

		int direction = 0;

		for(int i=0;i<instructions.length();i++){
			if(instructions.charAt(i) == 'G'){
				if(direction == 0){
					pos[1]++;
				}else if(direction == 90){
					pos[0]++;
				}else if(direction == -90){
					pos[0]--;
				}else if(direction == 180){
					pos[1]--;
				}else if(direction == -180){
					pos[1]--;
				}else if(direction == 270){
					pos[0]--;
				}else if(direction == -270){
					pos[0]++;
				}
			}else if(instructions.charAt(i) == 'L'){
				direction = (direction-90) % 360;
			}else{
				direction = (direction+90) % 360;
			}
		}

		return (pos[0] == 0 && pos[0] == pos[1]) || direction != 0;
	}
}
