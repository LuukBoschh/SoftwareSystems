package ss.week2;

public class TrafficSignal {
public enum state {OFF,LOW, MEDIUM, HIGH};
public state light;

// @ensures light() == OFF;
public TrafficSignal () {
	light = TrafficSignal.state.OFF;
}

/* @ensures 
  this.light() == TrafficSignal.OFF || 
  this.light() == TrafficSignal.LOW ||
  this.light() == TrafficSignal.MEDIUM ||
  this.light() == TrafficSignal.HIGH; 
  */;
public state light () {
	return light;
	
}
/*
 @ensures this.light() == OFF ==> \old(this.light()) == HIGH
          this.light() == LOW ==> \old(this.light()) == OFF
          this.light() == MEDIUM ==> \old(this.light()) == LOW
          this.light() == HIGH ==> \old(this.light()) == MEDIUM
*/
public void change () {
	switch(light){
		case OFF:
			light = TrafficSignal.state.LOW;
			break;
		case LOW:
			light = TrafficSignal.state.MEDIUM;
			break;
		case MEDIUM:
			light = TrafficSignal.state.HIGH;
			break;
		case HIGH:
			light = TrafficSignal.state.OFF;
			break;
	}
}
}
