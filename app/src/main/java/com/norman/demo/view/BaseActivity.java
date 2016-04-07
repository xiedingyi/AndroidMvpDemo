package com.norman.demo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.norman.demo.utils.AppManager;

public abstract class BaseActivity extends Activity {
	protected Activity context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		AppManager.getAppManager().addActivity(context);
//		initControl();
//		initView();
//		initData();
//		setListener();
	}



//	/**
//	 * 顶部操作
//	 * @param leftStr 左标题名称
//	 * @param leftBool 是否显示 true 显示 false 隐藏
//	 * @param leftBackBool  是否显示 true 显示 false 隐藏
//	 * @param str 主标题名称
//	 * @param rightBackBool 是否显示 true 显示 false 隐藏
//	 * @param rightStr 右标题名称
//	 * @param rightBool 左标题名称
//	 */
//	public void changeTitle(String leftStr,Boolean leftBool,Boolean leftBackBool,String str,Boolean rightBackBool,String rightStr,Boolean rightBool){
//		TextView tvLeft =(TextView) findViewById(R.id.title_txt_left);//左标题
//		tvLeft.setText(leftStr);
//		if(leftBool){
//			tvLeft.setVisibility(View.VISIBLE);//显示
//		}else{
//			tvLeft.setVisibility(View.GONE);//隐藏
//		}
//
//		ImageView ivLeft =(ImageView) findViewById(R.id.title_img_back);//左标题图片
//		if(leftBackBool){
//			ivLeft.setVisibility(View.VISIBLE);//显示
//		}else{
//			ivLeft.setVisibility(View.GONE);//隐藏
//		}
//
//		TextView tv =(TextView) findViewById(R.id.title_txt_title);//标题
//		tv.setText(str);
//
//		TextView tvRight =(TextView) findViewById(R.id.title_txt_right);//右标题
//		tvRight.setText(rightStr);
//		if(rightBool){
//			tvRight.setVisibility(View.VISIBLE);//显示
//		}else{
//			tvRight.setVisibility(View.GONE);//隐藏
//		}
//
//		ImageView ivRight =(ImageView) findViewById(R.id.title_img_right);//右标题图片
//		if(rightBackBool){
//			ivRight.setVisibility(View.VISIBLE);//显示
//		}else{
//			ivRight.setVisibility(View.GONE);//隐藏
//		}
//	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	public void onPause() {
		super.onPause();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AppManager.getAppManager().finishActivity(this);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

//	/**
//	 * 绑定控件id
//	 */
//	protected abstract void initControl();
//
//	/**
//	 * 初始化控件
//	 */
//	protected abstract void initView();
//
//	/**
//	 * 初始化数据
//	 */
//	protected abstract void initData();
//
//	/**
//	 * 设置监听
//	 */
//	protected abstract void setListener();

	/**
	 * 打开 Activity
	 *
	 * @param cls
	 * @param
	 */
	public void start_Activity( Class<?> cls) {
		Intent inent = new Intent();
		inent.setClass(this,cls);
		startActivity(inent);
	}

	/**
	 * 通过类名启动Activity，并且含有Bundle数据
	 *
	 * @param pClass
	 * @param pBundle
	 */
	protected void start_Activity(Class<?> pClass, Bundle pBundle) {
		Intent intent = new Intent(this, pClass);
		if (pBundle != null) {
			intent.putExtras(pBundle);
		}
		startActivity(intent);
	}

	/**
	 * 关闭 Activity
	 *
	 * @param activity
	 */
	public static void finish(Activity activity) {
		AppManager.getAppManager().finishActivity(activity);
	}
}