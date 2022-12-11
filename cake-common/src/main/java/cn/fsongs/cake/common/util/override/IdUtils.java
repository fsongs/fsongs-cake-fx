package cn.fsongs.cake.common.util.override;

import cn.fsongs.cake.common.exception.BusinessAssert;
import cn.hutool.core.util.IdUtil;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/7/1 11:37
 */
public class IdUtils extends IdUtil {
    /**
     * 数字+字母
     */
    public static final char[] NUMBER_TO_TEXT_SIXTWO_ARR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * 雪花算法生成id -- 单节点
     * 分布式不要用
     */
    public static long nextId() {
        return getSnowflakeNextId();
    }

    /**
     * 十进制转化62进制
     */
    public static String to62Number(long number) {
        final int scale = 62;
        StringBuilder sb = new StringBuilder(12);
        boolean negative = number < 0;
        if (negative) {
            number = -number;
        }
        BusinessAssert.isTrue(number > 0, "参数必须>0");
        long remainder;
        while (number != 0) {
            remainder = number % scale;
            sb.append(NUMBER_TO_TEXT_SIXTWO_ARR[(int) remainder]);
            number = number / scale;
        }
        if (negative) {
            sb.append('-');
        }
        return sb.toString();
    }
}
