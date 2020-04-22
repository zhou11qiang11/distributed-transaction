package cn.zq.service;


import cn.zq.pojo.QgOrder;
import org.dromara.hmily.annotation.Hmily;

public interface QgOrderService {

    //新增数据
    @Hmily
    int insertTry(QgOrder order);
}

