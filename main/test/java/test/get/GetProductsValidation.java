package test.get;

import arguments.holder.ProductValidationArgsHolder;
import arguments.provider.ProductValidationArgsProvider;
import consts.ProductsEndpoints;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import test.BaseTest;

public class GetProductsValidation extends BaseTest {

    @ParameterizedTest
    @ArgumentsSource(ProductValidationArgsProvider.class)
    public void getProductInvalidId(ProductValidationArgsHolder validationArgs){
            Response response = (Response) getRequestGiven()
                    .pathParams(validationArgs.getParams())
                    .get(ProductsEndpoints.ID_PRODUCT_URL);

            response.then()
                    .statusCode(validationArgs.getStatusCode());
    }
}
