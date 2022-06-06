package com.ecommerce.java_ecommerce.services.storage;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    public String store(MultipartFile file, String path);

}
