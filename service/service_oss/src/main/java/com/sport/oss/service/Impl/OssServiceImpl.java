package com.sport.oss.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.sport.oss.service.OssService;
import com.sport.utils.ConstantPropertiesUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) throws FileNotFoundException {
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        try{

            //创建OSS实例
            OSS ossClient=new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
            //上传文件流
            InputStream inputStream= file.getInputStream();
            //获取文件名
            String fileName = file.getOriginalFilename();
            //实现上传
            ossClient.putObject(bucketName,fileName,inputStream);
            //关闭
            ossClient.shutdown();
            //路径返回，拼接
            //https://sport-club.oss-cn-beijing.aliyuncs.com/001.jpg
            String url="https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;
        }catch (Exception e){
        e.printStackTrace();
            return null;
        }

    }

}
