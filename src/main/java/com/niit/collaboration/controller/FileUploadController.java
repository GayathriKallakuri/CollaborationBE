package com.niit.collaboration.controller;

import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.collaboration.util.FileUtil;

@RestController
@MultipartConfig(fileSizeThreshold = 20971520)
public class FileUploadController {

	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);
     
	@RequestMapping(value="/upload")
	public void uploadFile(@RequestParam("uploadFile")MultipartFile multipartFile){
		FileUtil.upload(multipartFile, "test.png");
	}
}
