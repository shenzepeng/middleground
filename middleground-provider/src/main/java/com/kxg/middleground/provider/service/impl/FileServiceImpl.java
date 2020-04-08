package com.kxg.middleground.provider.service.impl;
import com.kxg.middleground.provider.constants.MiddlerGroudConstans;
import com.kxg.middleground.provider.client.OSSClientUtil;
import com.kxg.middleground.provider.dao.KxgImgFileDbDao;
import com.kxg.middleground.provider.model.FileUrl;
import com.kxg.middleground.provider.pojo.KxgImgFileDb;
import com.kxg.middleground.provider.service.FileService;
import com.kxg.middleground.provider.utils.FileSizeUtils;
import com.kxg.middleground.provider.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    @Value("${img.size.allowed.size}")
    private Double allowedFileSize;
    @Value("${bigFile.size.allowed.size}")
    private Double bigFileAllowedFileSize;
    @Autowired
    private KxgImgFileDbDao kxgImgFileDbDao;
    @Autowired
    private OSSClientUtil ossClient;
    @Override
    public FileUrl uploadImg(MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()){
            throw new RuntimeException("图像不能为空");
        }
        if (FileSizeUtils.getMbSize(file.getSize())>allowedFileSize){
            throw new RuntimeException("文件大于允许上传大小-"+allowedFileSize+"MB");
        }
        FileUrl fileUrl = uploadFileToOss(file);
        String ipAddr = IpUtil.getIpAddr(request);
        fileUrl.setAddIp(ipAddr);
        fileUrl.setStatus(MiddlerGroudConstans.IMG_NORMAL);
        //TODO userId appKey
        KxgImgFileDb fileDb=new KxgImgFileDb();
        fileDb.setAddIp(ipAddr);
        fileDb.setCreateTime(new Date());
        fileDb.setImgUrl(fileUrl.getImgUrl());
        fileDb.setStatus(MiddlerGroudConstans.IMG_NORMAL);
        kxgImgFileDbDao.addImgFile(fileDb);
        //将oss缓存的key去掉，这些只保存在数据库中
        String url=fileUrl.getImgUrl().split("\\?")[0];
        fileUrl.setImgUrl(url);
        return fileUrl;
    }

    @Override
    public FileUrl uploadBigFile(MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()){
            throw new RuntimeException("文件不能为空");
        }
        if (FileSizeUtils.getMbSize(file.getSize())>allowedFileSize){
            throw new RuntimeException("文件大于允许上传大小-"+allowedFileSize+"MB");
        }
        FileUrl fileUrl = uploadFileToOss(file);
        String ipAddr = IpUtil.getIpAddr(request);
        fileUrl.setAddIp(ipAddr);
        fileUrl.setStatus(MiddlerGroudConstans.FILE_NORMAL);
        //TODO userId appKey
        KxgImgFileDb fileDb=new KxgImgFileDb();
        fileDb.setAddIp(ipAddr);
        fileDb.setCreateTime(new Date());
        fileDb.setImgUrl(fileUrl.getImgUrl());
        fileDb.setStatus(MiddlerGroudConstans.FILE_NORMAL);
        kxgImgFileDbDao.addImgFile(fileDb);
        //将oss缓存的key去掉，这些只保存在数据库中
        String url=fileUrl.getImgUrl().split("\\?")[0];
        fileUrl.setImgUrl(url);
        return fileUrl;
    }



    private FileUrl uploadFileToOss(MultipartFile file){
        FileUrl fileUrl=new FileUrl();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrlEachOne = ossClient.getImgUrl(name);
        fileUrl.setCreateTime(new Date());
        fileUrl.setUpdateTime(new Date());
        //将http转化为https
        String httpToHttps = imgUrlEachOne.replaceAll("http://", "https://");
        //这个url会带缓存的key
        fileUrl.setImgUrl(httpToHttps);
        log.info("fileUrlFromOss--{}",imgUrlEachOne);
        return fileUrl;
    }
}
