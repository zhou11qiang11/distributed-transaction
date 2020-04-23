package cn.zq.service;

import org.dromara.hmily.annotation.Hmily;

public interface GameUserService {
    @Hmily
    Integer updateUserRemaining(Integer userId,Double amount);
}
