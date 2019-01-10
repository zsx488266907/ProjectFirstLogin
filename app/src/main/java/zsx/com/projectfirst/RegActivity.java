package zsx.com.projectfirst;

import android.content.Intent;
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

public class RegActivity extends BaseMvpActivity<MyContract.MyModel,MyContract.MyPresenter> implements MyContract.MyView  {
    @BindView(R.id.reg_login)
    EditText edit_login;
    @BindView(R.id.reg_password)
    EditText edit_password;
    @BindView(R.id.btn_reg)
    Button button;
    @BindView(R.id.tx_login)
    TextView textView;
    private String name;
    private String password;


    @Override
    protected void initView() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> params=new HashMap<>();
                name = edit_login.getText().toString();
                password = edit_password.getText().toString();
                params.put("phone", name);
                params.put("pwd", password);
                presenter.Reg(params);
            }
        });
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_reg;
    }

    @Override
    public void onFile(String s) {

    }

    @Override
    public void onSuccess(String msg) {
        showToast(msg);
        UserBean userBean = new Gson().fromJson(msg, UserBean.class);
        showToast(userBean+"");
        Intent intent = new Intent();
        intent.putExtra("phone",name);
        intent.putExtra("pwd",password);
        setResult(2000,intent);
        finish();
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
}
