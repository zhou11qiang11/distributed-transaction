package cn.zq.listener;

import cn.zq.dao.GamePayMapper;
import cn.zq.dao.MessageMapper;
import cn.zq.pojo.Message;
import cn.zq.pojo.Pay;
import cn.zq.service.GamePayService;
import cn.zq.service.MessageService;
import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.JMSException;
import java.util.Date;

@Service
public class ActiveMQListener {

    @Resource
    private GamePayService gamePayService;

    @Resource
    private MessageMapper messageMapper;

    @Reference(version = "1.0.0")
    private MessageService messageService;

    @JmsListener(destination = "game:insert")
    public void gameListener(ActiveMQTextMessage msg) throws JMSException {
        Message mq = JSON.parseObject(msg.getText(), Message.class);
        gameInsert(mq);

    }

    @Transactional
    public void gameInsert(Message mq) {
        //1.为了防止重复处理,先判本地该消息是否处理成功
        Message local = messageMapper.findById(mq.getId());
        if (local != null) { //有该消息
            //如果成功,则不处理
            if (local.getStatus() == 1) {
                messageService.complete(mq.getId());
                return;
            }
        } else {
            //如果没有该消息,把消息保存到本地
            messageMapper.insert(mq);
        }

        Pay pay = new Pay();
        pay.setUid(mq.getUserId());
        pay.setAmount(mq.getAmount());
        pay.setPaydate(new Date());
        //处理订单
        System.out.println("处理订单!");
        gamePayService.insertPay(pay);
        //更新本地状态为完成
        messageMapper.complete(mq.getId());
        //调用消息服务,把消息的状态更新为已处理
        messageService.complete(mq.getId());
    }

}
