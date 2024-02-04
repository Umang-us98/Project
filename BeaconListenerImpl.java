import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class BeaconListenerImpl extends java.rmi.server.UnicastRemoteObject implements BeaconListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static HashMap<Integer, TimerTask> hashmap = new HashMap<Integer, TimerTask>();
    static int[] array1 = new int[20000];
    static ArrayList<Integer> ch = new ArrayList<Integer>(100);

    public BeaconListenerImpl(HashMap<Integer, TimerTask> hash, ArrayList<Integer> l ) throws java.rmi.RemoteException
    {
        setBulb(false);
         hashmap = hash;
         ch = l;
    }

    private boolean lightOn;
    private int count;
    private boolean flag;

    public void on() throws java.rmi.RemoteException { setBulb(true); }

    public void off() throws java.rmi.RemoteException { setBulb(false); }
    public boolean isOn() throws java.rmi.RemoteException { return getBulb(); }
    public void setBulb(boolean value) { lightOn = value; }
    public boolean getBulb() { return lightOn; }
    public void setCount() throws java.rmi.RemoteException{
    	count = 0;
    }
    public int deposit(Beacon b){
    	
    	// System.out.println("Beacon Time "+b.time);
    	// System.out.println("Check Time " + (int)System.currentTimeMillis()/1000);
    	check(b.id);
    	return count;
 }
 public boolean check(int s){
 			
			if(!ch.contains(s)){
				Timer timer = new Timer(); // creating timer
      			TimerTask task = new MyTask(s); // creating timer task
      			timer.schedule(task, 15*1000);
 				hashmap.put(s, task);
 				if(array1[s]==-1) {
  				System.out.println("AGENT Resurrected");
  				flag = false;
  				count++;
  				}
  				else{
  					System.out.println("A new agent");
  					System.out.println("Id of Agent:" + s);
  					System.out.println("GetLocalOs: " + (int)System.currentTimeMillis()/1000);
  					System.out.println("GetVersion: MacOsX");
  					count = 0;
  				}
  				array1[s]=0;
				ch.add(s);
				flag = true;
				count++;
				
			}
			else{
				hashmap.get(s).cancel();
      			Timer timer = new Timer(); // creating timer
      			TimerTask task = new MyTask(s); // creating timer task
      			timer.schedule(task, 15*1000);
 				hashmap.put(s, task);

				System.out.println("Already exists");
				flag = false;
				count++;
			}
			return flag;
	}


	static class MyTask extends TimerTask {
	int s;
	MyTask(int s) {
	this.s = s;
}
   public void run() {
   	array1[s] = -1;
      System.out.println("Agent Died, Of that Agent was "+ s);
      ch.remove(ch.indexOf(s));
   }
}
}













