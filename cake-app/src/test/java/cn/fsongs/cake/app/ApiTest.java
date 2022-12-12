package cn.fsongs.cake.app;

import cn.fsongs.cake.api.dingtalk.DingRecordApi;
import cn.fsongs.cake.api.dingtalk.DingTokenApi;
import cn.fsongs.cake.api.wechat.AuthApi;
import cn.fsongs.cake.api.wechat.CustomerApi;
import cn.fsongs.cake.common.util.override.DateUtils;
import cn.fsongs.cake.model.pojo.bo.api.ding.DingRecordBO;
import cn.fsongs.cake.model.pojo.bo.api.ding.DingTokenBO;
import cn.fsongs.cake.model.pojo.bo.api.wx.CustomerPhoneBO;
import cn.fsongs.cake.model.pojo.vo.api.ding.DingRecordVO;
import cn.fsongs.cake.model.pojo.vo.api.ding.DingTokenVO;
import cn.fsongs.cake.model.pojo.vo.api.wx.WxLoginVO;
import cn.fsongs.cake.model.pojo.vo.api.wx.WxTokenVO;
import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
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
    private DingRecordApi dingRecordClient;
    @Resource
    private AuthApi authClient;
    @Resource
    private CustomerApi customerApi;

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

    @Test
    public void wxToken() {
        WxTokenVO wxTokenVO = authClient.buildToken("wxcf35b3eb344403aa", "28bf865dfe3e290cc4b05e29bd4dd58c", "client_credential");
        System.out.println(wxTokenVO.toString());
    }

    @Test
    public void openId() {
        WxLoginVO wxLoginVO = authClient.userOpenId("wxcf35b3eb344403aa", "28bf865dfe3e290cc4b05e29bd4dd58c", "013BOj0w35daKZ2sth3w3QWjt81BOj0l", "authorization_code");
        System.out.println(wxLoginVO.toString());
    }

    @Test
    public void phone() {
        CustomerPhoneBO bo = new CustomerPhoneBO();
        bo.setCode("063aEE0w3ljfJZ2e4N1w3viEpW1aEE0b");
        JSONObject vo = customerApi.userPhoneNumber("63_CZrS7LA9h9mmFzlrQ2FMrt_Z7FAYVS59kZyUt4d0cLidgWxCs2EBU0hLOO5nFMNUjVUCNb55hIWHOCoBBtWXTokg9c7F2t3rS26fnau6rjkWoYnWwUCPcqyyOpMMDNiAEAIZJ", bo);
        System.out.println(vo.toString());
    }
}
