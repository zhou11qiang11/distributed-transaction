package cn.zq.service.impl;

import cn.zq.dao.MessageMapper;
import cn.zq.pojo.Message;
import cn.zq.service.GameUserService;
import cn.zq.service.LocalGamePayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class LocalGameServiceImpl implements LocalGamePayService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private GameUserService gameUserService;

    @Transactional
    public void game(Integer userId, Double amount) {
        //保存消息
        Message msg = new Message();
        msg.setUserId(userId);
        msg.setAmount(amount);
        msg.setCreatedTime(new Date());
        messageMapper.insert(msg);
        //更新本地数据
        Integer count = gameUserService.updateUserRemaining(userId, amount);
    }
}
