package com.example.mvpdemo.presenter;

import android.content.Context;

import com.example.mvpdemo.app.MyAppcation;
import com.example.mvpdemo.view.IView.IView;

/**
 * Created by hasee on 2017/9/6.
 */

//BasePresenter是所有的presenter的父类,他具有的行为,子类都可能具有
public abstract class BasePresenter<T extends IView> {

    // T 通知view刷新的接口
    protected T iView;

    public BasePresenter(T iView) {
        this.iView = iView;
        initModel();
    }

    protected abstract void initModel();

    //如果接口提供的环境变量为null的话, 就返回application环境变量
    Context context() {
        if (iView != null && iView.context() != null) {
            return iView.context();
        }
        return MyAppcation.appContext();
    }
}
