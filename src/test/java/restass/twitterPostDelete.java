package restass;

import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;


public class twitterPostDelete {
    String ConsumerKey = "M2WNmkP8Yco3uUna3YoD0OIai";
    String ConsumerSecret ="q0rdZhJ2jIeXuLasW9M4yw24auu8ok9v1IENiSwkJ1KZcNhrfH";
    String AccessToken = "1155842746067935233-s3QHc7o4X4BsoLWHJY1HjTq7NJlxJN";
    String TokenSecret = "KOTKXOFfTOD93NjXaDYzOCRV5EscTg2SJWVg2zCuNS40v";


    @Test
    public void post() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .queryParam("status","only￼a life lived for others is a life worthwhile")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
 /*   @Test
    public void postDelete() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .queryParam("status","good")
                .when().post("https://api.twitter.com/1.1/statuses/destroy/1156692281837203456.json");
        response.prettyPrint();
        response.then().assertThat().body("text",is(equalToIgnoringCase("good")));
    }*/
 @Test
 public void postDelete() {
     Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
             .queryParam("status", "good")
             .when().post("https://api.twitter.com/1.1/statuses/destroy/1156692281837203456.json");
     response.prettyPrint();
     response.then().assertThat().body("text", is(equalToIgnoringCase("good")));

 }
    @Test
    public void postRet() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().post("https://api.twitter.com/1.1/statuses/retweet/1156665418884493312.json");
        response.prettyPrint();
    }
    @Test
    public void postUnReTweet() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().post("https://api.twitter.com/1.1/statuses/unretweet/1156665418884493312.json");
        response.prettyPrint();
    }


    @Test
    public void postlookUp() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/lookup.json?id=1,1156665418884493312");
        response.prettyPrint();

    }
    @Test
    public void postUpDateWithMedia() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .queryParam("id","211809988708278162")
                .when().post("https://api.twitter.com/1.1/statuses/update_with_media.json ");
        response.prettyPrint();
    }







}





