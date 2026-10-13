package com.reactnative.googlecast;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.reactnative.googlecast.api.RNGCCastContext;
import com.reactnative.googlecast.api.RNGCCastSession;
import com.reactnative.googlecast.api.RNGCDiscoveryManager;
import com.reactnative.googlecast.api.RNGCRemoteMediaClient;
import com.reactnative.googlecast.api.RNGCSessionManager;
import com.reactnative.googlecast.components.RNGoogleCastButtonManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class GoogleCastPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNGCCastContext(reactApplicationContext));
        arrayList.add(new RNGCCastSession(reactApplicationContext));
        arrayList.add(new RNGCDiscoveryManager(reactApplicationContext));
        arrayList.add(new RNGCRemoteMediaClient(reactApplicationContext));
        arrayList.add(new RNGCSessionManager(reactApplicationContext));
        return arrayList;
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNGoogleCastButtonManager());
        return arrayList;
    }
}
