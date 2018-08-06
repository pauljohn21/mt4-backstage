package com.kajie88.base.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;


public class CollectionUtils {

	public static void copyProperties(List source, List target,Class<?> tClass){
		if(source==null||source.size()==0)return;
		if(target==null){
			return;
		}
		target.clear();
		for (Object s:source){
			try {
				Object t = tClass.newInstance();
				BeanUtils.copyProperties(s,t);
				target.add(t);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
