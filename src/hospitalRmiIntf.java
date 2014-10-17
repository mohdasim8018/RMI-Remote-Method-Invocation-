import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface hospitalRmiIntf extends Remote{

	public Map<String, String> displayHospitals() throws RemoteException;
	public Map<String, String> getDoctorsInfo(Patient x) throws Exception;
	public Map<String, String> getInsurCompInfo(Patient y) throws Exception;
}