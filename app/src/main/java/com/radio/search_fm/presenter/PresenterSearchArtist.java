package com.radio.search_fm.presenter;

import android.util.Log;

import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.models.ArtistRepository;
import com.radio.search_fm.models.Repository;
import com.radio.search_fm.views.ViewSearchActivity;

import java.util.HashMap;
import java.util.Map;

public class PresenterSearchArtist {
    private ViewSearchActivity mView;
    private Repository<Artist> mRepository;

    public PresenterSearchArtist(ViewSearchActivity view, Repository<Artist> repository) {
        this.mView = view;
        this.mRepository = repository;
    }

    public void searchArtistByName(String name, Repository.QueryResult<Artist> resultCallback){
        Map<String, String> criteria = new HashMap<>();
        criteria.put(ArtistRepository.ARTIST_NAME, name);

        mRepository.query(criteria, resultCallback);
    }
}
