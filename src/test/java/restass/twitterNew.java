package restass;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class twitterNew {
    String ConsumerKey = "pXnD4WbYiBxgkXIvyCh5kWTH6";
    String ConsumerSecret = "LMQiz92B9hmSwK3VDkNRpMhGyVZ3BXvDmdsTHJzvDIMAgvH5dt";
    String AccessToken = "1155842746067935233-oRFBxB9wGjItqs4dwqxZ9JbLjMZkLc";
    String TokenSecret = "tf9PMYvEndYbHcwJqpM4YT7vLg2FBrH9vADtRrzHADPJ4";


    @Test
    public void post_status_update() {
        Response response = given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret)
                .queryParam("status", "Dare to dream , care to achieve")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void post_like(){
        Response response=given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .queryParam("id","1159783026576019456")
                .when().post("https://api.twitter.com/1.1/favorites/create.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void practise(){
        Response response=given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .queryParam("status","good night")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

}
