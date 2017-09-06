package com.example.mvpdemo.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.bean.LoginDataBean;
import com.example.mvpdemo.model.bean.RegisterDataBean;
import com.example.mvpdemo.presenter.RegisterAndLoginPresenter;
import com.example.mvpdemo.view.IView.IRegisterAndLoginView;


//处理view    只关心结果,结果出来之后通知我刷新页面 ,所以需要传一个接口给通知我的类
public class RegisterAndLoginActivity extends AppCompatActivity implements IRegisterAndLoginView {

    private RegisterAndLoginPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Presenter的构造器中可以传接口给presenter
        registerPresenter = new RegisterAndLoginPresenter(this);
    }

    //点击事件
    public void register(View view) {
        registerPresenter.register();
    }

    public void login(View view) {
        registerPresenter.login();
    }

    //成功的回调
    @Override
    public void onRegisterSucced(RegisterDataBean dataBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterAndLoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRegisterFaild(String exception) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterAndLoginActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onLoginSucced(LoginDataBean dataBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterAndLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onLoginFaild(String exception) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterAndLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public Context context() {
        return this;
    }


}
