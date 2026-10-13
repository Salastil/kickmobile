package io.invertase.firebase.messaging;

import android.util.Log;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import io.invertase.firebase.common.ReactNativeFirebaseMeta;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;
import io.invertase.firebase.common.UniversalFirebasePreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ReactNativeFirebaseMessagingStoreImpl implements ReactNativeFirebaseMessagingStore {
    private static final int DEFAULT_MAX_SIZE_NOTIFICATIONS = 100;
    private static final String KEY_MAX_STORED_NOTIFICATIONS = "messaging_max_stored_notifications";
    private static final String S_KEY_ALL_NOTIFICATION_IDS = "all_notification_ids";
    private static final String TAG = "RNFirebaseMsgStore";
    private static volatile int maxNotificationSize = -1;
    private final String DELIMITER = WebViewLogEventConsumer.DDTAGS_SEPARATOR;

    private static int resolveMaxNotificationSize() {
        String str;
        int intValue;
        ReactNativeFirebaseJSON sharedInstance = ReactNativeFirebaseJSON.getSharedInstance();
        ReactNativeFirebaseMeta sharedInstance2 = ReactNativeFirebaseMeta.getSharedInstance();
        ReactNativeFirebasePreferences sharedInstance3 = ReactNativeFirebasePreferences.getSharedInstance();
        try {
            if (sharedInstance3.contains(KEY_MAX_STORED_NOTIFICATIONS)) {
                intValue = sharedInstance3.getIntValue(KEY_MAX_STORED_NOTIFICATIONS, 100);
                str = "SharedPreferences";
            } else if (sharedInstance.contains(KEY_MAX_STORED_NOTIFICATIONS)) {
                intValue = sharedInstance.getIntValue(KEY_MAX_STORED_NOTIFICATIONS, 100);
                str = "firebase.json";
            } else if (!sharedInstance2.contains(KEY_MAX_STORED_NOTIFICATIONS)) {
                str = Constants.COLLATION_DEFAULT;
                intValue = 100;
            } else {
                intValue = sharedInstance2.getIntValue(KEY_MAX_STORED_NOTIFICATIONS, 100);
                str = "AndroidManifest";
            }
            Log.d(TAG, "messaging_max_stored_notifications: " + intValue + " (from " + str + ")");
            return intValue;
        } catch (Exception e) {
            Log.w(TAG, "Error resolving max notification size, using default: 100", e);
            return 100;
        }
    }

    private static int getMaxNotificationSize() {
        if (maxNotificationSize == -1) {
            maxNotificationSize = resolveMaxNotificationSize();
        }
        return maxNotificationSize;
    }

    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingStore
    public void storeFirebaseMessage(RemoteMessage remoteMessage) {
        UniversalFirebasePreferences sharedInstance = UniversalFirebasePreferences.getSharedInstance();
        int maxNotificationSize2 = getMaxNotificationSize();
        List<String> listConvertToArray = convertToArray(sharedInstance.getStringValue(S_KEY_ALL_NOTIFICATION_IDS, ""));
        int i = maxNotificationSize2 > 0 ? maxNotificationSize2 - 1 : 0;
        while (!listConvertToArray.isEmpty() && listConvertToArray.size() > i) {
            clearFirebaseMessage(listConvertToArray.get(0));
            listConvertToArray.remove(0);
        }
        if (maxNotificationSize2 <= 0) {
            return;
        }
        try {
            String string = JsonConvert.reactToJSON(ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage)).toString();
            String stringValue = sharedInstance.getStringValue(S_KEY_ALL_NOTIFICATION_IDS, "");
            sharedInstance.setStringValue(remoteMessage.getMessageId(), string);
            sharedInstance.setStringValue(S_KEY_ALL_NOTIFICATION_IDS, stringValue + remoteMessage.getMessageId() + WebViewLogEventConsumer.DDTAGS_SEPARATOR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingStore
    @Deprecated
    public RemoteMessage getFirebaseMessage(String str) {
        WritableMap firebaseMessageMap = getFirebaseMessageMap(str);
        if (firebaseMessageMap == null) {
            return null;
        }
        if (!firebaseMessageMap.hasKey("to")) {
            firebaseMessageMap.putString("to", str);
        }
        return ReactNativeFirebaseMessagingSerializer.remoteMessageFromReadableMap(firebaseMessageMap);
    }

    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingStore
    public WritableMap getFirebaseMessageMap(String str) {
        String stringValue = UniversalFirebasePreferences.getSharedInstance().getStringValue(str, null);
        if (stringValue != null) {
            try {
                return JsonConvert.jsonToReact(new JSONObject(stringValue));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // io.invertase.firebase.messaging.ReactNativeFirebaseMessagingStore
    public void clearFirebaseMessage(String str) {
        UniversalFirebasePreferences sharedInstance = UniversalFirebasePreferences.getSharedInstance();
        sharedInstance.remove(str).apply();
        String stringValue = sharedInstance.getStringValue(S_KEY_ALL_NOTIFICATION_IDS, "");
        if (stringValue.isEmpty()) {
            return;
        }
        sharedInstance.setStringValue(S_KEY_ALL_NOTIFICATION_IDS, removeRemoteMessageId(str, stringValue));
    }

    private String removeRemoteMessageId(String str, String str2) {
        StringBuilder sb = new StringBuilder(str2.length());
        for (String str3 : convertToArray(str2)) {
            if (!str3.equals(str)) {
                sb.append(str3);
                sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
            }
        }
        return sb.toString();
    }

    private List<String> convertToArray(String str) {
        if (str.isEmpty()) {
            return new ArrayList();
        }
        return new ArrayList(Arrays.asList(str.split(WebViewLogEventConsumer.DDTAGS_SEPARATOR)));
    }
}
