package eu.thedarken.nkv2;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class WidgetConfigure extends Activity {

    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    @Override
    public void onCreate(Bundle utz) {
        super.onCreate(utz);

        // Set the result to CANCELED.  This will cause the widget host to cancel
        // out of the widget placement if they press the back button.
        setResult(RESULT_CANCELED);

        startActivity(new Intent("android.settings.INPUT_METHOD_SETTINGS"));
        Toast.makeText(this, "To use 'Null Keyboard v2' enable it now", Toast.LENGTH_LONG).show();

        // Find the widget id from the intent. 
        Intent w_intent = getIntent();
        Bundle extras = w_intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
            Intent cancelResultValue = new Intent();
            cancelResultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            setResult(RESULT_CANCELED, cancelResultValue);
        } else {
            finish();
        }
        if (mAppWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
            // tell the app widget manager that we're now configured
            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            setResult(RESULT_OK, resultValue);
        }

        // activity is now done
        finish();

    }
}
