package com.system.assignment.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.system.assignment.data.api.ApiHelper
import com.system.assignment.data.api.ApiHelperImpl
import com.system.assignment.data.local.AppDatabase
import com.system.assignment.data.local.DatabaseHelper
import com.system.assignment.data.local.DatabaseHelperImpl
import com.system.assignment.data.repository.AppDataManager
import com.system.assignment.data.repository.DataManager
import com.system.assignment.data.shared.AppPreferencesHelper
import com.system.assignment.data.shared.PreferencesHelper
import com.system.assignment.di.annotations.Database
import com.system.assignment.di.annotations.Preference
import com.system.assignment.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: ApiHelperImpl): ApiHelper {
        return appApiHelper
    }

    @Singleton
    @Provides
    fun providePreferenceHelper(appPreferencesHelper: AppPreferencesHelper) : PreferencesHelper{
        return appPreferencesHelper
    }

    @Singleton
    @Provides
    fun provideDataManager(dataManager: AppDataManager) : DataManager {
        return dataManager
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@Database dbName: String?, context: Context?): AppDatabase {
        return Room.databaseBuilder(context!!, AppDatabase::class.java, dbName!!)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Database
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: DatabaseHelperImpl): DatabaseHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Preference
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

}