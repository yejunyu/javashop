package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author yejunyu
 * @date 18-3-8.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        if (fileName.indexOf(".") < 0) {
            logger.error("文件没有扩展名");
            return null;
        }
        // 获取扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
        String uploadFileName = UUID.randomUUID().toString() + fileExtensionName;
        logger.info("开始上传文件，上传文件的文件名：{}，上传路径：{}，新文件名：{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            // 上传文件到ftp，然后删除本地
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
//            targetFile.delete();
        } catch (IOException e) {
            logger.error("文件上传异常", e);
            return null;
        }
        return targetFile.getName();
    }
}
