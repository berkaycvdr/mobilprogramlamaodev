package com.abdullahakcakil.abdullahakcakilodev.dataui.pro

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdullahakcakil.abdullahakcakilodev.data.datarepository.MainRepository
import com.abdullahakcakil.abdullahakcakilodev.dataui.main.MainViewModel

class MainViewModelProviderFactory(val app: Application,
                                   private val mainRepository: MainRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app, mainRepository) as T
    }
}