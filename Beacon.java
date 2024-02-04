import java.io.Serializable;

public class Beacon implements Serializable{
	int id, time;
	Beacon(int identity, int lastTime){
		id = identity;
		time = lastTime;
	}
}