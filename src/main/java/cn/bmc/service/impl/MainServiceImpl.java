package cn.bmc.service.impl;


import cn.bmc.dao.MainMapper;
import cn.bmc.entity.Upload;
import cn.bmc.service.MainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Resource
    private MainMapper mainMapper;

    @Override
    public List<Upload> getUploadList(Integer shopid, Integer estatus) {
        return mainMapper.getUploadList(shopid, estatus);
    }

    @Override
    public List<Upload> getSearch(Integer shopid, String uploader,
                                      String filename, Integer estatus, String starttime, String endtime) {
        return mainMapper.getSearch(shopid, uploader, filename, estatus, starttime, endtime);
    }

    @Transactional
    public Boolean upEstatus(Integer uploadid, Integer estatus) throws Exception {
        return mainMapper.upEstatus(uploadid,estatus);
    }

}
