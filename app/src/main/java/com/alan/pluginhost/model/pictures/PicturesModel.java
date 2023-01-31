package com.alan.pluginhost.model.pictures;


import com.alan.pluginhost.model.OnNetRequestListener;
import com.alan.pluginhost.model.entity.OpenApiPicture;
import com.alan.pluginhost.model.entity.OpenApiResponse;
import com.alan.pluginhost.model.entity.PictureBody;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface PicturesModel {
    String DEFAULT_TYPE = "4001";//类别 "清纯"

    Observable<OpenApiResponse<List<OpenApiPicture>>> netLoadPicturesByOpenApi(int page, int count);

    void netLoadPictures(String type, int page, OnNetRequestListener<List<PictureBody>> listener);
}
