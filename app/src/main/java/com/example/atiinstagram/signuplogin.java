package com.example.atiinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class signuplogin extends AppCompatActivity {
    private EditText edt1username,edt2username,edt1password,edt2password;
    private Button btnsignup,btnlogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_login);
        edt1username=findViewById(R.id.edt1username);
        edt2username=findViewById(R.id.edt2username);
        edt1password=findViewById(R.id.edt1password);
        edt2password=findViewById(R.id.edt2password);
        btnsignup=findViewById(R.id.btnsignup);
        btnlogin=findViewById(R.id.btnlogin);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser appuser=new ParseUser();
                appuser.setUsername(edt1username.getText().toString());
                appuser.setPassword(edt1password.getText().toString());
                appuser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            FancyToast.makeText(signuplogin.this, "Signed Up Succesull  !", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                            Intent intent=new Intent(signuplogin.this,Welcome.class);
                            startActivity(intent);
                        }else {
                            FancyToast.makeText(signuplogin.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
ParseUser.logInInBackground(edt2username.getText().toString(), edt2password.getText().toString(), new LogInCallback() {
    @Override
    public void done(ParseUser user, ParseException e) {
        if (user !=null && e==null){
            FancyToast.makeText(signuplogin.this, "Login sucessfull   !", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
            Intent intent=new Intent(signuplogin.this,Welcome.class);
            startActivity(intent);
        }else {
            FancyToast.makeText(signuplogin.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }
});
            }
        });
    }
}