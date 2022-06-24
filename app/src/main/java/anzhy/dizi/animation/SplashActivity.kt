package anzhy.dizi.animation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import anzhy.dizi.animation.databinding.ActivityMainBinding
import anzhy.dizi.animation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)


        val animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.rotation)
        splashBinding.icon.startAnimation(animation)
    }
}