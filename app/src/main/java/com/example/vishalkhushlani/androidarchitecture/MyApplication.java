package com.example.vishalkhushlani.androidarchitecture;
import android.app.Application;
import android.content.Context;
import com.example.vishalkhushlani.androidarchitecture.DependecyInjection.AppComponent;
import com.example.vishalkhushlani.androidarchitecture.DependecyInjection.AppModule;
import com.example.vishalkhushlani.androidarchitecture.DependecyInjection.DaggerAppComponent;
import com.example.vishalkhushlani.androidarchitecture.DependecyInjection.RetrofitModule;

public class MyApplication extends Application{
    AppComponent appComponent;
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent =
                DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule()).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

}
