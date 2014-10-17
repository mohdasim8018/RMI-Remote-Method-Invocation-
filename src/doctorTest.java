import static org.junit.Assert.*;

import org.junit.Test;

import java.rmi.RemoteException;
import java.util.*;


public class doctorTest {

	@Test
	public void test_provideDocsInfo() throws RemoteException {
		doctor obj = new doctor();
		String temp = "1";
		Patient obj1 = new Patient();
		obj1.setChoice(temp);
		Map<String, String> docSelect =obj.provideDocsInfo(obj1);
		assertEquals(7,docSelect.size());
		
	}
	
	@Test
	public void test_provideRushDocsInfo() throws RemoteException {
		doctor obj = new doctor();
		Map<String, String> docSelect =obj.provideRushDocsInfo();
		assertEquals(8,docSelect.size());	
	}

	@Test
	public void test_provideUIDocsInfo() throws RemoteException {
		doctor obj = new doctor();
		Map<String, String> docSelect =obj.provideUIDocsInfo();
		assertEquals(8,docSelect.size());	
	}
	
	@Test
	public void test_provideStrogerDocsInfo() throws RemoteException {
		doctor obj = new doctor();
		Map<String, String> docSelect =obj.provideStrogerDocsInfo();
		assertEquals(7,docSelect.size());	
	}
}
