package zsx.com.projectfirst;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import zsx.com.projectfirst.bean.UserBean;
import zsx.com.projectfirst.contract.MyContract;
import zsx.com.projectfirst.presenter.MyPresenter;


public class LoginActivity extends BaseMvpActivity<MyContract.MyModel,MyContract.MyPresenter> implements MyContract.MyView {
    @BindView(R.id.edit_login)
    EditText edit_login;
    @BindView(R.id.edit_password)
    EditText edit_password;
    @BindView(R.id.btn_login)
    Button button;
    @BindView(R.id.rem_pass)
    CheckBox checkBox;
    @BindView(R.id.fast_reg)
    TextView textView;



    @Override
    protected void initView() {
     initData();
     textView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(LoginActivity.this,RegActivity.class);
             startActivityForResult(intent,1000);
         }
     });

     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
           //  String phone = edit_login.getText().toString();
           //  String pwd = edit_password.getText().toString();
             String phone="13777777777";
             String pwd ="123456";
             HashMap<String,String> params = new HashMap<>();
             params.put("phone",phone);
             params.put("pwd",pwd);
             presenter.Login(params);
         }
     });

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void onFile(String s) {

    }

    @Override
    public void onSuccess(String msg) {
        UserBean userBean = new Gson().fromJson(msg, UserBean.class);
         showToast(userBean.message);
        if (userBean.message.equals("登录成功")){
            Intent intent = new Intent(LoginActivity.this,ProductActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public BasePresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000&&resultCode==2000){

            String phone = data.getStringExtra("phone");
            String pwd = data.getStringExtra("pwd");
            showToast(pwd+"");
            edit_login.setText(phone);
            edit_password.setText(pwd);

        }
    }
}
