package com.radio.search_fm.models;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.radio.search_fm.R;
import com.radio.search_fm.entities.Artist;
import com.radio.search_fm.entities.ModelArtistResult;
import com.radio.search_fm.network.ModelRequest;
import com.radio.search_fm.network.RestClient;

import java.util.Map;

public class ArtistRepository implements Repository<Artist> {
    public static String ARTIST_NAME = "artist_name";

    private Context mContext;

    public ArtistRepository(@NonNull Context context) {
        this.mContext = context;
    }

    @Override
    public void query(Map<String, String> criteria, QueryResult<Artist> resultCallback) {
        // Artist name
        String artistName = criteria.get(ARTIST_NAME);

        RestClient.getInstance(mContext).addRequest(new ModelRequest<>(ModelArtistResult.class,
                Request.Method.GET,
                "http://ws.audioscrobbler.com/2.0/?method=artist.search&artist=" + artistName +"&api_key=" + mContext.getString(R.string.api_key) + "&format=json",
                r -> resultCallback.onQueryResult(r.getResults().getArtistmatches().getArtist()),
                null));
    }

    @Override
    public void query(Map<String, String> criteria, QueryResult<Artist> resultCallback, QueryError errorCallback) {
        // Artist name
        String artistName = criteria.get(ARTIST_NAME);

        RestClient.getInstance(mContext).addRequest(new ModelRequest<>(ModelArtistResult.class,
                Request.Method.GET,
                "http://ws.audioscrobbler.com/2.0/?method=artist.search&artist=" + artistName +"&api_key=" + mContext.getString(R.string.api_key) + "&format=json",
                r -> resultCallback.onQueryResult(r.getResults().getArtistmatches().getArtist()),
                errorCallback::onError));
    }

    @Override
    public void querySingle(Map<String, String> criteria, QueryResultSingle<Artist> resultCallback) {

    }
}
