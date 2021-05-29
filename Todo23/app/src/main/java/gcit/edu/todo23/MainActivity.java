package gcit.edu.todo23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import static android.provider.ContactsContract.Intents.Insert.ACTION;

public class MainActivity extends AppCompatActivity {
    public static  final String ACTION_CUSTOM_BROADCAST=BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";
    private  CustomReceiver customReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customReceiver=new CustomReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);

        this.registerReceiver(customReceiver,intentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(customReceiver,
                new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(customReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(customReceiver);
        super.onDestroy();
    }

    public void SendCustomBroadcast(View view) {
        Intent intent=new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}