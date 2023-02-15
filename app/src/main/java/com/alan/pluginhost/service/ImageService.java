package com.alan.pluginhost.service;

import com.alan.pluginhost.pojo.ImageBean;

import java.io.File;

public interface ImageService {

    ImageBean upfileByUser(File file, String userId) throws Exception;
}
