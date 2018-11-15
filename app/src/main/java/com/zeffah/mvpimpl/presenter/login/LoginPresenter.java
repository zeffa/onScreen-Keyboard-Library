package com.zeffah.mvpimpl.presenter.login;

import com.zeffah.mvpimpl.models.dao.User;
import com.zeffah.mvpimpl.views.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.loginSuccessCode();
        String message;
        boolean isError;
        switch (loginCode){
            case User.ERROR_EMPTY_FIELDS:
                message = "Empty email or password";
                isError = true;
                break;
            case User.ERROR_SHORT_PASSWORD:
                message = "Password must be longer than 5";
                isError = true;
                break;
            case User.ERROR_WRONG_EMAIL:
                message = "Invalid Email Address";
                isError = true;
                break;
            default:
                message = "Login success";
                isError = false;
                break;
        }
        if (isError) {
            loginView.onLoginError(message);
        } else {
            loginView.onLoginSuccess(message);
        }
    }
}
