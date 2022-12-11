package cn.fsongs.cake.common.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/5/16 15:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCode implements Serializable {
    private static final long serialVersionUID = -1194431368646619386L;
    
    private Integer code;
    
    private String message;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}