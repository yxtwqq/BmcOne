package cn.bmc.controller;

import cn.bmc.entity.Shop;
import cn.bmc.service.ShopService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/bmc")
public class HelloController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(@RequestParam("id") String id, @RequestParam("fileName") String fileName,
                        HttpServletRequest request) {
        id = request.getParameter("id");
        fileName = request.getParameter("fileName");
        System.out.println(id +"   :   "+ fileName);

        return "true";
    }

    @RequestMapping(value = "/shops")
    @ResponseBody
    public List<Shop> shops()throws Exception{
        List<Shop> shopList = new ArrayList<Shop>();
        shopList = shopService.getShopList();
        return shopList;
    }

}