import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class doctor extends UnicastRemoteObject implements doctorRmiIntf {
    private static final long serialVersionUID = 1L;
    
    private Map<String, String> docMap= new HashMap<String, String>();    
	
    protected doctor() throws RemoteException{
	    super();
    }
    
	/*
	 * Checks patient's choice:
	 * If 1, Stroger associated doctors info is being requested 
	 * If 2, Rush associated doctors info is being requested 
	 * If 3, UI associated doctors info is being requested  
	 * */
	public Map<String, String> provideDocsInfo(Patient k){
        //String choiceUnivDoc = hospObj.hospGetChoice();
		if (k.getChoice().equals("3")){
		    this.docMap = provideUIDocsInfo();
	    }
		else if (k.getChoice().equals("2")){
            this.docMap = provideRushDocsInfo();
		}
		else if (k.getChoice().equals("1")){
            this.docMap = provideStrogerDocsInfo();
		}
		return docMap;
	}
	
	
	public Map<String, String> provideRushDocsInfo(){
        Map<String, String> rushMap= new HashMap<String, String>();
        rushMap.put("Chase Secrest", "Cardiology");
        rushMap.put("Arnette Cockrum", "Neurology");
        rushMap.put("Aisha Nuss", "Orthopedics");
        rushMap.put("Homer Sturgis", "Psychiatry");
        rushMap.put("Lane Mccleskey", "Pulmonology");
        rushMap.put("Margherita Tancredi", "Orthopedics");
        rushMap.put("Janae Neff", "Pulmonology");
        rushMap.put("Corazon Rexrode", "Neurology");
        return rushMap;
	}
	
	public Map<String, String> provideUIDocsInfo(){
        Map<String, String> uiMap = new HashMap<String, String>();
        uiMap.put("Clorinda Blankenbaker", "Neurology");
        uiMap.put("Dewitt Kelemen", "Orthopedics");
        uiMap.put("Teresita Spence", "Psychiatry");
        uiMap.put("Kathern Lorentzen", "Pulmonology");
        uiMap.put("Frida Pollman", "Orthopedics");
        uiMap.put("Brain Swanner", "Cardiology");
        uiMap.put("Eva Littlejohn", "Orthopedics");
        uiMap.put("Cora Metzger", "Psychiatry");
        return uiMap;
	}
	
	public Map<String, String> provideStrogerDocsInfo(){
        Map<String, String> strogerMap = new HashMap<String, String>();
        strogerMap.put("Cinthia Stickler", "Neurology");
        strogerMap.put("Terry Hertz", "Pulmonology");
        strogerMap.put("Anh Sonnier", "Psychiatry");
        strogerMap.put("Marvella Tiemann", "Cardiology");
        strogerMap.put("Dannielle Chafin", "Orthopedics");
        strogerMap.put("Dana Lykes", "Pulmonology");
        strogerMap.put("Gretchen Deaner", "Neurology");
        return strogerMap;
	}
    
	public static void main(String[] args)throws Exception {
		doctor docObj = new doctor();
		Naming.rebind("doctorObj", docObj);
		System.out.println("rmi object bound to the name 'doctorObj' and is ready for use");

	}



	/* 
	 * Referencial integrity check:
	 * ---------------------------
	 * Printing to verify if Patient object's id 
	 * pointed by the both references in the argument is same
	 * */
	public void refIntegrity(Patient obj, Patient obj1) throws RemoteException {
		System.out.println("Referential Integrity:");
		System.out.println("---------------------");
		System.out.println("First Reference object id"+System.identityHashCode(obj));
		System.out.println("Second reference object id"+System.identityHashCode(obj1));
		
	}

}
