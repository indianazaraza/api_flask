package arguments.holder;

import java.util.Map;

public class ProductBodyValidationArgsHolder {
    private final Map<String, Object> params;
    private final String idProduct;
    private final int statusCode;

    public ProductBodyValidationArgsHolder(Map<String, Object> params, String idProduct, int statusCode) {
        this.params = params;
        this.idProduct = idProduct;
        this.statusCode = statusCode;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public String getId() {
        return idProduct;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
