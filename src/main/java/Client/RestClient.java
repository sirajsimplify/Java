package Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	// Get Method
	public void getMethod(String url) throws ClientProtocolException, IOException{		

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);  // http get request
		CloseableHttpResponse closablehttpresponse =  httpclient.execute(httpget);  // hit the get URL
		
		// a. Status code:
		int responsecode = closablehttpresponse.getStatusLine().getStatusCode();   // Response code
		System.out.println("The status code is -" + responsecode);  // Printing the response code
		
		// b. JSON string:
		String responseString = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");  // UTF-8 is a standard to print and storing the result in the form of String
		
		JSONObject responsejson = new JSONObject(responseString); // Creating the Json object to convert from string to Json response
		
		System.out.println("Response in the form of JSON" + responsejson);   // Printing the response body in the form of Json
		
		// c. All headers:
		Header[] headerArray = closablehttpresponse.getAllHeaders();
		
		HashMap allHeader = new HashMap<String, String>();
		
		for(Header header : headerArray){
			
			allHeader.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array -->" + allHeader);		
	}
	
	public static void main(String[] args) {
	
		RestClient rest = new RestClient();
		try {
			rest.getMethod1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getMethod1() throws ClientProtocolException, IOException{	
		String url ="https://reqres.in/api/users";

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);  // http get request
		CloseableHttpResponse closablehttpresponse =  httpclient.execute(httpget);  // hit the get URL
		
		// a. Status code:
		int responsecode = closablehttpresponse.getStatusLine().getStatusCode();   // Response code
		System.out.println("The status code is -" + responsecode);  // Printing the response code
		
		// b. JSON string:
		String responseString = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");  // UTF-8 is a standard to print and storing the result in the form of String
		
		JSONObject responsejson = new JSONObject(responseString); // Creating the Json object to convert from string to Json response
		
		System.out.println("Response in the form of JSON" + responsejson);   // Printing the response body in the form of Json
		
		Set keys = responsejson.keySet();
		Iterator a = keys.iterator();
	    String key1 = (String)a.next();
	    String value1 = (String)responsejson.get("per_page");
        System.out.println("key : "+key1);
        System.out.println("Value is " + value1);
		
		
		// c. All headers:
		Header[] headerArray = closablehttpresponse.getAllHeaders();
		
		HashMap allHeader = new HashMap<String, String>();
		
		for(Header header : headerArray){
			
			allHeader.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array -->" + allHeader);		
	}

}
