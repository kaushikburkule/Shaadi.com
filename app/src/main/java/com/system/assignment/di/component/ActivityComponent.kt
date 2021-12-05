package com.system.assignment.di.component

import com.system.assignment.di.module.ActivityModule
import com.system.assignment.di.scope.ActivityScope
import com.system.assignment.ui.activities.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}