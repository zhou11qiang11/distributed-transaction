package cn.zq.service.impl;

import cn.zq.dao.GamePayMapper;
import cn.zq.pojo.Pay;
import cn.zq.service.GamePayService;
import org.apache.dubbo.config.annotation.Service;
import org.dromara.hmily.annotation.Hmily;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class GamePayServiceImpl implements GamePayService {
    @Resource
    private GamePayMapper gamePayMapper;

    @Override
    @Hmily(confirmMethod = "insertConfirm",cancelMethod = "insertCancel")
    public Integer insertPay(Pay pay) {
        return gamePayMapper.insert(pay);
    }

    public Integer insertConfirm(Pay pay) {
        System.out.println("执行confirm");
        return gamePayMapper.updatePayConfirm(pay.getPayid());
    }

    public Integer insertCancel(Pay pay) {
        System.out.println("执行cancel");
        return gamePayMapper.updatePayCancel(pay.getPayid());
    }


}
