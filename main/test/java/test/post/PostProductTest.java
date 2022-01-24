package test.post;

import consts.ProductsEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import java.util.Map;

public class PostProductTest extends BaseTest {
    private String idNewProduct;

    @Test
    public void createProduct(){
        String productName= "monitor";
        Response response = (Response) getRequestGiven()
                .body(Map.of(
                        "name", productName,
                        "description", "full hd"
                        ))
                .contentType(ContentType.JSON)
                .post(ProductsEndpoints.ALL_PRODUCTS_URL);
        idNewProduct = response.body().jsonPath().get("id").toString();
        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(productName));
    }

    @AfterEach
    public void deleteNewProduct(){
        getRequestGiven()
                .pathParam("id", idNewProduct)
                .delete(ProductsEndpoints.ID_PRODUCT_URL)
                .then()
                .statusCode(200);
    }
}
