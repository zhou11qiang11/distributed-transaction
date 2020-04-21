package cn.zq.service;


import cn.zq.dao.QgGoodsTempStockMapper;
import cn.zq.pojo.QgGoodsTempStock;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class QgGoodsTempStockServiceImpl implements QgGoodTempStockService {
    @Resource
    private QgGoodsTempStockMapper qgGoodsTempStockMapper;


    @Override
    public int insertTry(String xid, QgGoodsTempStock gts) {
        return qgGoodsTempStockMapper.insertTry(xid, gts);
    }

    @Override
    public int insertConfirm(String xid) {
        qgGoodsTempStockMapper.insertConfirm(xid);
        qgGoodsTempStockMapper.insertCancel(xid);
        return 1;
    }

    @Override
    public int insertCancel(String xid) {
        return qgGoodsTempStockMapper.insertCancel(xid);
    }
}
