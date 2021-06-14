package stunning.palm.tree.o;

public class StopIntersactionSystem {
	public StopIntersactionSystem() {}
	
	int state = 0; // four states: North South, North South left turn, East West, East West left turn;
	Lights[] trafficLights = new Lights[] {Lights.GREEN, Lights.YELLOW, Lights.RED}; //traffic lights sequence
	Lights[] leftTurnLights = new Lights[] {Lights.GREEN_LEFT, Lights.RED};
	
	//four lights horizontal and vertical
	//eight Pedestrian lights
	int nsl=0; // two lights
	int wel=2; // two lights
	int nsll=1; // two left turn lights
	int well=1; // two let turn lights
	
	public void run() throws InterruptedException {
		while(true) {
			display();
		}
	}

	private void display() throws InterruptedException {
		//north south lights, vertical
		System.out.println(String.format("North traffic light is %s", trafficLights[nsl].getName()));
		System.out.println(String.format("South traffic light is %s", trafficLights[nsl].getName()));
		//Pedestrian lights
		System.out.println(String.format("North Pedestrian traffic lights are %s", !trafficLights[nsl].getName().equals("RED")? "GREEN" : "RED"));
		System.out.println(String.format("South Pedestrian traffic lights are %s", !trafficLights[nsl].getName().equals("RED")? "GREEN" : "RED"));
		//left turn lights vertical
		System.out.println(String.format("North traffic left turn light is %s", leftTurnLights[nsll].getName()));
		System.out.println(String.format("South traffic left turn light is %s", leftTurnLights[nsll].getName()));
		
		//west east lights, horizontal. 
		System.out.println(String.format("West traffic light is %s", trafficLights[wel].getName()));
		System.out.println(String.format("East traffic light is %s", trafficLights[wel].getName()));
		//Pedestrian lights
		System.out.println(String.format("West Pedestrian traffic lights are %s", !trafficLights[wel].getName().equals("RED")? "GREEN" : "RED"));
		System.out.println(String.format("East Pedestrian traffic lights are %s", !trafficLights[wel].getName().equals("RED")? "GREEN" : "RED"));	
		//left turn lights horizontal
		System.out.println(String.format("West traffic left turn light is %s", leftTurnLights[well].getName()));
		System.out.println(String.format("East traffic left turn light is %s", leftTurnLights[well].getName()));
	
		
		System.out.println(System.lineSeparator());
		stateChange();
	}

	private void stateChange() throws InterruptedException {
		switch(state) {
		case 0: //north south light
			if(trafficLights[nsl] != Lights.RED) Thread.sleep(trafficLights[nsl].getValue()*1000);
			nsl = (nsl+1) % 3;
			if(trafficLights[nsl] == Lights.RED) {
				state = (state+1)%4;
				nsll = (nsll+1) %2;
			}
			break;
		case 1: //north south left turn lights
			if(leftTurnLights[nsll] != Lights.RED) Thread.sleep(leftTurnLights[nsll].getValue()*1000);
			nsll = (nsll+1) %2;
				if(leftTurnLights[nsll] == Lights.RED) {
					state = (state+1)%4;
					wel = (wel+1) %3;
				}			
			break;
		case 2: //west east light
			if(trafficLights[wel] != Lights.RED) Thread.sleep(trafficLights[wel].getValue()*1000);
			wel = (wel+1) % 3;
			if(trafficLights[wel] == Lights.RED) {
				state = (state+1)%4;
				well = (well+1) %2;
			}			
			break;
		case 3: //west east left turn lights
			if(leftTurnLights[well] != Lights.RED) Thread.sleep(leftTurnLights[well].getValue()*1000);
			well = (well+1) %2;
			if(leftTurnLights[well] == Lights.RED) {
				state = (state+1)%4;
				nsl = (nsl+1) %3;
			}				
			break;
		}
	}
	
	public static void main(String[] args) {
		StopIntersactionSystem sol = new StopIntersactionSystem();
		try {
			sol.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

enum Lights{
	GREEN(30,"GREEN"),
	GREEN_LEFT(15,"GREEN"),
	YELLOW(5,"YELLOW"),
	RED(0,"RED");
	
	int time_out;
	String name;
	Lights(int time_out) {
		this.time_out=time_out;
	}
	
	Lights(int time_out,String name){
		this.time_out = time_out;
		this.name = name;
	}
	
	public int getValue() {
		return this.time_out;
	}
	
	public String getName() {
		return this.name;
	}
}


