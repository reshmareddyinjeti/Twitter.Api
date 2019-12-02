package restass;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class twitterGet {
    String CunsumerKey = "08wWclb3CDDABquxGnqgo7BHZ";
    String CunsumerSecret = "peyI8WlkeQ0vL8oS7Na5vlrR4N2xWrDHzUROBaLGaClgMda5rq";
    String AccessToken = "1155842746067935233-37tT8IgWou9iuGuQD5mXiguI5KfvjO";
    String TokenSecret = "dY6IssnVe9tKOTIKF9lGJxk9GmZ3UuosWAmpHoFoM1Y9B";

    @Test
    public void Get_Home_TimeLine() {
        Response response = given().auth().oauth(CunsumerKey, CunsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/home_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void get_Mention_TimeLine() {
        Response response = given().auth().oauth(CunsumerKey, CunsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/mentions_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void get_User_TimeLine() {
        Response response = given().auth().oauth(CunsumerKey, CunsumerSecret, AccessToken, TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/user_timeline.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void post_Status_Update() {
        Response response = given().auth().oauth(CunsumerKey, CunsumerSecret, AccessToken, TokenSecret)
                .queryParam("status", "life is too short for long tearm grudges")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void post_Favoite_Create() {
        Response response = given().auth().oauth(CunsumerKey, CunsumerSecret, AccessToken, TokenSecret)
                .queryParam("id", "1157673900563734528")
                .when().post("https://api.twitter.com/1.1/favorites/create.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void post_Status_Destory() {
        Response response = given().auth().oauth(CunsumerKey, CunsumerSecret, AccessToken, TokenSecret)
                .queryParam("status", "this is my first post")
                .when().post("https://api.twitter.com/1.1/statuses/destroy/:id.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void post_status() {
        Response response = given().auth().oauth(CunsumerKey, CunsumerSecret, AccessToken, TokenSecret)
                .queryParam("status", "Be kind for poor people")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

}

