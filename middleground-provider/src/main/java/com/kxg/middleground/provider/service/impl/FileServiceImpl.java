package com.kxg.middleground.provider.service.impl;
import com.kxg.middleground.provider.constants.MiddlerGroudConstans;
import com.kxg.middleground.provider.client.OSSClientUtil;
import com.kxg.middleground.provider.dao.KxgImgFileDbDao;
import com.kxg.middleground.provider.model.FileUrl;
import com.kxg.middleground.provider.pojo.KxgImgFileDb;
import com.kxg.middleground.provider.service.FileService;
import com.kxg.middleground.provider.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private KxgImgFileDbDao kxgImgFileDbDao;
    @Autowired
    private OSSClientUtil ossClient;
    @Override
    public FileUrl uploadImg(MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()){
            throw new RuntimeException("图像不能为空");
        }
        FileUrl fileUrl=new FileUrl();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrlEachOne = ossClient.getImgUrl(name);
        String ipAddr = IpUtil.getIpAddr(request);
        fileUrl.setAddIp(ipAddr);
        fileUrl.setCreateTime(new Date());
        fileUrl.setUpdateTime(new Date());
        //将http转化为https
        String httpToHttps = imgUrlEachOne.replaceAll("http://", "https://");
        fileUrl.setImgUrl(httpToHttps);
        fileUrl.setStatus(MiddlerGroudConstans.IMG_NORMAL);
        log.info("imgUrlEachOne--{}",imgUrlEachOne);
        //TODO userId appKey
        KxgImgFileDb fileDb=new KxgImgFileDb();
        fileDb.setAddIp(ipAddr);
        fileDb.setCreateTime(new Date());
        fileDb.setImgUrl(imgUrlEachOne);
        fileDb.setStatus(MiddlerGroudConstans.IMG_NORMAL);
        kxgImgFileDbDao.addImgFile(fileDb);
        return fileUrl;
    }
}
