package com.example.atiinstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1;
    private EditText ed1;
    private EditText ed2;
private TextView txt1;
private Button btngetdata;
private String allkickbixer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.bt1);
        bt1.setOnClickListener(MainActivity.this);
        ed1=findViewById(R.id.edt1);
        ed2=findViewById(R.id.edt2);
        txt1=findViewById(R.id.txt1);
        btngetdata=findViewById(R.id.btngetdata);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parseQuery=ParseQuery.getQuery("Kickboxer");
                parseQuery.getInBackground("w3GbQ2VQ4p", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if (object!=null && e==null){
                            txt1.setText(object.get("Name")+"-"+"Speed:"+ object.get("Punch_Speed"));
                        }
                    }
                });
            }
        });
        btngetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allkickbixer="";
                ParseQuery<ParseObject> queryall=ParseQuery.getQuery("Kickboxer");
                queryall.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e==null){
                            if (objects.size()>0){
                                for (ParseObject kickboxer:objects){
                                    allkickbixer=allkickbixer+kickboxer.get("Name") +"\n";
                                }
                                FancyToast.makeText(MainActivity.this, allkickbixer, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                            }else {
                                FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                            }
                        }
                    }
                });
            }
        });
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
