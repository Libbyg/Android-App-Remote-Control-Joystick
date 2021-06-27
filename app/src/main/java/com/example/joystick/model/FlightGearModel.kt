package com.example.joystick.model

import timber.log.Timber
import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.Executor

class FlightGearConnection() {
    var fg: Socket? = null
    var out: PrintWriter? = null
    fun connect(address: String, port: Int){
        try{
            fg = Socket(address, port)
//            if(fg != null){
//                Timber.d(fg.toString())
            out = PrintWriter(fg!!.getOutputStream(),true)
//            }
        } catch (t: Throwable) {
            Timber.d(t.message)
        }
    }
    fun change(value: Float, property: String){
        try {
            out?.print("set ${property} ${value}\r\n");
            out?.flush()
        } catch (t: Throwable) {
            Timber.d(t.message)
        }
    }
}

class FlightGearModel(private val executor: Executor) {
    val flightGearConnection = FlightGearConnection()
    fun connect(address: String, port: Int){
        executor.execute {
            flightGearConnection.connect(address, port)
        }
    }
    fun change(value: Float, property: String){
        executor.execute {
            flightGearConnection.change(value, property)
        }
    }
}