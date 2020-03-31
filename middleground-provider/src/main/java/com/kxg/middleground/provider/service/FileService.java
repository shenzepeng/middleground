package com.kxg.middleground.provider.service;

import com.kxg.middleground.provider.model.FileUrl;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {
    FileUrl uploadImg(MultipartFile file, HttpServletRequest request) ;
}
