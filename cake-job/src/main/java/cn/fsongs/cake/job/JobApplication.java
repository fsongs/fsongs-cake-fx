package cn.fsongs.cake.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/12/11 12:12
 */
@EnableFeignClients(basePackages = {"cn.fsongs.cake.api"})
@SpringBootApplication
@ComponentScan("cn.fsongs.cake")
@MapperScan("cn.fsongs.cake.model.mapper")
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }
}
