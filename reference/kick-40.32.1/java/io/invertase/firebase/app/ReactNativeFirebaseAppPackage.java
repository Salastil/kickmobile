package io.invertase.firebase.app;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import io.invertase.firebase.utils.NativeRNFBTurboUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes9.dex */
public class ReactNativeFirebaseAppPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    @Nonnull
    public List<NativeModule> createNativeModules(@Nonnull ReactApplicationContext reactApplicationContext) {
        if (ReactNativeFirebaseApp.getApplicationContext() == null) {
            ReactNativeFirebaseApp.setApplicationContext(reactApplicationContext.getApplicationContext());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeRNFBTurboApp(reactApplicationContext));
        arrayList.add(new NativeRNFBTurboUtils(reactApplicationContext));
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    @Nonnull
    public List<ViewManager> createViewManagers(@Nonnull ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }
}
