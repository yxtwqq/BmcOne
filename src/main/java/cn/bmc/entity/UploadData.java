package cn.bmc.entity;

import java.util.Date;

public class UploadData {
    private Long gId;//商品id
    private Double gPrice;//商品价格
    private Integer sId;//店铺id
    private Date upTime;//导入时间

    @Override
    public String toString() {
        return "UploadData{" +
                "gId=" + gId +
                ", gPrice=" + gPrice +
                ", sId=" + sId +
                ", upTime=" + upTime +
                '}';
    }

    public UploadData() {
        super();
    }

    public UploadData(Long gId, Double gPrice, Integer sId, Date upTime) {
        this.gId = gId;
        this.gPrice = gPrice;
        this.sId = sId;
        this.upTime = upTime;
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public Double getgPrice() {
        return gPrice;
    }

    public void setgPrice(Double gPrice) {
        this.gPrice = gPrice;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }
}
