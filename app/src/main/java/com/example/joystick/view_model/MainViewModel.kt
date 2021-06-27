package com.example.joystick.view_model

import android.text.Editable
import android.widget.SeekBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.joystick.model.FlightGearModel
import com.example.joystick.views.JoystickView

import timber.log.Timber
import kotlin.math.abs

class MainViewModel(private val model: FlightGearModel) : ViewModel() {
    private val _address = MutableLiveData<String>()
    private val _port = MutableLiveData<String>()
    val address: LiveData<String> = _address
    val port: LiveData<String> = _port
    fun setaddress(s: Editable){
        _address.value = s.toString()
    }
    fun setport(s: Editable){
        _port.value = s.toString()
    }

    private val _rudder = MutableLiveData<Int>().apply {
        value = 50
    }
    private val _throttle = MutableLiveData<Int>()
    val rudder: LiveData<Int> = _rudder
    val throttle: LiveData<Int> = _throttle
    fun setrudder(seekBar: SeekBar, progress: Int, fromUser: Boolean){
        _rudder.value = progress
        model.change((progress/50f)-1f,"/controls/flight/rudder")
    }
    fun setthrottle(seekBar: SeekBar, progress: Int, fromUser: Boolean){
        _throttle.value = progress
        model.change(progress/100f,"/controls/engines/current-engine/throttle")
    }

    val joystickOnChangeListener = JoystickView.OnChangeListener{aileron: Float, elevator: Float ->
//        Timber.d("aileron: ${aileron}, elevator: ${elevator}")
        var _aileron = aileron
        var _elevator = -elevator
        if(_aileron<-1){
            _aileron=-1f
        }
        if(_aileron>1){
            _aileron=1f
        }
        if(_elevator<-1){
            _elevator=-1f
        }
        if(_elevator>1){
            _elevator=1f
        }
        if(elevator==0f){
            _elevator=0f
        }
        model.change(_aileron,"/controls/flight/aileron")
        model.change(_elevator,"/controls/flight/elevator")
    }
    fun connect(address: String, port: String){
        try{
            model.connect(address, port.toInt())
        } catch (t: Throwable) {
            Timber.d(t.message)
        }
    }
}