import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class insuranceCompany extends UnicastRemoteObject implements insuranceRmiIntf {
	private static final long serialVersionUID = 1L;
	private Map<String, String> insurMap = new HashMap<String, String>(); 
	
	protected insuranceCompany() throws RemoteException {
		super();
	}

	
	/*
	 * Checks patient's choice:
	 * If 1, Stroger associated insurance companies info is being requested 
	 * If 2, Rush associated insurance companies info is being requested 
	 * If 3, UI associated insurance companies info is being requested  
	 * */
	public Map<String, String> provideInsurInfo(Patient m){
		if (m.getChoice().equals("1")){
		    this.insurMap = provideStrogerInsuranceInfo();
	    }
		else if (m.getChoice().equals("2")){
            this.insurMap = provideRushInsuranceInfo();
		}
		else if (m.getChoice().equals("3")){
            this.insurMap = provideUIInsuranceInfo();
		}	
		return insurMap;
	}
	
	/*
	 * List of insurance companies associated with Rush 
	 * */
	public Map<String, String> provideRushInsuranceInfo(){
	    Map<String, String> strogerInsurMap = new HashMap<String, String>();
	    strogerInsurMap.put("Bills Insurance Inc", "West Harrison street");
	    strogerInsurMap.put("AAA Chicago", "2121 N. Clybourn");
	    strogerInsurMap.put("AAA Chicago", "307 N. Michigan Ave");
	    strogerInsurMap.put("American Income Life", "22 W. Washington St");
	    strogerInsurMap.put("Anderson Insurance Inc.", "3542 W Montrose Ave");
	    strogerInsurMap.put("Aon Re Worldwide", "200 E Randolph St");
	    strogerInsurMap.put("Bin Insurance", "30 N LaSalle Suite 2500 ");
	    strogerInsurMap.put("Chicago Title", "10 S LaSalle St");
	    strogerInsurMap.put("Combined Insurance", "PO Box 91003");
	    strogerInsurMap.put("E-Insure Inc", "105 W Adams St STE 1325 ");
	    strogerInsurMap.put("Eagle Insurance Inc.", "3517 N. Spaulding Ave. ");
	    return strogerInsurMap;		
	}
	
	/*
	 * List insurance companies associated with UI 
	 * */
	public Map<String, String> provideUIInsuranceInfo(){
	    Map<String, String> strogerInsurMap = new HashMap<String, String>();
	    strogerInsurMap.put("Chicago Insurance", "W Taylor Street");
	    strogerInsurMap.put("First Nonprofit Inc.", "1 South Wacker Drive");
	    strogerInsurMap.put("Interstate Bankers Co.", "8501 W Higgins Rd Ste 710");
	    strogerInsurMap.put("Josh Eyman Insurance", "4059 W 47th St Ste 1 ");
	    strogerInsurMap.put("Kemper Corporation", "1 E Wacker Dr Ste 1000");
	    strogerInsurMap.put("Land of Lincoln", "222 S. Riverside Plaza");
	    strogerInsurMap.put("Northwest Insurance", "3416 W 26th St ");
	    strogerInsurMap.put("Network-47th St.", "1658 W 47th St ");
	    strogerInsurMap.put("Network-79th St.", "200 E 79th St");
	    strogerInsurMap.put("Network-Ashland Ave.", "1123 N. Ashland Ave. ");
	    strogerInsurMap.put("Network-Commercial Ave.", "9001 S Commercial Ave");
	    return strogerInsurMap;			
	}
	
	/*
	 * List of insurance companies associated with Stroger 
	 * */
	public Map<String, String> provideStrogerInsuranceInfo(){
	    Map<String, String> strogerInsurMap = new HashMap<String, String>();
	    strogerInsurMap.put("Cicero Insurance Comp", "809 S Marshfield");
	    strogerInsurMap.put("Northwest Insurance Ave.", "6060 W Fullerton Ave ");
	    strogerInsurMap.put("United Auto Insurance", "7142 W. Belmont Ave");
	    strogerInsurMap.put("Virginia Surety ", "175 W Jackson Blvd., 11th Floor");
	    strogerInsurMap.put("Water Tower LLC", "1 N Franklin St Ste 2470 ");
	    return strogerInsurMap;		
	}
	
	public static void main(String[] args) throws Exception{
        insuranceCompany insurObj = new insuranceCompany();
        Naming.rebind("insuranceObj", insurObj);
		System.out.println("rmi object bound to the name 'insuraceObj' and is ready for use");
	}

}
