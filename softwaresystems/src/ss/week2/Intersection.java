package ss.week2;


public class Intersection {
	TrafficSignalecht east_west;
	TrafficSignalecht north_south;

public Intersection() {
	east_west = new TrafficSignalecht();
	north_south = new TrafficSignalecht(); 
	north_south.change();
	north_south.change();
}

public TrafficSignalecht.state getColorNS() {
	return north_south.light();
}
public TrafficSignalecht.state getColorEW() {
	return east_west.light();
}

public void changes() {
	if(north_south.light() == TrafficSignalecht.state.GREEN) {
		north_south.change();
	}
	else if(east_west.light() == TrafficSignalecht.state.GREEN) { 
		east_west.change();
	}
	else {
		north_south.change();
		east_west.change();
	}
	System.out.println("north south light:" + north_south.light());
	System.out.println("east west light:" + east_west.light());
	System.out.println("-----------------------");
}
}