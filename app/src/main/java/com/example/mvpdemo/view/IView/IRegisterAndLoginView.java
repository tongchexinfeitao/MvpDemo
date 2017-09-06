package com.example.mvpdemo.view.IView;

import android.content.Context;

import com.example.mvpdemo.model.bean.LoginDataBean;
import com.example.mvpdemo.model.bean.RegisterDataBean;

/**
 * Created by hasee on 2017/9/5.
 */


//通知registerAcitity刷新页面的接口
public interface IRegisterAndLoginView  extends IView{

    void onRegisterSucced(RegisterDataBean dataBean);

    void onRegisterFaild(String exception);

    void onLoginSucced(LoginDataBean dataBean);

    void onLoginFaild(String exception);
}
