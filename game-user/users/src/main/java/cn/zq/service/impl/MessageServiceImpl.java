package cn.zq.service.impl;

import cn.zq.dao.MessageMapper;
import cn.zq.service.MessageService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public Integer complete(Integer id) {
        return messageMapper.complete(id);
    }
}
