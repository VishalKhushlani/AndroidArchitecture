package com.example.vishalkhushlani.androidarchitecture.Notification;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vishalkhushlani.androidarchitecture.Utils.APIResponse;
import com.example.vishalkhushlani.androidarchitecture.Utils.GenericEntityClass;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class NotificationViewModel extends ViewModel {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<APIResponse> notificationLiveData = new MutableLiveData<>();
    private NotificationRepository notificationRepository;
    private List<Notification> allNotification;
    GenericEntityClass<Notification> notification=new GenericEntityClass<Notification>();

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
                .doOnSubscribe((d) -> notificationLiveData.setValue(APIResponse.loading()))
                .subscribe(
                        result ->notificationLiveData.setValue(APIResponse.success(result.getResult())),
                        throwable -> notificationLiveData.setValue(APIResponse.error(throwable))
                )
        );
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

    public List<Notification> getAllNotificaion() {
        allNotification = notificationRepository.getAllNotification();
        return allNotification;
    }

//    private void setSuccessResponse(ArrayList<Notification> result){
//        notification.setArrayList(result);
//        notificationLiveData.setValue(apiResponse.success(notification));
//    }

    public ArrayList<Notification> getData(){
        return notification.getArrayList();
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

}
