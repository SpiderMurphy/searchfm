package com.radio.search_fm.views;

import com.radio.search_fm.entities.Artist;

public interface ViewArtistAdapter {
    void bindItem(Artist artist);
    void onClickListener(int position);
}
