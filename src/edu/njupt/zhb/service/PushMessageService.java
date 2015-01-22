package edu.njupt.zhb.service;

/**
 * @date 2015年1月13日 下午5:30:26
 * @author Zheng Haibo
 * @Description: 推送服务
 */
public interface PushMessageService {
	public void sendPushMessageToDevice(String content, String title,
			String devicesToken);
}
