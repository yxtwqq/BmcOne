package cn.bmc.service;

public interface ImportService {
    Boolean batchImport(Integer shopid, String fileName, String file) throws Exception;
}
