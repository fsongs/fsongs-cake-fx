package cn.fsongs.cake.service.service.attendance.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fsongs.cake.model.mapper.attendance.AttendanceUploadRecordMapper;
import cn.fsongs.cake.model.domain.attendance.AttendanceUploadRecord;
import cn.fsongs.cake.service.service.attendance.AttendanceUploadRecordService;
/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 13:09
 */
@Service
public class AttendanceUploadRecordServiceImpl extends ServiceImpl<AttendanceUploadRecordMapper, AttendanceUploadRecord> implements AttendanceUploadRecordService{

}
