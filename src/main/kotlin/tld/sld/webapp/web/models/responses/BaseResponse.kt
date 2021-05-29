package tld.sld.webapp.web.models.responses

class BaseResponse<T> {
    var success: Boolean = false
    var data: T? = null
    var errorMessage: String? = null
    var errors: Map<String, String>? = null

    constructor(success: Boolean, data: T?, errorMessage: String?, errors: Map<String, String>?) {
        this.success = success
        this.data = data
        this.errorMessage = errorMessage
        this.errors = errors
    }

    override fun toString(): String {
        return "BaseResponse{" +
                "success=" + success +
                ", data=" + data +
                ", errorMessage='" + errorMessage + '\'' +
                ", errors=" + errors +
                '}'
    }
}