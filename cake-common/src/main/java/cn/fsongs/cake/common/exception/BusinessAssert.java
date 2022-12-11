package cn.fsongs.cake.common.exception;

import cn.fsongs.cake.common.core.result.ResCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 遇事不决抛异常
 */
public class BusinessAssert {
    public BusinessAssert() {
    }

    public static void notNull(Object obj, String message) {
        if (null == obj) {
            throw new BusinessException(message);
        }
    }

    public static void notNull(Object obj, ResCode resCode) {
        if (null == obj) {
            throw new BusinessException(resCode);
        }
    }

    public static void notNull(Collection<?> coll, String message) {
        if (CollectionUtils.isEmpty(coll)) {
            throw new BusinessException(message);
        }
    }

    public static void notNull(Collection<?> coll, ResCode resCode) {
        if (CollectionUtils.isEmpty(coll)) {
            throw new BusinessException(resCode);
        }
    }

    public static void notNull(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new BusinessException(message);
        }
    }

    public static void notNull(String str, ResCode resCode) {
        if (StringUtils.isBlank(str)) {
            throw new BusinessException(resCode);
        }
    }


    public static void isNull(Object obj, String message) {
        if (null != obj) {
            throw new BusinessException(message);
        }
    }

    public static void isNull(Object obj, ResCode resCode) {
        if (null != obj) {
            throw new BusinessException(resCode);
        }
    }

    public static void isTrue(boolean express, String message) {
        if (!express) {
            throw new BusinessException(message);
        }
    }

    public static void isTrue(boolean express, ResCode resCode) {
        if (!express) {
            throw new BusinessException(resCode);
        }
    }

    public static void isTrue(boolean express) {
        if (!express) {
            throw new BusinessException();
        }
    }
}