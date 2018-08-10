package com.kajie88.base.utils;

import java.util.UUID;

/**
 * Created by wangjun on 2016/7/6.
 */
public class UUIDUtil {
	/**
	 * 获取UUID值
	 * @return
	 */
	public static String createUUID(){
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "").toUpperCase();
		return uuid;
	}
}
