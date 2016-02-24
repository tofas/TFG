// Generated code from Butter Knife. Do not modify!
package com.tfg.dani.tfg.features.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginView$$ViewBinder<T extends com.tfg.dani.tfg.features.login.LoginView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492945, "method 'onLoginButtonClicked'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onLoginButtonClicked();
        }
      });
  }

  @Override public void unbind(T target) {
  }
}
