package cn.fsongs.cake.common.util.core;

import cn.fsongs.cake.common.core.code.ResFailCode;
import cn.fsongs.cake.common.core.result.ResCode;
import cn.fsongs.cake.common.exception.BusinessAssert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/8/18 16:41
 */
public class EntityUtil {
    /**
     * 请求参数校验, 为空就报错
     * @param param 入参
     */
    public static void check(Object... param) {
        for (Object obj : param) {
            BusinessAssert.notNull(obj, ResFailCode.MUST_PARAM_NULL);
        }
    }

    /**
     * 请求参数校验, 为空就报错
     * @param param 入参
     */
    public static void check(ResCode res, Object... param) {
        for (Object obj : param) {
            BusinessAssert.notNull(obj, res);
        }
    }

    /**
     * 参数判空 -- 集合
     */
    public static boolean isNull(Collection<?> entity) {
        return CollectionUtils.isEmpty(entity);
    }

    /**
     * 参数判空 -- 字符串
     */
    public static boolean isNull(CharSequence entity) {
        return StringUtils.isBlank(entity);
    }

    /**
     * 参数判空 -- 对象
     */
    public static boolean isNull(Object entity) {
        return Objects.isNull(entity);
    }

    /**
     * 参数判空 -- 集合
     */
    public static boolean notNull(Collection<?> entity) {
        return !isNull(entity);
    }

    /**
     * 参数判空 -- 字符串
     */
    public static boolean notNull(String entity) {
        return !isNull(entity);
    }

    /**
     * 参数判空 -- 对象
     */
    public static boolean notNull(Object entity) {
        return !isNull(entity);
    }

    /**
     * 参数初始化 -- 集合
     */
    public static Collection<?> initNull(Collection<?> entity) {
        return isNull(entity) ? null : entity;
    }

    /**
     * 参数初始化 -- 字符串
     */
    public static CharSequence initNull(CharSequence entity) {
        return isNull(entity) ? null : entity;
    }

    /**
     * 参数初始化 -- 数字
     */
    public static Number initNull(Number entity) {
        return isNull(entity) ? 0 : entity;
    }
}
