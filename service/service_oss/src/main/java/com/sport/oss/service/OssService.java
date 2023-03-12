package com.sport.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface OssService {
    String uploadFileAvatar(MultipartFile file) throws FileNotFoundException;
}
