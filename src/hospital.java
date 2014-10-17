import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//import java.rmi.registry.*;
import java.util.*;

public class hospital extends UnicastRemoteObject implements hospitalRmiIntf{
    private static final long serialVersionUID = 1L;
    private Map<String, String> hospList = new HashMap<String, String>();
    private String choice;
    
    protected hospital() throws RemoteException{
	    super();
    }
	
	public void hospSetChoice(String a){
		this.choice = a;
	}
	
	public String hospGetChoice(){
		return this.choice;
	}
	
	/*
	 * Patient's hospital choice is passed wrapped in the patient object for the
	 * insurance companies info
	 * */
	public Map<String, String> getInsurCompInfo(Patient y)throws Exception{
		Map<String, String> insurInfo = new HashMap<String, String>();
		String url = new String("rmi://localhost/insuranceObj");
	    insuranceRmiIntf insurStubObj = (insuranceRmiIntf)Naming.lookup(url);
	    insurInfo = insurStubObj.provideInsurInfo(y);
		return insurInfo;	
	}	
	
	/*
	 * List of available hospitals
	 * */
	public Map<String, String> displayHospitals(){
		//Map<String, String> hospList = new HashMap<String, String>();
        this.hospList.put("UI Hospital", "722 W Maxwell St, Chicago, IL 60607");
        this.hospList.put("Rush Hospital", "1620 W Harrison St, Chicago, IL");
        this.hospList.put("Stroger Hospital","1969 W Ogden Ave Chicago, IL 60612");
		return hospList;
	}
	
	/*
	 * Patient's hospital choice is being passed wrapped in the patient object
	 * to retrieve respective hospital's doctors info
	 * */
	public Map<String, String> getDoctorsInfo(Patient k)throws Exception{
		Map<String, String> docsInfo = new HashMap<String, String>();
		String url = new String("rmi://localhost/doctorObj");
	    doctorRmiIntf doctorStubObj = (doctorRmiIntf)Naming.lookup(url);
	    docsInfo = doctorStubObj.provideDocsInfo(k);
		return docsInfo;
    }

	public static void main(String[] args)throws Exception {
		hospital hospObj = new hospital();
		Naming.rebind("hospitalObj", hospObj);
		System.out.println("rmi object bound to the name 'hospitalObj' and is ready for use");

	}

}
