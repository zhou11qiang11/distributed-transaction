package cn.zq;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class PayProvider {

    public static void main(String[] args) {
        SpringApplication.run(PayProvider.class,args);
        System.out.println("payProvider----------->启动成功");
    }
}
