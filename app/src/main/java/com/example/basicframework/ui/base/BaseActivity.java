package com.example.basicframework.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements Callback.CommonCallback<String> {
    public Context mContext;
    Unbinder unbinder;
    /***是否显示标题栏*/
    private  boolean isshowtitle = true;
    /***是否显示标题栏*/
//    private  boolean isshowstate = true;
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    public void loadData(String path){
        RequestParams params = new RequestParams(path);
        x.http().get(params,this);

    }
    protected final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if(!isshowtitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

//        if(isshowstate){
//            getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
//                    WindowManager.LayoutParams. FLAG_FULLSCREEN);
//        }
        //设置布局
        setContentView(intiLayout());
        unbinder = ButterKnife.bind(this);

        //初始化控件
        initView();
        //设置数据
        initData();
        //设置监听
        initListener();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int intiLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();
    /**
     * 设置监听
     */
    public abstract void initListener();

    /**
     * 是否设置标题栏
     *
     * @return
     */
    public void setTitle(boolean ishow) {
        isshowtitle=ishow;
    }

    /**
     * 设置是否显示状态栏
     * @param ishow
     */
    public void setState(boolean ishow) {
//        isshowstate=ishow;
    }

    /**
     * 显示长toast
     * @param msg
     */
    public void toastLong(String msg){
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    /**
     * 显示短toast
     * @param msg
     */
    public void toastShort(String msg){
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }
    private void unbinder() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder();
    }


    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
