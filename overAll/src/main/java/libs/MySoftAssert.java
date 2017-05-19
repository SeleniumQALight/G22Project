package libs;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import java.util.Iterator;
import java.util.Map;

public class MySoftAssert extends Assertion {
	
	private Map<AssertionError, IAssert> m_errors = Maps.newLinkedHashMap();
	
	public MySoftAssert() {
	}
	
	public void executeAssert(IAssert a) {
		try {
			a.doAssert();
		} catch (AssertionError var3) {
			this.m_errors.put(var3, a);
		}
		
	}
	
	public void assertEqualsWithMessage(boolean varExpected, boolean varActual, String message){
		assertEquals(varExpected, varActual,addValueToString(message,String.valueOf(varExpected),String.valueOf(varActual)));
	}
	
	public void assertEqualsWithMessage(int varExpected, int varActual, String message){
		assertEquals(varExpected, varActual,addValueToString(message, String.valueOf(varExpected), String.valueOf(varActual)));
	}
	
	private String addValueToString(String message, String expectedParam, String ActualParam){
		return message.trim() + " -> Expected: [" + expectedParam + "] but was: [" + ActualParam + "]";
	}
	
	public void assertAll() {
		if(!this.m_errors.isEmpty()) {
			StringBuilder sb = new StringBuilder("The following asserts failed:\n");
			boolean first = true;
			
			Map.Entry ae;
			for(Iterator i$ = this.m_errors.entrySet().iterator(); i$.hasNext(); sb.append(((IAssert)ae.getValue()).getMessage())) {
				ae = (Map.Entry)i$.next();
				if(first) {
					first = false;
				} else {
					sb.append(",\n");
				}
			}
			
			throw new AssertionError(sb.toString());
		}
	}
	
	
}
