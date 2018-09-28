package com.radio.search_fm.presenter;

import android.support.annotation.NonNull;

import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.views.ViewArtistAdapter;

import java.util.ArrayList;
import java.util.List;

public class PresenterArtistList {
    private List<Artist> mArtists;

    public PresenterArtistList() {
        mArtists = new ArrayList<>();
    }

    public PresenterArtistList(@NonNull List<Artist> artists) {
        this.mArtists = artists;
    }

    public int getCount() {
        return mArtists.size();
    }

    public void clear() {
        mArtists.clear();
    }

    public void bindViewHolder(ViewArtistAdapter viewHolder, int position) {
        viewHolder.bindItem(mArtists.get(position));
    }

    public void addArtists(List<Artist> artists) {
        mArtists.addAll(artists);
    }

    public Artist getArtist(int position) {
        return mArtists.get(position);
    }
}
