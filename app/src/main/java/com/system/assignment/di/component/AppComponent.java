package com.system.assignment.di.component;

import android.app.Application;

import com.system.assignment.application.Assignment;
import com.system.assignment.data.api.ApiHelper;
import com.system.assignment.data.repository.DataManager;
import com.system.assignment.data.shared.PreferencesHelper;
import com.system.assignment.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(Assignment app);

    DataManager provideDataManager();

    PreferencesHelper providePreferenceHelper();

    ApiHelper provideApiHelperImpl();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}