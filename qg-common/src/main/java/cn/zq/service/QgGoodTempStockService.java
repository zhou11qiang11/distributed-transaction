package cn.zq.service;


import cn.zq.pojo.QgGoodsTempStock;
import org.dromara.hmily.annotation.Hmily;

public interface QgGoodTempStockService {

    //新增
    @Hmily
    int insertTry(QgGoodsTempStock gts);

}

