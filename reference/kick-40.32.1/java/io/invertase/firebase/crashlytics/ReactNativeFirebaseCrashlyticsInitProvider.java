package io.invertase.firebase.crashlytics;

import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.invertase.firebase.common.ReactNativeFirebaseInitProvider;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import io.invertase.firebase.common.ReactNativeFirebaseMeta;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;

/* JADX INFO: loaded from: classes9.dex */
public class ReactNativeFirebaseCrashlyticsInitProvider extends ReactNativeFirebaseInitProvider {
    private static final String TAG = "RNFBCrashlyticsInit";

    static boolean isCrashlyticsCollectionEnabled() {
        boolean booleanValue;
        ReactNativeFirebaseJSON sharedInstance = ReactNativeFirebaseJSON.getSharedInstance();
        ReactNativeFirebaseMeta sharedInstance2 = ReactNativeFirebaseMeta.getSharedInstance();
        ReactNativeFirebasePreferences sharedInstance3 = ReactNativeFirebasePreferences.getSharedInstance();
        if (sharedInstance3.contains("crashlytics_auto_collection_enabled")) {
            booleanValue = sharedInstance3.getBooleanValue("crashlytics_auto_collection_enabled", true);
            Log.d(TAG, "isCrashlyticsCollectionEnabled via RNFBPreferences: " + booleanValue);
        } else if (sharedInstance.contains("crashlytics_auto_collection_enabled")) {
            booleanValue = sharedInstance.getBooleanValue("crashlytics_auto_collection_enabled", true);
            Log.d(TAG, "isCrashlyticsCollectionEnabled via RNFBJSON: " + booleanValue);
        } else {
            booleanValue = sharedInstance2.getBooleanValue("crashlytics_auto_collection_enabled", true);
            Log.d(TAG, "isCrashlyticsCollectionEnabled via RNFBMeta: " + booleanValue);
        }
        Log.d(TAG, "isCrashlyticsCollectionEnabled final value: " + booleanValue);
        return booleanValue;
    }

    static boolean isErrorGenerationOnJSCrashEnabled() {
        boolean booleanValue;
        ReactNativeFirebaseJSON sharedInstance = ReactNativeFirebaseJSON.getSharedInstance();
        ReactNativeFirebaseMeta sharedInstance2 = ReactNativeFirebaseMeta.getSharedInstance();
        ReactNativeFirebasePreferences sharedInstance3 = ReactNativeFirebasePreferences.getSharedInstance();
        if (sharedInstance3.contains("crashlytics_is_error_generation_on_js_crash_enabled")) {
            booleanValue = sharedInstance3.getBooleanValue("crashlytics_is_error_generation_on_js_crash_enabled", true);
            Log.d(TAG, "isErrorGenerationOnJSCrashEnabled via RNFBPreferences: " + booleanValue);
        } else if (sharedInstance.contains("crashlytics_is_error_generation_on_js_crash_enabled")) {
            booleanValue = sharedInstance.getBooleanValue("crashlytics_is_error_generation_on_js_crash_enabled", true);
            Log.d(TAG, "isErrorGenerationOnJSCrashEnabled via RNFBJSON: " + booleanValue);
        } else {
            booleanValue = sharedInstance2.getBooleanValue("crashlytics_is_error_generation_on_js_crash_enabled", true);
            Log.d(TAG, "isErrorGenerationOnJSCrashEnabled via RNFBMeta: " + booleanValue);
        }
        Log.d(TAG, "isErrorGenerationOnJSCrashEnabled final value: " + booleanValue);
        return booleanValue;
    }

    static boolean isCrashlyticsJavascriptExceptionHandlerChainingEnabled() {
        boolean booleanValue;
        ReactNativeFirebaseJSON sharedInstance = ReactNativeFirebaseJSON.getSharedInstance();
        ReactNativeFirebaseMeta sharedInstance2 = ReactNativeFirebaseMeta.getSharedInstance();
        ReactNativeFirebasePreferences sharedInstance3 = ReactNativeFirebasePreferences.getSharedInstance();
        if (sharedInstance3.contains("crashlytics_javascript_exception_handler_chaining_enabled")) {
            booleanValue = sharedInstance3.getBooleanValue("crashlytics_javascript_exception_handler_chaining_enabled", true);
            Log.d(TAG, "isCrashlyticsJavascriptExceptionHandlerChainingEnabled via RNFBPreferences: " + booleanValue);
        } else if (sharedInstance.contains("crashlytics_javascript_exception_handler_chaining_enabled")) {
            booleanValue = sharedInstance.getBooleanValue("crashlytics_javascript_exception_handler_chaining_enabled", true);
            Log.d(TAG, "isCrashlyticsJavascriptExceptionHandlerChainingEnabled via RNFBJSON: " + booleanValue);
        } else {
            booleanValue = sharedInstance2.getBooleanValue("crashlytics_javascript_exception_handler_chaining_enabled", true);
            Log.d(TAG, "isCrashlyticsJavascriptExceptionHandlerChainingEnabled via RNFBMeta: " + booleanValue);
        }
        Log.d(TAG, "isCrashlyticsJavascriptExceptionHandlerChainingEnabled final value: " + booleanValue);
        return booleanValue;
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseInitProvider, android.content.ContentProvider
    public boolean onCreate() {
        super.onCreate();
        try {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(isCrashlyticsCollectionEnabled());
            Log.i(TAG, "initialization successful");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "initialization failed", e);
            return false;
        }
    }
}
