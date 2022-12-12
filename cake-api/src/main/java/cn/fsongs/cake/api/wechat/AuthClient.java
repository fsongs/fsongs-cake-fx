package cn.fsongs.cake.api.wechat;

import cn.fsongs.cake.common.constant.api.ApiUrlConstant;
import cn.fsongs.cake.model.pojo.vo.api.wx.WxLoginVO;
import cn.fsongs.cake.model.pojo.vo.api.wx.WxTokenVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/12 10:53
 */
@Component
@FeignClient(url = ApiUrlConstant.WECHAT_URL, name = "wxAuth")
public interface AuthClient {

    /**
     * 获取token
     * @param appid appKey
     * @param secret appSecret
     * @param type 类型默认 “client_credential”
     * @return
     */
    @GetMapping("/cgi-bin/token")
    WxTokenVO buildToken(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("grant_type") String type);

    /**
     * 获取用户openid
     * @param appid appKey
     * @param secret appSecret
     * @param code 用户code, 小程序端获取
     * @param type 类型默认 “authorization_code”
     * @return
     */
    @PostMapping("/sns/jscode2session")
    WxLoginVO userOpenId(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("js_code") String code, @RequestParam("grant_type") String type);
}
