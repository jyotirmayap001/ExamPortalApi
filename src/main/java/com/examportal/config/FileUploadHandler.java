package com.examportal.config;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileUploadHandler {

	
	public final String UPLOAD_DIR="";
	
	
	/*new ClassPathResource("static/image").getFile().getAbsolutePath();*/
	
	public FileUploadHandler()throws IOException {}
	
	
	public boolean uploadFile(MultipartFile file) {
		
		boolean f=false;
		
		try {
	
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()));
			
			f=true;
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		
		return f;
		
	}
	
}
