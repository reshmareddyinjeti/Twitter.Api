package restass;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class postMethod {

    @Test
    public void postMethod() {
        Response response = given().when().post("https://reqres.in/api/users");
        JsonObject payload = new JsonObject();
        payload.addProperty("name", "Reshma");
        payload.addProperty("job", "tester");
        payload.addProperty("Salary", "5000");
        //response = postService(payload, "https://reqres.in/api/users");
        //int id = response.then().extract().path("id");
//assertThat("message",is(equalToIgnoringCase("sucessful")));
//assertThat(response.getStatusCode(),is(equalTo("201")));
        response.prettyPrint();
        response.then().assertThat().statusCode(201)
                .and().body("page", is(2)).and().body("data.name", is("Reshma"));
    }
    @Test
    public void payload(){
        JsonObject payload=new JsonObject();
        payload.addProperty("name","morpheus");
        payload.addProperty("job","leader");
        Response response=given().contentType(ContentType.JSON).when().
                body(payload).post("https://reqres.in/api/users");
        response.prettyPrint();

    }

    @Test
    public void creatMethod(){
       Response response= given().contentType("application/json").when()
                .body("{\n" +
                        "    \"name\": \"reshma\",\n" +
                        "    \"job\": \"tester\"\n" +
                        "}").post("https://reqres.in/api/users");
        response.prettyPrint();


    }
}
