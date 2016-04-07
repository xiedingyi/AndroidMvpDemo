//package com.norman.demo.listener;
//
//import android.support.annotation.Nullable;
//
//import com.lzy.okhttputils.callback.BeanCallBack;
//import com.lzy.okhttputils.request.BaseRequest;
//
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// * 多种回调函数
// * @param <T>
// */
//public abstract class MyBeanCallBack<T> extends BeanCallBack<T> {
//
//    @Override
//    public T parseNetworkResponse(Response response) throws Exception {
//        System.out.println("parseNetworkResponse");
//        return super.parseNetworkResponse(response);
//    }
//
//    @Override
//    public void onAfter(@Nullable T t, Request request, Response response, @Nullable Exception e) {
//        System.out.println("onAfter");
//    }
//
//    @Override
//    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//        System.out.println("upProgress -- " + totalSize + "  " + currentSize + "  " + progress + "  " + networkSpeed);
//    }
//
//    @Override
//    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//        System.out.println("downloadProgress -- " + totalSize + "  " + currentSize + "  " + progress + "  " + networkSpeed);
//    }
//
//    @Override
//    public void onError(Request request, @Nullable Response response, @Nullable Exception e) {
//        System.out.println("onError");
//        super.onError(request, response, e);
//    }
//
//    @Override
//    public void onBefore(BaseRequest request) {
//        System.out.println("onBefore");
//    }
//}
