package cn.zq.pojo;

import java.util.Date;
import java.io.Serializable;
/**
 * 充值记录表(Pay)实体类
 *
 * @author zhouqiang
 * @since 2020-04-26 14:35:08
 */
public class Pay implements Serializable {
    private static final long serialVersionUID = 422621493864231896L;
    /**
    * 充值id
    */
    private Integer payid;
    /**
    * 用户id
    */
    private Integer uid;
    /**
    * 充值金额
    */
    private Double amount;
    /**
    * 充值时间
    */
    private Date paydate;
    /**
    * 状态:0.临时 1.新建 -1.取消
    */
    private Integer paystatus;


    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

}