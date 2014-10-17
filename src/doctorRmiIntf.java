import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface doctorRmiIntf extends Remote {
	public void refIntegrity(Patient obj, Patient obj1) throws RemoteException;
	public Map<String, String> provideDocsInfo(Patient i) throws RemoteException;
	public Map<String, String> provideRushDocsInfo() throws RemoteException;
	public Map<String, String> provideUIDocsInfo() throws RemoteException;
	public Map<String, String> provideStrogerDocsInfo() throws RemoteException;
	
}
