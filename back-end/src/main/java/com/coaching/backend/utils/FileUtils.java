package com.coaching.backend.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileUtils {
    public static void saveFile(MultipartFile file, String documentPath, String documentName) throws IOException {
        if (!file.isEmpty()) {
            if (!new File(documentPath).exists()) {
                new File(documentPath).mkdirs();
            }
            String filePath = documentPath + documentName;
            File dest = new File(filePath);
            file.transferTo(dest);
        }
    }

    public static String getExtension(MultipartFile file) {
        return Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".") + 1);
    }
}
