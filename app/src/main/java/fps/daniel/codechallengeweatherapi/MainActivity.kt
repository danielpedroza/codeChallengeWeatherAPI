package fps.daniel.codechallengeweatherapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import fps.daniel.codechallengeweatherapi.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showProgressBar(){
        binding.mainProgressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar(){
        binding.mainProgressBar.visibility = View.INVISIBLE
    }
}