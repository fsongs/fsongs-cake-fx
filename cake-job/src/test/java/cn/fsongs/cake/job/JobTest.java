package cn.fsongs.cake.job;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 12:26
 */
@Slf4j
@SpringBootTest(classes = JobApplication.class)
@RunWith(SpringRunner.class)
public class JobTest {
    @Test
    public void demo() {
        log.info("this is demo job test.");
    }
}
