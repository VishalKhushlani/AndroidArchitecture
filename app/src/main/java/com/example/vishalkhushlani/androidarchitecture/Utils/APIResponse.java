package com.example.vishalkhushlani.androidarchitecture.Utils;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.example.vishalkhushlani.androidarchitecture.Utils.Status.ERROR;
import static com.example.vishalkhushlani.androidarchitecture.Utils.Status.LOADING;
import static com.example.vishalkhushlani.androidarchitecture.Utils.Status.SUCCESS;


public class APIResponse<E> {

    public final Status status;

    @Nullable
    public final E data;

    @Nullable
    public final Throwable error;

    private APIResponse(Status status, @Nullable E data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static APIResponse loading() {
        return new APIResponse(LOADING, null, null);
    }

    public APIResponse success(@NonNull E data) {
        return new APIResponse(SUCCESS, data, null);
    }

    public static APIResponse error(@NonNull Throwable error) {
        return new APIResponse(ERROR, null, error);
    }

}