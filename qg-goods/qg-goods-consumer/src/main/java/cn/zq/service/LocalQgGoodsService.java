package cn.zq.service;


import cn.zq.pojo.QgGoodsTempStock;
import cn.zq.pojo.QgOrder;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LocalQgGoodsService {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Reference(version = "1.0.0",retries = 0,timeout = 10000)
    private QgGoodTempStockService qgGoodTempStockService;

    @Reference(version = "1.0.0",retries = 0,timeout = 10000)
    private QgOrderService qgOrderService;

    public boolean qg(String userId, String goodsId, Integer num){
        QgGoodsTempStock gts = new QgGoodsTempStock();
        gts.setCreatedTime(new Date());
        gts.setGoodsId(goodsId);
        gts.setStatus(0);
        gts.setUserId(userId);
        int count1 = qgGoodTempStockService.insert(gts);

        QgOrder order = new QgOrder();
        order.setCreatedTime(new Date());
        order.setGoodsId(goodsId);
        order.setNum(num);
        order.setOrderNo(sdf.format(new Date())+goodsId+userId);
        order.setStatus(0);
        order.setUserId(userId);

        int count2 = qgOrderService.insert(order);

        return count1*count2>0;
    }
}
