package cn.fsongs.cake.common.util.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * mysql 1000 -> 1元
 * 钳钳工具类
 * @author fsongs
 * @version 1.0
 * @date 2022/6/26 11:30
 */
public class MoneyUtil {
    private final static int MONEY_CHANGE = 10000;

    /**
     * web转sql: x10000
     * @param money
     * @return
     */
    public static Long webToSql(String money) {
        return new BigDecimal(money).movePointRight(4).longValue();
    }
    /**
     * sql转web: ÷10000
     * @param money
     * @return
     */
    public static String sqlToWeb(Long money) {
        return new BigDecimal(money).movePointLeft(4).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    /**
     * 抖店转sql: x100
     * @param money
     * @return
     */
    public static Long apiToSql(Long money) {
        return new BigDecimal(money).movePointRight(2).longValue();
    }
}
