package com.example.englishforhotwlmanagement;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ReceptionWork extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception_work);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" English for Hotel ");
        toolbar.setTitleTextColor(getResources().getColor(R.color.yello));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView=(ListView)findViewById(R.id.simpleListView);


        dataModels= new ArrayList<>();
        dataModels.add(new DataModel("do you have reservation?", "তোমার কি রিজার্ভেশন আছে?"));
        dataModels.add(new DataModel("How long will you be  staying ?", "কতক্ষণ থাকবেন?"));
        dataModels.add(new DataModel("Could I see your ID,please ?", "আমি আপনার আইডি দেখতে পারে,দয়া করে?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        dataModels.add(new DataModel("Could you please fill out this form?","আপনি কি এই ফর্মটি পূরণ করতে পারেন?"));
        adapter= new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
