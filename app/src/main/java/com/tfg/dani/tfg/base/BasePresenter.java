package com.tfg.dani.tfg.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by dani on 31/10/15.
 */
public class BasePresenter<S extends BaseViewInterface> extends MvpBasePresenter<S> implements BasePresenterInterface{

    @Override
    public void onError(String error) {

    }
}
