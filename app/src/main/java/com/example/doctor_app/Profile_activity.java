package com.example.doctor_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Profile_activity extends AppCompatActivity {

    final String CHANNEL_ID = "Important_mail_channel";
    NotificationManagerCompat mNotificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        createNotificationChannel();
        mNotificationManagerCompat = NotificationManagerCompat.from(Profile_activity.this);
    }
    public void gotosetting(View v){
        Intent intent = new Intent(Profile_activity.this, Setting_Activity.class);
        startActivity(intent);
    }
    public void gotohome(View v){
        Intent intent = new Intent(Profile_activity.this,   Dashboard_Activity.class);
        startActivity(intent);
    }
    public void addNotification(View v){
        createSimpleNotification("Doctor - we got your back!", "This is sample notification from developer team.", 1);
    }

    private void createSimpleNotification(String title, String text, int notificationId) {

        //removes all previously shown notifications.
        mNotificationManagerCompat.cancelAll();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.message_icon_red);

        //open the url when user taps the notification
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.c1ctech.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                //Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        // notificationId is a unique int for each notification that you must define
        mNotificationManagerCompat.notify(notificationId, notification);

    }
    private void createNotificationChannel() {

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //Channel name
            CharSequence name = "Important_mail_channel";

            //Channel description
            String description = "This channel will show notification only to important people";

            //The importance level you assign to a channel applies to all notifications that you post to it.
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            //Create the NotificationChannel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

            //Set channel description
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

//    public void btNotification(View v){
//        String message = "This is Doctor App Notification Examples";
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(
//                Profile_activity.this
//        )
//                .setSmallIcon(R.drawable.message_icon_red)
//                .setContentTitle("New notification")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setAutoCancel(true);
//        Intent intent = new Intent(Profile_activity.this, Notification_Activity.class);
//        startActivity(intent);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("message", message);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(Profile_activity.this,
//                0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager = (NotificationManager)getSystemService(
//                Context.NOTIFICATION_SERVICE
//        );
//        notificationManager.notify(0, builder.build());
//    }

//    public void addNotification(View view) {
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(this)
//                        .setSmallIcon(R.drawable.message_icon_red)
//                        .setContentTitle("Notifications Example")
//                        .setContentText("This is a test notification");
//
//        Intent notificationIntent = new Intent(this, Notification_Activity.class);
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(contentIntent);
//
//        // Add as notification
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(0, builder.build());
//    }

}