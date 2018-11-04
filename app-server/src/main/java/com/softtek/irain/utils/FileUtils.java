package com.softtek.irain.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by kaishen on 09/09/2018.
 */
public class FileUtils {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
