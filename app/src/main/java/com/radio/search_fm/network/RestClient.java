package com.radio.search_fm.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RestClient {
    private static RestClient mInstance;

    // Volley's Request queue
    private RequestQueue mRequestQueue;

    public synchronized static RestClient getInstance(@NonNull Context context) {
        if(mInstance == null) mInstance = new RestClient(context.getApplicationContext());

        return mInstance;
    }

    private RestClient(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    /**
     * Add a quest to the queue
     *
     * @param request
     * @param <T>
     */
    public <T> void addRequest(Request<T> request) {
        mRequestQueue.add(request);
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
