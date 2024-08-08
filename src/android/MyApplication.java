package unic.cicoco.cordova.umeng;


import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

import java.util.Map;

public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Map<String, String> keys = UmengUtils.getAppkeyAndChannel(this);
        String appKey = keys.get(UmengUtils.APPKEY);
        String channel = keys.get(keys.get(UmengUtils.CHANNEL));
        UMConfigure.preInit(this, appKey, channel);
    }
}