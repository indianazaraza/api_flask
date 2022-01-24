package test.delete;

import consts.ProductsEndpoints;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import java.util.Map;

public class DeleteProductTest extends BaseTest {
    private String idNewProduct;

    @BeforeEach
    public void createNewProduct(){
        idNewProduct = getRequestGiven()
                .body(Map.of(
                        "name", "gabinete",
                        "description", "acrilico"
                ))
                .contentType(ContentType.JSON)
                .when()
                .post(ProductsEndpoints.ALL_PRODUCTS_URL)
                .body().jsonPath().get("id").toString();

    }


    @Test
    public void deleteProduct(){
        getRequestGiven()
                .pathParams("id", idNewProduct)
                .when()
                .delete(ProductsEndpoints.ID_PRODUCT_URL)
                .then()
                .statusCode(200);
        getRequestGiven()/*check that the product does not exist*/
                .get(ProductsEndpoints.ALL_PRODUCTS_URL)
                .then()
                .statusCode(200)
                .body("id", Matchers.not(Matchers.hasItem(idNewProduct)));
    }
}
