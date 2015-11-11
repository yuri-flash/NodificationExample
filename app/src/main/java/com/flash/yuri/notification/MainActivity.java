package com.flash.yuri.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void botao(View view)
    {

        Intent intent = new Intent(this, NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        Notification noti = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject").setSmallIcon(R.drawable.favicon)
                .setContentIntent(pIntent)
                .addAction(R.drawable.favicon, "Call", pIntent)
                .addAction(R.drawable.favicon, "More", pIntent)
                .addAction(R.drawable.favicon, "And more", pIntent).build();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, noti);
    }
}
