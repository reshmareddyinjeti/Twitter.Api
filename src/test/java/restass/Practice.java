package restass;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class Practice {
    //Get command
    @Test
    public void getMethod()

    {
        Response response = given().when().get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and()
                .body("page", is(2)).and().body("data.id", hasItems(4, 5, 6));
    }

    //single user
    @Test
    public void getMethod1(){
        RestAssured.baseURI="https://reqres.in/";
        Response response=given().when().get("/api/users?page=2");
        response.prettyPrint();
       response.then().assertThat().body("data.id",is(4));

    }
    //SINGLE USER NOT FOUND
    @Test
    public  void getData(){
         Response response=given().when().get("https://reqres.in/api/users/23");
         response .prettyPrint();
         response.then().assertThat().log().all();


    }
    //single resource not found
    @Test
    public void notFound(){
        Response response=given().when().get("https://reqres.in/api/unknown/23");
response.prettyPrint();
    }


}
