package anzhy.dizi.animation

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import anzhy.dizi.animation.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding
    private var isFabOpen = false
    private lateinit var fabOpenAnim: Animation
    private lateinit var fabCloseAnim: Animation
    private lateinit var fabRightAnim: Animation
    private lateinit var fabLeftAnim: Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fabOpenAnim = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fabCloseAnim = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        fabLeftAnim = AnimationUtils.loadAnimation(this, R.anim.fab_rotation_left)
        fabRightAnim = AnimationUtils.loadAnimation(this, R.anim.fab_rotation_right)

        binding.fab1.setOnClickListener {
            binding.fab3.visibility = View.VISIBLE
            binding.fab2.visibility = View.VISIBLE
            checkFabOpenOrNot()
        }
        binding.fab2.setOnClickListener {
            Toast.makeText(
                this,
                "Fab2 is clicked", Toast.LENGTH_SHORT
            ).show()
            binding.fab3.visibility = View.INVISIBLE
            binding.fab2.visibility = View.INVISIBLE
            checkFabOpenOrNot()
        }
        binding.fab3.setOnClickListener {
            Toast.makeText(
                this,
                "Fab3 is clicked", Toast.LENGTH_SHORT
            ).show()
            binding.fab3.visibility = View.INVISIBLE
            binding.fab2.visibility = View.INVISIBLE
            checkFabOpenOrNot()
        }

    }

    private fun checkFabOpenOrNot() {
        if (isFabOpen) {
            binding.fab1.startAnimation(fabLeftAnim)
            binding.fab2.startAnimation(fabCloseAnim)
            binding.fab3.startAnimation(fabCloseAnim)
            binding.fab2.isClickable = false
            binding.fab3.isClickable = false
            isFabOpen = false
        } else {
            binding.fab1.startAnimation(fabRightAnim)
            binding.fab2.startAnimation(fabOpenAnim)
            binding.fab3.startAnimation(fabOpenAnim)
            binding.fab2.isClickable = true
            binding.fab3.isClickable = true
            isFabOpen = true
        }
    }
}