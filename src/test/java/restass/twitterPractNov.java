package restass;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class twitterPractNov {
    String ConsumerKey = "Uzmh1dfGf0aHBB8ZiJMb8jPP2";
    String ConsumerSecret = "TK4yROvQKF4Z2unkFNqvMQHa3xTaJOAaIwc3GMhG1ubSTponIi";
    String AccessToken = "1155842746067935233-ed1Ablvk4IuHKcfoNWZtOJL3iqiWTy";
    String TokenSecret = "1cF9rR544Jr7nnGfGSk4Ilwej8M4xmKuouQSJNf7OnYwv";

    @Test
    public void getHomeTimeLine() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/home_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
@Test
    public void getMentionTimeLine() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/mentions_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);


    }
    @Test
    public void getUserTimeLIne(){
    Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
            .when().get("https://api.twitter.com/1.1/statuses/user_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

}
@Test
    public void postMethod(){
      Response response=given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
              .queryParam("status","Do good for others It will Come back in unexpected ways")
              .when().post("https://api.twitter.com/1.1/statuses/update.json");
      response.prettyPrint();
      response.then().assertThat().statusCode(200);

    }
    @Test
    public void postDestory(){
        Response response=given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .when().post("https://api.twitter.com/1.1/statuses/destroy/1156949885939322881.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);


    }
    @Test
    public void postFavorites(){
        Response response=given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .queryParam("id","1156949885939322881")
                .when().post("https://api.twitter.com/1.1/favorites/create.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public  void postReTweet(){
        Response response=given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .queryParam("id","1194015258077253632")
                .when().post("https://api.twitter.com/1.1/statuses/retweet/1194015258077253632.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

}
