package cn.zq.service.impl;

import cn.zq.dao.GameUserMapper;
import cn.zq.service.GameUserService;
import org.apache.dubbo.config.annotation.Service;
import org.dromara.hmily.annotation.Hmily;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class GameUserServiceImpl implements GameUserService {
    @Resource
    private GameUserMapper gameUserMapper;

    @Override
    @Hmily(confirmMethod = "updateConfirm",cancelMethod = "updateCancel")
    public Integer updateUserRemaining(Integer userId,Double amount) {
//        return gameUserMapper.updateUser(userId, amount);
    throw new RuntimeException("来个异常");
    }

    public Integer updateConfirm(Integer userId,Double amount) {
        return gameUserMapper.updatePayConfirm(userId, amount);
    }

    public Integer updateCancel(Integer userId,Double amount) {

        return gameUserMapper.updatePayCancel(userId, amount);
    }


}
