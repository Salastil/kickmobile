package com.datadog.reactnative;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DdSdkReactNativePackage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/reactnative/DdSdkReactNativePackage;", "Lcom/facebook/react/TurboReactPackage;", "<init>", "()V", "sdkWrapper", "Lcom/datadog/reactnative/DatadogSDKWrapper;", "ddTelemetry", "Lcom/datadog/reactnative/DdTelemetry;", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "name", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdSdkReactNativePackage extends TurboReactPackage {
    private final DatadogSDKWrapper sdkWrapper = new DatadogSDKWrapper();
    private final DdTelemetry ddTelemetry = new DdTelemetry();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        switch (name.hashCode()) {
            case -1143383609:
                if (name.equals("DdFlags")) {
                    return new DdFlags(reactContext);
                }
                return null;
            case -1130275707:
                if (name.equals("DdTrace")) {
                    return new DdTrace(reactContext);
                }
                return null;
            case 65861066:
                if (name.equals("DdRum")) {
                    return new DdRum(reactContext, this.sdkWrapper);
                }
                return null;
            case 65861498:
                if (name.equals("DdSdk")) {
                    return new DdSdk(reactContext, this.sdkWrapper, this.ddTelemetry);
                }
                return null;
            case 2041508463:
                if (name.equals("DdLogs")) {
                    return new DdLogs(reactContext, this.sdkWrapper);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.datadog.reactnative.DdSdkReactNativePackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return DdSdkReactNativePackage.getReactModuleInfoProvider$lambda$0();
            }
        };
    }

    static final Map getReactModuleInfoProvider$lambda$0() {
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"DdSdk", "DdRum", "DdTrace", "DdLogs", "DdFlags"});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            String str = (String) obj;
            linkedHashMap.put(obj, new ReactModuleInfo(str, str, false, false, true, false, true));
        }
        return linkedHashMap;
    }
}
