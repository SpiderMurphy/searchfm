package com.radio.search_fm.models;

import com.android.volley.VolleyError;

import java.util.List;
import java.util.Map;

public interface Repository<T> {
    void query(Map<String, String> criteria, QueryResult<T> resultCallback);
    void query(Map<String, String> criteria, QueryResult<T> resultCallback, QueryError errorCallback);

    interface QueryResult<T> {
        void onQueryResult(List<T> results);
    }

    interface QueryError {
        void onError(VolleyError error);
    }
}
