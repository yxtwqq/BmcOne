package cn.bmc.dao;

import cn.bmc.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    /**
     * 获取店铺列表
     * @return
     * @throws Exception
     */
    public List<Shop> getShopList()throws Exception;
}
