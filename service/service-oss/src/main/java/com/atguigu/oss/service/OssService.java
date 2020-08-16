package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * @author
 * @date 2020/7/17-9:07
 */
public interface OssService {
    String uploadAvatar(MultipartFile file) throws FileNotFoundException;
}
