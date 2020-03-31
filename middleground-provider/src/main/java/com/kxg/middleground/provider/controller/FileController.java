package com.kxg.middleground.provider.controller;

import com.kxg.middleground.provider.common.SzpJsonResult;
import com.kxg.middleground.provider.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping
    public SzpJsonResult<?> uploadImg(HttpServletRequest request, MultipartFile file) {
        return SzpJsonResult.ok(fileService.uploadImg(file,request));
    }
}
