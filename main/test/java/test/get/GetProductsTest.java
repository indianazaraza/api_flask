package test.get;

import consts.ParamValues;
import consts.ProductsEndpoints;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import test.BaseTest;

public class GetProductsTest extends BaseTest {
    @Test
    public void getAllProducts(){
        getRequestGiven()
                .get(ProductsEndpoints.ALL_PRODUCTS_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void getProduct(){
        getRequestGiven()
                .pathParam("id", ParamValues.ID_PRODUCT)
                .get(ProductsEndpoints.ID_PRODUCT_URL)
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo("impresora"));
    }
}
