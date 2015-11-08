package com.tfg.dani.tfg.base;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by dani on 31/10/15.
 */
public interface BaseViewInterface extends MvpView{

    void showLoading();
    void hideLoading();
}
