package cn.zq.dao;


import cn.zq.pojo.QgOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QgOrderMapper {
    int insert(QgOrder order);
}
