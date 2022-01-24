package test.delete;

import arguments.holder.ProductValidationArgsHolder;
import arguments.provider.ProductValidationArgsProvider;
import consts.ProductsEndpoints;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import test.BaseTest;

public class DeleteProductValidation extends BaseTest {

    @ParameterizedTest
    @ArgumentsSource(ProductValidationArgsProvider.class)
    public void deleteProductInvalidId(ProductValidationArgsHolder validationArgs){
        getRequestGiven()
                .pathParams(validationArgs.getParams())
                .when()
                .delete(ProductsEndpoints.ID_PRODUCT_URL)
                .then()
                .statusCode(500);
    }
}
