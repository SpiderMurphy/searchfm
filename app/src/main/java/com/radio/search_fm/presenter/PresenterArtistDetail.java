package com.radio.search_fm.presenter;

import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.models.ArtistRepository;
import com.radio.search_fm.models.Repository;
import com.radio.search_fm.views.ViewArtistDetail;

import java.util.HashMap;
import java.util.Map;

public class PresenterArtistDetail {
    private Repository<Artist> mRepository;
    private ViewArtistDetail mView;

    public PresenterArtistDetail(ViewArtistDetail view, Repository<Artist> repository) {
        this.mView = view;
        this.mRepository = repository;
    }

    public void getArtistInfo(String name){
        Map<String, String> criteria = new HashMap<>();
        criteria.put(ArtistRepository.ARTIST_NAME, name);

        mRepository.querySingle(criteria, mView::onArtistDetailReceived);
    }
}
