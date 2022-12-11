package cn.fsongs.cake.app.controller;

import cn.fsongs.cake.app.business.business.AttendanceBusiness;
import cn.fsongs.cake.common.core.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 14:57
 */
@RestController
@RequestMapping("/ding")
public class RecordController {

    @Resource
    private AttendanceBusiness attendanceBusiness;

    @PostMapping("/record")
    public Result<Boolean> record(@RequestParam("code") String code, @RequestParam("checkTime") Long checkTime) {
        return Result.data(attendanceBusiness.build(code, checkTime), "你这瓜真甜");
    }

}
