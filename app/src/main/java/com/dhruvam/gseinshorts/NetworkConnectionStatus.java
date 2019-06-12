package com.dhruvam.gseinshorts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkConnectionStatus extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        checkOnlineStatus(context);
    }
    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = null;
            if (cm != null) {
                netInfo = cm.getActiveNetworkInfo();
            }
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void checkOnlineStatus(Context context) {
        if(isOnline(context)){
            Toast.makeText(context,"You're back on internet!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"No network found",Toast.LENGTH_LONG).show();
        }
    }
}
