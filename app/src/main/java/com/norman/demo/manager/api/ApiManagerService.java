package com.norman.demo.manager.api;

import com.norman.demo.entity.ApiResponse;
import com.norman.demo.entity.Version;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/4/5.
 */
public interface ApiManagerService {
    @GET("LFHAPI/clientapi.ashx?action=99998")
    Observable<ApiResponse<Version>> getData(@Query("page") int query);

//    @GET("search")
//    Observable<List<ZhuangbiImage>> search(@Query("q") String query);

}
