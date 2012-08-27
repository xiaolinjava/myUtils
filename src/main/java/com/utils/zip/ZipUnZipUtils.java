package com.utils.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.utils.GlobalConstant;

public class ZipUnZipUtils {

	private ZipUnZipUtils() {
	}

	private static class ZipUnZipUtilsInstance {
		private static final ZipUnZipUtils instance = new ZipUnZipUtils();

		public static ZipUnZipUtils getInstance() {
			return instance;
		}
	}

	public static ZipUnZipUtils getInstance() {
		return ZipUnZipUtilsInstance.getInstance();
	}

	public byte[] zipString(String str) throws Exception {
		return zipString(str, GlobalConstant.ENCODING_UTF_8);
	}

	public String unzip2String(byte[] b) throws Exception {
		return unzip2String(b, GlobalConstant.ENCODING_UTF_8);
	}

	public byte[] zipString(String str, String charsetName) throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes(charsetName));
		gzip.close();

		return out.toByteArray();
	}

	public byte[] zipByte(byte[] str) throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str);
		gzip.close();

		return out.toByteArray();
	}

	public String unzip2String(byte[] b, String charsetName) throws Exception {
		return unzip2String(b, charsetName, 2048);
	}

	public byte[] unzip2Bytes(byte[] b) throws Exception {
		return unzip2Bytes(b, 2048);
	}

	public byte[] unzip2Bytes(byte[] b, int buffsize) throws Exception {

		ByteArrayInputStream in = new ByteArrayInputStream(b);
		GZIPInputStream gin = new GZIPInputStream(in);
		ByteArrayOutputStream upzip = new ByteArrayOutputStream();
		byte[] buf = new byte[buffsize];
		int len;
		while ((len = gin.read(buf)) > 0) {
			upzip.write(buf, 0, len);
		}
		gin.close();
		upzip.close();

		return upzip.toByteArray();
	}

	public String unzip2String(byte[] b, String charsetName, int buffsize) throws Exception {

		ByteArrayInputStream in = new ByteArrayInputStream(b);
		GZIPInputStream gin = new GZIPInputStream(in);
		ByteArrayOutputStream upzip = new ByteArrayOutputStream();
		byte[] buf = new byte[buffsize];
		int len;
		while ((len = gin.read(buf)) > 0) {
			upzip.write(buf, 0, len);
		}
		gin.close();
		upzip.close();

		return new String(upzip.toByteArray(), charsetName);
	}

}