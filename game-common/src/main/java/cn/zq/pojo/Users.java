package cn.zq.pojo;

import java.io.Serializable;
/**
 * 用户表(Users)实体类
 *
 * @author zhouqiang
 * @since 2020-04-26 14:35:35
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 571489425036622435L;
    /**
    * 用户id
    */
    private Integer userid;
    /**
    * 用户名
    */
    private String username;
    /**
    * 余额
    */
    private Double remaining;
    /**
    * 冻结金额
    */
    private Integer lockremaining;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

    public Integer getLockremaining() {
        return lockremaining;
    }

    public void setLockremaining(Integer lockremaining) {
        this.lockremaining = lockremaining;
    }

}