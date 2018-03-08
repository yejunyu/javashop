package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yejunyu
 * @date 18-3-8.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);

}
