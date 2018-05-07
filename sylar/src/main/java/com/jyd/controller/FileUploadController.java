/**
 * Project Name:sylar
 * File Name:FileUploadController.java
 * Package Name:com.jyd.controller
 * Date:2018年4月22日下午10:52:59
 * Copyright (c) 2018
 */
package com.jyd.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



/**
 * ClassName: FileUploadController
 * Comment:
 * Time: 2018年4月22日 下午10:52:59
 * Author:sylar
 * @Version 
 * @Since JDK 1.8
 */
@Controller
public class FileUploadController {
	
	@RequestMapping(value="testUpload",method=RequestMethod.POST)  
	@ResponseBody  
	public Map<String,Object> testUpload(Model model,@RequestParam(value = "upfile", required = false) MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws Exception{  
	      
	  
	      
	    request.setCharacterEncoding("utf-8");  
	    response.setCharacterEncoding("utf-8");  
	    Map<String,Object> result=new HashMap<String,Object>();//  
	    String fileName = file.getOriginalFilename();  
	    String filePath="/uploads/image"+File.separator;  
	      File targetFile = new File(filePath, fileName);  
	        if(!targetFile.exists()){    
	            targetFile.mkdirs();    
	        }    
	        try {    
	            file.transferTo(targetFile);    
	        } catch (Exception e) {    
	            e.printStackTrace();    
	        }    
	        result.put("name", file.getOriginalFilename());//新的文件名  
	        result.put("originalName", file.getOriginalFilename());//原始文件名  
	        result.put("size", file.getSize());  
	        result.put("state", "SUCCESS");  
	        result.put("url", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/testEditor/testShowImg.action?path="+fileName);//展示图片的请求url  
	    return result;  
	      
	}  
	  
	  
	/** 
	 * 显示图片 
	 * @param request 
	 * @return 
	 * @throws Exception  
	 */  
	@RequestMapping(value = "testShowImg")  
	public void testShowImg(Model model,@RequestParam String path, HttpServletRequest request,HttpServletResponse response) throws Exception {  
	    String relaPath = path;  
	      
	
	        //构造完整的图片路径  
	        String rootPath;  
	        rootPath = "/uploads/image";  
	        String fullImagePath;             
	        fullImagePath = rootPath+relaPath;        
	       
	    }
	
}
