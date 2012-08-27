package com.utils.file;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import com.utils.GlobalConstant;

public class FileTools {
    
    
    
    public static String read(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return "";
        }
        return FileUtils.readFileToString(file, GlobalConstant.ENCODING_UTF_8);
    }
    
    public static void write(String filePath,String content) throws IOException {
    	FileUtils.writeStringToFile(new File(filePath), content, GlobalConstant.ENCODING_UTF_8);
    }
    
    public static boolean fileExists(String filePath){
        File file = new File(filePath);
        return file.exists();
    }

    public static void append(String filePath, String imageIndex) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(FileTools.read(filePath));
        stringBuilder.append(imageIndex);
        FileTools.write(filePath, stringBuilder.toString());
    }

    public static void mkDir(String filePath) {
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();  
        }
    }

    public static void delete(String filePath){
    	File file = new File(filePath);
    	file.deleteOnExit();
    }
}
