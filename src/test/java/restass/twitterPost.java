package restass;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class twitterPost {

    String ConsumerKey = "HAEKog6IsxpAjjMTcE0O7kXxQ";
    String ConsumerSecret ="3DZ8TMwU4sbi387J9LIj8ogGoynDWaXJjXCaRXlsgo0qX92IJY";
    String AccessToken = "1155842746067935233-3POb8slJ767rC6mzrW7VGUVJBhtEkv";
    String TokenSecret = "rpnxYwXhhbRwZ9hfwWxVLTuweQvhTzy5fg9rKAxUzTOPf";


    @Test
    public void get_Home_TimeLine() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/home_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void user_TimeLine() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/user_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void mention_TimeLine() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/mentions_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void post_Status_Update() {
        Response response = given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .queryParam("status", "good")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }


    @Test
    public void post_Status_Updates() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .queryParam("status", "***")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
        response.prettyPrint();
        //response.then().assertThat().statusCode(200)
        // .body("text",is(equals("***"))).body("user name",is(equalToIgnoringCase("HariMag")));


    }


}