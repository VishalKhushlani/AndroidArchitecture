package com.example.vishalkhushlani.androidarchitecture;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vishalkhushlani.androidarchitecture.Notification.Notification;
import com.example.vishalkhushlani.androidarchitecture.Notification.NotificationVIewModel;
import com.example.vishalkhushlani.androidarchitecture.Utils.APIResponse;

public class MainActivity extends AppCompatActivity {

    NotificationVIewModel notificationVIewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getAppComponent().doInjection(this);
        notificationVIewModel = ViewModelProviders.of(this, (ViewModelProvider.Factory) notificationVIewModel).get(NotificationVIewModel.class);
        notificationVIewModel.getNotificationLiveData().observe(this, this::consumeResponse);
    }

    private void consumeResponse(APIResponse<Notification> notificationAPIResponse) {
        switch (notificationAPIResponse.status) {
            case LOADING:
                break;

            case SUCCESS:
                break;

            case ERROR:
                break;

            default:
                break;
        }
    }
}
