package zsx.com.projectfirst.model;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

import zsx.com.projectfirst.api.UserApi;
import zsx.com.projectfirst.contract.MyContract;

public class MyModel implements MyContract.MyModel {

    @Override
    public void Login(HashMap<String, String> params, OkhttpCallback callback) {
        OkhttpUtils.getInstance().doPost(UserApi.USER_LPGIN,params,callback);
    }

    @Override
    public void Reg(HashMap<String, String> params, OkhttpCallback callback) {
        OkhttpUtils.getInstance().doPost(UserApi.USER_REG,params,callback);
    }
}
