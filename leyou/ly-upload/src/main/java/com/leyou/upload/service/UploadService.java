package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.upload.config.UploadProperties;
import com.leyou.upload.web.UploadController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * @author wfl
 * @description
 */
@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    // 支持的文件类型  使用配置文件 UploadProperties
    //private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg","image/bmp");

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties properties;

    public String upload(MultipartFile file) {

        try {
            // 1、图片信息校验
            // 1)校验文件类型
            String type = file.getContentType();
            if (!properties.getSuffixes().contains(type)) {
                logger.info("上传失败，文件类型不匹配：{}", type);
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);

            }
            // 2、上传fastDFS
            //2.1 获取文件后缀名
            //String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("." + 1));
            String extention = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extention, null);

            return properties.getBaseUrl() + storePath.getFullPath();
        } catch (Exception e) {
            logger.info("[文件上传] 上传失败");
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }
    }
}
