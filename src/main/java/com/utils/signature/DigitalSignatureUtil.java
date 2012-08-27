package com.utils.signature;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utils.GlobalConstant;
import com.utils.base64.Base64StringUtils;
import com.utils.string.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureUtil {

	private static final Logger logger = LoggerFactory.getLogger(DigitalSignatureUtil.class);

	/**
	 * 数字签名
	 * 
	 * @param key
	 *            私钥
	 * @param sourceText
	 *            待签名数据
	 * @return 数字签名结果
	 */
	public static String sign(PrivateKey key, String sourceText) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("进入数字签名：" + sourceText);
		}
		try {
			byte[] digestByte = md5Encrypt(sourceText, GlobalConstant.ENCODING_UTF_8).getBytes(
					GlobalConstant.ENCODING_UTF_8);
			Signature sig = Signature.getInstance("SHA1WithRSA");
			sig.initSign(key);
			sig.update(digestByte);
			return Base64StringUtils.encryptBASE64(sig.sign());
		} catch (Exception ex) {
			logger.error("签名发生错误", ex);
			throw new Exception("签名发生错误", ex);
		}
	}

	/**
	 * 验证签名
	 * 
	 * @param key
	 *            解密的密钥
	 * @param
	 * @return 解密后的明文
	 */
	public static boolean verify(PublicKey key, String signStr, String sourceText) {
		if (logger.isDebugEnabled()) {
			logger.debug("进入数字签名验证：signStr：" + signStr + ",sourceText:" + sourceText);
		}
		try {
			Signature sig = Signature.getInstance("SHA1WithRSA");
			sig.initVerify(key);
			sig.update(md5Encrypt(sourceText, GlobalConstant.ENCODING_UTF_8).getBytes(GlobalConstant.ENCODING_UTF_8));
			if (sig.verify(Base64StringUtils.decryptBASE64(signStr)))
				return true;
			return false;
		} catch (Exception ex) {
			logger.error("解密发生异常", ex);
			throw new RuntimeException("签名发生错误");
		}
	}

	/**
	 * 该方法用于返回MD5摘要
	 */
	public static String md5Encrypt(String content, String charset) {
		if (StringUtils.isEmpty(charset)) {
			charset = GlobalConstant.ENCODING_UTF_8;
		}
		return DigestUtils.md5Hex(getContentBytes(content, charset));
	}

	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}
}
