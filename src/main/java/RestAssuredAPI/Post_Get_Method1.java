package RestAssuredAPI;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Get_Method1 {
	
	static JSONObject jsonObject;
	String value1;
	String key1;
	
	/**public static void main(String[] args) {
		Post_Get_Method1 gp = new Post_Get_Method1();
		System.out.println("Post method Test started");
		gp.postMethod("https://apiv4.talview.com/oauth2/token");
		
		System.out.println("Get method started");
		gp.getMethod();
		
		System.out.println("Test completed");		
	} **/
	
	
	/**
	 * @postMethod == Used to send Post request
	 * @ Rest assured = Post example
	 * @author Siraj
	 */
	@Test(priority=1)
	public void postMethod(){		
		RestAssured.baseURI ="https://apiv4.talview.com/oauth2/token";
		RequestSpecification request = RestAssured.given();
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("grant_type", "password"); 
		requestParams.put("client_id", "web-application-3");		 
		requestParams.put("client_secret", "");
		requestParams.put("username", "support.qaautomation@talview.com");
		requestParams.put("password", "qaautomation5001");
		
		request.header("Content-Type", "application/json");
		
		// Add the Json to the body of the request
		request.body(requestParams.toString());
		Response response = request.post();
		
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		System.out.println(response.getBody().asString());
		jsonObject = null;
		try {
		     jsonObject = new JSONObject(response.getBody().asString());
		}catch (JSONException err){
			err.printStackTrace();
		     System.out.println(err);
		}
		
		Set keys = jsonObject.keySet();
		// Iterator a = keys.iterator();
	   // String key1 = (String)a.next();
		value1 = (String)jsonObject.get("access_token");
      // System.out.println("key : "+key1);
       System.out.println("Value is " + value1);
		
	}
	
	@Test(priority=2)
	public void getMethod(){		
		RestAssured.baseURI ="https://apiv4.talview.com/models/answer";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + value1);
		Response rep = request.get();  // GET method
		System.out.println(rep.getStatusCode());
		System.out.println(rep.getBody().asString());		
	}
	
	@Test(priority=3)
	public void getMethod1(){		
		RestAssured.baseURI ="https://reqres.in/api/users?page=2";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		//request.header("Authorization", "Bearer " + value1);
		Response rep = request.get();  // GET method
		System.out.println(rep.getStatusCode());
		System.out.println(rep.getStatusLine());
		System.out.println(rep.getBody().asString());		
	}

}
