package com.example.musicplayer

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.musicplayer.playlist.PlaylistFragment

class MyService : Service() {

    private var mBinder = MyBinder()
    private var mMediaPlayer: MediaPlayer? = null
    private var isPlaying: Boolean = false

    inner class MyBinder : Binder() {
        fun getService(): MyService {
            return this@MyService
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startMusic()
        createNotificationChannel()
        pushNotification()
        return START_NOT_STICKY
    }

    private fun startMusic() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(applicationContext, R.raw.doi_minh)
        }
        mMediaPlayer?.start()
        isPlaying = true
    }

    @SuppressLint("RemoteViewLayout")
    private fun pushNotification() {

        val notificationIntent = Intent(this, PlaylistFragment::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val remoteView = RemoteViews(packageName, R.layout.item_notification).apply {
            setTextViewText(R.id.tv_ntf_title, "none title")
            setTextViewText(R.id.tv_ntf_artist, "artist")
        }
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("ForegroundService")
            .setContentText("mata")
            .setContentIntent(pendingIntent)
            .setCustomContentView(remoteView)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        startForeground(1, notification)
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                setSound(null,null)
            }
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }

    companion object {
        const val CHANNEL_ID = "ForegroundServiceChannel"
    }
}