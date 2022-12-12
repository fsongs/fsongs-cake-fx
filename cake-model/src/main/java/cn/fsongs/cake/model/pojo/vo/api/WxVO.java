package cn.fsongs.cake.model.pojo.vo.api;

import cn.fsongs.cake.model.pojo.BasePojo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/12 11:01
 */
@Data
public abstract class WxVO extends BasePojo {
    /**
     * 错误代码
     */
    @JsonProperty("errcode")
    private Integer errCode;

    /**
     * 返回消息
     */
    @JsonProperty("errmsg")
    private String errMsg;

    @Override
    public String toString() {
        return super.toString();
    }
}
