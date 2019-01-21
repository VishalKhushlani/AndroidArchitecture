package com.example.vishalkhushlani.androidarchitecture.Notification;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notification_table")
public class Notification {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String notification;
    private String createdAt;
    private String status;
    private int orderId;

    public Notification(String notification, String createdAt, String status, int orderId) {
        this.notification = notification;
        this.createdAt = createdAt;
        this.status = status;
        this.orderId = orderId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNotification() {
        return notification;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public int getOrderId() {
        return orderId;
    }
}

