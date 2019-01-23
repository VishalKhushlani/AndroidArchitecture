package com.example.vishalkhushlani.androidarchitecture.Notification;
import android.app.Application;
import android.os.AsyncTask;
import com.example.vishalkhushlani.androidarchitecture.Utils.ApiInterface;
import com.example.vishalkhushlani.androidarchitecture.Utils.GenericBaseEntity;
import java.util.List;

public class NotificationRepository {
    private NotificationDao notificationDao;
    private ApiInterface apiInterface;
    private List<Notification> allNotification;

    public NotificationRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public io.reactivex.Observable<GenericBaseEntity<Notification>> getNotifications(int userId){
        return apiInterface.getNotifications(userId,"Customer");
    }

    public NotificationRepository(Application application) {
        NotificationDataBase database = NotificationDataBase.getInstance(application);
        notificationDao = database.notificationDao();
        allNotification = notificationDao.getAllNotification();
    }

    public void insert(Notification notification) {
        new InsertNotificatonAsyncTask(notificationDao).execute(notification);
    }

    public void update(Notification notification) {
        new UpdateNotificationAsyncTask(notificationDao).execute(notification);
    }

    public void delete(Notification notification) {
        new DeleteNotificationAsyncTask(notificationDao).execute(notification);
    }

    public List<Notification> getAllNotification() {
        return allNotification;
    }

    private static class InsertNotificatonAsyncTask extends AsyncTask<Notification, Void, Void> {
        private NotificationDao notificationDao;

        private InsertNotificatonAsyncTask(NotificationDao notificationDao) {
           this.notificationDao=notificationDao;
        }

        @Override
        protected Void doInBackground(Notification... notifications) {
            notificationDao.insert(notifications[0]);
            return null;
        }
    }

    private static class UpdateNotificationAsyncTask extends AsyncTask<Notification, Void, Void> {
        private NotificationDao notificationDao;

        private UpdateNotificationAsyncTask(NotificationDao notificationDao) {
            this.notificationDao = notificationDao;
        }

        @Override
        protected Void doInBackground(Notification... notifications) {
            notificationDao.update(notifications[0]);
            return null;
        }
    }

    private static class DeleteNotificationAsyncTask extends AsyncTask<Notification, Void, Void> {
        private NotificationDao notificationDao;

        private DeleteNotificationAsyncTask(NotificationDao notificationDao) {
            this.notificationDao = notificationDao;
        }

        @Override
        protected Void doInBackground(Notification... notifications) {
            notificationDao.delete(notifications[0]);
            return null;
        }
    }

}
