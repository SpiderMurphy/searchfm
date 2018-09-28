package com.radio.search_fm.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistResult {
    @SerializedName("opensearch:Query")
    private Query query;

    @SerializedName("opensearch:totalResults")
    private int totalResults;

    @SerializedName("opensearch:startIndex")
    private int startIndex;

    @SerializedName("opensearch:itemsPerPage")
    private int itemsPerPage;

    private ArtistMatches artistmatches;

    public ArtistMatches getArtistmatches() {
        return artistmatches;
    }

    public void setArtistmatches(ArtistMatches artistmatches) {
        this.artistmatches = artistmatches;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
}
