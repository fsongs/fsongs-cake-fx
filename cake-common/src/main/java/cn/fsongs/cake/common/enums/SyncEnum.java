package cn.fsongs.cake.common.enums;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/8/2 23:22
 */
public class SyncEnum {
    /**
     * sku同步状态
     */
    public enum GOODS_STATUS {
        // 0.未同步, 1.同步成功, 2.同步失败
        NOT_SYNC(0),
        SUCCESS(1),
        FAIL(2);

        final int code;

        GOODS_STATUS(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }
}
