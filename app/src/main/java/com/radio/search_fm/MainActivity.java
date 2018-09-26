package com.radio.search_fm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.radio.search_fm.presenter.PresenterSearchArtist;
import com.radio.search_fm.views.ViewSearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewSearchActivity {
    @BindView(R.id.searchToolbar)
    Toolbar mToolbar;

    @BindView(R.id.artists)
    RecyclerView mRwArtists;

    // Presenter
    private PresenterSearchArtist mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_artist, menu);

        return true;
    }
}
