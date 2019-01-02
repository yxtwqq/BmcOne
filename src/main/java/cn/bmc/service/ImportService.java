package cn.bmc.service;

public interface ImportService {
    Integer batchImport(Integer uploadid, String fileName, String file) throws Exception;
    int selectByID(Integer uploadid);
}
