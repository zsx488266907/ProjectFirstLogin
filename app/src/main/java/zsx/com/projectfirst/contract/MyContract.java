package zsx.com.projectfirst.contract;

import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

import java.util.HashMap;

import zsx.com.projectfirst.model.LoginModel;

public interface MyContract  {
    public abstract class LoginPresenter extends BasePresenter<ILoginModel,ILoginView>{

        @Override
        public ILoginModel getModel() {
            return new LoginModel();
        }

        public abstract void getLoginList(HashMap<String, String> params);
    }

    public interface ILoginModel extends IBaseModel {

        void getLoginList(HashMap<String,String> params, LoginModel.ILogintCallback callback);

    }

    interface ILoginView extends IBaseView {

        void success(String result);
        void keywordsEmpty(String error);

    }


}
