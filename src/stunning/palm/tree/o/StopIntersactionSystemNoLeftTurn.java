package stunning.palm.tree.o;

public class StopIntersactionSystemNoLeftTurn {
	public StopIntersactionSystemNoLeftTurn() {}
	Lights[] lights = new Lights[] {Lights.GREEN,Lights.YELLOW,Lights.RED};
	int nsl = 0;
	int wel = 2;
	int state =0;
	
	public void display() throws Exception{
		System.out.println(String.format("North traffic light is %s", lights[nsl].getName()));
		System.out.println(String.format("North pedestrian traffic light is %s", lights[nsl] == Lights.RED? lights[nsl].getName() : "GREEN"));
		System.out.println(String.format("South traffic light is %s", lights[nsl].getName()));
		System.out.println(String.format("South pedestrian traffic light is %s", lights[nsl] == Lights.RED? lights[nsl].getName() : "GREEN"));
		
		System.out.println(String.format("West traffic light is %s", lights[wel].getName()));
		System.out.println(String.format("West pedestrian traffic light is %s", lights[wel] == Lights.RED? lights[wel].getName() : "GREEN"));
		System.out.println(String.format("East traffic light is %s", lights[wel].getName()));
		System.out.println(String.format("East pedestrian traffic light is %s", lights[wel] == Lights.RED? lights[wel].getName() : "GREEN"));
		System.out.println(System.lineSeparator());
		
		stateChange();
	}
	
	public void stateChange() throws Exception{
		switch(state) {
		case 0:
			if(lights[nsl] != Lights.RED) Thread.sleep(1000*lights[nsl].getValue()); 
			nsl = (nsl+1)%3;
			if(lights[nsl] == Lights.RED) {
				wel = (wel+1)%3;
				state = (state+1)%2;
			}
			break;
		case 1:
			if(lights[wel] != Lights.RED) Thread.sleep(1000*lights[wel].getValue()); 
			wel = (wel+1)%3;
			if(lights[wel] == Lights.RED) {
				nsl = (nsl+1)%3;
				state = (state+1)%2;
			}			
			break;
		}
	}
	
	public void run() throws Exception {
		while(true) {
			display();
		}
	}
	
	public static void main(String[] args) throws Exception {
		StopIntersactionSystemNoLeftTurn sol = new StopIntersactionSystemNoLeftTurn();
		sol.run();
	}
}
