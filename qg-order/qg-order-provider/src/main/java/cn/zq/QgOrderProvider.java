package cn.zq;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class QgOrderProvider {
    public static void main(String[] args) {
        SpringApplication.run(QgOrderProvider.class ,args);
        System.out.println("OrderProvider-------->启动成功");
    }

}
