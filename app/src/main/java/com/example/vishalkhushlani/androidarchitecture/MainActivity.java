package com.example.vishalkhushlani.androidarchitecture;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vishalkhushlani.androidarchitecture.Notification.NotificationViewModel;
import com.example.vishalkhushlani.androidarchitecture.Utils.APIResponse;

public class MainActivity extends AppCompatActivity {

    NotificationViewModel notificationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getAppComponent().doInjection(this);
        notificationViewModel = ViewModelProviders.of(this, (ViewModelProvider.Factory) notificationViewModel).get(NotificationViewModel.class);
        notificationViewModel.getNotificationLiveData().observe(this, this::consumeResponse);
        notificationViewModel.hitNotificationApi(120);
    }

    private void consumeResponse(APIResponse notificationAPIResponse) {
        switch (notificationAPIResponse.status) {
            case LOADING:
                break;

            case SUCCESS:
//                notificationViewModel.insert(notificationAPIResponse);
                break;

            case ERROR:
                break;

            default:
                break;
        }
    }
}
