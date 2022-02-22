package com.coaching.backend.service;

import com.coaching.backend.enumeration.CoachDocuments;
import com.coaching.backend.exception.FileNullException;
import com.coaching.backend.exception.FileTypeInappropriateException;
import com.coaching.backend.model.Coach;
import com.coaching.backend.utils.FileConfig;
import com.coaching.backend.utils.FileUtils;
import com.coaching.backend.utils.MD5;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@Service
@Transactional
@AllArgsConstructor
public class FileService {
    private final CoachService coachService;
    private final FileConfig fileConfig;
    public void uploadCoachDocuments(Coach coach, MultipartFile file, CoachDocuments type) throws IOException, NoSuchAlgorithmException {
        if (file == null || file.getContentType() == null) throw new FileNullException();
        if(!file.getContentType().startsWith("image") && !file.getContentType().startsWith("application/pdf")){
            throw new FileTypeInappropriateException(file.getContentType().toLowerCase(),"image","pdf");
        }
        String documentName = MD5.getMD5Hash(coach.getEmail() + type.value()) + "." + FileUtils.getExtension(file);
        String documentPath = fileConfig.getDirectory();
        FileUtils.saveFile(file,documentPath, documentName);
        coachService.setCoachDocument(coach,type,documentPath);
    }
}
