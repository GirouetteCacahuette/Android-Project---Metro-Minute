package fr.girouettecacahuete.metrominute;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface RatpServices {

    String ENDPOINT = "https://api-ratp.pierre-grimaud.fr/v3";
    @GET("/stations/metros/{code}")
    void listStationsAsync(@Path("code") String code, Callback<ApiResult> callback);
    @GET("/schedules/metros/{code}/{station}/A")
    void listSchedulesAAsync(@Path("code") String code, @Path("station") String station, Callback<ApiResult> callback);
    @GET("/schedules/metros/{code}/{station}/R")
    void listSchedulesBAsync(@Path("code") String code, @Path("station") String station, Callback<ApiResult> callback);
}