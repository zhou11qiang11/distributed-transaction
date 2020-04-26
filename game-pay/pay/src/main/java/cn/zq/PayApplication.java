package cn.zq;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class,args);
        System.out.println("PayApplication----------->启动成功");
    }
}
