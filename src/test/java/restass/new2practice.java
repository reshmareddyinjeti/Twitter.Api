package restass;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class new2practice {
    @Test
    public void getPage2() {
        Response response = given().when().get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("page", is(2)).body
                ("data.id", hasItems(7, 8, 9, 10, 11, 12));
    }

    @Test
    public void getSingleUser() {
        Response response = given().when().get("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("data.id", is(2));

    }

    @Test
    public void getUnknow() {
        Response response = given().when().get("https://reqres.in/api/unknown");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("page", is(1)).body("data.id", hasItems(1, 2, 3, 4, 5, 6));

    }

    @Test
    public void getUnknow2() {
        Response response = given().when().get("https://reqres.in/api/unknown/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("data.id", is(2));
    }

    @Test
    public void postCreate() {//instade of giveing we can use "application/json",ContentType

        JsonObject payload = new JsonObject();
        payload.addProperty("name", "abhay");
        payload.addProperty("job", "happy");
        payload.addProperty("salary", "500000");
        payload.addProperty(" company", "google");
        Response response = given().contentType(ContentType.JSON).
                when().body(payload).post("https://reqres.in/api/users");
        response.prettyPrint();
        response.then().assertThat().statusCode(201).body("name",is("abhay"));

    }
    @Test
    public void postcreate(){
        Response response=given().contentType(ContentType.JSON).when()
                .body("{" +
                "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").post("https://reqres.in/api/users");
        response.prettyPrint();
       // response.then().statusCode(201);
    }
    @Test
    public void put(){
        JsonObject payload=new JsonObject();
        payload.addProperty("name","sai");
        payload.addProperty("job","god");
        Response response=given().contentType(ContentType.JSON).when().body(payload).post("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(201).body("job",is("god"));
    }
    @Test
    public void delete(){
        Response response=given().when().delete("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);

    }
    @Test
    public void postRegister(){
        JsonObject payload=new JsonObject();
        payload.addProperty("email","reshma@gmail.com");
        payload.addProperty("password","resham");
        Response response=given().contentType(ContentType.JSON).when().body(payload).post("https://reqres.in/api/register");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("token",is("QpwL5tke4Pnpja7X4"));
    }
    @Test
    public void postunsuccesful(){
        JsonObject payload=new JsonObject();
        payload.addProperty("email","sydney@fife");
        Response response=given().contentType(ContentType.JSON).when().body(payload).post("https://reqres.in/api/register");
        response.prettyPrint();
        response.then().assertThat().statusCode(400);

    }
    @Test
    public void getLookUp(){

    }
}