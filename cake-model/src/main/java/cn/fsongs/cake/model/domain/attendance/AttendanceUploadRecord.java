package cn.fsongs.cake.model.domain.attendance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 12:08
 */
/**
    * 上传记录表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "attendance_upload_record")
public class AttendanceUploadRecord implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "clz_name")
    private String clzName;

    /**
     * 请求ip
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * 是否成功
     */
    @TableField(value = "success")
    private Boolean success;

    /**
     * 上传时间
     */
    @TableField(value = "upload_time")
    private Date uploadTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CLZ_NAME = "clz_name";

    public static final String COL_IP = "ip";

    public static final String COL_SUCCESS = "success";

    public static final String COL_UPLOAD_TIME = "upload_time";
}