package zsx.com.projectfirst.presenter;

import java.util.HashMap;

import zsx.com.projectfirst.contract.MyContract;
import zsx.com.projectfirst.model.LoginModel;

public class LoginPresenter extends MyContract.LoginPresenter {
    @Override
    public void getLoginList(HashMap<String, String> params) {
   model.getLoginList(params, new LoginModel.ILogintCallback() {
       @Override
       public void failure(String msg) {
           view.failure(msg);
       }

       @Override
       public void success(String result) {
               view.success(result);
       }
   });

    }
}
