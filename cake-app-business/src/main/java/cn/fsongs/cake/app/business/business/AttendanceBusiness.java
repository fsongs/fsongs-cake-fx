package cn.fsongs.cake.app.business.business;

import cn.fsongs.cake.api.dingtalk.DingRecordApi;
import cn.fsongs.cake.api.dingtalk.DingTokenApi;
import cn.fsongs.cake.api.wechat.AuthApi;
import cn.fsongs.cake.common.constant.api.ApiResConstant;
import cn.fsongs.cake.common.core.code.ApiResFailCode;
import cn.fsongs.cake.common.exception.BusinessAssert;
import cn.fsongs.cake.common.exception.BusinessException;
import cn.fsongs.cake.model.domain.attendance.AttendanceUploadRecord;
import cn.fsongs.cake.model.pojo.bo.api.ding.DingRecordBO;
import cn.fsongs.cake.model.pojo.bo.api.ding.DingTokenBO;
import cn.fsongs.cake.model.pojo.vo.api.ding.DingRecordVO;
import cn.fsongs.cake.model.pojo.vo.api.ding.DingTokenVO;
import cn.fsongs.cake.model.pojo.vo.api.wx.WxLoginVO;
import cn.fsongs.cake.service.service.attendance.AttendanceUploadRecordService;
import cn.hutool.core.date.DateUtil;
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
            put("oV7CR5bETAVifyJitfpzwbOUMDok", "324311302720047381");//me
            put("oV7CR5Rdv_goP2QAW_J1ugeITwaY", "226941244924245814");
        }
    };

    @Resource
    private DingTokenApi dingTokenApi;
    @Resource
    private DingRecordApi dingRecordClient;
    @Resource
    private AuthApi authClient;
    @Resource
    private AttendanceUploadRecordService attendanceUploadRecordService;

    public Boolean record(String code, String clientIp, Long checkTime) {
        // 根据code获取openId
        WxLoginVO login = authClient.userOpenId(WECHAT_KEY, WECHAT_SECRET, code, WECHAT_TYPE);
        String openId = login.getOpenId();

        // 获取钉钉token
        DingTokenBO bo = new DingTokenBO(DING_KEY, DING_SECRET);
        DingTokenVO token = dingTokenApi.build(bo);
        BusinessAssert.notNull(token.getAccessToken(), ApiResFailCode.TOKEN_BUILD_FAIL);

        //上传记录
        DingRecordBO recordBO = new DingRecordBO();
        recordBO.setUserCheckTime(checkTime);
        recordBO.setDeviceName(DEVICE_NAME);
        recordBO.setDeviceId(DEVICE_ID);
        recordBO.setUserid(WHITE_LIST.get(openId));
        DingRecordVO record = dingRecordClient.record(token.getAccessToken(), recordBO);
        if (!ApiResConstant.DING_OK.equals(record.getErrCode())) {
            throw new BusinessException(ApiResFailCode.RECORD_UPLOAD_FAIL);
        }

        //存储记录
        AttendanceUploadRecord upload = new AttendanceUploadRecord();
        upload.setIp(clientIp);
        upload.setUploadTime(DateUtil.date(checkTime));
        upload.setUser(openId);
        upload.setSuccess(record.getSuccess());
        attendanceUploadRecordService.save(upload);

        return record.getSuccess();
    }

}
