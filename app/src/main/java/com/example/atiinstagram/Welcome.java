package com.example.atiinstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Welcome extends AppCompatActivity {
private TextView txtwelcome;
private Button btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtwelcome=findViewById(R.id.txtwelcome);
        btnlogout=findViewById(R.id.btnlogout);
        txtwelcome.setText("Welcome  "+ ParseUser.getCurrentUser().get("username"));
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                finish();
                FancyToast.makeText(Welcome.this, "Logged out sucessfully  !", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
            }
        });
    }
}
