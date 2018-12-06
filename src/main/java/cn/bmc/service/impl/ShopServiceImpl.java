package cn.bmc.service.impl;

import cn.bmc.dao.ShopMapper;
import cn.bmc.entity.Shop;

import cn.bmc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> getShopList() throws Exception {
        return shopMapper.getShopList();
    }
}
