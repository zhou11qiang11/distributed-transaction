package cn.zq;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class QgGoodsConsumer {
    public static void main(String[] args) {
        SpringApplication.run(QgGoodsConsumer.class ,args);
        System.out.println("GoodsConsumer---------->启动成功");
    }

}
