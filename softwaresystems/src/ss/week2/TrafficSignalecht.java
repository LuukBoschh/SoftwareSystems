package ss.week2;

public class TrafficSignalecht {
public enum state {GREEN, ORANGE, RED};
private state light;


public TrafficSignalecht () {
	light = TrafficSignalecht.state.GREEN;
}

public state light () {
	return light;
	
}

public void change () {
	switch(light){
		case GREEN:
			light = TrafficSignalecht.state.ORANGE;
			break;
		case ORANGE:
			light = TrafficSignalecht.state.RED;
			break;
		case RED:
			light = TrafficSignalecht.state.GREEN;
			break;
	}
}
}
