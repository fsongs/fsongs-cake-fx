package cn.fsongs.cake.common.exception;


import cn.fsongs.cake.common.core.code.ResFailCode;
import cn.fsongs.cake.common.core.result.ResCode;
import lombok.Getter;

/**
 * 自定义异常对象
 */
@Getter
public class BusinessException extends RuntimeException {

    private long code;

    /**
     * 空参构造
     */
    public BusinessException() {
    }

    /**
     * 统一异常处理
     */
    public BusinessException(ResCode resCode) {
        super(resCode.getMessage());
        this.code = resCode.getCode();
    }

    public BusinessException(ResCode resCode, String message) {
        super(message);
        this.code = resCode.getCode();
    }

    /**
     * 统一异常处理
     * @param code    状态码
     * @param message 提示信息
     */
    public BusinessException(long code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
        this.code = ResFailCode.SERVER_ERROR.getCode();
    }

}
