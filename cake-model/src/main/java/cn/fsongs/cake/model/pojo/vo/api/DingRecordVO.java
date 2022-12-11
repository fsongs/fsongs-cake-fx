package cn.fsongs.cake.model.pojo.vo.api;

import cn.fsongs.cake.model.pojo.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DingRecordVO extends BaseVO {
    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("request_id")
    private String requestId;
}
