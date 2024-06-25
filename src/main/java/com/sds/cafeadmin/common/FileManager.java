package com.sds.cafeadmin.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.sds.cafeadmin.domain.Product;
import com.sds.cafeadmin.exception.UploadException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileManager {

//	@Autowired
//    private ResourceLoader resourceLoader;
//	
//	 @Value("${upload.location}")
//	    private String uploadLoctaion;
//
//    public void save(Product product) throws UploadException {
//        if (product.getFile() != null && !product.getFile().isEmpty()) {
//            try {
//                Path path = Paths.get(uploadLoctaion + File.separator + product.getFile().getOriginalFilename());
//                Files.write(path, product.getFile().getBytes());
//            } catch (IOException e) {
//                log.error("파일 업로드 중 오류 발생: " + e.getMessage());
//                throw new UploadException("파일 업로드에 실패하였습니다.", e);
//            }
//        } else {
//            log.warn("업로드할 파일이 없습니다.");
//            throw new UploadException("업로드할 파일이 없습니다.");
//        }
//    }
//
//
//    private String getExt(String path) {
//        return path.substring(path.lastIndexOf(".") + 1, path.length());
//    }
//
//    private String createFilename(String ext) {
//        long time = System.currentTimeMillis();
//        return time + "." + ext;
//    }
}
