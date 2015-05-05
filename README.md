先上图片：
![效果](https://github.com/01100044093/StateView/blob/master/8.gif)

用法：
首先在主页面初始化下列信息
	
	  MultiConfigure.setEmptyViewResId(R.layout.welcome); //空页面
        MultiConfigure.setErrorViewResId(R.layout.error); //错误页面
        MultiConfigure.setLoadingViewResId(R.layout.loding); //加载页面
        MultiConfigure.setViewState(MultiConfigure.LOADING_VIEW); //初始页面状态
        //如果不写初始页面状态，默认为加载页面
	
然后在布局中嵌套使用
	
	<czh.stateviewlib.MultiStateView
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:id="@+id/stateview" >

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="页面加载完成"
                android:id="@+id/textView10" />
            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="emplay"
                android:text="空页面"
                />
            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="error"
                android:text="失败页面"
                 />
        </LinearLayout>

    </czh.stateviewlib.MultiStateView>

有如下2种方法可以在页面中调用：

	 setViewState(ViewState state)；
	 getViewState()；

使用方法：
	
	  multiStateView=(MultiStateView)findViewById(R.id.stateview);
	  //服务器请求完数据后调用页面切换回来。
      multiStateView.setViewState(MultiStateView.ViewState.CONTENT);
切换状态说明：
	
	MultiStateView.ViewState.CONTENT； //主页面
	MultiStateView.ViewState.EMPTY； //空页面
	MultiStateView.ViewState.ERROR； //错误页面
	MultiStateView.ViewState.LOADING； //加载页面
	
初始配置状态说明：

	MultiConfigure.LOADING_VIEW

	public static final int CONTENT_VIEW = 0; //初始打开为主页面

    public static final int ERROR_VIEW = 1; //错误页面

    public static final int EMPTY_VIEW = 2; //空页面

    public static final int LOADING_VIEW = 3; //加载页面

说明：
 直接下载LIB包导入就可以使用，空页面是做预留作用，以防有加载和错误状态外的页面状态使用。


另外：
为了实现小人奔跑效果，另附上自己写的一个小控件。

	<czh.stateviewlib.LodingView
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:layout_marginTop="50dp"
        android:background="@drawable/loding"
        android:id="@+id/view"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true" />

直接设置背景图片，就会自动循环播放背景图片的动画。
图片动画文件：

	<?xml version="1.0" encoding="utf-8"?>
	<animation-list xmlns:android="http://schemas.android.com/apk/res/android" >
    <item android:drawable="@drawable/progress_loading_image_01" android:duration="200"/>
    <item android:drawable="@drawable/progress_loading_image_02" android:duration="200"/>
	</animation-list>  
