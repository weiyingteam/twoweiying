package com.example.zdm.weiyingdemo.presenter;

import com.example.zdm.weiyingdemo.model.bean.SelectBean;
import com.example.zdm.weiyingdemo.model.http.SelecTionModle;
import com.example.zdm.weiyingdemo.view.interfaces.SelecteinterfacesV;

public class SelectePresenter extends BasePresenter implements SelecteinterfacesP {


    private SelecteinterfacesV selecTionInterV;
    private SelecTionModle selecTionModle;

    public SelectePresenter(SelecteinterfacesV selecTionInterV) {
        this.selecTionInterV = selecTionInterV;
    }
    public void toM(){
        if(selecTionModle==null){
            selecTionModle = new SelecTionModle(this);
        }
        selecTionModle.backP();

    }

    @Override
    public void selectioninterp(SelectBean.RetBean p) {
        selecTionInterV.selectioninterv(p,true);
    }

    @Override
    public void errow(SelectBean.RetBean p) {
        selecTionInterV.selectioninterv(p,false);
    }
}
