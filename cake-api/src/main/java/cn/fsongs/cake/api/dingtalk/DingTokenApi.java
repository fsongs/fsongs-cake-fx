package cn.fsongs.cake.api.dingtalk;

import cn.fsongs.cake.model.pojo.bo.api.DingTokenBO;
import cn.fsongs.cake.model.pojo.vo.api.DingTokenVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

;

/**
 * 钉钉api
 * @author fsongs
 * @version 1.0
 * @date 2022/7/24 14:33
 * @apiNote name属性与类名不同
 */
@Component
@FeignClient(url = "https://api.dingtalk.com/v1.0", name = "dtApi")
public interface DingTokenApi {

    /**
     * 获取钉钉 access_token
     * @param dingTokenBo 入参
     * @return token
     */
    @PostMapping("/oauth2/accessToken")
    DingTokenVO build(@RequestBody DingTokenBO dingTokenBo);

}
