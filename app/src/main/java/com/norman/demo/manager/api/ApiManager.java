package com.norman.demo.manager.api;

import com.norman.demo.entity.ApiResponse;
import com.norman.demo.entity.Version;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Administrator on 2016/4/5.
 */
public class ApiManager {
    private static final String ENDPOINT = "http://192.168.0.118:8080/";
    private static final  OkHttpClient okhttpclient= new OkHttpClient();

    private static final Retrofit sRetrofit = new Retrofit .Builder()
            .baseUrl(ENDPOINT)

            .client(okhttpclient)
           //.baseUrl("http://zhuangbi.info/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static final ApiManagerService apiManager = sRetrofit.create(ApiManagerService.class);

    /**
     *
     * @return
     */
    public static Observable<ApiResponse<Version>> getWeatherData(int str) {
        return apiManager.getData(str);
    }
}
