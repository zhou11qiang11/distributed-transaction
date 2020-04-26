package cn.zq.service.impl;

import cn.zq.dao.GamePayMapper;
import cn.zq.pojo.Pay;
import cn.zq.service.GamePayService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class GamePayServiceImpl implements GamePayService {
    @Resource
    private GamePayMapper gamePayMapper;

    @Override
    public Integer insertPay(Pay pay) {
        return gamePayMapper.insert(pay);
    }
}
