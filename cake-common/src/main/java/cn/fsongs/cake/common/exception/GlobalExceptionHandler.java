package cn.fsongs.cake.common.exception;

import cn.fsongs.cake.common.core.code.ResFailCode;
import cn.fsongs.cake.common.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author fsongs
 * @version 1.0
 * @date 2022/5/17 10:06
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常 - 业务异常
     * @param e 异常
     * @return 返回
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> businessException(BusinessException e) {
        log.error(e.getMessage());
        return Result.fail(e.getMessage());
    }

    /**
     * 自定义异常 - api调用异常
     * @param e 异常
     * @return 返回
     */
    @ExceptionHandler(ApiException.class)
    public Result<?> apiException(ApiException e) {
        log.error("API调用异常，code：{}，msg：{}",e.getCode(), e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 全局异常
     * @param e 异常
     * @return 返回
     */
    @ExceptionHandler(Exception.class)
    public Result<?> globalException(Exception e) {
        e.printStackTrace();
        return Result.fail(ResFailCode.SERVER_ERROR);
    }
}
