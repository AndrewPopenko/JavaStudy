package udemy.testing.rest.api.with.restassured.common;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import udemy.testing.rest.api.with.restassured.constants.Auth;
import udemy.testing.rest.api.with.restassured.constants.Path;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

//@Getter @Setter
public class RestUtilities {
    public static String ENDPOINT;
    public static RequestSpecBuilder REQUEST_BUILDER;
    public static RequestSpecification REQUEST_SPEC;
    public static ResponseSpecBuilder RESPONSE_BUILDER;
    public static ResponseSpecification RESPONSE_SPEC;

    public static void setEndPoint(String endPoint) {
        ENDPOINT = endPoint;
    }

    public static RequestSpecification getRequestSpec() {
        AuthenticationScheme authenticationScheme = RestAssured.oauth(Auth.CONSUMER_KEY, Auth.CONSUMER_SECRET,
                Auth.ACCESS_TOKEN, Auth.ACCESS_SECRET);

        REQUEST_BUILDER = new RequestSpecBuilder();
        REQUEST_BUILDER.setBaseUri(Path.BASE_URI);
        REQUEST_BUILDER.setAuth(authenticationScheme);

        REQUEST_SPEC = REQUEST_BUILDER.build();

        return REQUEST_SPEC;
    }

    public static ResponseSpecification getResponseSpec() {
        RESPONSE_BUILDER = new ResponseSpecBuilder();
        RESPONSE_BUILDER.expectStatusCode(200);
        RESPONSE_BUILDER.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);

        RESPONSE_SPEC = RESPONSE_BUILDER.build();

        return RESPONSE_SPEC;
    }

    public static RequestSpecification createQueryParam(RequestSpecification rspec, String param, String value) {
        return rspec.queryParam(param, value);
    }

    public static RequestSpecification createQueryParam(RequestSpecification rspec, Map<String, String> queryMap) {
        return rspec.queryParams(queryMap);
    }

    public static RequestSpecification createPathParam(RequestSpecification rspec, String param, String value) {
        return rspec.pathParam(param, value);
    }

    public static Response getResponse() {
        return given().get(ENDPOINT);
    }

    public static Response getResponse(RequestSpecification rspec, String type) {
        REQUEST_SPEC.spec(rspec);
        Response response = null;

        switch (type.toLowerCase()) {
            case "get":
                response = given().spec(REQUEST_SPEC).get(ENDPOINT);
                break;
            case "post":
                response = given().spec(REQUEST_SPEC).post(ENDPOINT);
                break;
            case "put":
                response = given().spec(REQUEST_SPEC).put(ENDPOINT);
                break;
            case "delete":
                response = given().spec(REQUEST_SPEC).delete(ENDPOINT);
                break;
            default:
                System.out.println("HTTP method is not supported");
                break;
        }

        /*if (type.equalsIgnoreCase("get")) {
            response = given().spec(REQUEST_SPEC).get(ENDPOINT);
        } else if (type.equalsIgnoreCase("post")) {
            response = given().spec(REQUEST_SPEC).post(ENDPOINT);
        } else if (type.equalsIgnoreCase("put")) {
            response = given().spec(REQUEST_SPEC).put(ENDPOINT);
        } else if (type.equalsIgnoreCase("delete")) {
            response = given().spec(REQUEST_SPEC).delete(ENDPOINT);
        } else {
            System.out.println("HTTP method is not supported");
        }*/

        response.then().log().all();
        response.then().spec(RESPONSE_SPEC);

        return response;
    }

    public static JsonPath getJsonPath(Response response) {
        String jsonPath = response.asString();
        return new JsonPath(jsonPath);
    }

    public static XmlPath getXmlPath(Response response) {
        String jsonPath = response.asString();
        return new XmlPath(jsonPath);
    }

    public static void setContentType(ContentType type) {
        given().contentType(type);
    }
}