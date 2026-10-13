package io.invertase.firebase.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import com.facebook.fbreact.specs.NativeRNFBTurboUtilsSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class NativeRNFBTurboUtils extends NativeRNFBTurboUtilsSpec {
    private static final String FIREBASE_TEST_LAB = "firebase.test.lab";
    private static final String KEY_CACHE_DIRECTORY = "CACHES_DIRECTORY";
    private static final String KEY_DOCUMENT_DIRECTORY = "DOCUMENT_DIRECTORY";
    private static final String KEY_EXTERNAL_DIRECTORY = "EXTERNAL_DIRECTORY";
    private static final String KEY_EXT_STORAGE_DIRECTORY = "EXTERNAL_STORAGE_DIRECTORY";
    private static final String KEY_LIBRARY_DIRECTORY = "LIBRARY_DIRECTORY";
    private static final String KEY_MAIN_BUNDLE = "MAIN_BUNDLE";
    private static final String KEY_MOVIES_DIRECTORY = "MOVIES_DIRECTORY";
    private static final String KEY_PICS_DIRECTORY = "PICTURES_DIRECTORY";
    private static final String KEY_TEMP_DIRECTORY = "TEMP_DIRECTORY";
    private static final String TAG = "Utils";

    public NativeRNFBTurboUtils(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private static Boolean isRunningInTestLab() {
        return Boolean.valueOf("true".equals(Settings.System.getString(ReactNativeFirebaseApp.getApplicationContext().getContentResolver(), FIREBASE_TEST_LAB)));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboUtilsSpec
    public void androidGetPlayServicesStatus(Promise promise) {
        promise.resolve(getPlayServicesStatusMap());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboUtilsSpec
    public void androidPromptForPlayServices(Promise promise) {
        Activity currentActivity;
        int iIsGooglePlayServicesAvailable = isGooglePlayServicesAvailable();
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (iIsGooglePlayServicesAvailable != 0 && googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable) && (currentActivity = getCurrentActivity()) != null) {
            googleApiAvailability.getErrorDialog(currentActivity, iIsGooglePlayServicesAvailable, iIsGooglePlayServicesAvailable).show();
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboUtilsSpec
    public void androidResolutionForPlayServices(Promise promise) {
        Activity currentActivity;
        int iIsGooglePlayServicesAvailable = isGooglePlayServicesAvailable();
        ConnectionResult connectionResult = new ConnectionResult(iIsGooglePlayServicesAvailable);
        if (!connectionResult.isSuccess() && connectionResult.hasResolution() && (currentActivity = getCurrentActivity()) != null) {
            try {
                connectionResult.startResolutionForResult(currentActivity, iIsGooglePlayServicesAvailable);
            } catch (IntentSender.SendIntentException e) {
                Log.d(TAG, "resolutionForPlayServices", e);
            }
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboUtilsSpec
    public void androidMakePlayServicesAvailable(final Promise promise) {
        if (isGooglePlayServicesAvailable() != 0) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: io.invertase.firebase.utils.NativeRNFBTurboUtils$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$androidMakePlayServicesAvailable$1(promise);
                }
            });
        } else {
            promise.resolve(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$androidMakePlayServicesAvailable$1(final Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(currentActivity).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.utils.NativeRNFBTurboUtils$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    NativeRNFBTurboUtils.lambda$androidMakePlayServicesAvailable$0(promise, task);
                }
            });
        } else {
            promise.resolve(null);
        }
    }

    static /* synthetic */ void lambda$androidMakePlayServicesAvailable$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(null);
        } else if (task.isCanceled()) {
            promise.reject("play-services-update-canceled", "Play Services update was canceled by the user");
        } else {
            Exception exception = task.getException();
            promise.reject("play-services-update-failed", exception != null ? exception.getMessage() : "Unknown error", exception);
        }
    }

    private static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            Log.d(TAG, "getAppVersionName", e);
            return null;
        }
    }

    private int isGooglePlayServicesAvailable() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getReactApplicationContext());
    }

    private WritableMap getPlayServicesStatusMap() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(getReactApplicationContext());
        writableMapCreateMap.putInt("status", iIsGooglePlayServicesAvailable);
        if (iIsGooglePlayServicesAvailable == 0) {
            writableMapCreateMap.putBoolean("isAvailable", true);
            return writableMapCreateMap;
        }
        writableMapCreateMap.putBoolean("isAvailable", false);
        writableMapCreateMap.putString("error", googleApiAvailability.getErrorString(iIsGooglePlayServicesAvailable));
        writableMapCreateMap.putBoolean("isUserResolvableError", googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable));
        writableMapCreateMap.putBoolean("hasResolution", new ConnectionResult(iIsGooglePlayServicesAvailable).hasResolution());
        return writableMapCreateMap;
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboUtilsSpec
    protected Map<String, Object> getTypedExportedConstants() {
        HashMap map = new HashMap();
        map.put("isRunningInTestLab", isRunningInTestLab());
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        String appVersionName = getAppVersionName(reactApplicationContext);
        if (appVersionName != null && !appVersionName.isEmpty()) {
            map.put("appVersion", appVersionName);
        }
        map.put(KEY_MAIN_BUNDLE, "");
        map.put(KEY_LIBRARY_DIRECTORY, reactApplicationContext.getFilesDir().getAbsolutePath());
        map.put(KEY_TEMP_DIRECTORY, reactApplicationContext.getCacheDir().getAbsolutePath());
        map.put(KEY_CACHE_DIRECTORY, reactApplicationContext.getCacheDir().getAbsolutePath());
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            map.put(KEY_DOCUMENT_DIRECTORY, externalFilesDir.getAbsolutePath());
        } else {
            map.put(KEY_DOCUMENT_DIRECTORY, reactApplicationContext.getFilesDir().getAbsolutePath());
        }
        if (!map.containsKey(KEY_DOCUMENT_DIRECTORY)) {
            map.put(KEY_DOCUMENT_DIRECTORY, reactApplicationContext.getFilesDir().getAbsolutePath());
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        map.put(KEY_PICS_DIRECTORY, externalStoragePublicDirectory != null ? externalStoragePublicDirectory.getAbsolutePath() : "");
        File externalStoragePublicDirectory2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        map.put(KEY_MOVIES_DIRECTORY, externalStoragePublicDirectory2 != null ? externalStoragePublicDirectory2.getAbsolutePath() : "");
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            map.put(KEY_EXT_STORAGE_DIRECTORY, externalStorageDirectory.getAbsolutePath());
        }
        if (externalFilesDir != null) {
            map.put(KEY_EXTERNAL_DIRECTORY, externalFilesDir.getAbsolutePath());
        }
        return map;
    }
}
