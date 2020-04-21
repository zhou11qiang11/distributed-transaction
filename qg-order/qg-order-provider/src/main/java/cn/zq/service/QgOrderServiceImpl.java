package cn.zq.service;

import cn.zq.dao.QgOrderMapper;
import cn.zq.pojo.QgOrder;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class QgOrderServiceImpl  implements QgOrderService{
    @Resource
    private QgOrderMapper qgOrderMapper;
    @Override
    public int insert(QgOrder order) {
//        throw new RuntimeException("模拟异常");
        return qgOrderMapper.insert(order);
    }
}
