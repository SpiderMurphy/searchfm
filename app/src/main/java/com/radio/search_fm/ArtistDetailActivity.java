package com.radio.search_fm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.models.ArtistDetailRepository;
import com.radio.search_fm.models.ArtistRepository;
import com.radio.search_fm.presenter.PresenterArtistDetail;
import com.radio.search_fm.views.ViewArtistDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistDetailActivity extends AppCompatActivity implements ViewArtistDetail {
    private PresenterArtistDetail mPresenter;

    @BindView(R.id.artistImage)
    ImageView mArtistCover;

    @BindView(R.id.artistDetails)
    RecyclerView mRwDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        ButterKnife.bind(this);

        mPresenter = new PresenterArtistDetail(this, new ArtistDetailRepository(this));
        mPresenter.getArtistInfo(getIntent().getStringExtra(ArtistRepository.ARTIST_NAME), this::onArtistDetailReceived);
    }

    @Override
    public void onArtistDetailReceived(Artist artist) {
        if(artist == null) return;

        if(artist.getImage().size() > 2)
            Glide.with(this).load(artist.getImage().get(2).getUrl()).into(mArtistCover);
    }
}
