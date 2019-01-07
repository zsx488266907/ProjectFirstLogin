package zsx.com.projectfirst.model;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

import zsx.com.projectfirst.api.UserApi;
import zsx.com.projectfirst.contract.MyContract;

public class LoginModel implements MyContract.ILoginModel {


    @Override
    public void getLoginList(HashMap<String, String> params, final LoginModel.ILogintCallback callback) {
        OkhttpUtils.getInstance().doGet(UserApi.PRODUCT_API, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callback.failure(msg);
            }

            @Override
            public void success(String result) {
               callback.success(result);
            }
        });
    }

    public interface ILogintCallback {
        public void failure(String msg);

        public void success(String result);
    }
}
