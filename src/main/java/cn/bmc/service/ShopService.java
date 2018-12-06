package cn.bmc.service;

import cn.bmc.entity.Shop;

import java.util.List;

public interface ShopService {
    /**
     * 获取店铺列表
     * @return
     * @throws Exception
     */
    public List<Shop> getShopList()throws Exception;
}
