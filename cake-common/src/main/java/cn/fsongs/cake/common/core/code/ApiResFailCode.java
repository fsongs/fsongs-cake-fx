package cn.fsongs.cake.common.core.code;

import cn.fsongs.cake.common.core.result.ResCode;

/**
 * api调用相关异常
 * @author fsongs
 * @version 1.0
 * @date 2022/5/16 17:18
 */
public class ApiResFailCode {
    /**
     * api通用异常
     */
    public static final ResCode API_ERROR = new ResCode(200000, "接口调用失败");
    public static final ResCode PARAM_INIT_ERROR = new ResCode(200011, "参数初始化错误");
    public static final ResCode PARAM_ERROR = new ResCode(200012, "参数错误");

    public static final ResCode SHOP_NOT_FOUND = new ResCode(200021, "未找到店铺相关信息");
    public static final ResCode SHOP_IS_NULL = new ResCode(200022, "暂无店铺信息");

    public static final ResCode TOKEN_BUILD_FAIL = new ResCode(200031, "token获取失败");
    public static final ResCode TOKEN_REFRESH_FAIL = new ResCode(200032, "token刷新失败");

    /**
     * 钉钉相关
     */
    public static final ResCode RECORD_UPLOAD_FAIL = new ResCode(200041, "你这瓜有问题");

}
