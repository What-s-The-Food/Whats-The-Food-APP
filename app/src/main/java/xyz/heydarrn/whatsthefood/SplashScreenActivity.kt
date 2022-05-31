package xyz.heydarrn.whatsthefood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, TIMES_MILLISECONDS)
        supportActionBar?.hide()
        findViewById<ImageView>(R.id.imageView_app_logo).setImageResource(R.drawable.logo_transparent)
    }

    companion object{
        private const val TIMES_MILLISECONDS=2000L
    }
}