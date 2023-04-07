package id.bts.onlinetestapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import id.bts.onlinetestapplication.R
import id.bts.onlinetestapplication.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navController.apply {
            popBackStack()
            navigate(R.id.loginFragment)
        }
    }
}