package cn.fsongs.cake.app.business.business;

import cn.fsongs.cake.api.dingtalk.DingRecordClient;
import cn.fsongs.cake.api.dingtalk.DingTokenApi;
import cn.fsongs.cake.api.wechat.WxApi;
import cn.fsongs.cake.common.constant.api.ApiResConstant;
import cn.fsongs.cake.common.core.code.ApiResFailCode;
import cn.fsongs.cake.common.exception.BusinessAssert;
import cn.fsongs.cake.common.exception.BusinessException;
import cn.fsongs.cake.model.pojo.bo.api.DingRecordBO;
import cn.fsongs.cake.model.pojo.bo.api.DingTokenBO;
import cn.fsongs.cake.model.pojo.vo.api.DingRecordVO;
import cn.fsongs.cake.model.pojo.vo.api.DingTokenVO;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 12:13
 */
@Component
public class AttendanceBusiness {
    /**
     * 钉钉-appKey
     */
    private static final String DING_KEY = "dingnfclxg7kk3bs6dig";

    /**
     * 钉钉-appSecret
     */
    private static final String DING_SECRET = "D8iEnRlZQdRiCP_0lZ_uf6HyeglbgehV0U9TX3IB6_NflhQkGjWrhzfrBPPPpVg_";

    /**
     * 微信-appId
     */
    private static final String WECHAT_KEY = "wxcf35b3eb344403aa";

    /**
     * 微信-appSecret
     */
    private static final String WECHAT_SECRET = "28bf865dfe3e290cc4b05e29bd4dd58c";

    /**
     * 微信-appSecret
     */
    private static final String WECHAT_TYPE = "authorization_code";

    /**
     * 地点
     */
    private static final String DEVICE_NAME = "IX-work大厦";

    /**
     * 机器号
     */
    private static final String DEVICE_ID = "1";

    /**
     * 白名单
     */
    private static final Map<String, String> WHITE_LIST = new HashMap<String, String>() {
        {
            put("oV7CR5QMWBu4CqOSpYb8tvuaEMEE", "01084749613126318215");
            put("oV7CR5bETAVifyJitfpzwbOUMDok", "324311302720047381");
            put("oV7CR5Rdv_goP2QAW_J1ugeITwaY", "226941244924245814");
        }
    };

    @Resource
    private DingTokenApi dingTokenApi;
    @Resource
    private DingRecordClient dingRecordClient;
    @Resource
    private WxApi wxApi;

    public Boolean record(String code, Long checkTime) {
        // 根据code获取openId
        String info = wxApi.userOpenId(WECHAT_KEY, WECHAT_SECRET, code, WECHAT_TYPE);
        JSONObject user = JSONUtil.parseObj(info);
        String openid = (String) user.get("openid");

        // 获取钉钉token
        DingTokenBO bo = new DingTokenBO(DING_KEY, DING_SECRET);
        DingTokenVO token = dingTokenApi.build(bo);
        BusinessAssert.notNull(token.getAccessToken(), ApiResFailCode.TOKEN_BUILD_FAIL);

        //上传记录
        DingRecordBO recordBO = new DingRecordBO();
        recordBO.setUserCheckTime(checkTime);
        recordBO.setDeviceName(DEVICE_NAME);
        recordBO.setDeviceId(DEVICE_ID);
        recordBO.setUserid(WHITE_LIST.get(openid));
        DingRecordVO record = dingRecordClient.record(token.getAccessToken(), recordBO);
        if (!ApiResConstant.DING_OK.equals(record.getErrCode())) {
            throw new BusinessException(ApiResFailCode.RECORD_UPLOAD_FAIL);
        }
        return record.getSuccess();
    }

}
