package com.example.vishalkhushlani.androidarchitecture.Notification;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.vishalkhushlani.androidarchitecture.Utils.APIResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class NotificationVIewModel extends ViewModel {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<APIResponse<Notification>> notificationLiveData = new MutableLiveData<>();
    private NotificationRepository notificationRepository;
    private List<Notification> allNotification;
    private APIResponse<Notification> apiResponse;

    public NotificationVIewModel(@NonNull Application application) {
        notificationRepository = new NotificationRepository(application);
        allNotification = notificationRepository.getAllNotification();
    }

    public NotificationVIewModel( NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public MutableLiveData<APIResponse<Notification>> getNotificationLiveData() {
        return notificationLiveData;
    }

    public void hitNotificationApi(int userId){
        disposables.add(notificationRepository.getNotifications(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> notificationLiveData.setValue(apiResponse.loading()))
                .subscribe(
                        result -> notificationLiveData.setValue(apiResponse.success(result)),
                        throwable -> notificationLiveData.setValue(apiResponse.error(throwable))
                ));}

    public void insert(Notification notification){
        notificationRepository.insert(notification);
    }

    public void update(Notification notification){
        notificationRepository.update(notification);
    }

    public void delete(Notification notification){
        notificationRepository.delete(notification);
    }

    public List<Notification> getAllNotificaion(){
        return allNotification;
    }

}
