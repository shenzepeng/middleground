package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 图片上传
     * @param request
     * @param file
     * @return
     */
    @PostMapping("upload/img")
    public SzpJsonResult<?> uploadImg(HttpServletRequest request, MultipartFile file) {
        return SzpJsonResult.ok(fileService.uploadImg(file,request));
    }

    /**
     * 大文件上传
     * @param request
     * @param file
     * @return
     */
    @PostMapping("upload/bigfile")
    public SzpJsonResult<?> uploadBigFile(HttpServletRequest request, MultipartFile file){
        return SzpJsonResult.ok();
    }
}
