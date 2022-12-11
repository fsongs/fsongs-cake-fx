package cn.fsongs.cake.common.core.code;


import cn.fsongs.cake.common.constant.ResConstant;
import cn.fsongs.cake.common.core.result.ResCode;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/5/16 17:18
 */
public class ResFailCode {
    /**
     * 通用 10
     */
    public static final ResCode SERVER_ERROR = new ResCode(ResConstant.ERROR, "服务器内部错误");

    public static final ResCode INSERT_ERROR = new ResCode(100011, "数据添加失败");
    public static final ResCode DELETE_ERROR = new ResCode(100012, "数据删除失败");
    public static final ResCode UPDATE_ERROR = new ResCode(100013, "数据修改失败");
    public static final ResCode QUERY_ERROR = new ResCode(100014, "数据查询失败");

    public static final ResCode PARAM_NULL = new ResCode(100021, "请求参数为空");
    public static final ResCode MUST_PARAM_NULL = new ResCode(100021, "必填参数为空");
    public static final ResCode PARAM_TYPE_ERROR = new ResCode(100021, "参数类型不匹配");

    public static final ResCode REDIS_NOT_CACHE = new ResCode(100031, "redis未缓存相关key");

}
