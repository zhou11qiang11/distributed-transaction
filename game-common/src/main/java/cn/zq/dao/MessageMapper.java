package cn.zq.dao;

import cn.zq.pojo.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    //查询状态为0的消息
    @Select("SELECT * FROM message WHERE `status` = 0")
    List<Message> queryByStatus();

    //添加消息
    @Insert("INSERT INTO message (id, userId,`status`, amount,createdTime, updatedTime)\n" +
            "VALUES(#{id},#{userId},0,#{amount},#{createdTime}, #{updatedTime})")
    Integer insert(Message message);

    //更新消息状态
    @Update("update message set status=1 where id=#{id}")
    Integer complete(@Param("id")Integer id);

    //查询消息
    @Select("select * from message where id=#{id}")
    Message findById(@Param("id")Integer id);


}
