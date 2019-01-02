package cn.bmc.controller;

import cn.bmc.common.MyException;
import cn.bmc.entity.Shop;
import cn.bmc.entity.Upload;
import cn.bmc.service.ImportService;
import cn.bmc.service.MainService;
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
@RequestMapping
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ShopService shopService;    //获取店铺列表的服务
    @Autowired
    private UploadService uploadService;    //上传文件的服务
    @Autowired
    private ImportService importService;    //数据导入服务
    @Autowired
    private MainService mainService;


    /**
     * 载入主界面的接口
     *
     * @param shopid
     * @param estatus
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUploadList")
    public List<Upload> getUploadList(@RequestParam("shopid") Integer shopid,
                                          @RequestParam("estatus") Integer estatus) {
        //System.out.println(shopid + "   " + estatus);
        List<Upload> list = mainService.getUploadList(shopid, estatus);
        logger.info("getUploadList-----------shopid=" + shopid);
        return list;
    }

    @ResponseBody
    @RequestMapping("/upestatus")
    public String upestatus(@RequestParam("uploadid") Integer uploadid,
                            @RequestParam("estatus") Integer estatus){
        try {
            boolean flag = mainService.upEstatus(uploadid,estatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "修改生效状态成功";
    }

    /**
     * 条件查询接口
     *
     * @param shopid
     * @param uploader
     * @param filename
     * @param estatus
     * @param starttime
     * @param endtime
     * @return
     */
    @ResponseBody
    @RequestMapping("/search")
    public List<Upload> getSearch(@RequestParam("shopid") Integer shopid,
                                      @RequestParam("uploader") String uploader,
                                      @RequestParam("filename") String filename,
                                      @RequestParam("estatus") Integer estatus,
                                      @RequestParam("starttime") String starttime,
                                      @RequestParam("endtime") String endtime) {
        logger.info("getSearch-----------shopid=" + shopid);
        logger.info("getSearch-----------uploader=" + uploader);
        logger.info("getSearch-----------filename=" + filename);
        logger.info("getSearch-----------estatus=" + estatus);
        logger.info("getSearch-----------starttime=" + starttime);
        logger.info("getSearch-----------endtime=" + endtime);
        List<Upload> list = mainService.getSearch(shopid, uploader, filename, estatus, starttime, endtime);
        //System.out.println(list.toString());
        return list;
    }

    /**
     * 文件上传接口
     * @param shopid
     * @param filename
     * @param uploader
     * @param stime
     * @param etime
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("shopid") Integer shopid,
                        @RequestParam("filename") String filename,
                        @RequestParam("uploader") String uploader,
                        @RequestParam("stime") String stime,
                        @RequestParam("etime") String etime,
                        @RequestParam("file") MultipartFile file) throws Exception {
        Integer estatus = 1;
//        id = request.getParameter("id");
//        fileName = request.getParameter("fileName");
        Integer num = 0;
        Integer flag1 = 0;
        List<Upload> fname = new ArrayList<Upload>();
        fname = uploadService.getUploadListById(shopid);

        for (int i = 0; i < fname.size(); i++) {
            if (fname.get(i).getFilename().equals(filename)) {
                flag1 = 1;
                break;
            }
        }
        if (flag1 == 1) {
            return "文件名已存在！";
        } else {
            logger.info(shopid + ":" + file.getName() + ":" + filename + ":" + uploader +
                    ":" + estatus + ":" + stime + ":" + etime);
            String fileName = file.getOriginalFilename();   //获取文件名称
            String filePath = "D:/workspace/";    //文件保存位置

            String date = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//设置时间格式
            date = simpleDateFormat.format(new Date());//获取当前时间

            File dest = new File(filePath + date + fileName);//实例化file对象dest
            try {
                file.transferTo(dest);//上传file对象

                Upload upload = new Upload();//实例化Upload类
                upload.setShopid(shopid);
                upload.setFilepath(filePath + date + fileName);
                upload.setUptime(new Date());
                upload.setEstatus(estatus);
                upload.setEtime(etime);
                upload.setStime(stime);
                upload.setUploader(uploader);
                upload.setFilename(filename);

                List<Upload> uploadList = uploadService.getUploadList();
                Integer uploadid = null;
                for (Upload d : uploadList) {
                    uploadid = d.getId();
                    break;
                }
                //System.out.println(uploadid);
                num = importService.batchImport((uploadid + 1), fileName, filePath + date + fileName);//导入数据
                //logger.info("importService.batchImport==============" + flag);//true为导入数据成功
                boolean flag = uploadService.addUplod(upload);//插入上传记录到数据库
                logger.info("uploadService.addUpload(uploads)==============" + flag);//true为插入数据成功
                num = importService.selectByID(uploadid);
                //System.out.println(num);
            } catch (IOException e) {
                logger.info(e.toString(), e);
            }

            return "上传成功,导入"+num+"条记录";
        }
    }

    /**
     * 店铺列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/shops")
    @ResponseBody
    public List<Shop> shops() throws Exception {
        List<Shop> shopList = new ArrayList<Shop>();
        shopList = shopService.getShopList();
        return shopList;
    }

}