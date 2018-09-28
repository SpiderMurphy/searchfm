package com.radio.search_fm.views;

import com.radio.search_fm.entities.Artist;

import java.util.List;

/**
 * An interface to bind Activity methods to the underlying presenter
 */
public interface ViewSearchActivity {
    void onArtistSearchResult(List<Artist> results);
}
