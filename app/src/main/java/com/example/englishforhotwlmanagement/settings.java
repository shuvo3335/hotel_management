package com.example.englishforhotwlmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {
TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window g =getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);

        setContentView(R.layout.settings_activity);


        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);


        textView4=findViewById(R.id.text4);
        textView5=findViewById(R.id.text5);
        textView6=findViewById(R.id.text6);
        textView7=findViewById(R.id.text7);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text1=new Intent(settings.this,home.class);
                startActivity(text1);
            }
        });

       textView2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent text3=new Intent(settings.this, profile_set.class);
               startActivity(text3);
           }
       });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text3=new Intent(settings.this, profile_set.class);
                startActivity(text3);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text4=new Intent(settings.this,progress.class);
                startActivity(text4);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text5=new Intent(settings.this,about.class);
                startActivity(text5);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text6=new Intent(settings.this,rating.class);
                startActivity(text6);
            }
        });  textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent text7=new Intent(settings.this,logout.class);
                startActivity(text7);
            }
        });

    }
}
