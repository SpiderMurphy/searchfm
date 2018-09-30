package com.radio.search_fm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.android.volley.Request;
import com.radio.search_fm.adapter.AdapterArtistItem;
import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.entities.ArtistResult;
import com.radio.search_fm.entities.ModelArtistResult;
import com.radio.search_fm.models.ArtistRepository;
import com.radio.search_fm.network.ModelRequest;
import com.radio.search_fm.network.RestClient;
import com.radio.search_fm.presenter.PresenterArtistList;
import com.radio.search_fm.presenter.PresenterSearchArtist;
import com.radio.search_fm.views.ViewSearchActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewSearchActivity {
    @BindView(R.id.searchToolbar)
    Toolbar mToolbar;

    @BindView(R.id.artists)
    RecyclerView mRwArtists;

    // Presenter
    private PresenterSearchArtist mPresenter;

    // List presenter
    private PresenterArtistList mPresenterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        ArtistRepository artistRepository = new ArtistRepository(this);
        ((SearchFm)getApplication()).getRestComponent().inject(artistRepository);

        mPresenter = new PresenterSearchArtist(this, artistRepository);
        mPresenterList = new PresenterArtistList();

        mRwArtists.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRwArtists.setAdapter(new AdapterArtistItem(mPresenterList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_artist, menu);

        setupSearchView((SearchView) menu.findItem(R.id.action_search).getActionView());

        return true;
    }

    private void setupSearchView(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mPresenter.searchArtistByName(query, MainActivity.this::onArtistSearchResult);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onArtistSearchResult(List<Artist> results) {
        mPresenterList.clear();
        mPresenterList.addArtists(results);
        mRwArtists.getAdapter().notifyDataSetChanged();
    }
}
