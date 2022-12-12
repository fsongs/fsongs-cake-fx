package cn.fsongs.cake.model.pojo.bo.api.ding;

import cn.fsongs.cake.model.pojo.bo.BaseBO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 13:45
 */
@Data
public class DingRecordBO extends BaseBO {
    @JsonProperty("device_name")
    private String deviceName = "IX-work大厦";

    @JsonProperty("device_id")
    private String deviceId = "1";

    @JsonProperty("userid")
    private String userid;

    @JsonProperty("user_check_time")
    private Long userCheckTime;
}
