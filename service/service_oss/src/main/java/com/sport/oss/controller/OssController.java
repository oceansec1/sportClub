package com.sport.oss.controller;

import com.sport.common_utils.R;
import com.sport.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
@Autowired
private OssService ossService;
    //上传头像
    @PostMapping
    public R uploadOssFile(MultipartFile file) throws FileNotFoundException {
    String url = ossService.uploadFileAvatar(file);
        return R.success().data("url",url);
    }
}
