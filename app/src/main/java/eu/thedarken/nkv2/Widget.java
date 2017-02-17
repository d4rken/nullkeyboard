package eu.thedarken.nkv2;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;


public class Widget extends AppWidgetProvider {
    @Override
    public void onEnabled(Context context) {
        Log.d(getClass().getSimpleName(), "Null Keyboard v2, Widget here!");
        super.onEnabled(context);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            Intent intent = new Intent(Intent.ACTION_MAIN, null);

            ComponentName cn = new ComponentName("eu.thedarken.nkv2", "eu.thedarken.nkv2.toggle");
            intent.setComponent(cn);

            PendingIntent myPI = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            views.setOnClickPendingIntent(R.id.button1, myPI);

            AppWidgetManager mgr = AppWidgetManager.getInstance(context);
            mgr.updateAppWidget(appWidgetId, views);
        }


    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(getClass().getSimpleName(), "Null Keyboard v2, Widget destroyed!");
    }
}

