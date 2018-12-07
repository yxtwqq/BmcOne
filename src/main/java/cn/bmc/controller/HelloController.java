package cn.bmc.controller;

import cn.bmc.entity.Shop;
import cn.bmc.entity.Upload;
import cn.bmc.service.ImportService;
import cn.bmc.service.ShopService;
import cn.bmc.service.UploadService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/bmc")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ShopService shopService;    //获取店铺列表的服务
    @Autowired
    private UploadService uploadService;    //上传文件的服务
    @Autowired
    private ImportService importService;    //数据导入服务


    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(@RequestParam("id") String id, @RequestParam("file") MultipartFile file) throws Exception {
//        id = request.getParameter("id");
//        fileName = request.getParameter("fileName");
        Integer shopid = Integer.parseInt(id);  //获取店铺id，并且转换为整形
        logger.info(shopid + ":" + file.getName());
        String fileName = file.getOriginalFilename();   //获取文件名称
        String filePath = "D:/workspace/";    //文件保存位置

        String date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//设置时间格式
        date = simpleDateFormat.format(new Date());//获取当前时间

        File dest = new File(filePath + date + fileName);//实例化file对象dest
        try {
            file.transferTo(dest);//上传file对象

            Upload upload = new Upload();//实例化Upload类
            upload.setUpSid(shopid);
            upload.setUpPath(filePath + date + fileName);
            upload.setUpTime(new Date());

            boolean flag = uploadService.addUplod(upload);//插入上传记录到数据库
            logger.info("uploadService.addUpload(uploads)==============" + flag);//true为插入数据成功

            flag = importService.batchImport(shopid, fileName, filePath + date + fileName);//导入数据
            logger.info("importService.batchImport==============" + flag);//true为导入数据成功

        } catch (IOException e) {
            logger.info(e.toString(), e);
        }

        return "true";
    }

    @RequestMapping(value = "/shops")
    @ResponseBody
    public List<Shop> shops() throws Exception {
        List<Shop> shopList = new ArrayList<Shop>();
        shopList = shopService.getShopList();
        return shopList;
    }

}