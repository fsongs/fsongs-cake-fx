package cn.fsongs.cake.common.core.result;


import cn.fsongs.cake.common.constant.ResConstant;
import cn.fsongs.cake.common.core.code.ResFailCode;
import cn.fsongs.cake.common.core.code.ResSucCode;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/5/16 15:00
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 数据集
     */
    private T data;

    /**
     * 提示信息
     */
    private String message;

    private Result(ResCode resCode) {
        this(resCode, null, resCode.getMessage());
    }

    private Result(ResCode resCode, String msg) {
        this(resCode, null, msg);
    }

    private Result(ResCode resCode, T data) {
        this(resCode, data, resCode.getMessage());
    }

    private Result(ResCode resCode, T data, String msg) {
        this(resCode.getCode(), data, msg);
    }

    private Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    public static <T> Result<T> data(T data) {
        return data(data, ResConstant.SUCCESS_MESSAGE);
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(ResConstant.OK, data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result<>(code, data, data == null ? ResConstant.SUCCESS_MESSAGE : msg);
    }

    public static <T> Result<T> data(T data, ResCode resCode) {
        return new Result<>(resCode.getCode(), data, resCode.getMessage());
    }

    public static <T> Result<T> success() {
        return new Result<>(ResSucCode.SUCCESS);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(ResSucCode.SUCCESS, msg);
    }

    public static <T> Result<T> success(ResCode resCode) {
        return new Result<>(resCode);
    }

    public static <T> Result<T> success(ResCode resCode, String msg) {
        return new Result<>(resCode, msg);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<>(ResFailCode.SERVER_ERROR, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    public static <T> Result<T> fail(ResCode resCode) {
        return new Result<>(resCode);
    }

    public static <T> Result<T> fail(ResCode resCode, String msg) {
        return new Result<>(resCode, msg);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

