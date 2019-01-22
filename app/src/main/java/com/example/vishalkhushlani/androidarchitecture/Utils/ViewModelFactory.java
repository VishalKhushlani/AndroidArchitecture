package com.example.vishalkhushlani.androidarchitecture.Utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.vishalkhushlani.androidarchitecture.Notification.NotificationRepository;
import com.example.vishalkhushlani.androidarchitecture.Notification.NotificationVIewModel;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private NotificationRepository notificationRepository;

    @Inject
    public ViewModelFactory(NotificationRepository repository) {
        this.notificationRepository = repository;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NotificationVIewModel.class)) {
            return (T) new NotificationVIewModel(notificationRepository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
