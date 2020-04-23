package cn.zq.service;


import cn.zq.dao.QgGoodsMapper;
import cn.zq.dao.QgGoodsTempStockMapper;
import cn.zq.pojo.QgGoodsTempStock;
import org.apache.dubbo.config.annotation.Service;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class QgGoodsTempStockServiceImpl implements QgGoodTempStockService {
    @Resource
    private QgGoodsTempStockMapper qgGoodsTempStockMapper;
    @Resource
    private QgGoodsMapper qgGoodsMapper;

    @Transactional
    public Integer insertTry(QgGoodsTempStock gts,Integer num) {

        //冻结库存,把stock中的数量,移动到lockStock中
        int count =qgGoodsMapper.lockStock(gts.getGoodsId(),num);
        if(count==0){
            throw new RuntimeException("库存不足冻结失败!");
        }
        return  qgGoodsTempStockMapper.insert(gts);
    }
}
