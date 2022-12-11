package cn.fsongs.cake.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 11:40
 */
@Slf4j
@SpringBootTest(classes = AdminApplication.class)
@RunWith(SpringRunner.class)
public class BusinessTest {

    @Test
    public void demo() {
        System.out.println("this is business test.");
    }
}
