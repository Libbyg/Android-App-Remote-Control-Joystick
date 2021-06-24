package com.example.joystick.view_model

import com.example.joystick.model.FlightGearModel
import androidx.lifecycle.ViewModel

class MainViewModel(private val model: FlightGearModel) : ViewModel() {
    var rudder: Float = 0f
    var throttle: Float = 0f
    var aileron: Float = 0f
    var elevator: Float = 0f
}