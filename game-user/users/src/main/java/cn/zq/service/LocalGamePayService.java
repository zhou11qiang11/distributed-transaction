package cn.zq.service;

import org.apache.ibatis.annotations.Mapper;

public interface LocalGamePayService {
    void game(Integer userId,Double amount);
}
