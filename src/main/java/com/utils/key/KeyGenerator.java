package com.utils.key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utils.GlobalConstant;
import com.utils.base64.Base64StringUtils;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class KeyGenerator {

	private static final Logger logger = LoggerFactory.getLogger(KeyGenerator.class);

	/**
	 * 生成密钥对
	 * 
	 * @return KeyPair
	 */
	public static KeyPair generateKeyPair() throws Exception {
		try {
			// 形成RSA公钥对
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(GlobalConstant.RSA);
			keyGen.initialize(1024);
			KeyPair keyPair = keyGen.generateKeyPair();
			return keyPair;
		} catch (Exception ex) {
			logger.error("生成密钥对产生错误", ex);
			throw new Exception("生成密钥对产生错误", ex);
		}
	}

	/**
	 * 生成公钥
	 * 
	 * @param modulus
	 * @param publicExponent
	 * @return RSAPublicKey
	 * @throws Exception
	 */
	public static PublicKey generatePublicKey(String modulus, String publicExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance(GlobalConstant.RSA);

			RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(
					new BigInteger(Base64StringUtils.decryptBASE64(modulus)), new BigInteger(
							Base64StringUtils.decryptBASE64(publicExponent)));
			return (PublicKey) keyFac.generatePublic(pubKeySpec);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	/**
	 * 生成私钥 　　
	 * @param modulus
	 * @param privateExponent
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey generatePrivateKey(String modulus, String privateExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance(GlobalConstant.RSA);
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.getMessage());
		}

		RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(Base64StringUtils.decryptBASE64(modulus)),
				new BigInteger(Base64StringUtils.decryptBASE64(privateExponent)));
		try {
			return keyFac.generatePrivate(priKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new Exception(ex.getMessage());
		}
	}

	public static void generatedPublicKeyHexString(RSAPublicKey publicKey) throws Exception {
		System.out.println("public-modulus-->" + Base64StringUtils.encryptBASE64(publicKey.getModulus().toByteArray()));
		System.out.println("public-exponent-->"
				+ Base64StringUtils.encryptBASE64(publicKey.getPublicExponent().toByteArray()));
	}

	public static void generatedPrivateKeyHexString(RSAPrivateKey privateKey) throws Exception {
		System.out.println("private-modulus-->"
				+ Base64StringUtils.encryptBASE64(privateKey.getModulus().toByteArray()));
		System.out.println("private-exponent-->"
				+ Base64StringUtils.encryptBASE64(privateKey.getPrivateExponent().toByteArray()));
	}

	public static void main(String[] args) throws Exception {
		KeyPair keyPair = KeyGenerator.generateKeyPair();
		generatedPublicKeyHexString((RSAPublicKey) keyPair.getPublic());
		generatedPrivateKeyHexString((RSAPrivateKey) keyPair.getPrivate());
	}
}
