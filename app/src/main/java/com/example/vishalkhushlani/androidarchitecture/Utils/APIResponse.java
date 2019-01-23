package com.example.vishalkhushlani.androidarchitecture.Utils;
import com.example.vishalkhushlani.androidarchitecture.Notification.Notification;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import static com.example.vishalkhushlani.androidarchitecture.Utils.Status.ERROR;
import static com.example.vishalkhushlani.androidarchitecture.Utils.Status.LOADING;
import static com.example.vishalkhushlani.androidarchitecture.Utils.Status.SUCCESS;


public class APIResponse{

    public final Status status;

    @Nullable
    public final ArrayList<Notification> data;

    @Nullable
    public final Throwable error;

    private APIResponse(Status status, @Nullable ArrayList<Notification> data ,@Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static APIResponse loading() {
        return new APIResponse(LOADING,null,null);
    }

    public static APIResponse success(@NonNull ArrayList<Notification> data) {
        return new APIResponse(SUCCESS, data,null);
    }

    public static APIResponse error(@NonNull Throwable error) {
        return new APIResponse(ERROR,null ,error);
    }

}
