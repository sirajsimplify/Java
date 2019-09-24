package RestAssured1;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Client.RestClient;

public class GetREST extends TestBase{
	TestBase testbase;
	String serviceUrl;
	String apiUrl;
	String Url;
	RestClient restClient;
	
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException{
		testbase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		
		Url = serviceUrl + apiUrl;		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		restClient.getMethod(Url);		
	}

}
