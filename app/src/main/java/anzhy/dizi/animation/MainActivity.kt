package anzhy.dizi.animation

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import anzhy.dizi.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.runLeft.setOnClickListener {
            binding.tom.animate().translationXBy(-2000f).setDuration(3000)
            binding.jerry.animate().translationXBy(-2000f).setDuration(3000)
        }

        binding.runRight.setOnClickListener {
            binding.tom.animate().translationXBy(1500f).setDuration(3000)
            binding.jerry.animate().translationXBy(1500f).setDuration(3000)
        }

        binding.animation.setOnClickListener {
            // val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_in)
            //val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_out)
            //val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.rotation)
            val animation =
                AnimationUtils.loadAnimation(this@MainActivity, R.anim.multiple_animation)

            binding.circle.startAnimation(animation)
        }


        binding.btnB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                var (vars1, vars2) = Pair<View, String>(
                    Pair(binding.jerry, "jerry").first,
                    Pair(binding.tom, "tom").second
                )

                val options = ActivityOptions.makeSceneTransitionAnimation(this, vars1, vars2)
                startActivity(intent, options.toBundle())
            } else {
                startActivity(intent)
            }
        }
    }
}