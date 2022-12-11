package cn.fsongs.cake.api.wechat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/10/31 15:04
 */
@Component
@FeignClient(url = "https://api.weixin.qq.com", name = "wxApi")
public interface WxApi {
    /**
     * 获取用户openid
     */
    @PostMapping("/sns/jscode2session")
    String getOpenId(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("js_code") String code, @RequestParam("grant_type") String type);
}
