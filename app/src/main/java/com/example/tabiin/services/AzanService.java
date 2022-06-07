package com.example.tabiin.services;

import android.app.*;
import android.content.*;
import android.os.*;

import androidx.core.app.*;

public class AzanService extends Service {

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){

        createNotificationChannel();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        /*
        Intent resultIntent1 = new Intent(this, DailyActivity.class);
        PendingIntent resultPendingIntent1 = PendingIntent.getActivity(this, 1, resultIntent1,
                PendingIntent.FLAG_UPDATE_CURRENT);




        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this,"dailyAzkar")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Daily Zickr")
                        .setContentText("Let's go!")
                        .setContentIntent(resultPendingIntent1);





        Notification notification = builder.build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, notification);

        Intent resultIntent = new Intent(this, SubhanActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder1 =
                new NotificationCompat.Builder(this, "subhanaLlah")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("СубханаЛлахи ва би Хамдих СубханаЛлахиль Азым")
                        .setContentText("СубханаЛлахи ва би Хамдих СубханаЛлахиль Азым")
                        .setContentIntent(resultPendingIntent);



        Notification notification1 = builder1.build();

        NotificationManager notificationManager1 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationManagerCompat notificationManager2 = NotificationManagerCompat.from(this);

        notificationManager2.notify(2, notification1);

        startForeground(1, notification);
        //startForeground(2, notification1);

        return START_STICKY;

         */

        // delete return in future
        return Integer.parseInt("0");
    }



    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Foreground notify";
            String description = "Foreground notify";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("dailyAzkar", name, importance);
            NotificationChannel channel1 = new NotificationChannel("subhanaLlah", name, importance);
            channel.setDescription(description);
            channel1.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            NotificationManager notificationManager1 = getSystemService(NotificationManager.class);
            notificationManager1.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel);

        }
    }

    @Override
    public void onDestroy() {

    }
}
