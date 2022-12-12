package cn.fsongs.cake.model.pojo.vo.api.wx;

import cn.fsongs.cake.model.pojo.vo.api.WxVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/12 11:37
 */
@Data
public class WxLoginVO extends WxVO {
    /**
     * 用户openid
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 会话密钥
     */
    @JsonProperty("session_key")
    private String sessionKey;

    /**
     * 用户在开放平台的唯一标识符
     */
    @JsonProperty("unionid")
    private String unionId;

    @Override
    public String toString() {
        return super.toString();
    }
}
