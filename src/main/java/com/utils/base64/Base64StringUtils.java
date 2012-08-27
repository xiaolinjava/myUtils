package com.utils.base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.utils.GlobalConstant;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64StringUtils {

	/**
	 * BASE64加密
	 * 
	 * @param key
	 *            byte[]
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 *            string
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	public static String encryptBASE64(String key)
			throws UnsupportedEncodingException {
		return encryptBASE64(key.getBytes(GlobalConstant.ENCODING_UTF_8));
	}

	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static byte[] decryptBASE64(String key) throws IOException {
		return (new BASE64Decoder()).decodeBuffer(key);
	}
}
