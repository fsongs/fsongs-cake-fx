package cn.fsongs.cake.model.pojo;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/11/30 10:55
 */
public abstract class BasePojo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
