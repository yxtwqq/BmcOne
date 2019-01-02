package cn.bmc.service.impl;

import cn.bmc.dao.UploadMapper;
import cn.bmc.entity.Upload;
import cn.bmc.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;

    @Transactional
    public boolean addUplod(Upload upload) throws Exception {
        boolean flag = false;
        if (uploadMapper.addUplod(upload) > 0)
            flag = true;
        return flag;
    }

    @Override
    public List<Upload> getUploadListById(Integer shopid) throws Exception {
        return uploadMapper.getUploadListById(shopid);
    }

    @Override
    public List<Upload> getUploadList() throws Exception {
        return uploadMapper.getUploadList();
    }
}
