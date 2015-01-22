package edu.njupt.zhb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @date 2015年1月21日 下午11:10:54
 * @author Zheng Haibo
 * @Description: 文件操作
 */
public class FileUtils {

	/**
	 * copy file
	 * 
	 * @param oldFile
	 * @param newPath
	 */
	public static boolean copyFile(File oldFile, String newPath) {
		try {
			File newfile = new File(newPath);
			if (newfile.exists()) {
				return false;
			}
			InputStream is = new FileInputStream(oldFile); // 读入原文件
			// 把写入到上面设置的路径里
			OutputStream os = new FileOutputStream(newfile);
			byte[] buffer = new byte[4096];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			System.out.println("copy file error");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
