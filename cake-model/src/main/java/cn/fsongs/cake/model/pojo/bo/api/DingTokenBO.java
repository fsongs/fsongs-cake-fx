package cn.fsongs.cake.model.pojo.bo.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/7/29 1:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DingTokenBO {
    /**
     * 钉钉 app_key
     */
    private String appKey;

    /**
     * 钉钉 app_secret
     */
    private String appSecret;
}
