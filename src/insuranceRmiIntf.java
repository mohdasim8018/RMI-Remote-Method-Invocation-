import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface insuranceRmiIntf extends Remote{
	public Map<String, String> provideInsurInfo(Patient m) throws RemoteException;
	public Map<String, String> provideRushInsuranceInfo() throws RemoteException;
	public Map<String, String> provideUIInsuranceInfo() throws RemoteException;
	public Map<String, String> provideStrogerInsuranceInfo() throws RemoteException;
}
