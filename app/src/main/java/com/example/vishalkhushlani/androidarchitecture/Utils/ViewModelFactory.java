package com.example.vishalkhushlani.androidarchitecture.Utils;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.example.vishalkhushlani.androidarchitecture.Notification.NotificationRepository;
import com.example.vishalkhushlani.androidarchitecture.Notification.NotificationViewModel;

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
        if (modelClass.isAssignableFrom(NotificationViewModel.class)) {
            return (T) new NotificationViewModel(notificationRepository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
