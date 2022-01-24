package test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setBaseUrl(){
        RestAssured.baseURI = "http://localhost:5000";
    }

    protected RequestSpecification getRequestGiven(){
        return RestAssured.given();
    }
}
