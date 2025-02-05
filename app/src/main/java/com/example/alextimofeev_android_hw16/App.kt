package com.example.alextimofeev_android_hw16

import android.app.Application
import com.example.alextimofeev_android_hw16.di.AppComponent
import com.example.alextimofeev_android_hw16.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent.create()
    }

    companion object {
        lateinit var daggerAppComponent: AppComponent
    }
}