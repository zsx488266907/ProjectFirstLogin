package zsx.com.projectfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;

import butterknife.BindView;
import zsx.com.projectfirst.contract.MyContract;

public class MainActivity extends BaseMvpActivity<MyContract.ILoginModel,MyContract.LoginPresenter> implements MyContract.ILoginView{
@BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayoutId() {
        return 0;
    }

    @Override
    public void success(String result) {

    }

    @Override
    public void keywordsEmpty(String error) {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
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
