package cn.zq.service.impl;

import cn.zq.dao.GameUserMapper;
import cn.zq.service.GameUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class GameUserServiceImpl implements GameUserService {
    @Resource
    private GameUserMapper gameUserMapper;

    @Override
    public Integer updateUserRemaining(Integer userId,Double amount) {
        int count =gameUserMapper.updateUser(userId, amount);
        if(count==0){
            throw new RuntimeException("库存不足");
        }
        return count;
    }
}
