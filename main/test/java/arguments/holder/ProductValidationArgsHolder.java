package arguments.holder;

import java.util.Map;

public class ProductValidationArgsHolder {
    private final Map<String, Object> params;
    private final int statusCode;

    public ProductValidationArgsHolder(Map<String, Object> params, int statusCode) {
        this.params = params;
        this.statusCode = statusCode;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
