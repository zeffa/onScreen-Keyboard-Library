package com.zeffah.mvpimpl.models.dao;

import android.text.TextUtils;
import android.util.Patterns;

import com.zeffah.mvpimpl.models.callback.IUser;

public class User implements IUser {
    public static final int LOGIN_SUCCESS = 0;
    public static final int ERROR_EMPTY_FIELDS = 1;
    public static final int ERROR_WRONG_EMAIL = 2;
    public static final int ERROR_SHORT_PASSWORD = 3;
    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Integer loginSuccessCode() {
        if (TextUtils.isEmpty(getEmail())){
            return ERROR_EMPTY_FIELDS;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            return ERROR_WRONG_EMAIL;
        }else if (getPassword().length() < 5) {
            return ERROR_SHORT_PASSWORD;
        }else {
            return LOGIN_SUCCESS;
        }
    }
}
