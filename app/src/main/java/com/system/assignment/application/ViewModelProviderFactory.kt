package com.system.assignment.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.system.assignment.ui.viewmodels.MainActivityViewModel
import javax.inject.Singleton

@Singleton
@SuppressWarnings("unchecked")
class ViewModelProviderFactory<T : ViewModel?>(
    private val viewModelClass: Class<T>,
    private val viewModelSupplier: androidx.core.util.Supplier<T>
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(viewModelClass)) {
            viewModelSupplier.get() as T
        } else {
            throw IllegalArgumentException("Unknown Class name " + viewModelClass.name)
        }
    }

}