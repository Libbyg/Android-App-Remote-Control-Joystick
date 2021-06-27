package com.example.joystick

import android.app.Application
import timber.log.Timber
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class JoystickApp : Application() {
    val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}