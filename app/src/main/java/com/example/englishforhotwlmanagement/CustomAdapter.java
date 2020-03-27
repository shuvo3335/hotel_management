package com.example.englishforhotwlmanagement;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


/**
 * Created by anupamchugh on 09/02/16.
 */
class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataSet;
    Context mContext;
    private TextToSpeech textToSpeech;
    // View lookup cache
    private static class ViewHolder {
        TextView txtEnglish;
        TextView txtBangla;
        Button playBtn;
    }



    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.reciption1, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.reciption1, parent, false);
            viewHolder.txtEnglish = (TextView) convertView.findViewById(R.id.textview);
            viewHolder.txtBangla = (TextView) convertView.findViewById(R.id.textview2);
            viewHolder.playBtn = (Button) convertView.findViewById(R.id.playbtn);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

      /*  Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;*/


        viewHolder.txtEnglish.setText(dataModel.getEnglishText());
        viewHolder.txtBangla.setText(dataModel.getBanglaText());
        viewHolder.playBtn.setOnClickListener(this);
        viewHolder.playBtn.setTag(position);
        // Return the completed view to render on screen


        viewHolder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataModel dataModel= dataSet.get(position);
                Toast.makeText(mContext, "TTS Initialization failed!"+dataModel.getEnglishText(), Toast.LENGTH_SHORT).show();
                int speechStatus = textToSpeech.speak(dataModel.getEnglishText(), TextToSpeech.QUEUE_FLUSH, null);

                if (speechStatus == TextToSpeech.ERROR) {
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
            }
        });

        textToSpeech = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                } else {
                    Toast.makeText(mContext, "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }


}
