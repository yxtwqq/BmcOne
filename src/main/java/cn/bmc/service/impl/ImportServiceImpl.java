package cn.bmc.service.impl;


import cn.bmc.common.MyException;
import cn.bmc.dao.ImportMapper;

import cn.bmc.entity.UploadData;
import cn.bmc.service.ImportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.FileInputStream;
import java.io.InputStream;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ImportServiceImpl implements ImportService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportServiceImpl.class);

    @Autowired
    private ImportMapper importMapper;


    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public Integer batchImport(Integer uploadid, String fileName, String file) throws Exception {

        Integer num = 0;
        Boolean notNull = false;
        List<UploadData> dataList = new ArrayList<UploadData>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = new FileInputStream(file);
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }
        UploadData uploadData;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            uploadData = new UploadData();

            Long gid = new Double(row.getCell(0).getNumericCellValue()).longValue();

            if (gid == null || gid == 0) {
                throw new MyException("导入失败(第" + (r + 1) + "行,商品id未填写)");
            }

            Double price1 = row.getCell(1).getNumericCellValue();
            DecimalFormat df = new DecimalFormat("#.##");
            String price = df.format(price1);
            if (price == null || price == "") {
                throw new MyException("导入失败(第" + (r + 1) + "行,价格未填写)");
            }


            /*Integer sid = (int) row.getCell(2).getNumericCellValue();
            if (sid == null) {
                throw new MyException("导入失败(第" + (r + 1) + "行,不存在此单位或单位未填写)");
            }*/

            Date date = new Date();


            uploadData.setGoodsid(gid);
            uploadData.setPrice(price);
            uploadData.setUploadid(uploadid);
            //System.out.println("gid:" + gid + ",price:" + price + ",sid:" + shopid + ",date:" + date);
            dataList.add(uploadData);
        }
        for (UploadData data : dataList) {
            num++;
            importMapper.addData(data);
            LOGGER.info(" 插入 " + data);
        }
        return num;
    }

    @Override
    public int selectByID(Integer uploadid) {
        return importMapper.selectByID(uploadid);
    }
}
