package cn.zq;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDubbo
@EnableScheduling  //定时任务
public class QgGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(QgGoodsApplication.class ,args);
        System.out.println("GoodsConsumer---------->启动成功");
    }

}
