package com.radio.search_fm.models;

import java.util.List;
import java.util.Map;

public interface Repository<T> {
    void query(Map<String, String> criteria, QueryResult<T> resultCallback);

    interface QueryResult<T> {
        void onQueryResult(List<T> results);
    }
}
