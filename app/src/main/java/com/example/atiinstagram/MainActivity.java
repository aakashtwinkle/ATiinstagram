package com.example.atiinstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1;
    private EditText ed1;
    private EditText ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.bt1);
        bt1.setOnClickListener(MainActivity.this);
        ed1=findViewById(R.id.edt1);
        ed2=findViewById(R.id.edt2);
    }

    @Override
    public void onClick(View v) {
        try {
            final ParseObject kickboxer = new ParseObject("Kickboxer");
            kickboxer.put("Name", ed1.getText().toString());
            kickboxer.put("Punch_Speed", ed2.getText().toString());
            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        //Toast.makeText(MainActivity.this,kickboxer.get("Name")+"saved sucsessfull",Toast.LENGTH_LONG).show();
                        FancyToast.makeText(MainActivity.this, "Saved  !", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                    } else {
                        FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        // Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }

            });
        }catch (Exception e){
            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }
    // public void helloworld(View view){
     //   ParseObject boxer=new ParseObject("Boxer");
       // boxer.put("punch_speed",200);
        //boxer.saveInBackground(new SaveCallback() {
          //  @Override
            //public void done(ParseException e) {
              //  if (e==null){
                    //Toast.makeText(MainActivity.this,"boxer object is sucsesfull",Toast.LENGTH_LONG).show();
                //}
            //}
        //});

    //}
}
