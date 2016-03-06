package com.tfg.dani.tfg.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by dani on 31/10/15.
 */
public class BasePresenter<S extends BaseViewInterface>{

    private S mBaseView;

    public void onError(String error) {

    }

    public S getView() {
        return mBaseView;
    }

    public void setView(S view) {
        mBaseView = view;
    }
}
