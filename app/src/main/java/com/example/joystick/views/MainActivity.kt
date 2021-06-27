package com.example.joystick.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.joystick.JoystickApp
import com.example.joystick.R
import com.example.joystick.databinding.ActivityMainBinding
import com.example.joystick.model.FlightGearModel
import com.example.joystick.view_model.MainViewModel

class MainActivity : AppCompatActivity() {
//    private lateinit var viewModel: MainViewModel

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = MainViewModel(FlightGearModel((application as JoystickApp).executorService))
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel


    }
}
