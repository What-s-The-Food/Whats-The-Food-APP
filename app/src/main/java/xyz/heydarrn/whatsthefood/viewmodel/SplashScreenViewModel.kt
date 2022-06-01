package xyz.heydarrn.whatsthefood.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class SplashScreenViewModel : ViewModel() {
    private var mutableSplashScreen=MutableLiveData<SplashScreenState>()
    val liveSplashScreen:LiveData<SplashScreenState> = mutableSplashScreen

    init {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2500)
            mutableSplashScreen.postValue(SplashScreenState.MainActivity)
        }
    }


}

sealed class SplashScreenState{
    object MainActivity : SplashScreenState()
}