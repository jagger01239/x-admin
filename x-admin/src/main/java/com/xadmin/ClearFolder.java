package com.xadmin;

import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class ClearFolder {
    public static void main1(String pathname) {
        File folder = new File(pathname); // 文件夹路径
        try {
            clearFolder(folder);
            String directoryPath = pathname;
            File directory = new File(directoryPath);
            if (!directory.exists()){
                directory.mkdir();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void clearFolder(File folder) {
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                clearFolder(file);
            }
        }
        folder.delete();
    }
}