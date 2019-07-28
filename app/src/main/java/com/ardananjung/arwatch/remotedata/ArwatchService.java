package com.ardananjung.arwatch.remotedata;

import com.ardananjung.arwatch.data.Watch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ArwatchService {
    @GET("/arwatch_service/api.php/apaya")
    Call<List<Watch>> getWatch();

    @POST("/arwatch_service/api.php/apaya")
    Call<Watch>postWatch(@Body Watch watch);
}
