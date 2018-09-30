package com.radio.search_fm;

import android.app.Application;

import com.radio.search_fm.components.DaggerRestComponent;
import com.radio.search_fm.components.RestComponent;
import com.radio.search_fm.modules.ApplicationModule;
import com.radio.search_fm.modules.RestModule;

public class SearchFm extends Application {
    private RestComponent mRestComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mRestComponent = DaggerRestComponent.builder()
                .restModule(new RestModule())
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public RestComponent getRestComponent() {
        return mRestComponent;
    }
}
