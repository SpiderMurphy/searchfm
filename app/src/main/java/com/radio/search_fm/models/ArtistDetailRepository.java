package com.radio.search_fm.models;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.radio.search_fm.R;
import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.entities.ModelArtistInfo;
import com.radio.search_fm.network.ModelRequest;
import com.radio.search_fm.network.RestClient;

import java.util.Map;

public class ArtistDetailRepository implements Repository<Artist> {
    public static String ARTIST_MBID = "artist-mbid";

    private Context mContext;

    public ArtistDetailRepository(@NonNull Context context) {
        this.mContext = context;
    }

    @Override
    public void query(Map<String, String> criteria, QueryResult<Artist> resultCallback) { }

    @Override
    public void query(Map<String, String> criteria, QueryResult<Artist> resultCallback, QueryError errorCallback) { }

    @Override
    public void querySingle(Map<String, String> criteria, QueryResultSingle<Artist> resultCallback) {
        String artistName = Uri.encode(criteria.get(ArtistRepository.ARTIST_NAME));

        RestClient.getInstance(mContext).addRequest(new ModelRequest<>(ModelArtistInfo.class,
                Request.Method.GET,
                "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" + artistName + "&api_key=" +
                        mContext.getString(R.string.api_key) + "&format=json",
                r -> resultCallback.onQueryResultSingle(r.getArtist()),
                null));
    }
}
