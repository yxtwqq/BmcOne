package cn.bmc.entity;

import java.util.Date;

public class Upload {
    private Integer id;//上传的id主键
    private String uploader;//店铺id
    private String filename;//文件储存路径
    private Integer estatus;//上传时间
    private Integer shopid;//上传时间
    private String filepath;//上传时间
    private Date uptime;//上传时间
    private String stime;//上传时间
    private String etime;//上传时间

    @Override
    public String toString() {
        return "Upload{" +
                "id=" + id +
                ", uploader='" + uploader + '\'' +
                ", filename='" + filename + '\'' +
                ", estatus=" + estatus +
                ", shopid=" + shopid +
                ", filepath='" + filepath + '\'' +
                ", uptime=" + uptime +
                ", stime='" + stime + '\'' +
                ", etime='" + etime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }
}
