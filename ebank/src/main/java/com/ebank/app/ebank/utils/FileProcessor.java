package com.ebank.app.ebank.utils;


import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


@Component
public class FileProcessor {


    private static final String DIRECTORY_PATH = "C:\\E-Banking Application\\backend\\ebank\\pdf\\";




    public static String uploadFile(ByteArrayInputStream inputStream) throws IOException {
        String fileName = "Example.pdf";
        String filePath = DIRECTORY_PATH + File.separator + fileName;


        File file = new File(DIRECTORY_PATH);


        if (!file.exists()) {
            file.mkdir();
        }


        Files.copy(inputStream, Paths.get(filePath));


        return fileName;
    }

}
