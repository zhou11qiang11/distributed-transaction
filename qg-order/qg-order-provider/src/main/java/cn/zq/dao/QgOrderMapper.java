package cn.zq.dao;


import cn.zq.pojo.QgGoodsTempStock;
import cn.zq.pojo.QgOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QgOrderMapper {
    //把要新增的数据,放到临时表中
    int insert(QgOrder order);
    //再把临时表中对于事务id的数据,复制到正式表中
    int confirm(@Param("id") String id);
    //撤销事务,从临时表删除对应事务id的数据
    int cancel(@Param("id") String id);
}
