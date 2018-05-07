/**
 * Project Name:qqtest
 * File Name:HttpClient.java
 * Package Name:com.jyd.test
 * Date:2017年9月15日下午10:13:12
 * Copyright (c) 2017
 *
 */
package com.jyd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jyd.domain.WeixinDepartment;

/**
 * 类名: HttpClient 备注: 时间: 2017年9月15日 下午10:13:12 作者:sylar
 * 
 * @version
 * @since JDK 1.8
 */
public class HttpClient {
	private static Logger log = LoggerFactory.getLogger(HttpClient.class);
	
	// 获取微信token
	public static String getToken(){
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {  
            //利用get形式获得token  
            HttpGet httpget = new HttpGet(Constant.url+"?corpid="+Constant.corpid+"&corpsecret="+Constant.corpsecret);  
            // Create a custom response handler  
            ResponseHandler<JSONObject> responseHandler = new ResponseHandler<JSONObject>() {  
                public JSONObject handleResponse(  
                        final HttpResponse response) throws ClientProtocolException, IOException {  
                    int status = response.getStatusLine().getStatusCode();  
                    if (status >= 200 && status < 300) {  
                        HttpEntity entity = response.getEntity();  
                        if(null!=entity){  
                            String result= EntityUtils.toString(entity);  
                            //根据字符串生成JSON对象  
                            JSONObject resultObj = JSONObject.fromObject(result);  
                            return resultObj;  
                        }else{  
                            return null;  
                        }  
                    } else {  
                        throw new ClientProtocolException("Unexpected response status: " + status);  
                    }  
                }  
            };
            //返回的json对象  
            JSONObject responseBody = httpclient.execute(httpget, responseHandler);  
            String token="";  
            if(null!=responseBody){  
                token= (String) responseBody.get("access_token");//返回token  
            }  
            System.out.println("access_token:"+responseBody.get("access_token"));  
            System.out.println("expires_in:"+responseBody.get("expires_in"));  
            httpclient.close();  
            return token;  
        }catch (Exception e) {  
            e.printStackTrace();  
            return "";  
        }   
    }
	
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("连接超时：{}", ce);
		} catch (Exception e) {
			log.error("https请求异常：{}", e);
		}
		return jsonObject;
	}
	
	//创建部门
	public static Object createDept(String access_token,WeixinDepartment dept){
		HttpResponse response = null;
		StringBuffer sb = new StringBuffer();
		sb.append("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=");
		sb.append(access_token);
		String url = sb.toString();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		JSONObject params = new JSONObject();
		params.put("name", dept.getName());
		params.put("parentid", dept.getParentid());
		params.put("order", dept.getOrder());
		params.put("id", dept.getId());
		StringEntity entity = new StringEntity(params.toString(),"utf-8");//解决中文乱码问题    
		entity.setContentEncoding("UTF-8");    
		entity.setContentType("application/json");    
		httpPost.setEntity(entity);
		System.out.println(params);
		System.out.println(entity);
		try {
			response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == 200) {
				HttpEntity he = response.getEntity();
				String respContent = EntityUtils.toString(he,"UTF-8");
				return respContent;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//获取部门
	public static JSONObject getDeptList(String access_token){
		JSONObject jsonObject = null;
		HttpResponse response = null;
		StringBuffer sb = new StringBuffer();
		sb.append("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=");
		sb.append(access_token);
		String url = sb.toString();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); 
		try {
			response = httpClient.execute(httpget);
			if(response.getStatusLine().getStatusCode()==200){
				HttpEntity he = response.getEntity();
				String data = he.getContent().toString();
				return JSONObject.fromObject(data);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}