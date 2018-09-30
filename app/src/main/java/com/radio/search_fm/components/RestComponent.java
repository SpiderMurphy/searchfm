package com.radio.search_fm.components;

import com.radio.search_fm.models.ArtistDetailRepository;
import com.radio.search_fm.models.ArtistRepository;
import com.radio.search_fm.modules.ApplicationModule;
import com.radio.search_fm.modules.RestModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RestModule.class})
public interface RestComponent {
    void inject(ArtistRepository repository);
    void inject(ArtistDetailRepository repository);
}
