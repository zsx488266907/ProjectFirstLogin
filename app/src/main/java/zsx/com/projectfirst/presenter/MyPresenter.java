package zsx.com.projectfirst.presenter;

import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

import zsx.com.projectfirst.contract.MyContract;

public class MyPresenter extends MyContract.MyPresenter {
    @Override
    public void Login(HashMap<String, String> params) {
        model.Login(params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                view.onFile("铁子,不行啊啊啊啊");
            }

            @Override
            public void success(String result) {
                view.onSuccess(result);
            }
        });
    }

    @Override
    public void Reg(HashMap<String, String> params) {
              model.Reg(params, new OkhttpCallback() {
                  @Override
                  public void failure(String msg) {
                      view.onFile("铁子,不行啊啊啊啊");
                  }

                  @Override
                  public void success(String result) {
                    view.onSuccess(result);
                  }
              });
    }
}
