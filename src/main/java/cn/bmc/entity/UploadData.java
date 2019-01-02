package cn.bmc.entity;

import java.util.Date;

public class UploadData {
    private Integer id;//商品id
    private Long goodsid;//商品价格
    private String price;//店铺id
    private Integer uploadid;//导入时间

    @Override
    public String toString() {
        return "UploadData{" +
                "id=" + id +
                ", goodsid='" + goodsid + '\'' +
                ", price='" + price + '\'' +
                ", uploadid=" + uploadid +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getUploadid() {
        return uploadid;
    }

    public void setUploadid(Integer uploadid) {
        this.uploadid = uploadid;
    }
}
