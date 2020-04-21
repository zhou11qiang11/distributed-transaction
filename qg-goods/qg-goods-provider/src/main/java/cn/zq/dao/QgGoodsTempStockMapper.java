package cn.zq.dao;


import cn.zq.pojo.QgGoodsTempStock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QgGoodsTempStockMapper {
    int insert(QgGoodsTempStock gts);
}
