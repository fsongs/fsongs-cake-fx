package cn.fsongs.cake.common.exception;


import cn.fsongs.cake.common.core.code.ApiResFailCode;
import cn.fsongs.cake.common.core.result.ResCode;
import lombok.Getter;

/**
 * 自定义异常对象 - api调用异常
 */
@Getter
public class ApiException extends RuntimeException {

    private int code;

    /**
     * 空参构造
     */
    public ApiException() {
    }

    /**
     * 统一异常处理
     */
    public ApiException(ResCode resCode) {
        super(resCode.getMessage());
        this.code = resCode.getCode();
    }

    public ApiException(ResCode resCode, String message) {
        super(message);
        this.code = resCode.getCode();
    }

    /**
     * 统一异常处理
     * @param code    状态码
     * @param message 提示信息
     */
    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ApiException(String message) {
        super(message);
        this.code = ApiResFailCode.API_ERROR.getCode();
    }

}
