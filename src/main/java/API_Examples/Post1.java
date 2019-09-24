package API_Examples;

import java.net.HttpURLConnection;

import java.util.Iterator;
import java.util.Set;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class Post1 {
	public static void main(String[] args) {
		
		/** try {
		    JSONArray jsonArr = new JSONArray("[{\"id\":[\"5\"]},{\"Tech\":[\"Java\"]}]");

		    for (int i = 0; i < jsonArr.length(); i++) {
		        JSONObject jsonObj = jsonArr.getJSONObject(i);
		        String k = jsonObj.keys().next();
		        System.out.println(jsonObj.getString(k));
		    }
		} catch (JSONException ex) {
		    ex.printStackTrace();
		} **/
		
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("a", "aaa");
			jsonObject.put("b", "bbb");
			
		    Set keys = jsonObject.keySet();
		    Iterator a = keys.iterator();
		    
		    String value1 = (String)jsonObject.get("b");  // To get a specific value from the JSON object
		    System.out.println("The value of the key b is -- " + value1);
		    
		    // To display all the values of JSON array
		    while(a.hasNext()) {
		    	String key = (String)a.next();
		        // loop to get the dynamic key
		        String value = (String)jsonObject.get(key);
		        System.out.print("key : " + key + " == & == ");
		        System.out.println("value :"+value);
		    }
		}		
	}