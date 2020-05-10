package com.kxg.middleground.provider.service;

import com.kxg.middleground.provider.model.FileUrl;
import com.kxg.middleground.request.UploadFileRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {
    FileUrl uploadImg(MultipartFile file, HttpServletRequest request, UploadFileRequest uploadFileRequest) ;
    FileUrl uploadBigFile(MultipartFile file,HttpServletRequest request,UploadFileRequest uploadFileRequest);
}
