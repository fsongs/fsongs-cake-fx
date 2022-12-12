package cn.fsongs.cake.api.dingtalk;

import cn.fsongs.cake.common.constant.api.ApiUrlConstant;
import cn.fsongs.cake.model.pojo.bo.api.ding.DingRecordBO;
import cn.fsongs.cake.model.pojo.vo.api.ding.DingRecordVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 钉钉api
 * @author fsongs
 * @version 1.0
 * @date 2022/7/24 14:33
 * @apiNote name属性与类名不同
 */
@Component
@FeignClient(url = ApiUrlConstant.DING_URL_O, name = "dingRecord")
public interface DingRecordApi {

    /**
     * 上传记录
     * @param token 钉钉token
     * @param dingRecordBO 入参
     * @return 是否成功
     */
    @PostMapping("/topapi/attendance/record/upload")
    DingRecordVO record(@RequestParam("access_token") String token, @RequestBody DingRecordBO dingRecordBO);
}
