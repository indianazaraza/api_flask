package test.post;

import arguments.holder.ProductBodyValidationArgsHolder;
import arguments.provider.ProductBodyValidationArgsProvider;
import consts.ProductsEndpoints;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import test.BaseTest;

public class PostProductValidation extends BaseTest {

    @ParameterizedTest
    @ArgumentsSource(ProductBodyValidationArgsProvider.class)
    public void createProductInvalidBody(ProductBodyValidationArgsHolder validationArgs){
        getRequestGiven()
                .body(validationArgs.getParams())
                .contentType(ContentType.JSON)
                .when()
                .post(ProductsEndpoints.ALL_PRODUCTS_URL)
                .then()
                .statusCode(validationArgs.getStatusCode());
    }
}
