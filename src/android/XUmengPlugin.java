package unic.cicoco.cordova.umeng;

import android.content.Context;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.umcrash.IUMCrashCallbackWithType;
import com.umeng.umcrash.UMCrash;
import com.umeng.umcrash.customlog.UAPMCustomLog;

import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author tafiagu@gmail.com
 * @since 2024/08/07 9:04 下午
 */
public class XUmengPlugin extends CordovaPlugin {
    private static final String TAG = "XUmengPlugin";

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            Context context = cordova.getContext();
            Map<String, String> keys = UmengUtils.getAppkeyAndChannel(context);
            String appKey = keys.get(UmengUtils.APPKEY);
            String channel = keys.get(keys.get(UmengUtils.CHANNEL));
            UMConfigure.init(context, appKey, channel, UMConfigure.DEVICE_TYPE_PHONE, null);
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            return true;
        } else if (action.equals("registerCrashCallback")) {
            UMCrash.registerUMCrashCallback(new IUMCrashCallbackWithType() {
                @Override
                public String onCallback(CrashType type) {
                    UAPMCustomLog.e(TAG, "CRASH: " + args.toString());
                    return "Crash";
                }
            });
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            return true;

        }
        return false;
    }
}