package cn.fsongs.cake.app;

import cn.fsongs.cake.api.dingtalk.DingRecordClient;
import cn.fsongs.cake.api.dingtalk.DingTokenApi;
import cn.fsongs.cake.common.util.override.DateUtils;
import cn.fsongs.cake.model.pojo.bo.api.DingRecordBO;
import cn.fsongs.cake.model.pojo.bo.api.DingTokenBO;
import cn.fsongs.cake.model.pojo.vo.api.DingRecordVO;
import cn.fsongs.cake.model.pojo.vo.api.DingTokenVO;
import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 12:29
 */
@Slf4j
@SpringBootTest(classes = AppApplication.class)
@RunWith(SpringRunner.class)
public class ApiTest {
    @Resource
    private DingTokenApi dingTokenApi;
    @Resource
    private DingRecordClient dingRecordClient;

    @Test
    public void dingToken() {
        DingTokenBO bo = new DingTokenBO();
        DingTokenVO build = dingTokenApi.build(bo);
        log.info(build.toString());
    }

    @Test
    public void dingUploadRecord() {
        DingRecordBO bo = new DingRecordBO();
        DateTime dateTime = DateUtils.parse("2022-10-20 09:22:00");
        bo.setUserCheckTime(dateTime.getTime());
        bo.setUserid("1");
        DingRecordVO record = dingRecordClient.record("557df233d5af37a7b597ce03c6749edd", bo);
        log.info(record.toString());
    }
}
