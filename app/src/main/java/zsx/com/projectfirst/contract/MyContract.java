package zsx.com.projectfirst.contract;

import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

import zsx.com.projectfirst.model.MyModel;


public interface MyContract {
    abstract  class MyPresenter extends BasePresenter<MyModel,MyView>{
        public MyModel getModel(){

            return new zsx.com.projectfirst.model.MyModel();
        }
        public abstract void Login(HashMap<String,String> params);
        public abstract void Reg(HashMap<String,String> params);
    }
    interface MyModel extends IBaseModel{
        void Login(HashMap<String,String> params, OkhttpCallback callback);
        void Reg(HashMap<String,String> params, OkhttpCallback callback);
    }

    interface  MyView extends IBaseView{
        void onFile(String s);
        void onSuccess(String msg);
    }
}
