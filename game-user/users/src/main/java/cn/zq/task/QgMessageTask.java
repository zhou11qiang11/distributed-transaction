package cn.zq.task;

import cn.zq.dao.MessageMapper;
import cn.zq.pojo.Message;
import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class QgMessageTask {

    @Resource
    private MessageMapper MessageMapper;

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Scheduled(fixedDelay=5000)
    public void sendMessage(){
        System.out.println("----------定时发送未完成消息-----------");
        //定时读取消息表中的未处理完成的消息
        List<Message> list= MessageMapper.queryByStatus();
        for (Message msg : list){
            //发送消息到消息队列
            ActiveMQQueue queue = new ActiveMQQueue("game:insert");
            jmsMessagingTemplate.convertAndSend(queue, JSON.toJSONString(msg));
        }
        System.out.println("----------发送结束-----------");
    }
}
