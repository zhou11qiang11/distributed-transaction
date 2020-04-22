package cn.zq;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class QgGoodsProvider {
    public static void main(String[] args) {
        SpringApplication.run(QgGoodsProvider.class ,args);
        System.out.println("GoodsProvider-------->启动成功");
    }

}
