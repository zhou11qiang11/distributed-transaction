package cn.zq.service;

import cn.zq.pojo.Pay;
import org.dromara.hmily.annotation.Hmily;

public interface GamePayService {
    @Hmily
    Integer insertPay(Pay pay);
}
