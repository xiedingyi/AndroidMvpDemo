package com.norman.demo.manager;

import com.norman.demo.listener.DataFinishedListener;

/**
 * Created by Administrator on 2016/3/23.
 */
public interface VersionListManager {
    void getData(int page, final DataFinishedListener listener);
}
