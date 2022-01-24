package test.put;

import arguments.holder.ProductBodyValidationArgsHolder;
import arguments.provider.ProductBodyValidationArgsProvider;
import consts.ProductsEndpoints;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import test.BaseTest;


public class UpdateProductValidation extends BaseTest {

    @ParameterizedTest
    @ArgumentsSource(ProductBodyValidationArgsProvider.class)
    public void updateProductInvalidBody(ProductBodyValidationArgsHolder validationArgs){
        getRequestGiven()
                .pathParam("id", validationArgs.getId())
                .body(validationArgs.getParams())
                .contentType(ContentType.JSON)
                .put(ProductsEndpoints.ID_PRODUCT_URL)
                .then()
                .statusCode(validationArgs.getStatusCode());

    }
}
