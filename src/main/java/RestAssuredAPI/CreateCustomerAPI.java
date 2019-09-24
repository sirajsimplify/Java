package RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateCustomerAPI {
	
	@Test
	public void countryNames(){	
		
			given()
			.when()
			.get(ServiceURL.raceURL)
			.then()
			.assertThat()
			.statusCode(200);
			
			Response response = given()
					.when()
					.get(ServiceURL.raceURL);			
			
			String resp = response.getBody().asString();			
			System.out.println("The response is " + resp);
			
			JsonPath jsonpath = new JsonPath(resp);
			String countryName = jsonpath.getString("MRData.CircuitTable.Circuits.Location.country[0]");
			System.out.println(countryName);
			Assert.assertEquals(countryName, "Australia", "There is an error");
		
	}

}
