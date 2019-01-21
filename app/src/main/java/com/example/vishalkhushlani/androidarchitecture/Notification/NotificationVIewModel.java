package com.example.vishalkhushlani.androidarchitecture.Notification;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class NotificationVIewModel extends AndroidViewModel {
    private NotificationRepository notificationRepository;
    private LiveData<List<Notification>>allNotification;

    public NotificationVIewModel(@NonNull Application application) {
        super(application);
        notificationRepository = new NotificationRepository(application);
        allNotification = notificationRepository.getAllNotification();
    }

    public void insert(Notification notification){
        notificationRepository.insert(notification);
    }

    public void update(Notification notification){
        notificationRepository.update(notification);
    }

    public void delete(Notification notification){
        notificationRepository.delete(notification);
    }

    public LiveData<List<Notification>> getAllNotificaion(){
        return allNotification;
    }

}
