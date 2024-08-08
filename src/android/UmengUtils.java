package unic.cicoco.cordova.umeng;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class UmengUtils {
    public final static String APPKEY = "appkey";
    public final static String CHANNEL = "channel";

    public static Map<String, String> getAppkeyAndChannel(Context ctx) {
        if (ctx == null) {
            return null;
        }
        Map<String, String> result = new HashMap<String, String>();
        String appkey = null;
        String channelName = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        appkey = applicationInfo.metaData.get("UMENG_APPKEY") + "";
                        channelName = applicationInfo.metaData.get("UMENG_CHANNEL") + "";
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(appkey)) {
            result.put(APPKEY, appkey);
        }
        if (!TextUtils.isEmpty(channelName)) {
            result.put(CHANNEL, channelName);
        }
        return result;
    }

}