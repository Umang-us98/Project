import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.HashMap;

public class Manager
{
	static HashMap<Integer, TimerTask> hashmap = new HashMap<Integer, TimerTask>();
	static ArrayList<Integer> l = new ArrayList<>();
    public static void main(String args[])
    {
        try
        {	

            BeaconListenerImpl bulbService = new BeaconListenerImpl(hashmap, l);
            RemoteRef location = bulbService.getRef();
            System.out.println(location.remoteToString());
            bulbService.setCount();
            String registry = "localhost";
            if (args.length >= 1)
            {
                registry = args[0];
            }
            String registration = "rmi://" + registry + "/BeaconListener";

            Naming.rebind(registration, bulbService);
        }
        catch(Exception e)
        {
            System.err.println("Error - " + e);
        }
    }
    public native void execute();
}

// class Monitor extends Thread{
// 	boolean flag;
// 	public void run(){
		
// 	}
// }