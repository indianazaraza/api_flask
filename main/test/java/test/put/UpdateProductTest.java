package test.put;

import consts.ProductsEndpoints;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import java.util.Map;

public class UpdateProductTest extends BaseTest {
    @Test
    public void updateProduct(){
        String newProductName = "escritorio";
        getRequestGiven()
                .pathParam("id", "3")
                .body(Map.of(
                        "name", newProductName,
                        "description", "simple"
                ))
                .contentType(ContentType.JSON)
                .when()
                .put(ProductsEndpoints.ID_PRODUCT_URL)
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo(newProductName));
    }
}
