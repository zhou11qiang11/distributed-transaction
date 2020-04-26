package cn.zq.pojo;

import java.util.Date;
import java.io.Serializable;
/**
 * (Message)实体类
 *
 * @author zhouqiang
 * @since 2020-04-26 14:35:25
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -83941599390130399L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 状态-0未完成,1已完成
    */
    private Integer status;
    /**
    * 金额
    */
    private Double amount;
    /**
    * 创建时间
    */
    private Date createdTime;
    /**
    * 更新时间
    */
    private Date updatedTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}