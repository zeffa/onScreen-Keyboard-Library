package com.zeffah.mvpimpl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zeffah.mvpimpl.presenter.login.ILoginPresenter;
import com.zeffah.mvpimpl.presenter.login.LoginPresenter;
import com.zeffah.mvpimpl.views.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private EditText edtEmail, edtPassword;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btn_login);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(btnClickListener);
    }

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginPresenter.onLogin(edtEmail.getText().toString().trim(), edtPassword.getText().toString().trim());
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String errorMessage) {
        Toast.makeText(this, "" + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
