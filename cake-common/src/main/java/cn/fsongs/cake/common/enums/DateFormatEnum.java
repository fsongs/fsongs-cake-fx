package cn.fsongs.cake.common.enums;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/7/6 11:00
 */
public class DateFormatEnum {
    public enum DATE {
        YMD("yyyyMMdd"),
        Y_M_D("yyyy-MM-dd"),
        CHINESE("yyyy年MM月dd日");

        final String format;

        DATE(String format) {
            this.format = format;
        }

        public String get() {
            return this.format;
        }
    }

    public enum TIME {
        HMS("HHmmss"),
        H_M_S("HH:mm:ss"),
        CHINESE("HH时mm分ss秒");

        final String format;

        TIME(String format) {
            this.format = format;
        }

        public String get() {
            return this.format;
        }

    }

    public enum DATE_TIME {
        COMMON("yyyy-MM-dd HH:mm:ss"),
        SIMPLE("yyyy-M-d H:m:s"),
        CHINESE("yyyy年MM月dd日 HH:mm:ss");

        final String format;

        DATE_TIME(String format) {
            this.format = format;
        }

        public String get() {
            return this.format;
        }

    }
}
