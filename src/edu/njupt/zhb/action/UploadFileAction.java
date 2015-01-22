package edu.njupt.zhb.action;

import java.io.File;
import java.util.Random;

import net.sf.json.JSONObject;
import edu.njupt.zhb.utils.FileUtils;

/**
 * @date 2015年1月21日 下午11:06:50
 * @author Zheng Haibo
 * @Description: 上传文件接口
 */
public class UploadFileAction extends BaseAction {

	private static final long serialVersionUID = 6189305235503047621L;

	private File userImage;

	private String userImageContentType;

	private String userImageFileName;
	
	public static final String UPLOAD_FILE_DIR = "uploadfiles/";

	public void upload() {
		String myFileNameStr = getUserImageFileName();
		String clientIP = getRequest().getRemoteAddr();
		System.out.println("clientIP:" + clientIP);
		if (clientIP.equals("0:0:0:0:0:0:0:1")) {
			clientIP = "localhost";
		}
		String myFileName = clientIP + "_" + myFileNameStr;
		String fileDir = getBasePath() + UPLOAD_FILE_DIR;
		if(!new File(fileDir).exists()){
			new File(fileDir).mkdirs();
		}
		String filePath = fileDir + myFileName;
		boolean isSucc = FileUtils.copyFile(userImage, filePath);
		if (isSucc) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("error_code", 2000);
			jsonObject.put("msg", "OK");
			jsonObject.put("filepath",UPLOAD_FILE_DIR+myFileName);
			writeStr(jsonObject.toString());
		} else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("error_code", 4001);
			jsonObject.put("msg", "error");
			jsonObject.put("filepath",null);
			writeStr(jsonObject.toString());
		}
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

}
