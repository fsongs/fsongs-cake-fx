package cn.fsongs.cake.api.wechat;

import cn.fsongs.cake.common.constant.api.ApiUrlConstant;
import cn.fsongs.cake.model.pojo.bo.api.wx.CustomerPhoneBO;
import cn.hutool.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/12 13:58
 */
@Component
@FeignClient(url = ApiUrlConstant.WECHAT_URL, name = "wxCustomer")
public interface CustomerApi {

    /**
     * 获取用户手机号
     * @param token 小程序ccess_token
     * @param bo 用户code
     * @return 电话
     */
    @PostMapping("/wxa/business/getuserphonenumber")
    JSONObject userPhoneNumber(@RequestParam("access_token") String token, @RequestBody CustomerPhoneBO bo);

}
