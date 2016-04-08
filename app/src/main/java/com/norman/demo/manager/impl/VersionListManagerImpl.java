package com.norman.demo.manager.impl;

import android.util.Log;

import com.norman.demo.entity.ApiResponse;
import com.norman.demo.entity.Version;
import com.norman.demo.listener.DataFinishedListener;
import com.norman.demo.manager.VersionListManager;
import com.norman.demo.manager.api.ApiManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/3/23.
 */
public class VersionListManagerImpl implements VersionListManager {

    DataFinishedListener listener;
    Observer<ApiResponse<Version>> observer = new Observer<ApiResponse<Version>>() {
        @Override
        public void onCompleted() {
            Log.e("Manger", "完成");
        }

        @Override
        public void onError(Throwable e) {
            Log.e("Manger", "完成" + e.getMessage());
            listener.onFailed();
        }

        @Override
        public void onNext(ApiResponse<Version> ss) {
            Log.e("next", ss.getMsg() + "");
            listener.onSuccess(ss.getObjLists());
        }
    };

    /**
     * 获取数据
     * @param page 页数
     * @param listener 返回事件
     */
    @Override
    public void getData(int page, final DataFinishedListener listener) {
        this.listener = listener;
        ApiManager.getWeatherData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResponse<Version>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("MangerSDdfdf", "完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Manger", "完成" + e.getMessage());
                        listener.onFailed();
                    }

                    @Override
                    public void onNext(ApiResponse<Version> ss) {
                        Log.e("next", ss.getMsg() + "");
                        listener.onSuccess(ss.getObjLists());
                    }
                });
                //observer
//                        new Action1<ApiResponse<Version>>() {
//                            @Override
//                            public void call(ApiResponse<Version> weatherData) {
//                                Log.e("sd",weatherData.getMsg());
//                                listener.onSuccess(weatherData.getObjLists());
//                               System.out.print(weatherData.getMsg());
//                            }
//                        }, new Action1<Throwable>() {
//                            @Override
//                            public void call(Throwable throwable) {
//                                Log.e("sdddd",throwable.getMessage());
//                                System.out.print(throwable.getMessage());
//                            }
//                        });

//        OkHttpUtils.post("http://192.168.0.118:8080/LFHAPI/clientapi.ashx?action=99998")
//                .tag(this)
//                .params("page",page+"")
//                .execute(new BeanCallBack<String>() {
//                    @Override
//                    public void onResponse(String versionInfo) {
//                        Type beanType = new TypeToken<ApiResponse<List<Version>>>(){}.getType();
//                        Gson gson = new Gson();
//                        ApiResponse<List<Version>> av = gson.fromJson(versionInfo, beanType);
//                        listener.onSuccess(av.getObjLists());
//                    }
//
//                    @Override
//                    public void onError(Request request, @Nullable Response response, @Nullable Exception e) {
//                        super.onError(request, response, e);
//                        listener.onFailed();
//                    }
//                });
    }
}
