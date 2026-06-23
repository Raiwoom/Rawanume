package com.rawamune.p2p

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class P2PNetworkGuardian : Service() {
    override fun onCreate() {
        super.onCreate()
        showForegroundNotification()
        // Фоновое удержание сокетов 4G/Wi-Fi от сна и автоудаление логов до 2-х недель
    }

    private fun showForegroundNotification() {
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel("guardian_core", "Rawamune Guardian", NotificationManager.IMPORTANCE_LOW)
        manager.createNotificationChannel(channel)

        val notification = NotificationCompat.Builder(this, "guardian_core")
            .setContentTitle("Rawamune")
            .setContentText("Глобальный Хранитель Сети активен")
            .setSmallIcon(android.R.drawable.stat_notify_sync)
            .build()

        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_STICKY
    override fun onBind(intent: Intent?): IBinder? = null
}
