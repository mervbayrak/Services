package com.example.merve.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
    int mcount=0; //kaç kere calıstıgı
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("start","servis basladi");
        sendMessage();
        return START_STICKY;
    }
    void sendMessage()
    {
        mcount++;
        Log.i("message","calisiyor sayi:"+mcount);

        if(mcount==10)  /// 10 olunca duruyor.
            return;

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               sendMessage();
           }
       },5*1000);
    }

    @Override
    public void onDestroy() {
        Log.d("destroy","servis sonlandi");
        super.onDestroy();
    }
}
