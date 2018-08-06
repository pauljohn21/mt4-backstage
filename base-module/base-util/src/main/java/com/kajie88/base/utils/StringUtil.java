package com.kajie88.base.utils;

import java.text.DecimalFormat;

public class StringUtil {

	public static String empt = "";

	/**
	 * 在所需值前
	 * @param value
	 * @param len
	 * @param fillValue
	 * @return
	 */
	public static String beforFillValue(String value, int len, String fillValue) {
		String str = (value == null) ? "" : value.trim();
		StringBuffer result = new StringBuffer();
		int paramLen = str.length();
		if (paramLen < len) {
			for (int i = 0; i < len - paramLen; i++) {
				result.append(fillValue);
			}
		}
		result.append(str);
		return result.toString();
	}
	/**
	 * 首字母转小写
	 */
	public static String toLowerCaseFirstOne(String s)
	{
		if(Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	/**
	 * 首字母转大写
	 */
	public static String toUpperCaseFirstOne(String s)
	{
		if(Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * Convert byte[] to hex string.这里我们可以将byte转换成int，
	 * 然后利用Integer.toHexString(int)来转换成16进制字符串。
	 *
	 * @param src byte[] data
	 * @return hex string
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 16进制字符串转换为字节数组
	 *
	 * @param hexString 16进制的字符串
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	public static boolean isEmpt(String str){
		if(str==null||"".equals(str)){
			return true;
		}
		return false;
	}



	public static String numberAddUnit(double number) {
		DecimalFormat df = new DecimalFormat("######0.0");
		double bw = number/1000000;
		if(bw>1){
			return (int)bw+"百万";
		}
		double w = number/10000;
		if(w>1){
			return df.format(w)+"万";
		}
		double q = number/1000;
		if(q>1){
			return df.format(q)+"千";
		}
		return (int)number+"";
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}


	public static boolean isEmptyForTrim(String str) {
		if(str==null||"".equals(str.trim()))return true;
		return false;
	}

	public static String toString(Object str) {
		return hasEmpty(str)?null:str.toString();
	}

	public static String toString(Object str, String def) {
		return hasEmpty(str)?def:str.toString();
	}


	public static boolean hasEmpty(Object headImg) {
		return headImg == null || headImg.toString().trim().equals(empt);
	}

}
