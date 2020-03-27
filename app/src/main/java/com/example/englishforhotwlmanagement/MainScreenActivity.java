package com.example.englishforhotwlmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainScreenActivity extends AppCompatActivity {

    ImageView imageView,imageView2;

    Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle(" English for Hotel ");
        toolbar1.setTitleTextColor(getResources().getColor(R.color.yello));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.recept);
        imageView2 = findViewById(R.id.invt);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this,ReceptionWork.class);
                startActivity(intent);
            }
        });
imageView2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intv = new Intent(MainScreenActivity.this,QuizActivity.class);
        startActivity(intv);
    }
});

    }


}
