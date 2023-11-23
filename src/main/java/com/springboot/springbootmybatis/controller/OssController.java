package com.springboot.springbootmybatis.controller;


import com.springboot.springbootmybatis.util.OssManagerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Objects;

@Slf4j
@RestController
public class OssController {
    @Resource
    private OssManagerUtil ossManagerUtil;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileload");
        return modelAndView;
    }


    @RequestMapping("/upload")
    public ModelAndView testALoss(MultipartFile multipartFile,  HttpServletRequest request) {
        HashMap<Object, Object> map = new HashMap<>();
        String fileUrl;
        try {
            // 获取文件名
            String fileName = Objects.requireNonNull(multipartFile.getOriginalFilename());

            // 获取文件内容
            byte[] fileContent = multipartFile.getBytes();

            // 调用OssManagerUtil的upload方法将文件内容直接上传到阿里云OSS
            fileUrl = ossManagerUtil.upload(fileContent, fileName);
            // 返回上传成功的文件URL
            map.put("fileUrl", fileUrl);
            log.info("文件上传成功，文件URL: {}", fileUrl);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("msg", "（上传成功）");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fileUrl", fileUrl);
        modelAndView.setViewName("fileload");
        return modelAndView;
    }


    @RequestMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("filename") String filename) {
        log.error(filename);
        try {
            // 调用 OssManagerUtil 或文件检索逻辑以获取文件内容
            byte[] fileContent = ossManagerUtil.download(filename);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", filename);

            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException("文件下载失败: " + e.getMessage());
        }
    }

}
