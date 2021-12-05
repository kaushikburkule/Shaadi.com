package com.system.assignment.application

import android.app.Application
import com.system.assignment.di.component.AppComponent
import com.system.assignment.di.component.DaggerAppComponent

class Assignment : Application() {

    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent!!.inject(this)
    }

}