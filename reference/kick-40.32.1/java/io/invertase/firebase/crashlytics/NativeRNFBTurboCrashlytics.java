package io.invertase.firebase.crashlytics;

import android.os.Handler;
import android.util.Log;
import com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class NativeRNFBTurboCrashlytics extends NativeRNFBTurboCrashlyticsSpec {
    private static final String TAG = "Crashlytics";

    public NativeRNFBTurboCrashlytics(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    protected Map<String, Object> getTypedExportedConstants() {
        HashMap map = new HashMap();
        map.put("isCrashlyticsCollectionEnabled", Boolean.valueOf(ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()));
        map.put("isErrorGenerationOnJSCrashEnabled", Boolean.valueOf(ReactNativeFirebaseCrashlyticsInitProvider.isErrorGenerationOnJSCrashEnabled()));
        map.put("isCrashlyticsJavascriptExceptionHandlerChainingEnabled", Boolean.valueOf(ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsJavascriptExceptionHandlerChainingEnabled()));
        return map;
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void checkForUnsentReports(final Promise promise) {
        FirebaseCrashlytics.getInstance().checkForUnsentReports().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.crashlytics.NativeRNFBTurboCrashlytics$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboCrashlytics.lambda$checkForUnsentReports$0(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$checkForUnsentReports$0(Promise promise, Task task) {
        String message;
        if (task.isSuccessful()) {
            if (task.getResult() != null) {
                promise.resolve(task.getResult());
                return;
            } else {
                ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "unknown", "Unknown result of check for unsent reports");
                return;
            }
        }
        if (task.getException() != null) {
            message = task.getException().getMessage();
        } else {
            message = "checkForUnsentReports() request error";
        }
        ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "unknown", message);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void crashWithStackPromise(ReadableMap readableMap, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            recordJavaScriptError(readableMap).printStackTrace(System.err);
            Log.e(TAG, "Crash logged. Terminating app.");
            System.exit(0);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void crash() {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            new Handler().postDelayed(new Runnable() { // from class: io.invertase.firebase.crashlytics.NativeRNFBTurboCrashlytics.1
                @Override // java.lang.Runnable
                public void run() {
                    throw new RuntimeException("Crash Test");
                }
            }, 50L);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void deleteUnsentReports(Promise promise) {
        FirebaseCrashlytics.getInstance().deleteUnsentReports();
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void didCrashOnPreviousExecution(Promise promise) {
        promise.resolve(Boolean.valueOf(FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void log(String str) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            FirebaseCrashlytics.getInstance().log(str);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void logPromise(String str, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            FirebaseCrashlytics.getInstance().log(str);
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void setAttribute(String str, String str2, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void setAttributes(ReadableMap readableMap, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                firebaseCrashlytics.setCustomKey(strNextKey, readableMap.getString(strNextKey));
            }
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void sendUnsentReports() {
        FirebaseCrashlytics.getInstance().sendUnsentReports();
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void setUserId(String str, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            FirebaseCrashlytics.getInstance().setUserId(str);
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void setCrashlyticsCollectionEnabled(boolean z, Promise promise) {
        ReactNativeFirebasePreferences.getSharedInstance().setBooleanValue("crashlytics_auto_collection_enabled", z);
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void recordError(ReadableMap readableMap) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            recordJavaScriptError(readableMap);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboCrashlyticsSpec
    public void recordErrorPromise(ReadableMap readableMap, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.isCrashlyticsCollectionEnabled()) {
            recordJavaScriptError(readableMap);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
        promise.resolve(null);
    }

    private Exception recordJavaScriptError(ReadableMap readableMap) {
        Exception javaScriptError;
        String string = readableMap.getString("message");
        ReadableArray readableArray = (ReadableArray) Objects.requireNonNull(readableMap.getArray("frames"));
        if (readableMap.getBoolean("isUnhandledRejection")) {
            javaScriptError = new UnhandledPromiseRejection(string);
        } else {
            javaScriptError = new JavaScriptError(string);
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap readableMap2 = (ReadableMap) Objects.requireNonNull(readableArray.getMap(i));
            stackTraceElementArr[i] = new StackTraceElement("", readableMap2.getString("fn"), readableMap2.getString("file"), -1);
        }
        javaScriptError.setStackTrace(stackTraceElementArr);
        FirebaseCrashlytics.getInstance().recordException(javaScriptError);
        return javaScriptError;
    }
}
