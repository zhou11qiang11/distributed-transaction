package cn.zq.service;


import cn.zq.pojo.QgGoodsTempStock;
import org.dromara.hmily.annotation.Hmily;

public interface QgGoodTempStockService {

    //下单
    @Hmily
    Integer insertTry(QgGoodsTempStock gts,Integer num);

}

