package tld.sld.webapp.web.models.responses;

import java.util.Map;

public class BaseResponse<T> {
    private boolean success = false;
    private T data = null;
    private String errorMessage = null;
    private Map<String, String> errors = null;

    static public BaseResponse builder() {
        return new BaseResponse();
    }

    public BaseResponse success(final boolean success) {
        this.success = success;
        return this;
    }

    public BaseResponse data(final T data) {
        this.data = data;
        return this;
    }

    public BaseResponse errorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public BaseResponse errors(final Map<String, String> errors) {
        this.errors = errors;
        return this;
    }

    public boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
            "success=" + success +
            ", data=" + data +
            ", errorMessage='" + errorMessage + '\'' +
            ", errors=" + errors +
            '}';
    }
}
