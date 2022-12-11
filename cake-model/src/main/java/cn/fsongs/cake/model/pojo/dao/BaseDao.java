package cn.fsongs.cake.model.pojo.dao;


import cn.fsongs.cake.model.pojo.BasePojo;

import java.util.Date;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/5 16:24
 */
public abstract class BaseDao extends BasePojo {
    private static final long serialVersionUID = 1L;

    /**
     * 时间戳转化为日期
     * @param timestamp 时间戳
     * @return 日期
     */
    protected abstract Date second(Long timestamp);
}
