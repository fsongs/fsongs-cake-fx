package cn.fsongs.cake.job.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 12:20
 */
@Component
@Slf4j
public class DemoJob {

    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJob() {
        execute();
        return ReturnT.SUCCESS;
    }

    private void execute() {
        log.info("this is demo job.");
    }
}
