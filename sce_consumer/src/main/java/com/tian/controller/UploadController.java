package com.tian.controller;

import com.tian.entity.Constants;
import com.tian.entity.Result;
import com.tian.utils.QiniuUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile) {
        //获取原始文件名
        String originalFilename = imgFile.getOriginalFilename();
        int lastIndexOf = originalFilename.lastIndexOf(".");
        //获取文件后缀
        String suffix = originalFilename.substring(lastIndexOf);
        //使用UUID随机产生文件名称，防止同名文件覆盖
        String fileName = UUID.randomUUID() + suffix;
        try {
            QiniuUtils.upload2Qiniu(imgFile.getBytes(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(Constants.CODE_405);
        }
        return Result.success(fileName);
    }
}
