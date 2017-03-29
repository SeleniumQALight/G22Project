package restTest;


import libs.Response;
import org.junit.Test;

import java.io.IOException;

import static libs.RestUtils.sendRequest;

public class TestRest {
	
	@Test
	public void testRest() throws IOException {
		Response response = sendRequest("https://api.getpostman.com/collections", "2f5cca516c164793bfaa6b8c946d3790");
		int sizeOfCollection = response.getCollections().size();
		
		System.out.println("response length = " + sizeOfCollection );
		System.out.println("All collections ->" + response.getCollections());
		
		if (sizeOfCollection > 0) {
			for (int numberInCollection = 0; numberInCollection < sizeOfCollection; numberInCollection++) {
				System.out.println("Response name"+numberInCollection+" = " + response.getCollections().get(numberInCollection).get("name"));
			}
			
		}
	}
}


