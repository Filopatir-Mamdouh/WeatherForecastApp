package filo.mamdouh.weatherforecast

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import filo.mamdouh.weatherforecast.datastorage.local.objectbox.ObjectBox

@HiltAndroidApp
class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
        val channel = NotificationChannel("alarm_channel", "Alarm Channel", NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}