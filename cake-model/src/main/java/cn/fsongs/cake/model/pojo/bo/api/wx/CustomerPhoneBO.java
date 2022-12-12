package cn.fsongs.cake.model.pojo.bo.api.wx;

import cn.fsongs.cake.model.pojo.bo.BaseBO;
import lombok.Data;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/12 14:16
 */
@Data
public class CustomerPhoneBO extends BaseBO {
    /**
     * 手机号获取凭证
     */
    private String code;

    @Override
    public String toString() {
        return super.toString();
    }
}
