import static org.junit.Assert.*;

import org.junit.Test;

import java.rmi.RemoteException;
import java.util.*;


public class insuranceCompanyTest {

	@Test
	public void test_provideInsurInfo() throws RemoteException {
		insuranceCompany obj = new insuranceCompany();
		Patient obj1 = new Patient();
		obj1.setChoice("1");
		Map<String, String> hospSelect = obj.provideInsurInfo(obj1); 
		assertEquals(5,hospSelect.size());
	}
	
	@Test
	public void test_provideRushInsuranceInfo() throws RemoteException {
		insuranceCompany obj1 = new insuranceCompany();
		Map<String, String> hospSelect1 = obj1.provideRushInsuranceInfo(); 
		assertEquals(11,hospSelect1.size());
	}
	
	@Test
	public void test_provideUIInsuranceInfo() throws RemoteException {
		insuranceCompany obj1 = new insuranceCompany();
		Map<String, String> hospSelect1 = obj1.provideUIInsuranceInfo(); 
		assertEquals(11,hospSelect1.size());
	}
	
	@Test
	public void test_provideStrogerInsuranceInfo() throws RemoteException {
		insuranceCompany obj1 = new insuranceCompany();
		Map<String, String> hospSelect1 = obj1.provideUIInsuranceInfo(); 
		assertEquals(11,hospSelect1.size());
	}

}
