package cn.zq.task;

import cn.zq.dao.QgGoodsMessageMapper;
import cn.zq.pojo.QgGoodsMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class QgMessageTask {

    @Resource
    private QgGoodsMessageMapper qgGoodsMessageMapper;

//    @Scheduled(initialDelay = 0,//第一次执行,实在?毫秒后
//            fixedDelay = 0,//上次执行完毕后n毫秒执行
//            fixedRate = 0,//上次执行开始时间后n毫秒执行
//            cron = "",//秒（0~59） 分钟（0~59） 小时（0~23） 月中的天（1~31） 月（1~12） 周中的天
//            fixedDelayString = "",
//            fixedRateString = "",
//            initialDelayString = "",
//            zone = "")

//    @Scheduled(fixedRate = 15000) //每隔15秒执行一次
    @Scheduled(cron = "0 0/1 16-23 ? * THU") //每周四16点的从0分开始，每分钟执行一次打印
    public void sendMessage(){
        //定时读取消息表中的未处理完成的消息,发送到消息队列mq,0新创建
        List<QgGoodsMessage> list=qgGoodsMessageMapper.queryByStatus(0);

        for(QgGoodsMessage msg:list){
            System.out.println(msg.getUserId()+"\t"+msg.getGoodsId()+"\t"+msg.getAmount().intValue());//bigdecimal 不能直接打印
        }
    }
}
