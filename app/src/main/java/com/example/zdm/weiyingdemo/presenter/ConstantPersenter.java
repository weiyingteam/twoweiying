package com.example.zdm.weiyingdemo.presenter;

import com.example.zdm.weiyingdemo.model.bean.ConstantBean;
import com.example.zdm.weiyingdemo.model.bean.VideoDateilsBean;
import com.example.zdm.weiyingdemo.model.mdata.ConstantData;
import com.example.zdm.weiyingdemo.model.mdata.VideoDetailsData;
import com.example.zdm.weiyingdemo.model.minterfaces.Constantinterface;
import com.example.zdm.weiyingdemo.model.minterfaces.VideoDetailsinterface;
import com.example.zdm.weiyingdemo.view.interfaces.IConstanView;
import com.example.zdm.weiyingdemo.view.interfaces.IVideoDetailsView;

public class ConstantPersenter extends BasePresenter<IConstanView<ConstantBean>> {


    private final ConstantData constantData;

    public ConstantPersenter() {
        constantData = new ConstantData();

    }

    public void  getDate(String uid) {
        constantData.getData(uid,new Constantinterface<ConstantBean>() {
            @Override
            public void onsucess(ConstantBean abBean) {
                getView().onsucess(abBean);
            }

            @Override
            public void erro() {

            }
        });

    }
}
