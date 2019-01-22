package com.example.vishalkhushlani.androidarchitecture.DependecyInjection;



import com.example.vishalkhushlani.androidarchitecture.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RetrofitModule.class})
@Singleton
public interface AppComponent {

    void doInjection(MainActivity mainActivity);

}
