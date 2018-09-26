package com.radio.search_fm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.radio.search_fm.views.ViewSearchActivity;

public class MainActivity extends AppCompatActivity implements ViewSearchActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
