package cn.fsongs.cake.model.pojo.bo.api;

import cn.fsongs.cake.model.pojo.bo.BaseBO;
import lombok.Data;

import java.util.Date;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/11/30 16:07
 */
@Data
public abstract class ApiBO extends BaseBO {
    private static final long serialVersionUID = 1L;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 获取秒时间
     * @param datetime 日期类时间
     * @return 秒
     */
    protected abstract Long second(Date datetime);
}
