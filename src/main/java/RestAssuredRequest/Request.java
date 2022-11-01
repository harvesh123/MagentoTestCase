package RestAssuredRequest;

import Parser.UserResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class Request {
    private static final Logger requestLogger = Logger.getLogger(Request.class.getName());

    public UserResponseModel getRandomUser() throws IOException {
        RestAssured.baseURI = "https://randomuser.me";
        RestAssured.basePath = "/api/";

        Response response = given().header("Accept", "application/hal+json")
                .header("Content-Type", "application/json").when().get();

        requestLogger.info("Random User Generated For Registration");

        //convert json string to object
        ObjectMapper objectMapper = new ObjectMapper();
        UserResponseModel userResponseModel = objectMapper.readValue(response.asString(), UserResponseModel.class);
        return userResponseModel;
    }
}
