package cn.zq.service;

import cn.zq.dao.QgOrderMapper;
import cn.zq.pojo.QgOrder;
import org.apache.dubbo.config.annotation.Service;
import org.dromara.hmily.annotation.Hmily;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class QgOrderServiceImpl implements QgOrderService {
    @Resource
    private QgOrderMapper qgOrderMapper;

    @Override
    @Hmily(confirmMethod = "insertConfirm", cancelMethod = "insertCancel")
    public int insertTry(QgOrder order) {
//        try {
//            Thread.sleep(10000);
            return qgOrderMapper.insert(order);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//        throw new RuntimeException("模拟异常");
    }

    public int insertConfirm(QgOrder order) {
        System.out.println("执行confirm");
        qgOrderMapper.confirm(order.getId());
        qgOrderMapper.cancel(order.getId());
        return 1;
    }

    public int insertCancel(QgOrder order) {
        System.out.println("执行cancel");
        return qgOrderMapper.cancel(order.getId());
    }
}
