package cn.fsongs.cake.model.pojo.vo.api;

import cn.fsongs.cake.model.pojo.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/7/29 1:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DingTokenVO extends BaseVO {
    @JsonProperty("expireIn")
    private Integer expireIn;

    @JsonProperty("accessToken")
    private String accessToken;
}
