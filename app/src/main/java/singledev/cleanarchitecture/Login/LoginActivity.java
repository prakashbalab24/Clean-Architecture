package singledev.cleanarchitecture.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import singledev.cleanarchitecture.MainActivity;
import singledev.cleanarchitecture.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ProgressBar progressBar;
    private Button loginBut;
    private EditText usernameEt, passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = findViewById(R.id.progressBar);
        loginBut = findViewById(R.id.button);
        usernameEt = findViewById(R.id.editText);
        passwordEt = findViewById(R.id.editText2);

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un =usernameEt.getText().toString();
                String pw =passwordEt.getText().toString();
                new LoginPresenterImplementation(LoginActivity.this).validateLogin(un,pw);
            }
        });

    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dissmissProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loginSucess() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
