package com.getHelp.App;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.telephony.gsm.SmsManager;
import android.widget.RemoteViews;

public class GetHelpWidget extends AppWidgetProvider {
    public static String ACTION_SEND_SMS = "SEND_SOS_SMS";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (intent.getAction().equals(ACTION_SEND_SMS)) {
            SmsManager smsManager = SmsManager.getDefault();
            String destinationAddress = "5556";
            String messageText = "Hello world";
            smsManager.sendTextMessage(destinationAddress, null, messageText, null, null);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Intent smsIntent = new Intent(context, GetHelpWidget.class);
        smsIntent.setAction(ACTION_SEND_SMS);
        smsIntent.putExtra("msg", "Message for SOS button");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, smsIntent, 0);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        remoteViews.setOnClickPendingIntent(R.id.widget_button, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}
