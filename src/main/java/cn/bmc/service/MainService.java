package cn.bmc.service;

import cn.bmc.entity.Upload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainService {
    public List<Upload> getUploadList(Integer shopid, Integer estatus);

    /**
     * 条件查询
     *
     * @param shopid
     * @param uploader
     * @param filename
     * @param estatus
     * @param starttime
     * @param endtime
     * @return
     */
    public List<Upload> getSearch(@Param("shopid") Integer shopid,
                                      @Param("uploader") String uploader,
                                      @Param("filename") String filename,
                                      @Param("estatus") Integer estatus,
                                      @Param("starttime") String starttime,
                                      @Param("endtime") String endtime);

    public Boolean upEstatus(Integer uploadid,Integer estatus)throws Exception;
}
