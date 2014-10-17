import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;

public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	private String glob;
	
	protected Patient() throws RemoteException{
	 super();
    }
	
	public void setChoice(String a){
		this.glob = a;
	}
	
	public String getChoice(){
		return this.glob;
	}

	public static void main(String[] args) throws Exception{
			Patient patientObj = new Patient();
			
			String url1 = new String("rmi://localhost/doctorObj");
		    doctorRmiIntf doctorStubObj1 = (doctorRmiIntf)Naming.lookup(url1);
		    Patient ref1 = patientObj;
		    Patient ref2 = patientObj;
		    
		    /*
		     * Remote method call with the two references(ref1 and ref2) of 
		     * the same object
		     * */
		    doctorStubObj1.refIntegrity(ref1, ref2);
		    
			String url = new String("rmi://localhost/hospitalObj");
		    hospitalRmiIntf hospitalStubObj = (hospitalRmiIntf)Naming.lookup(url);
		    Map<String, String> hosps= hospitalStubObj.displayHospitals();
		    while (true){
		    	System.out.println("\t Hospital Name \t\t Address");
		    	System.out.println("\t ------------- \t\t -------");
		    	
	    		for(Map.Entry<String,String> entry : hosps.entrySet()) {
	    			System.out.printf("\t%-20s \t%-20s %n", entry.getKey(), entry.getValue());
	    			System.out.println();
	    		}
	    		
          	
            	while(true) {
            	    System.out.println("Enter '1' for Doctors"+"\n"+"Enter '2' for Insurance\n"
            	    		+ "Enter '3' to 'Exit Application'");
    				@SuppressWarnings("resource")
					Scanner userInput = new Scanner(System.in);
            	    String docInsuran = userInput.next();
            	
            	    if (docInsuran.equals("1")){
            	        while(true){	
            	    	    System.out.println("Enter '1' for 'Stroger' doctors Info \nEnter '2' for 'Rush' "
            	    			+ "doctors Info\nEnter '3' for 'UI Hospital' doctors Info\n"
        	    				+ "Enter '4' to 'Return to previous menu' \n" + "Enter '5' to 'Exit Application'\n");
            	    	    String docChoice = userInput.next();
            	    	    patientObj.setChoice(docChoice);
        		            if (docChoice.equals("4")){
         		                break;
         		            }
        		            if (docChoice.equals("5")){
         		                System.exit(0);
        		            }
    		                Map<String, String> docs = hospitalStubObj.getDoctorsInfo(patientObj);
    		                System.out.println("List of Doctors:");
    				    	System.out.println("\t Doctor Name \t\t\t Speciality");
    				    	System.out.println("\t ----------- \t\t\t ------------");
         		            for(Map.Entry<String,String> entry : docs.entrySet()) {
        			            System.out.printf("\t%-30s %-30s %n", entry.getKey(), entry.getValue());
        			            System.out.println();
        		            }
            	        }
            	    }
         		
         		    else if (docInsuran.equals("2")){
         		        while(true){
         		        	System.out.println("Enter '1' for 'Stroger' Insurance companies Info \nEnter '2' for 'Rush' "
         		    			+ "Insurance Companies Info\nEnter '3' for 'UI Hospital' Insurance Companies Info\n"
        	    				+ "Enter '4' to 'Return to previous menu' \n" + "Enter '5' to 'Exit Application'\n");
         		    	    String insurChoice = userInput.next();
         		    	    patientObj.setChoice(insurChoice);
        		            if (insurChoice.equals("4")){
         		                break;
         		            }
        		            if (insurChoice.equals("5")){
         		                System.exit(0);
        		            }
    		                Map<String, String> insur = hospitalStubObj.getInsurCompInfo(patientObj);
    		                System.out.println("List of Insurance companies:");
    		                System.out.println("\t Company Name \t\t\t Address");
    				    	System.out.println("\t ------------- \t\t\t -------");
         		            for(Map.Entry<String,String> entry : insur.entrySet()) {
        			            System.out.printf("\t%-30s %-30s %n", entry.getKey(), entry.getValue());
        			            System.out.println();
        		            }
         		        }
         		    }
            	    
         		    else if (docInsuran.equals("3")){
         		    	System.exit(0);
         		    }
            	}
		    }
	}
}

