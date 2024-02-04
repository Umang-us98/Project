import java.rmi.*;
import java.util.Random;

public class Agent 
{
    public static void main(String args[])
    {
        try
        {


        	String registry = "localhost";
            String registration = "rmi://" + registry + "/BeaconListener";
            Remote remoteService = Naming.lookup( registration );
        	BeaconListener bulbService = (BeaconListener) remoteService;
        	//bulbService.setCount();
        	// Random rand = new Random();
        	// int id = rand.nextInt(1000)+2000;
        	//for(;;){
            
            
            // bulbService.on();
            // System.out.println("Bulb State: " + bulbService.isOn());
            // bulbService.off();
            // System.out.println("Bulb State: " + bulbService.isOn());
            Random rand = new Random();
            int i = rand.nextInt(2000)+1000;
            while(true){
            	int currentTime = (int)System.currentTimeMillis()/1000;
            	//System.out.println("time when Beacon was sent " + currentTime);
            	Beacon b = new Beacon(i, currentTime);
         	    System.out.println("Count ="+ bulbService.deposit(b));
         	    java.util.concurrent.TimeUnit.SECONDS.sleep(3);

        }
            //
        	//}

        }
        catch(Exception e)
        {
            System.out.println("Error - " + e);
        }
    }
}
// class cmdAgent extends Thread{
// 	public void run(){

// 	}
// }
