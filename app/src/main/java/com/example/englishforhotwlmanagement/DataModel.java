package com.example.englishforhotwlmanagement;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class DataModel {

    String englishText;
    String banglaText;


    public DataModel(String englishText, String banglaText) {
        this.englishText=englishText;
        this.banglaText=banglaText;

    }

    public String getEnglishText() {
        return englishText;
    }


    public String getBanglaText() {
        return banglaText;
    }


}
