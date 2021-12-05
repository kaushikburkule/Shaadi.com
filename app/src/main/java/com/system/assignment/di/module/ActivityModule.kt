package com.system.assignment.di.module

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import com.system.assignment.application.ViewModelProviderFactory
import com.system.assignment.data.repository.AppDataManager
import com.system.assignment.data.repository.DataManager
import com.system.assignment.ui.base.BaseActivity
import com.system.assignment.ui.viewmodels.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity : BaseActivity<*, *>) {

    @Provides
    fun provideMainViewModel(dataManager: DataManager,
    ): MainActivityViewModel {
        val supplier: Supplier<MainActivityViewModel> =
            Supplier {
                MainActivityViewModel(
                    dataManager
                )
            }
        val factory: ViewModelProviderFactory<MainActivityViewModel> =
            ViewModelProviderFactory(MainActivityViewModel::class.java, supplier)
        return ViewModelProvider(activity, factory)[MainActivityViewModel::class.java]
    }

}