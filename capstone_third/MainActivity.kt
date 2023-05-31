create bottom menupackage com.example.practice_info



import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.practice_info.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fl: FrameLayout by lazy {
        findViewById(R.id.fl_con)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.today_Fragment -> {
                        bottomNav.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        bottomNav.itemTextColor =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        today_Fragment()
                        // Respond to navigation item 1 click
                    }

                    R.id.cam_Fragment -> {
                        bottomNav.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        bottomNav.itemTextColor =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        cam_Fragment()
                        // Respond to navigation item 2 click
                    }

                    R.id.info_Fragment -> {
                        bottomNav.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        bottomNav.itemTextColor =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        InfoFragment()
                        // Respond to navigation item 2 click
                    }

                    else -> {
                        bottomNav.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        bottomNav.itemTextColor =
                            ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        my_Fragment()
                        // Respond to navigation item 3 click
                    }
                }
            )
            true
        }
        bottomNav.selectedItemId = R.id.info_Fragment


    }

   private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_con, fragment)
            .commit()
    }
}





