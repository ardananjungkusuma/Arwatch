package com.blogspot.ardananjungkusuma.arwatch.remotedata;

import com.blogspot.ardananjungkusuma.arwatch.data.Watch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ArwatchService {
    @GET("/arwatch_service/api.php/contacts")
    Call<List<Watch>> getWatch();

    @POST("/arwatch/api.php/contacts")
    Call<Watch>postWatch(@Body Watch watch);
}
