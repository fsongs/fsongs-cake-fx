package cn.fsongs.cake.common.enums;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/11/30 13:53
 */
public class ShopEnum {

    public enum STATUS {
        // 店铺状态, 0.正常, 1.冻结, 2.删除
        ACTIVE(0),
        FREEZE(1),
        DELETE(2);

        final int code;

        STATUS(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum TYPE {
        // 店铺类型, 0.未知, 1.企业户, 2.个体户
        UNKNOWN(0),
        COMPANY(1),
        PERSON(2);

        final int code;

        TYPE(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }
}
