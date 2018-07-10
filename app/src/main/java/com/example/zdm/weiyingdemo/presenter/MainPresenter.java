package com.example.zdm.weiyingdemo.presenter;

import com.example.zdm.weiyingdemo.model.bean.AbBean;
import com.example.zdm.weiyingdemo.model.mdata.TestData;
import com.example.zdm.weiyingdemo.model.minterfaces.Foundinterface;
import com.example.zdm.weiyingdemo.view.interfaces.IfoundView;

/**
 * author:Created by WeiWeiFeng on 2018/7/5.
 * -------------------------//┏┓　　　┏┓
 * -------------------------//┏┛┻━━━┛┻┓
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　━　　　┃
 * -------------------------//┃　┳┛　┗┳　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　┻　　　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┗━┓　　　┏━┛
 * -------------------------//┃　　　┃  神兽保佑
 * -------------------------//┃　　　┃  代码无BUG！
 * -------------------------//┃　　　┗━━━┓
 * -------------------------//┃　　　　　　　┣┓
 * -------------------------//┃　　　　　　　┏┛
 * -------------------------//┗┓┓┏━┳┓┏┛
 * -------------------------// ┃┫┫　┃┫┫
 * -------------------------// ┗┻┛　┗┻┛
 */
public class MainPresenter extends BasePresenter<IfoundView<AbBean>>{
    public MainPresenter() {
        TestData mTest = new TestData();
        mTest.getData(new Foundinterface<AbBean>() {
            @Override
            public void onsucess(AbBean abBean) {
                getView().onsucess(abBean);
            }

            @Override
            public void erro() {

            }
        });

    }
}
