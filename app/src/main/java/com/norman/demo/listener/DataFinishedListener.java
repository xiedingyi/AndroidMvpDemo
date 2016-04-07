package com.norman.demo.listener;

/**
 * Manager响应结果的封装类
 */
public interface DataFinishedListener<T> {
    void onSuccess(T t);

    void onFailed();
}
