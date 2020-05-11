package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.model.FileUrl;
import com.kxg.middleground.provider.service.FileService;
import com.kxg.middleground.request.UploadFileRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传
 */
@RestController
@Api("文件上传")
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
    @ApiOperation("图片上传")
    public SzpJsonResult<FileUrl> uploadImg(HttpServletRequest request, MultipartFile file,String appKey) {
        return SzpJsonResult.ok(fileService.uploadImg(file,request,appKey));
    }

    /**
     * 大文件上传
     * @param request
     * @param file
     * @return
     */
    @ApiOperation("大图片上传")
    @PostMapping("upload/bigfile")
    public SzpJsonResult<FileUrl> uploadBigFile(HttpServletRequest request, MultipartFile file,String appKey){
        return SzpJsonResult.ok(fileService.uploadBigFile(file, request,appKey));
    }
}
