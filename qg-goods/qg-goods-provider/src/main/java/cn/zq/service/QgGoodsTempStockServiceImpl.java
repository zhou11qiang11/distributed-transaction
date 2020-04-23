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

    /**
     * try:预留资源的方式:
     * 1.新增,
     * 1.把数据保存到临时表中
     * 2.把数据新增到正式表,但是状态字段的值是临时
     * 2.修改
     * 1.如果要修改很多字段的数据,把修改的数据保存到临时表中
     * 2.如果只修改一些数值,把要加减的量保存到临时字段(冻结)中,等到提交时,再更新
     * 3.删除
     * 1.把状态字段更新为待删除,正常的查询/更新的SQL都会带条件(状态不等于临时,待删除,已删除)
     */

    @Hmily(confirmMethod = "insertConfirm", cancelMethod = "insertCancel")
    @Transactional
    public Integer insertTry(QgGoodsTempStock gts,Integer num) {
        //保存临时表
        qgGoodsTempStockMapper.insert(gts);
        //冻结库存,把stock中的数量,移动到lockStock中
        int count =qgGoodsMapper.lockStock(gts.getGoodsId(),num);
        if(count==0){
            throw new RuntimeException("库存不足冻结失败!");
        }
        return count;
    }

    public Integer insertConfirm(QgGoodsTempStock gts,Integer num) {
        System.out.println("执行confirm");
        qgGoodsMapper.lockStockConfirm(gts.getGoodsId(),num);
        qgGoodsTempStockMapper.confirm(gts.getId());
        qgGoodsTempStockMapper.cancel(gts.getId());
        return 1;
    }

    public Integer insertCancel(QgGoodsTempStock gts,Integer num) {
        System.out.println("执行cancel");
        qgGoodsMapper.lockStockCancel(gts.getGoodsId(),num);
         qgGoodsTempStockMapper.cancel(gts.getId());
        return 1;
    }
}
