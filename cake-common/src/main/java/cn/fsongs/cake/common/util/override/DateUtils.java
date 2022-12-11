package cn.fsongs.cake.common.util.override;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Objects;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/6/26 11:13
 */
public class DateUtils extends DateUtil {
    private final static String WEB_DATE = "yyyy-MM-dd";
    private final static String SQL_DATE = "yyyyMMdd";

    /**
     * 一个格式的时间字符串转化为另一个格式的时间字符串
     * 例："2022-02-26"  -> "20220226"
     * @return
     */
    public static String strToStr(String date, String oldFormat, String newFormat) {
        return format(parse(date, oldFormat), newFormat);
    }

    /**
     * 字符串转化: yyyy-MM-dd -> yyyyMMdd
     * @return
     */
    public static String strToStr(String date) {
        return strToStr(date, WEB_DATE, SQL_DATE);
    }

    /**
     * 秒级时间戳转化为时间
     * @param date 时间戳(秒)
     */
    public static DateTime dateSeconds(long date) {
        return new DateTime(date * 1000);
    }

    /**
     * 日期转化为秒级时间戳
     * @return 时间戳(秒)
     */
    public static long seconds(Date date) {
        return Objects.isNull(date) ? 0 : date.getTime() / 1000;
    }

    /**
     * 日期转化为秒级时间戳
     * @return 时间戳(秒)-包装类
     */
    public static Long secondL(Date date) {
        return Objects.isNull(date) ? null : date.getTime() / 1000;
    }

    /**w
     * 获取偏移天的时间戳
     * @param date   日期
     * @param offset 偏移天数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的时间戳
     */
    public static long offsetDayToMilli(Date date, int offset) {
        return offsetDay(date, offset).getTime();
    }

    /**w
     * 获取偏移天的秒级时间戳
     * @param date   日期
     * @param offset 偏移天数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的时间戳(秒)
     */
    public static long offsetDayToSeconds(Date date, int offset) {
        return offsetDayToMilli(date, offset) / 1000;
    }

    /**
     * 89天之前
     * @return 89天之前的时间
     */
    public static Date day89Ago() {
        return day89Ago(new DateTime());
    }

    /**
     * 89天之前
     * @return 89天之前的时间
     */
    public static Date day89Ago(Date date) {
        return offsetDay(date, -89);
    }

    /**
     * 90天之前
     * @return 90天之前的时间
     */
    public static Date day90Ago() {
        return offsetDay(new DateTime(), -90);
    }

    /**
     * 一周之前 / 7天
     * @return 7天之前的时间
     */
    public static Date weekAgo() {
        return offsetDay(new DateTime(), -7);
    }

    /**
     * 一周之前 / 7天
     * @return 7天之前的时间
     */
    public static Date weekAgo(Date date) {
        return offsetDay(date, -7);
    }

    /**
     * 一周之后 / 7天
     * @return 7天之后的时间
     */
    public static Date weekAfter() {
        return offsetDay(new DateTime(), 7);
    }

    /**
     * 一周之后 / 7天
     * @return 7天之后的时间
     */
    public static Date weekAfter(Date date) {
        return offsetDay(date, 7);
    }

    /**
     * 某天的昨天
     * @return 昨天
     */
    public static DateTime yesterday(Date date) {
        return offsetDay(date, -1);
    }

    /**
     * 某天的明天
     * @return 明天
     * @since 3.0.1
     */
    public static DateTime tomorrow(Date date) {
        return offsetDay(date, 1);
    }
}
