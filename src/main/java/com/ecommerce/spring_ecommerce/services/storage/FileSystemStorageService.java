package com.ecommerce.spring_ecommerce.services.storage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation = Paths.get(System.getProperty("user.dir"));

    @Override
    public String store(MultipartFile file, String path) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            final Path location = Paths.get(this.rootLocation.toString() + "/" + path);
            if (!Files.isDirectory(location)) {
                Files.createDirectory(location);
            }

            String filename = file.getOriginalFilename();
            filename = new Date().getTime()
                    + "-" + (10000 + new Random().nextInt(100000))
                    + "-" + filename;
            Files.copy(file.getInputStream(), location.resolve(filename));
            return filename;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

}
