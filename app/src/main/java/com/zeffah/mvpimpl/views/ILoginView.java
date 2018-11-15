package com.zeffah.mvpimpl.views;

public interface ILoginView {
    void onLoginSuccess(String message);
    void onLoginError(String errorMessage);
}
