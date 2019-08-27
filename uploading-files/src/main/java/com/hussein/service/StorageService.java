package com.hussein.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * <p>Title: StorageService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 12:01 PM
 */
public interface StorageService {

    void init();

    void store(MultipartFile file);

    Path load(String filename);

    Stream<Path> loadAll();

    Resource loadAsResource(String filename);

    void deleteAll();
}
