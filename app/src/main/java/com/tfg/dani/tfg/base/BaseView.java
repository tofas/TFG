package com.tfg.dani.tfg.base;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by dani on 31/10/15.
 */
public class BaseView extends MvpFragment<BaseView, BasePresenter> implements BaseViewInterface{

    @Override
    public BasePresenter createPresenter() {
        return new BasePresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
