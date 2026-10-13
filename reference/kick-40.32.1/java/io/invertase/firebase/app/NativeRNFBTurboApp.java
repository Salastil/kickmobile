package io.invertase.firebase.app;

import android.util.Log;
import com.facebook.fbreact.specs.NativeRNFBTurboAppSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.FirebaseApp;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import io.invertase.firebase.common.ReactNativeFirebaseMeta;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public class NativeRNFBTurboApp extends NativeRNFBTurboAppSpec implements LifecycleEventListener {
    private static final String TAG = "App";
    public static final Map<String, String> authDomains = new ConcurrentHashMap();

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void removeListeners(double d) {
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void setLogLevel(String str) {
    }

    NativeRNFBTurboApp(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.addLifecycleEventListener(this);
        ReactNativeFirebaseEventEmitter.getSharedInstance().attachReactContext(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.removeLifecycleEventListener(this);
        ReactNativeFirebaseEventEmitter.getSharedInstance().detachReactContext(reactApplicationContext);
        super.invalidate();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        ReactNativeFirebaseEventEmitter.getSharedInstance().attachReactContext(getReactApplicationContext());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    protected Map<String, Object> getTypedExportedConstants() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<FirebaseApp> it = FirebaseApp.getApps(getReactApplicationContext()).iterator();
        while (it.hasNext()) {
            arrayList.add(RCTConvertFirebase.firebaseAppToMap(it.next()));
        }
        map.put("NATIVE_FIREBASE_APPS", arrayList);
        map.put("FIREBASE_RAW_JSON", ReactNativeFirebaseJSON.getSharedInstance().getRawJSON());
        return map;
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void initializeApp(ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        FirebaseApp firebaseApp = RCTConvertFirebase.readableMapToFirebaseApp(readableMap, readableMap2, getReactApplicationContext());
        configureAuthDomain(readableMap2.getString("name"), readableMap.getString("authDomain"));
        promise.resolve(RCTConvertFirebase.firebaseAppToWritableMap(firebaseApp));
    }

    public static void configureAuthDomain(String str, String str2) {
        if (str2 != null) {
            Log.d(TAG, str + " custom authDomain " + str2);
            authDomains.put(str, str2);
            return;
        }
        authDomains.remove(str);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void setAutomaticDataCollectionEnabled(String str, boolean z) {
        FirebaseApp.getInstance(str).setDataCollectionDefaultEnabled(z);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void deleteApp(String str, Promise promise) {
        FirebaseApp firebaseApp = FirebaseApp.getInstance(str);
        if (firebaseApp != null) {
            firebaseApp.delete();
            authDomains.remove(str);
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void eventsNotifyReady(boolean z) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().notifyJsReady(Boolean.valueOf(z));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void eventsGetListeners(Promise promise) {
        promise.resolve(ReactNativeFirebaseEventEmitter.getSharedInstance().getListenersMap());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void eventsPing(String str, ReadableMap readableMap, Promise promise) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseEvent(str, RCTConvertFirebase.readableMapToWritableMap(readableMap)));
        promise.resolve(RCTConvertFirebase.readableMapToWritableMap(readableMap));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void eventsAddListener(String str) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().addListener(str);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void eventsRemoveListener(String str, boolean z) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().removeListener(str, Boolean.valueOf(z));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void metaGetAll(Promise promise) {
        promise.resolve(ReactNativeFirebaseMeta.getSharedInstance().getAll());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void jsonGetAll(Promise promise) {
        promise.resolve(ReactNativeFirebaseJSON.getSharedInstance().getAll());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void preferencesSetBool(String str, boolean z, Promise promise) {
        ReactNativeFirebasePreferences.getSharedInstance().setBooleanValue(str, z);
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void preferencesSetString(String str, String str2, Promise promise) {
        ReactNativeFirebasePreferences.getSharedInstance().setStringValue(str, str2);
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void preferencesGetAll(Promise promise) {
        promise.resolve(ReactNativeFirebasePreferences.getSharedInstance().getAll());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAppSpec
    public void preferencesClearAll(Promise promise) {
        ReactNativeFirebasePreferences.getSharedInstance().clearAll();
        promise.resolve(null);
    }
}
