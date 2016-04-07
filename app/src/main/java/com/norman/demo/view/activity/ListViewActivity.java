package com.norman.demo.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.norman.demo.R;
import com.norman.demo.adapter.ListAdapter;
import com.norman.demo.entity.Version;
import com.norman.demo.presenter.VersionListPresenter;
import com.norman.demo.presenter.impl.VersionLisetPresenterImpl;
import com.norman.demo.utils.T;
import com.norman.demo.view.BaseActivity;
import com.norman.demo.viewimpl.BaseView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class ListViewActivity extends BaseActivity implements BaseView<List<Version>>{

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccess(List<Version> str) {

//        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText("Loading");
//        pDialog.setCancelable(false);
//        pDialog.show();

        if (str != null && !str.isEmpty()) {
            if (page == 1) { // 第一页
                listAd.setItems(str);
            } else { // 分页数据
                listAd.addItems(str);
            }
        }else if(str == null){
            T.showLong(getApplicationContext(),"已经是最后一页");
        }
        dicoverLvList.onRefreshComplete();
    }

    @Override
    public void onFailed(String Str) {

    }

    @Bind(R.id.dicover_lv_list)
    PullToRefreshListView dicoverLvList;
    ListAdapter listAd ;
    int page = 1;
    int maxPage = 0;
    VersionListPresenter vp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plistview);
        ButterKnife.bind(this);

        vp = new VersionLisetPresenterImpl(this);

        listAd = new ListAdapter(this);
        dicoverLvList.setAdapter(listAd);

        dicoverLvList.setMode(PullToRefreshBase.Mode.BOTH);

        // 下拉刷新时的提示文本设置
        dicoverLvList.getLoadingLayoutProxy(true, false).setLastUpdatedLabel("");
        dicoverLvList.getLoadingLayoutProxy(true, false).setPullLabel("");//刚下拉时，显示的提示
        dicoverLvList.getLoadingLayoutProxy(true, false).setRefreshingLabel("正在刷新");//刷新时
        dicoverLvList.getLoadingLayoutProxy(true, false).setReleaseLabel("松手可刷新");//下来达到一定距离时，显示的提示
        // 上拉加载更多时的提示文本设置
        dicoverLvList.getLoadingLayoutProxy(false, true).setLastUpdatedLabel("");
        dicoverLvList.getLoadingLayoutProxy(false, true).setPullLabel("");
        dicoverLvList.getLoadingLayoutProxy(false, true).setRefreshingLabel("正在加载...");
        dicoverLvList.getLoadingLayoutProxy(false, true).setReleaseLabel("放开以加载");

        vp.getData(1);

        dicoverLvList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                Log.i("MyOrder", "下啦");

                page = 1;
                vp.getData(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                Log.i("MyOrder", "上啦" + page);
                page++;
                vp.getData(page);
            }
        });


//        dicoverLvList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
//            @Override
//            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
//                if (refreshView.isHeaderShown()) {//下拉刷新
//                    Log.i("MyOrder", "下啦");
//                    page = 1;
//                    vp.getData(1);
//                } else {//上拉加载
//                    Log.i("MyOrder", "上啦" + page);
//                    page++;
//                    if(maxPage >= page){
//                        vp.getData(page);
//                    }else {
//                       // dicoverLvList.onRefreshComplete();
//                        refreshView.onRefreshComplete();
//                        T.showLong(ListViewActivity.this, "已到底部");
//                    }
//
//                }
//            }
//        });


    }
}
