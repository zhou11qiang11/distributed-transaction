package cn.zq.dao;


import cn.zq.pojo.QgGoodsTempStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QgGoodsTempStockMapper {
    int insert(QgGoodsTempStock gts);
    int confirm(@Param("id")String id);
    int cancel(@Param("id")String id);
}
