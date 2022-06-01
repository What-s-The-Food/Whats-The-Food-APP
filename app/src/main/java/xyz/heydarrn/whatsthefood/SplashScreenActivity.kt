package xyz.heydarrn.whatsthefood

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import xyz.heydarrn.whatsthefood.databinding.ActivitySplashScreenBinding
import xyz.heydarrn.whatsthefood.viewmodel.SplashScreenState
import xyz.heydarrn.whatsthefood.viewmodel.SplashScreenViewModel

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var bindingSplash:ActivitySplashScreenBinding
    private val viewModelSplash by viewModels<SplashScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSplash= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(bindingSplash.root)

        setAppLogo()
        monitorSplashScreen()

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }

    private fun setAppLogo(){
        bindingSplash.imageView.setImageResource(R.drawable.logo_transparent)
    }

    private fun monitorSplashScreen(){
        viewModelSplash.liveSplashScreen.observe(this){
            when(it){
                is SplashScreenState.MainActivity -> openMainActivity()
            }
        }
    }

    private fun openMainActivity(){
        finish()
        startActivity(Intent(this,MainActivity::class.java))
    }

}