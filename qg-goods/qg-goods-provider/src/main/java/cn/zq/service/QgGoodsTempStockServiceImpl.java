package cn.zq.service;


import cn.zq.dao.QgGoodsTempStockMapper;
import cn.zq.pojo.QgGoodsTempStock;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class QgGoodsTempStockServiceImpl implements QgGoodTempStockService{
    @Resource
    private QgGoodsTempStockMapper qgGoodsTempStockMapper;


    public int insert(QgGoodsTempStock gts) {
        return qgGoodsTempStockMapper.insert(gts);
    }
}
