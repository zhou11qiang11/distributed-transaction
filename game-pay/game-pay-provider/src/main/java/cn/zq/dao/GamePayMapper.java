package cn.zq.dao;

import cn.zq.pojo.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GamePayMapper {

    Integer insert(Pay pay);
    Integer updatePayConfirm(@Param("payId")Integer payId);
    Integer updatePayCancel(@Param("payId")Integer payId);
}
