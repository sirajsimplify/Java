package API_Examples;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class Talview_Move1 {
	
	static JSONObject jsonObject;
	String value1;
	String key1;
	
	public static void main(String[] args) throws Exception {
		Talview_Move1 m1 = new Talview_Move1();
		
		System.out.println("Post Method Test started =>");
		m1.post_method("{\"grant_type\": \"password\",\"client_id\": \"web-application-3\",\"client_secret\": null,\"username\": \"support.qaautomation@talview.com\",\"password\": \"qaautomation5001\"}"
				, "https://apiv4.talview.com/oauth2/token"
				, "Content-Type", "application/json", "access_token");
		System.out.println("\nPost method completed =>");
		
		System.out.println("Get method started =>");
		m1.get_method("https://apiv4.talview.com/models/answer", "Content-Type", "application/json", "Authorization");
		System.out.println("Get method completed");
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

		private void post_method(String payload, String url, String cont_key, String cont_val, String Json_key ) throws Exception {
		
		// String payload = "{\"grant_type\": \"password\",\"client_id\": \"web-application-3\",\"client_secret\": null,\"username\": \"support.qaautomation@talview.com\",\"password\": \"qaautomation5001\"}";
		// String url = "https://selfsolve.apple.com/wcResults.do";
		// String url = "https://apiv4.talview.com/oauth2/token";
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setDoInput(true);
		con.setDoOutput(true);
		//add reuqest header
		con.setRequestMethod("POST");    // Type of method
		con.setRequestProperty(cont_key, cont_val);  // To enter the header content
		OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
		writer.write(payload);  // To enter the body content
		// writer.flush();
        writer.close();
        
        int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);	
		

		BufferedReader br  = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer jsonString = new StringBuffer();
		System.out.println(jsonString);
		
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
	    value1 = (String)jsonObject.get(Json_key);
        System.out.println("key : "+key1);
        System.out.println("Value is " + value1);
	}
	
}
