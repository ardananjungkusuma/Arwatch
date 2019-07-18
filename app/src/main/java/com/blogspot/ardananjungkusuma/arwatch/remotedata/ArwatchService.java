package com.blogspot.ardananjungkusuma.arwatch.remotedata;

import com.blogspot.ardananjungkusuma.arwatch.data.WatchItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ArwatchService {
    @GET("/arwatch_service/api.php/watchitem")
    Call<List<WatchItem>>getWatchItem();

    @POST("/arwatch_service/api.php/watchitem")
    Call<WatchItem>postWatchItem(@Body WatchItem watchItem);
}
