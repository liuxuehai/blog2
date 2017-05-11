/*******************************************************************************
 * Created on 2017年5月11日 上午9:21:08
 * Copyright (c) 深圳市小牛在线互联网信息咨询有限公司版权所有. 粤ICP备13089339号
 * 注意：本内容仅限于深圳市小牛在线互联网信息咨询有限公司内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package com.pong.blog.management.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pong.blog.dto.UploadResult;

/**
 * 
 * @since 1.0.0
 * @version  
 * @author liuping : 2017年5月11日 
 */
@Controller
@RequestMapping("/ue")
public class UeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${service.upload.path}")
    private String uploadPath;
    @Value("${service.upload.url}")
    private String url;

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public Object handleFileUpload(@RequestParam("action") String action, @RequestParam("upfile") MultipartFile file) {
        UploadResult result = new UploadResult();
        if (!file.isEmpty()) {
            try {
                result.setState("SUCCESS");
                String original = file.getOriginalFilename();
                String extensionName = original.substring(original.lastIndexOf(".") + 1);
                String path = System.currentTimeMillis() + "." + extensionName;
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(uploadPath + path)));
                stream.write(bytes);
                stream.close();
                result.setOriginal(original);
                result.setUrl(url + path);
            } catch (Exception e) {
                logger.error("文件上传失败 {},{}", action, e);
                result.setState("ERROR");
                result.setMsg("文件上传失败");
            }
        } else {
            result.setState("ERROR");
            result.setMsg("文件不能为空");
        }
        return result;
    }

    @RequestMapping(value = "/file/{filename:[a-zA-Z0-9\\.]+}", method = RequestMethod.GET)
    public void download(@PathVariable String filename, ModelMap model, HttpServletResponse response) {
        logger.info("下载文件开始====={}", filename);
        if (StringUtils.isNotBlank(filename)) {
            File file = new File(uploadPath +filename);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    logger.info("文件{}下载成功", filename);
                } catch (Exception e) {
                    logger.error("下载文件出错====={}:()", filename, e);
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            logger.error("资源关闭出错====={}:()", filename, e);
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            logger.error("资源关闭出错====={}:()", filename, e);
                        }
                    }
                }
            }
        }
    }

}
