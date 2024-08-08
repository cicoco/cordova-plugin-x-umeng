package unic.cicoco.cordova.umeng;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;

import com.umeng.commonsdk.UMConfigure;

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
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            UMConfigure.init(cordova.getContext(), UMConfigure.DEVICE_TYPE_PHONE, null);
            return true;
        }
        return false;

    }
}
