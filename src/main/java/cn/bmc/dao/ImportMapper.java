package cn.bmc.dao;

import cn.bmc.entity.UploadData;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ImportMapper {
    void addData(UploadData uploadData);

    int updateDataById(UploadData uploadData);

    int selectByID(Long id);
}
