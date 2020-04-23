package cn.zq.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QgGoodsMapper {

    int lockStock(@Param("id")String id,@Param("num")Integer num);
    int lockStockConfirm(@Param("id")String id,@Param("num")Integer num);
    int lockStockCancel(@Param("id")String id,@Param("num")Integer num);
}