package cn.bmc.entity;

public class Shop {
    private Integer id;//店铺id
    private String shopName;//店铺名称
    private String shopUrl;//店铺url
    private String shopTable;//店铺对应的表名

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopUrl='" + shopUrl + '\'' +
                ", shopTable='" + shopTable + '\'' +
                '}';
    }

    public Shop() {
        super();
    }

    public Shop(Integer id, String shopName, String shopUrl, String shopTable) {
        this.id = id;
        this.shopName = shopName;
        this.shopUrl = shopUrl;
        this.shopTable = shopTable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getShopTable() {
        return shopTable;
    }

    public void setShopTable(String shopTable) {
        this.shopTable = shopTable;
    }
}
