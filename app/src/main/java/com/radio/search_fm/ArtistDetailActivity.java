package com.radio.search_fm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.radio.search_fm.models.ArtistDetailRepository;
import com.radio.search_fm.presenter.PresenterArtistDetail;
import com.radio.search_fm.views.ViewArtistDetail;

public class ArtistDetailActivity extends AppCompatActivity implements ViewArtistDetail {
    private PresenterArtistDetail mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        mPresenter = new PresenterArtistDetail(this, new ArtistDetailRepository(this));
    }
}
