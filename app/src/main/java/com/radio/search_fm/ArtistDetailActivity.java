package com.radio.search_fm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

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

    @BindView(R.id.toolbarDetails)
    Toolbar toolbar;

    @BindView(R.id.content)
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        ButterKnife.bind(this);

        String artistName = getIntent().getStringExtra(ArtistRepository.ARTIST_NAME);

        toolbar.setTitle(artistName);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArtistDetailRepository artistDetailRepository = new ArtistDetailRepository(this);
        ((SearchFm)getApplication()).getRestComponent().inject(artistDetailRepository);

        mPresenter = new PresenterArtistDetail(this, artistDetailRepository);
        mPresenter.getArtistInfo(artistName, this::onArtistDetailReceived);
    }

    @Override
    public void onArtistDetailReceived(Artist artist) {
        if(artist == null) return;

        content.setText(Html.fromHtml(artist.getBio().getContent()));

        if(artist.getImage().size() > 2)
            Glide.with(this).load(artist.getImage().get(2).getUrl()).into(mArtistCover);
    }
}
