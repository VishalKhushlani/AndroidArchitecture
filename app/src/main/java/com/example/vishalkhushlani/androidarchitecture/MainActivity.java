package com.example.vishalkhushlani.androidarchitecture;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.Toast;

import com.example.vishalkhushlani.androidarchitecture.Adapter.NotificationAdapter;
import com.example.vishalkhushlani.androidarchitecture.Notification.Notification;
import com.example.vishalkhushlani.androidarchitecture.Notification.NotificationViewModel;
import com.example.vishalkhushlani.androidarchitecture.Utils.APIResponse;
import com.example.vishalkhushlani.androidarchitecture.Utils.ViewModelFactory;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.rv)
    RecyclerView rv;

    NotificationViewModel notificationViewModel;
    ArrayList<Notification> notificationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getAppComponent().doInjection(this);
        notificationViewModel = ViewModelProviders.of(this,  viewModelFactory).get(NotificationViewModel.class);
        notificationViewModel.getNotificationLiveData().observe(this, this::consumeResponse);
        notificationViewModel.hitNotificationApi(120);
        notificationArrayList = new ArrayList<>();
    }

    private void consumeResponse(APIResponse notificationAPIResponse) {
        switch (notificationAPIResponse.status) {
            case LOADING:
                Toast.makeText(MainActivity.this,"Loading", Toast.LENGTH_SHORT).show();
                break;

            case SUCCESS:
//                notificationViewModel.insert(notificationAPIResponse.data.get(0));
                notificationArrayList = notificationAPIResponse.data;
                recyclerViewSetup(notificationArrayList);
                break;

            case ERROR:
                Toast.makeText(MainActivity.this,"Error", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    public void recyclerViewSetup(ArrayList<Notification> notificationEntityArrayList){
        NotificationAdapter notificationAdapter = new NotificationAdapter(notificationEntityArrayList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(notificationAdapter);
    }
}
