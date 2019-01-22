package com.example.vishalkhushlani.androidarchitecture.Notification;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NotificationDao {

    @Insert
    void insert(Notification notification);

    @Update
    void update(Notification notification);

    @Delete
    void delete(Notification notification);

    @Query("Select * From notification_table")
    List<Notification>  getAllNotification();

}
