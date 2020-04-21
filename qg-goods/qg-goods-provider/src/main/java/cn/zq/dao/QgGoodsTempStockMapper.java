package cn.zq.dao;


import cn.zq.pojo.QgGoodsTempStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QgGoodsTempStockMapper {
    //把要新增的数据,放到临时表中
    int insertTry(@Param("xid") String xid, @Param("gts") QgGoodsTempStock gts);
    //再把临时表中对于事务id的数据,复制到正式表中
    int insertConfirm(@Param("xid") String xid);
    //撤销事务,从临时表删除对应事务id的数据
    int insertCancel(@Param("xid") String xid);
}
