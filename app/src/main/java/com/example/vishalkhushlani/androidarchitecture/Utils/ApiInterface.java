package com.example.vishalkhushlani.androidarchitecture.Utils;

import com.example.vishalkhushlani.androidarchitecture.Notification.Notification;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST(Urls.NOTIFICATIONS)
    Observable<Notification> getNotifications(@Field("user_id") int userId);

}
