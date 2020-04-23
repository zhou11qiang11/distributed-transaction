package cn.zq.dao;

import cn.zq.pojo.QgGoodsMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QgGoodsMessageMapper {

    List<QgGoodsMessage> queryByStatus(@Param("status") Integer status);
}
