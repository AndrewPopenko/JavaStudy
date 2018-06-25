package udemy.testing.rest.api.with.restassured.statuses;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import udemy.testing.rest.api.with.restassured.common.RestUtilities;
import udemy.testing.rest.api.with.restassured.constants.EndPoints;
import udemy.testing.rest.api.with.restassured.constants.Path;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class UserTimeLineTest {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @Before
    public void setUp() {
        requestSpecification = RestUtilities.getRequestSpec();
        requestSpecification.queryParam("screen_name", "AndrewNoLastNa1");
        requestSpecification.basePath(Path.STATUSES);

        responseSpecification = RestUtilities.getResponseSpec();
    }

    @Test
    public void readTweets() {
        given()
                .spec(requestSpecification)
        .when()
                .log().all()
                .get(EndPoints.STATUSES_USER_TIMELINE)
        .then()
                .log().all()
                .spec(responseSpecification)
                .body("user.name", hasItem("Andrew NoLastName"));
    }

    @Test
    public void readTweet() {
        given()
                .spec(RestUtilities.createQueryParam(requestSpecification, "count", "1"))
        .when()
                .log().all()
                .get(EndPoints.STATUSES_USER_TIMELINE)
        .then()
                .log().all()
                .spec(responseSpecification)
                .body("user.name", hasItem("Andrew NoLastName"));
    }

    @Test
    public void readTweet1() {
        RestUtilities.setEndPoint(EndPoints.STATUSES_USER_TIMELINE);
        Response response = RestUtilities.getResponse(
                RestUtilities.createQueryParam(requestSpecification, "count", "1"), "get");
        ArrayList<String> stringArrayList = response.path("user.name");
        Assert.assertTrue(stringArrayList.contains("Andrew NoLastName"));
    }

    String id;

    @Test
    public void createAndDelete() {
        postTweet();
        deleteTweet();
    }

//    @Test
    public void postTweet() {
        RestUtilities.setEndPoint(EndPoints.STATUSES_TWEET_POST);
        Response response = RestUtilities.getResponse(RestUtilities.createQueryParam(requestSpecification, "status", "Tweet"),
                "post");

        assertThat(response.path("text"), Matchers.<Object>equalTo("Tweet"));
        id = response.path("id_str");
    }

//    @Test()
    public void deleteTweet() {
        RestUtilities.setEndPoint(EndPoints.STATUSES_TWEET_DESTROY);
        Response response = RestUtilities.getResponse(RestUtilities.createQueryParam(requestSpecification, "id", id), "post");

//        assertThat(response.path());
    }
}
