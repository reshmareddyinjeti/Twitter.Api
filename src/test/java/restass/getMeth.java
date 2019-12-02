package restass;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

public class getMeth {
    @Test
    public void getListUser() {
        Response response = given().when().get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("page", is(2)).body("data.id", hasItems(4, 5, 6));
    }

    @Test
    public void getSingleUer() {
        Response response = given().when().get("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("data.id", is(2));
    }

    @Test
    public void getSingleUserNotFound() {
        Response response = given().when().get("https://reqres.in/api/users/23");
        response.prettyPrint();
        response.then().assertThat().statusCode(404).log().all();
    }

    @Test
    public void getListResource() {
        Response response = given().when().get("https://reqres.in/api/unknown");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("page", is(1)).and().body("data.id", hasItems(1, 2, 3));
    }

    @Test
    public void getSingleResource() {
        Response response = given().when().get("https://reqres.in/api/unknown/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("data.id", is(2))
                .and().body("data.name", is("fuchsia rose"))
                .and().body("data.year", is(2001))
                .and().body("data.color", is("#C74375"))
                .and().body("data.pantone_value", is("17-2031"));
    }

    @Test
    public void getSingleResourceNotFound() {
        Response response = given().when().get("https://reqres.in/api/unknown/23");
        response.prettyPrint();
        response.then().assertThat().statusCode(404).and().log().all();

    }
    //POST METHOD

    @Test
    public void postCreat() {
        JsonObject payload = new JsonObject();
        payload.addProperty("name", "morpheus");
        payload.addProperty("job", "leader");
        Response response = given().contentType(ContentType.JSON)
                .when().body(payload).post("https://reqres.in/api/users");
        response.prettyPrint();
    response.then().assertThat().statusCode(201).and()
            .body("name",is("morpheus"))
            .and().body("job",is("leader"));

    }
    @Test
    public void postReshma(){
        JsonObject payload=new JsonObject();
        payload.addProperty("name","reshu");
        payload.addProperty("job","sdet");
        payload.addProperty("salary","100000");
        payload.addProperty("company","google");
        payload.addProperty("place","London");
        Response response=given().contentType(ContentType.JSON).when()
                .body(payload).post("https://reqres.in/api/users");;
        response.prettyPrint();
        response.then().assertThat().statusCode(201).and()
                .body("name",is("reshu")).body("job",is("sdet"));
    }
    @Test
    public void put(){
        JsonObject payload=new JsonObject();
        payload.addProperty("name","morpheus");
        payload.addProperty("job","zion resident");
        Response response=given().contentType(ContentType.JSON).when()
                .body(payload).put("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and()
                .body("name",is("morpheus"));
    }
    @Test
    public void delete() {
        Response response = given().when().delete("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);

    }
    @Test
    public void postRegister(){
        JsonObject payload=new JsonObject();
        payload.addProperty("email","eve.holt@reqres.in");
        payload.addProperty("password","pistol");
        Response response=given().contentType(ContentType.JSON).when()
                .body(payload).post("https://reqres.in/api/register");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void postRegisterUn(){
        JsonObject payload=new JsonObject();
        payload.addProperty("email","sydney@fife");
        Response response =given().contentType(ContentType.JSON).when()
                .body(payload).post("https://reqres.in/api/register");
        response.prettyPrint();
        response.then().assertThat().statusCode(400).and()
               .body("error",is("Missing password"));

    }
    @Test public void postlOGIN(){
        JsonObject payload=new JsonObject();
        payload.addProperty("email","eve.holt@reqres.in");
        payload.addProperty("password","cityslicka");
        Response response=given().contentType(ContentType.JSON)
                .when().body(payload).post("https://reqres.in/api/login");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and().body("token",is("QpwL5tke4Pnpja7X4"));

    }
    @Test
    public void postLogInUnSuccess(){
        JsonObject payload=new JsonObject();
        payload.addProperty("email","peter@klaven");
        Response response=given().contentType(ContentType.JSON)
                .when().body(payload).post("https://reqres.in/api/login");
        response.prettyPrint();
        response.then().assertThat().statusCode(400).body("error",is("Missing password"));
    }
    @Test
    public void getDelayed(){
        Response response=given().when().get("https://reqres.in/api/users?delay=3");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).and()
                .body("page",is(1)).and().body("data.id",hasItems(1,2,3));
    }
    @Test
    public void patch(){
        JsonObject payload=new JsonObject();
        payload.addProperty("name","morpheus");
        payload.addProperty("job","zion resident");
        Response response=given().contentType(ContentType.JSON).
                when().body(payload).patch("https://reqres.in/api/users/2");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
@Test
    public void post1(){
        Response response=given().contentType("application/json").when()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").post("https://reqres.in/api/users");
        response.prettyPrint();
        response.then().assertThat().statusCode(201).and()
                .body("name",is("morpheus"))
                .body("job",is("leader"));

}

}