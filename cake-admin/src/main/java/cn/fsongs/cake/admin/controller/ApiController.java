package cn.fsongs.cake.admin.controller;

import cn.fsongs.cake.common.core.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 11:38
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/demo")
    public Result<Boolean> demo() {
        return Result.data(true, "返回成功");
    }
}
