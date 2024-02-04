import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BeaconListener extends java.rmi.Remote
{
    public void on() throws java.rmi.RemoteException;
    public void off() throws java.rmi.RemoteException;
    public boolean isOn() throws java.rmi.RemoteException;
    public void setCount() throws java.rmi.RemoteException;
    public int deposit(Beacon b) throws java.rmi.RemoteException;
}