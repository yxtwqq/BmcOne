package cn.bmc.dao;

import cn.bmc.entity.Upload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UploadMapper {
    /**
     * 插入上传记录
     * @return
     * @throws Exception
     */
    public Integer addUplod(Upload upload)throws Exception;

    /**
     * 根据店铺id获取上传文件列表
     * @return
     * @throws Exception
     */
    public List<Upload> getUploadListById(Integer shopid)throws Exception;

    public List<Upload> getUploadList()throws Exception;

}
