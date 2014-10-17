import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import java.util.*;


public class hospitalTest {

	@Test
	public void test_displayHospitals() throws RemoteException {
		hospital obj = new hospital();
		Map<String,String> select = obj.displayHospitals();
		assertEquals(3,select.size());
	}

	@Test
	public void test_getDoctorsInfo() throws Exception {
		hospital obj = new hospital();
		Patient obj1 = new Patient();
		obj1.setChoice("1");
		Map<String,String> select = obj.getDoctorsInfo(obj1);
		assertEquals(7,select.size());
	}
	
	@Test
	public void test_getInsurCompInfo() throws Exception {
		hospital obj = new hospital();
		Patient obj1 = new Patient();
		obj1.setChoice("1");
		Map<String,String> select = obj.getInsurCompInfo(obj1);
		assertEquals(5,select.size());
	}
	
}
