package cn.zq.service;


import cn.zq.pojo.QgGoodsTempStock;
import org.springframework.data.repository.query.Param;

public interface QgGoodTempStockService {
    //把要新增的数据,放到临时表中
    int insertTry(String xid,QgGoodsTempStock gts);
    //再把临时表中对于事务id的数据,复制到正式表中
    int insertConfirm(String xid);
    //撤销事务,从临时表删除对应事务id的数据
    int insertCancel(String xid);

}

