package com.mybatis.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

@Controller
public class UserController {

	private static final String AK = null;
	private static final String SK = null;

	// �ļ��ϴ�
	@RequestMapping("/upload.do")
	public String upload() throws QiniuException {
		// ����һ����ָ��Zone�����������
		Configuration cfg = new Configuration(Zone.zone2());
		// ...���������ο���ע��
		UploadManager uploadManager = new UploadManager(cfg);
		// ...�����ϴ�ƾ֤��Ȼ��׼���ϴ�
		String accessKey = "gl2fsklCym7a9UWbcLGCGLCV7PakLaL-lcabLelr";
		String secretKey = "a8VKGZcuNkBWp0rRpYFhU3JYbrFTMhgR-Xs3VILo";
		String bucket = "yangzinan";

		String localFilePath = "E:\\nike.jpg";
		// Ĭ�ϲ�ָ��key������£����ļ����ݵ�hashֵ��Ϊ�ļ���
		String key = "nike.jpg";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		try {
			Response response = uploadManager.put(localFilePath, key, upToken);
			// �����ϴ��ɹ��Ľ��
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			System.out.println(putRet.key);
			System.out.println(putRet.hash);
		} catch (QiniuException ex) {
			Response r = ex.response;
			System.err.println(r.toString());
			try {
				System.err.println(r.bodyString());
			} catch (QiniuException ex2) {
				// ignore
			}
		}

		return "qiniu";
	}

	// �ļ�����
	@RequestMapping("/download.do")
	public String download(Map<String,Object> map) {
		//����һ����ָ��Zone�����������
		Configuration cfg = new Configuration(Zone.zone2());
		//���������ο���ע��
		String accessKey = "gl2fsklCym7a9UWbcLGCGLCV7PakLaL-lcabLelr";
		String secretKey = "a8VKGZcuNkBWp0rRpYFhU3JYbrFTMhgR-Xs3VILo";
		String bucket = "yangzinan";
		String key = "nike.jpg";
		Auth auth = Auth.create(accessKey, secretKey);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		try {
		    FileInfo fileInfo = bucketManager.stat(bucket, key);
		    String cdnUrl="http://ouripeu3p.bkt.clouddn.com/";
            System.out.println(cdnUrl+key);
            map.put("url", cdnUrl+key);
            
		} catch (QiniuException ex) {
		    System.err.println(ex.response.toString());
		}

		return "qiniu";
	}

}
