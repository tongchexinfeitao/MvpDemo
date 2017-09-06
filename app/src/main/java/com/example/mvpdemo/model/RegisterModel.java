package com.example.mvpdemo.model;

import android.support.annotation.NonNull;

import com.example.mvpdemo.model.bean.RegisterDataBean;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hasee on 2017/9/5.
 */


//处理数据,数据返回之后,通过接口通知presenter
public class RegisterModel{
    public RegisterModel() {
    }

    //注册的方法
    public void register(@NonNull final DataCallBack<RegisterDataBean> dataCallBack) {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.baidu.com");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 302) {

                        //// TODO: 2017/9/5 拿到输入流 转化成json,再通过gson转化成bean
                        RegisterDataBean dataBean = new RegisterDataBean("注册成功了");
                        dataCallBack.onGetDataSucced(dataBean);
                    } else {
                        //// TODO: 2017/9/5  注册失败  在activity中提示用户那里失败 (与界面更新有关的操作,放到view层)

                        String responseMessage = httpURLConnection.getResponseMessage();
                        dataCallBack.onGetDataFail(responseMessage);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }



    //数据回调接口, 成功之后,把相应的结果类型传给presenter, 这个相应的类型就是我们json生成的bean
    public interface DataCallBack<T> {
        void onGetDataSucced(T t);

        void onGetDataFail(String exception);
    }

}
