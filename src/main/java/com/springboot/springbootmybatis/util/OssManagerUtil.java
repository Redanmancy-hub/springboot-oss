package com.springboot.springbootmybatis.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.springboot.springbootmybatis.config.OssConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
@Slf4j
public class OssManagerUtil {
    private OssConfig ossConfig;

    public OssManagerUtil(OssConfig ossConfig) {
        this.ossConfig = ossConfig;
    }

    public String upload(byte[] fileContent, String originalFileName) {
        // 默认值：true
        boolean isImage = true;
        // 判断所要上传的文件是否是图片，图片可以预览，其他文件不提供通过URL浏览
        try {
            InputStream inputStream = new ByteArrayInputStream(fileContent);
            Image image = ImageIO.read(inputStream);
            isImage = image != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("----OSS文件上传开始----");

        // 生成UUID作为文件名
        String fileExtension = getFileExtension(originalFileName);
        String uuidFileName = UUID.randomUUID().toString().replace("-", "") + "." + fileExtension;

        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
        try {
            // 判断容器是否存在,不存在就创建
            if (!ossClient.doesBucketExist(ossConfig.getBucketName())) {
                ossClient.createBucket(ossConfig.getBucketName());
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(ossConfig.getBucketName());
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = uuidFileName; // UUID作为文件名
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(ossConfig.getBucketName(), fileUrl, new ByteArrayInputStream(fileContent)));
            // 设置权限(公开读)
            ossClient.setBucketAcl(ossConfig.getBucketName(), CannedAccessControlList.PublicRead);
            if (result != null) {
                // 上传成功后拼接地址
                String FILE_URL;
                if (isImage) {//如果是图片，则图片的URL为：....
                    FILE_URL = "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint() + "/" + fileUrl;
                } else {
                    FILE_URL = fileUrl;
                    log.debug("非图片,不可预览。文件路径为：" + fileUrl);
                }
                log.debug("------OSS文件上传成功------" + fileUrl);
                return FILE_URL;
            }
        } catch (OSSException ossException) {
            log.debug(ossException.getMessage());
        } catch (ClientException clientException) {
            log.debug(clientException.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // 返回空字符串表示没有扩展名
        }
        return fileName.substring(lastIndexOf + 1);
    }


    /**
     * 创建文件夹
     *
     * @param folder
     * @return
     */
    public String createFolder(String folder) {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
        // 文件夹名
        final String keySuffixWithSlash = folder;
        // 判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(ossConfig.getBucketName(), keySuffixWithSlash)) {
            // 创建文件夹
            ossClient.putObject(ossConfig.getBucketName(), keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            log.debug("创建文件夹成功");
            // 得到文件夹名
            OSSObject object = ossClient.getObject(ossConfig.getBucketName(), keySuffixWithSlash);
            String fileDir = object.getKey();
            ossClient.shutdown();
            return fileDir;
        }
        return keySuffixWithSlash;
    }


    public byte[] download(String filename) {
        log.debug("----OSS文件下载开始----");

        // 如果文件名为空，则直接返回空数组
        if (filename == null || filename.isEmpty()) {
            log.debug("文件名为空，无法进行下载。");
            return new byte[0];
        }

        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());

        try {
            // 下载文件
            OSSObject ossObject = ossClient.getObject(new GetObjectRequest(ossConfig.getBucketName(), filename));
            InputStream inputStream = ossObject.getObjectContent();

            // 读取文件内容
            byte[] fileContent = new byte[inputStream.available()];
            inputStream.read(fileContent);

            log.debug("------OSS文件下载成功------" + filename);
            return fileContent;
        } catch (IOException e) {
            log.debug("文件下载失败: " + e.getMessage());
            throw new RuntimeException("文件下载失败: " + e.getMessage());
        } catch (OSSException | ClientException e) {
            log.debug(e.getMessage());
            throw new RuntimeException("文件下载失败: " + e.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}

