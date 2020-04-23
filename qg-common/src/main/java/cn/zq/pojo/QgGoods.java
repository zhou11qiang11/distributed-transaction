package cn.zq.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class QgGoods implements Serializable {

    private Integer id;//主键
    private String goodsImg;//商品图片
    private String goodsName;//商品名称
    private BigDecimal price;//商品单价
    private Integer stock;//原始库存
    private Date createdTime;
    private Date updatedTimedatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTimedatetime() {
        return updatedTimedatetime;
    }

    public void setUpdatedTimedatetime(Date updatedTimedatetime) {
        this.updatedTimedatetime = updatedTimedatetime;
    }
}
