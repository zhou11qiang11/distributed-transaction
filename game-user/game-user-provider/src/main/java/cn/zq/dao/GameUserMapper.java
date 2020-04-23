package cn.zq.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GameUserMapper {

        Integer updateUser(@Param("userId") Integer userId,@Param("amount") Double amount);
        Integer updatePayConfirm(@Param("userId") Integer userId,@Param("amount") Double amount);
        Integer updatePayCancel(@Param("userId") Integer userId,@Param("amount") Double amount);

}
