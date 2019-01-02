package cn.bmc.service;

import cn.bmc.entity.Upload;

import java.util.List;

public interface UploadService {
    /**
     * 插入上传记录
     * @return
     * @throws Exception
     */
    public boolean addUplod(Upload upload)throws Exception;

    /**
     * 根据店铺id获取上传文件列表
     * @return
     * @throws Exception
     */
    public List<Upload> getUploadListById(Integer shopid)throws Exception;

    public List<Upload> getUploadList()throws Exception;
}
