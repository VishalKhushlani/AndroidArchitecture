package com.example.vishalkhushlani.androidarchitecture.Notification;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vishalkhushlani.androidarchitecture.Utils.APIResponse;
import com.example.vishalkhushlani.androidarchitecture.Utils.GenericEntityClass;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class NotificationViewModel extends ViewModel {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<APIResponse> notificationLiveData = new MutableLiveData<>();
    private NotificationRepository notificationRepository;
    private List<Notification> allNotification;
    private APIResponse apiResponse;

    public NotificationViewModel(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public MutableLiveData<APIResponse> getNotificationLiveData() {
        return notificationLiveData;
    }

    public void hitNotificationApi(int userId){
        disposables.add(notificationRepository.getNotifications(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> notificationLiveData.setValue(apiResponse.loading()))
                .subscribe(
                        result ->setSuccessResponse(result),
                        throwable -> notificationLiveData.setValue(apiResponse.error(throwable))
                )
        );}

    public void insert(Notification notification){
        notificationRepository.insert(notification);
    }

    public void update(Notification notification){
        notificationRepository.update(notification);
    }

    public void delete(Notification notification){
        notificationRepository.delete(notification);
    }

    public List<Notification> getAllNotificaion() {
        allNotification = notificationRepository.getAllNotification();
        return allNotification;
    }

    private void setSuccessResponse(Notification result){
        GenericEntityClass<Notification> notification=new GenericEntityClass<Notification>();
        notification.setObject(result);
        notificationLiveData.setValue(apiResponse.success(notification));
    }


}
