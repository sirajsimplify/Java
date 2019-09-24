package API_Examples;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.math3.analysis.function.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import com.google.gson.Gson;

public class Post_Method {
	
	static JSONObject jsonObject;
	static JSONObject jsonObject1;
	String value1;
	String key1;
	
	public static void main(String[] args) throws Exception {

		Post_Method http = new Post_Method();
		
		System.out.println("Test Started");	
		
		System.out.println("Testing 1 - Send Http POST request");
		http.sendPost();
		//http.sendPost("https://apiv4.talview.com/oauth2/token","{\"grant_type\": \"password\",\"client_id\": \"web-application-3\",\"client_secret\": null,\"username\": \"support.qaautomation@talview.com\",\"password\": \"qaautomation5001\"}", "access_token");
		
		System.out.println("\n Testing 2 - Send Http GET request");
		http.sendGet();
		//http.get_method("https://apiv4.talview.com/models/answer", "Content-Type", "application/json", "Authorization");

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = " https://apiv4.talview.com/models/answer";		
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		con.setRequestProperty("Authorization", "Bearer " + value1);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));		
		StringBuffer jsonString = new StringBuffer();
		String Line;
		while ((Line = in.readLine()) != null) {
			jsonString.append(Line);
		}
		in.close();
		con.disconnect();

		//print result
		String StringResponse = jsonString.toString();
		System.out.println(StringResponse);
		
		
		
		try {
			//jsonObject1 = new JSONObject(respo);
			JSONArray ja = new JSONArray(StringResponse);
			System.out.println(ja.length());
			int arraylength = ja.length();
			for(int i=1; i<arraylength; i++){
			JSONObject jsonObject1= ja.getJSONObject(i);			
			Map<String, Object> hh = jsonObject1.toMap();
			System.out.println("The total number of Id's are -- " +hh.size());
			int k = hh.size();			
			System.out.println("The id number "+ hh.get("id")+ " has the question_id " +hh.get("question_id") + " which was answered at " + hh.get("answered_at") + " and had "+hh.get("choice")+" choices.");
			System.out.println();}
			
		//	ja.put(jsonObject1);
			
		}catch (JSONException err){
			err.printStackTrace();
		     System.out.println(err);
		}

	}
	
	
	
private void sendPost(String url,String payload, String token) throws Exception {
		
		// String payload = "{\"grant_type\": \"password\",\"client_id\": \"web-application-3\",\"client_secret\": null,\"username\": \"support.qaautomation@talview.com\",\"password\": \"qaautomation5001\"}";
		// String url = "https://selfsolve.apple.com/wcResults.do";
//		String url = "https://apiv4.talview.com/oauth2/token";
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setDoInput(true);
		con.setDoOutput(true);
		//add reuqest header
		con.setRequestMethod("POST");    // Type of method
		con.setRequestProperty("Content-Type", "application/json");  // To enter the header content
		OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
		writer.write(payload);  // To enter the body content
		// writer.flush();
        writer.close();
        
        int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);		

		BufferedReader br  = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer jsonString = new StringBuffer();
		
		String Line;
		while ((Line = br.readLine()) != null) {
			jsonString.append(Line);
		}
		br.close();
		con.disconnect();
		
		String StringResponse = jsonString.toString();
		System.out.println(StringResponse);  //print result	
		try {
		     jsonObject = new JSONObject(StringResponse);
		}catch (JSONException err){
			err.printStackTrace();
		     System.out.println(err);
		}
		
		Set keys = jsonObject.keySet();
		Iterator a = keys.iterator();
	    key1 = (String)a.next();
	    value1 = (String)jsonObject.get(token);
        System.out.println("key : "+key1);
        System.out.println("Value is " + value1);		
	}
	
	private void sendPost() throws Exception {
		
		String payload = "{\"grant_type\": \"password\",\"client_id\": \"web-application-3\",\"client_secret\": null,\"username\": \"support.qaautomation@talview.com\",\"password\": \"qaautomation5001\"}";
		// String url = "https://selfsolve.apple.com/wcResults.do";
		String url = "https://apiv4.talview.com/oauth2/token";
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setDoInput(true);
		con.setDoOutput(true);
		//add reuqest header
		con.setRequestMethod("POST");    // Type of method
		con.setRequestProperty("Content-Type", "application/json");  // To enter the header content
		OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
		writer.write(payload);  // To enter the body content
		// writer.flush();
        writer.close();
        
        int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);		
		
		/** OutputStream os = con.getOutputStream();
		os.write(url.getBytes());
		//DataOutputStream wr = new DataOutputStream(con.getOutputStream());		
		os.flush();
		os.close(); **/		

		BufferedReader br  = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer jsonString = new StringBuffer();
		
		String Line;
		while ((Line = br.readLine()) != null) {
			jsonString.append(Line);
		}
		br.close();
		con.disconnect();
		
		String StringResponse = jsonString.toString();
		System.out.println(StringResponse);  //print result	
		
		/**	Gson gson = new Gson();
		gson.toJson(StringResponse);  **/
		
		try {
		     jsonObject = new JSONObject(StringResponse);
		}catch (JSONException err){
			err.printStackTrace();
		     System.out.println(err);
		}
		
		Set keys = jsonObject.keySet();
		Iterator a = keys.iterator();
	    key1 = (String)a.next();
	    value1 = (String)jsonObject.get("access_token");
        System.out.println("key : "+key1);
        System.out.println("Value is " + value1);
		
		/**JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(stringToParse);**/
	}
	
	
	private void get_method(String url, String cont_key, String cont_val, String aut_key) throws Exception {

		//String url = " https://apiv4.talview.com/models/answer";		
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty(cont_key, cont_val);
		
		con.setRequestProperty(aut_key, "Bearer " + value1);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));		
		StringBuffer jsonString = new StringBuffer();
		String Line;
		while ((Line = in.readLine()) != null) {
			jsonString.append(Line);
		}
		in.close();
		con.disconnect();

		//print result
		String StringResponse = jsonString.toString();
		System.out.println(StringResponse);
	}

}
