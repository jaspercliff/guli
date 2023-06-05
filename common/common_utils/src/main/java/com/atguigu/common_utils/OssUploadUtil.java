package com.atguigu.common_utils;

import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.atguigu.config.SystemContants;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
public class OssUploadUtil {

    public static String upload(MultipartFile file){
        String result = "";
        String originalFileName = file.getOriginalFilename();
        String newFileName = createNewFileName(originalFileName);
        OSS oss = new OSSClientBuilder().build(SystemContants.ENDPOINT, SystemContants.ACCESSKEYID, SystemContants.ACCESSKEYSECRET);
        try {
            PutObjectRequest request = new PutObjectRequest(SystemContants.BUCKETNAME, newFileName, new ByteArrayInputStream(file.getBytes()));
            request.setProcess("true");//设置返回response
            PutObjectResult putObjectResult = oss.putObject(request);
            System.out.println(putObjectResult.getResponse().getStatusCode());
            String filePath = "http://"+ SystemContants.BUCKETNAME+"."+ SystemContants.ENDPOINT+"/"+newFileName;
            result+=filePath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            oss.shutdown();
        }
        return result;
    }

    public static String createNewFileName(String originalFileName){
//        获取后缀
        String suffix = StrUtil.subAfter(originalFileName, '.', true);
//        生成目录
        String name = UUID.randomUUID().toString();
        Date date = new Date();

        int hash = name.hashCode();
        int d1 = hash & 0xF;
        int d2 = (hash>>4)& 0xF;
        return StrUtil.format("guli/avator/{}/{}/{}.{}",d1,d2,name,suffix);
    }
}
