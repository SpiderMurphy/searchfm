package com.radio.search_fm.modules;

import android.app.Application;

import com.radio.search_fm.network.RestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {
    @Provides
    @Singleton
    public RestClient provideRestClient(Application application) {
        return RestClient.getInstance(application);
    }
}
