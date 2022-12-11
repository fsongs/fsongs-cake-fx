package cn.fsongs.cake.common.util.core;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/9/5 11:28
 */
public class SqlUtil {
    private static final String PERCENT = "%";

    /**
     * 查询参数左边拼接'%'
     *
     * @param query 查询参数
     * @return 拼接后的字符串 %query
     */
    public static String perLeft(String query) {
        return PERCENT + query;
    }

    /**
     * 查询参数右边拼接'%'
     *
     * @param query 查询参数
     * @return 拼接后的字符串 query%
     */
    public static String perRight(String query) {
        return query + PERCENT;
    }

    /**
     * 查询参数左右两边拼接'%'
     *
     * @param query 查询参数
     * @return 拼接后的字符串 %query%
     */
    public static String percent(String query) {
        return PERCENT + query + PERCENT;
    }
}
