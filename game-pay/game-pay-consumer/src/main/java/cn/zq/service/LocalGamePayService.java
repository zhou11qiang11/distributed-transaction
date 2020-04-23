package cn.zq.service;

import cn.zq.pojo.Pay;
import cn.zq.pojo.Users;
import org.apache.dubbo.config.annotation.Reference;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LocalGamePayService {

    @Reference(version = "1.0.0",retries = 0,timeout = 10000)
    private  GamePayService gamePayService;

    @Reference(version = "1.0.0",retries = 0,timeout = 10000)
    private GameUserService gameUserService;

    @Hmily
    public void gamePay(Integer userId,Double amount){
        Pay pay = new Pay();
        pay.setPaydate(new Date());
        pay.setUid(userId);
        pay.setAmount(amount);
        //TCC分布式事务
        //1.Try
        int count1 = gamePayService.insertPay(pay);
        System.out.println("pay---->try,结果:"+count1);
        int count2 = gameUserService.updateUserRemaining(userId,amount);
        System.out.println("user---->try,结果:"+count2);
    }
}
