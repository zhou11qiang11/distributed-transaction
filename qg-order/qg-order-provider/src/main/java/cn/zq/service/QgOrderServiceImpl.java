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
    public int insertTry(String xid, QgOrder order) {
        //throw new RuntimeException("模拟异常");
        return qgOrderMapper.insertTry(xid, order);
    }

    @Override
    public int insertConfirm(String xid) {
        qgOrderMapper.insertConfirm(xid);
        qgOrderMapper.insertCancel(xid);
        return  1;
    }

    @Override
    public int insertCancel(String xid) {
        return qgOrderMapper.insertCancel(xid);
    }
}
