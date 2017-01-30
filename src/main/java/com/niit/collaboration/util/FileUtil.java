package com.niit.collaboration.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
private static Logger log = LoggerFactory.getLogger(FileUtil.class);

private static String path = "D:/Collaboration_images";

public static void upload(MultipartFile file , String fileName){
	
	log.debug("Start of method to uploadimage");
	if(!file.isEmpty()){
		try{
			byte[] bytes=file.getBytes();
			
			File dir = new File(path);
			if(!dir.exists())
				dir.mkdirs();
			File serverFile = new File(dir.getAbsolutePath()+File.separator+fileName);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			
			log.info("Server file location="+serverFile.getAbsolutePath());
		}
		catch(Exception e ){
			e.printStackTrace();
		}
	}
}
}
