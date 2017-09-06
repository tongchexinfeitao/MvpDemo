package com.example.mvpdemo.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.example.mvpdemo.model.LoginModel;
import com.example.mvpdemo.model.RegisterModel;
import com.example.mvpdemo.model.bean.LoginDataBean;
import com.example.mvpdemo.model.bean.RegisterDataBean;
import com.example.mvpdemo.view.IView.IRegisterAndLoginView;

/**
 * Created by hasee on 2017/9/5.
 */


//处理逻辑
public class RegisterAndLoginPresenter extends BasePresenter<IRegisterAndLoginView> {

    //model  包含一个专门去请求数据的model,具体的请求操作,让model去做
    private RegisterModel registerModel;
    private LoginModel loginModel;


    //在构造器中拿到actiivty传给我的接口, 当有结果的时候我利用这个接口通知activity
    public RegisterAndLoginPresenter(IRegisterAndLoginView iRegisterView) {
        super(iRegisterView);
    }

    @Override
    protected void initModel() {
        registerModel = new RegisterModel();
        loginModel = new LoginModel();
    }

    //去注册 ,只处理逻辑,具体的联网操作让model去做
    public void register() {
        registerModel.register(new RegisterModel.DataCallBack<RegisterDataBean>() {
            @Override
            public void onGetDataSucced(RegisterDataBean dataBean) {

                //// TODO: 2017/9/5  注册成功后在activity中跳转到别的页面  (与界面更新有关的操作,放到view层)


                // view的刷新不应该放在这里,只是为了使用一下context,
                ((Activity) context()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context(), "我拿到父类的环境变量", Toast.LENGTH_LONG).show();
                    }
                });

                //利用acitivity传过来的接口去通知acitity刷新页面

                iView.onRegisterSucced(dataBean);
            }

            @Override
            public void onGetDataFail(String exception) {
                iView.onRegisterFaild(exception);
            }
        });
    }

    public void login() {
        loginModel.login(new LoginModel.DataCallBack<LoginDataBean>() {

            @Override
            public void onGetDataSucced(LoginDataBean loginDataBean) {
                iView.onLoginSucced(loginDataBean);
            }

            @Override
            public void onGetDataFail(String exception) {
                iView.onLoginFaild(exception);
            }
        });
    }
}
