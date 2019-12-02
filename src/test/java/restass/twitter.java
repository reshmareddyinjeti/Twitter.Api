package restass;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class twitter {

    String ConsumerKey="ez5sTvZ1VNTyHfsyFSqZNtfhH";
    String ConsumerSecret="BmvZX7zFrTmfuViOEXAhRkgaL521VdkVqVohy2w1AzLpp7mJyK";
    String AccessToken="1155842746067935233-goVwuCcONk6ZHBp8AsWIzchyRQ8zrF";
    String TokenSecret="hJEa7lkO9nn0PWqp8cBrMyCUAABvQ7gyYDGIIiwImkubU";

    @Test
    public void twitter(){
        Response response=given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/user_timeline.json");
        response.prettyPrint();
    }
    @Test
            public void getTimeLine(){
        Response response=given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/home_timeline.json");
        response.prettyPrint();
    }
    @Test
            public void getMention(){
        Response response=given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/mentions_timeline.json");
        response.prettyPrint();
    }

        String consumerKey="dDVLlcLRuCBiphQfJC2OLe67z";
        String consumerSecret="euOfvQsK5GSCUqxseOAbzIJUA6HL6JaNRNWdvp4rgp1nXDTGtA";
        String accessToken="1155842746067935233-9GshodAPUBUZcNvMmgw7c5Og7aIwqd";
        String accessSecret="bpdsZ8oco9I2krhq2dtNEybxbEpRrqPqG4lRARV7cQ6P5";

        @Test
        public void twitterPost(){
            Response response=given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
           .queryParam("status","hello world")
                    .when().post("https://api.twitter.com/1.1/statuses/update.json");
            response.prettyPrint();
           response.then().assertThat().statusCode(200);
           //.and().body("id",is("1156602249180786690"));

        }
}

