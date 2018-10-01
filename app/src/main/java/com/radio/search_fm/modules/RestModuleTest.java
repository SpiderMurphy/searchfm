package com.radio.search_fm.modules;

import android.app.Application;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.HttpResponse;
import com.radio.search_fm.network.RestClient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestModuleTest extends RestModule {
    @Override
    public RestClient provideRestClient(Application application) {
        return RestClient.getInstance(application, getMockedHttpStack());
    }

    private BaseHttpStack getMockedHttpStack() {
        return new BaseHttpStack() {
            @Override
            public HttpResponse executeRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
                HttpResponse httpResponse = null;

                if(request.getUrl().startsWith("http://ws.audioscrobbler.com/2.0/?method=artist.search")) {
                    List<Header> headers = new ArrayList<>();
                    headers.add(new Header("content-type", "text/html; charset=UTF-8"));
                    headers.add(new Header("cache-control", "private, max-age=0"));

                    String jsonResponse = "{\"results\":{\"artistmatches\":{\"artist\":[{}]}}}";
                    InputStream inputStream = new ByteArrayInputStream(jsonResponse.getBytes("UTF-8"));

                    httpResponse = new HttpResponse(HttpURLConnection.HTTP_OK, headers, jsonResponse.length(), inputStream);
                }

                return httpResponse;
            }
        };
    }
}
