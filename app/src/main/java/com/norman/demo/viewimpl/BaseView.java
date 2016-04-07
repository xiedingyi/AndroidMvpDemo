package com.norman.demo.viewimpl;

/**
 *  通用 View接口基类
 */
public interface BaseView<T> {

    /**
     * 显示进度条
     */
    void showProgress();

    /**
     * 隐藏进度条
     */
    void hideProgress();

    /**
     * 数据操作成功
     * @param str 返回提示语
     */
    void onSuccess(T str);

    /**
     * 数据操作失败
     * @param Str 返回提示语
     */
    void onFailed(String Str);
}
