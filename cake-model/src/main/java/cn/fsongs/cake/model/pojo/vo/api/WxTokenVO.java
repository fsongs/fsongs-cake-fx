package cn.fsongs.cake.model.pojo.vo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/12 11:00
 */
@Data
public class WxTokenVO extends WechatVO {
    /**
     * 微信token
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 过期时间 秒
     */
    @JsonProperty("expires_in")
    private Integer expiresIn;

    @Override
    public String toString() {
        return super.toString();
    }
}
