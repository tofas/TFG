package com.tfg.dani.tfg.core.base;

/**
 * Created by dani on 31/10/15.
 */
public interface BaseViewInterface {

    enum TypeSnackbar {
        TYPE_POSITIVE, TYPE_ERROR
    }

    void showLoading();
    void hideLoading();

    void setFragmentContent(int layoutId);

    void showSnackbar(String displayName, TypeSnackbar TYPE);
}
