package com.example.vishalkhushlani.androidarchitecture.Notification;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Notification.class},version = 1)
public abstract class NotificationDataBase extends RoomDatabase {

    private static NotificationDataBase instance;

    public abstract NotificationDao notificationDao();

    public static synchronized NotificationDataBase getInstance(Context context){
        if(instance==null){
            instance=Room.databaseBuilder(context.getApplicationContext(),
                    NotificationDataBase.class,
                    "notification_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private NotificationDao notificationDao;

        private PopulateDbAsyncTask(NotificationDataBase db) {
            notificationDao = db.notificationDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            notificationDao.insert(new Notification("message1","date","2",12012));
            return null;
        }
    }

}


