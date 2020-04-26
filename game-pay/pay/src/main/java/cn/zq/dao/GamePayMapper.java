package cn.zq.dao;

import cn.zq.pojo.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GamePayMapper {
    //添加充值记录
    Integer insert(Pay pay);
}
