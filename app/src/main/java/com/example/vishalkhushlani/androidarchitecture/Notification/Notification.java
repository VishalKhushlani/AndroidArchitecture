package com.example.vishalkhushlani.androidarchitecture.Notification;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notification_table")
public class Notification{

    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("status")
    String status;
    @SerializedName("notification")
    String notification;
    @SerializedName("order_id")
    int orderId;
    @SerializedName("created_at")
    String createdAt;

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

