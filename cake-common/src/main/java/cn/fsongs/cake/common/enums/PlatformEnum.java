package cn.fsongs.cake.common.enums;

/**
 * 平台枚举
 * @author fsongs
 * @version 1.0
 * @date 2022/7/26 11:10
 */
public enum PlatformEnum {
    // 0.未知, 1.抖店, 2.快手, 3.微信, 4.拼多多
    UNKNOWN(0, "未知"),
    DOU_DIAN(1, "抖店"),
    KUAI_SHOU(2, "快手"),
    WECHAT(3, "微信"),
    PDD(4, "拼多多");
    final int code;
    final String desc;

    PlatformEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static String getEnumDescByCode(int code) {
        PlatformEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            PlatformEnum e = var1[var3];
            if (e.code == code) {
                return e.getDesc();
            }
        }
        return null;
    }

    public static Integer getEnumCodeDesc(String desc) {
        PlatformEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            PlatformEnum e = var1[var3];
            if (e.desc.equals(desc)) {
                return e.getCode();
            }
        }
        return null;
    }
}
