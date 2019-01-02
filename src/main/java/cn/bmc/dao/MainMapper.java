package cn.bmc.dao;

import cn.bmc.entity.Upload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {
    /**
     * 获取店铺上传记录
     *
     * @param shopid
     * @param estatus
     * @return
     */
    public List<Upload> getUploadList(@Param("shopid") Integer shopid, @Param("estatus") Integer estatus);

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

    public Boolean upEstatus(@Param("uploadid")Integer uploadid,@Param("estatus")Integer estatus)throws Exception;
}
