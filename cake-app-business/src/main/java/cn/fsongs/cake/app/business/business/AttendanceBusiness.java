package cn.fsongs.cake.app.business.business;

import cn.fsongs.cake.api.dingtalk.DingRecordClient;
import cn.fsongs.cake.api.dingtalk.DingTokenApi;
import cn.fsongs.cake.common.constant.api.ApiResConstant;
import cn.fsongs.cake.common.core.code.ApiResFailCode;
import cn.fsongs.cake.common.exception.BusinessAssert;
import cn.fsongs.cake.common.exception.BusinessException;
import cn.fsongs.cake.model.pojo.bo.api.DingRecordBO;
import cn.fsongs.cake.model.pojo.bo.api.DingTokenBO;
import cn.fsongs.cake.model.pojo.vo.api.DingRecordVO;
import cn.fsongs.cake.model.pojo.vo.api.DingTokenVO;
import cn.hutool.core.map.MapUtil;
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
    private static final String KEY = "dingnfclxg7kk3bs6dig";

    /**
     * 钉钉-appSecret
     */
    private static final String SECRET = "D8iEnRlZQdRiCP_0lZ_uf6HyeglbgehV0U9TX3IB6_NflhQkGjWrhzfrBPPPpVg_";

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

    public Boolean build(String code, Long checkTime) {
        DingTokenBO bo = new DingTokenBO(KEY, SECRET);
        DingTokenVO token = dingTokenApi.build(bo);
        BusinessAssert.notNull(token.getAccessToken(), ApiResFailCode.TOKEN_BUILD_FAIL);

        DingRecordBO recordBO = new DingRecordBO();
        recordBO.setUserCheckTime(checkTime);
        recordBO.setDeviceName(DEVICE_NAME);
        recordBO.setDeviceId(DEVICE_ID);
        recordBO.setUserid(WHITE_LIST.get(code));
        DingRecordVO record = dingRecordClient.record(token.getAccessToken(), recordBO);
        if (!ApiResConstant.DING_OK.equals(record.getErrCode())) {
            throw new BusinessException(ApiResFailCode.RECORD_UPLOAD_FAIL);
        }
        return record.getSuccess();
    }

    /**
     * 白名单
     *
     * @return key:微信openId,value:钉钉userId
     */
    private static final Map<String, String> whiteList() {
        Map<String, String> map = MapUtil.newHashMap();
        map.put("oV7CR5QMWBu4CqOSpYb8tvuaEMEE", "01084749613126318215");
        map.put("oV7CR5bETAVifyJitfpzwbOUMDok", "324311302720047381");
        map.put("oV7CR5Rdv_goP2QAW_J1ugeITwaY", "226941244924245814");
        return map;
    }

}
