package com.alan.pluginhost.model.pictures;

import com.alan.pluginhost.common.BizInterface;
import com.alan.pluginhost.model.OnNetRequestListener;
import com.alan.pluginhost.model.entity.OpenApiPicture;
import com.alan.pluginhost.model.entity.OpenApiResponse;
import com.alan.pluginhost.model.entity.PictureBody;
import com.alan.pluginhost.model.entity.ShowApiPictures;
import com.alan.pluginhost.model.entity.ShowApiResponse;
import com.alan.pluginhost.server.RetrofitService;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class PicturesModelImpl implements PicturesModel {
    @Override
    public void netLoadPictures(String type, int page, OnNetRequestListener<List<PictureBody>> listener) {
        Observable<ShowApiResponse<ShowApiPictures>> observable = RetrofitService.getInstance().
                createAPI().getShowApiPictures(RetrofitService.getCacheControl(), BizInterface.SHOW_API_APPID,
                        BizInterface.SHOW_API_KEY, type, page);

    }

    @Override
    public Observable<OpenApiResponse<List<OpenApiPicture>>> netLoadPicturesByOpenApi(int page, int count) {
        //临时切换baseurl
        Observable<OpenApiResponse<List<OpenApiPicture>>> observable = RetrofitService.getInstance().
                createAPI().getPictures(RetrofitService.getCacheControl(), page, count);

        return observable;

        /*observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mLifecycleTransformer)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        listener.onStart();
                    }
                })
                .subscribe(new Observer<OpenApiResponse<List<OpenApiPicture>>>() {
                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e);
                        listener.onFinish();
                    }

                    @Override
                    public void onComplete() {
                        listener.onFinish();
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OpenApiResponse<List<OpenApiPicture>> openApiResponse) {
                        if (OpenApiResponse.SUCCESS == openApiResponse.code) {
                            listener.onSuccess(openApiResponse.result);
                        } else {
                            listener.onFailure(new Exception());
                        }
                    }
                });*/
    }
}
