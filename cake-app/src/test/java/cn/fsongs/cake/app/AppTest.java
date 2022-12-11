package cn.fsongs.cake.app;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 12:29
 */
@Slf4j
@SpringBootTest(classes = AppApplication.class)
@RunWith(SpringRunner.class)
public class AppTest {
    @Test
    public void demo() {
        log.info("this is app test.");
    }

}
