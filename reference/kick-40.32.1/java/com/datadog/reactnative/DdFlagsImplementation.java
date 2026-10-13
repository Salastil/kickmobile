package com.datadog.reactnative;

import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.flags.EvaluationContextCallback;
import com.datadog.android.flags.Flags;
import com.datadog.android.flags.FlagsClient;
import com.datadog.android.flags.FlagsConfiguration;
import com.datadog.android.flags._FlagsInternalProxy;
import com.datadog.android.flags.model.FlagsClientState;
import com.datadog.android.flags.model.UnparsedFlag;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdFlagsImplementation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\bH\u0002J&\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J6\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/datadog/reactnative/DdFlagsImplementation;", "", "sdkCoreOverride", "Lcom/datadog/android/api/SdkCore;", "<init>", "(Lcom/datadog/android/api/SdkCore;)V", "clients", "", "", "Lcom/datadog/android/flags/FlagsClient;", "sdkCore", "getSdkCore", "()Lcom/datadog/android/api/SdkCore;", "enable", "", "configuration", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getClient", "name", "setEvaluationContext", "clientName", "targetingKey", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "trackEvaluation", "key", "rawFlag", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdFlagsImplementation {
    public static final String NAME = "DdFlags";
    private final Map<String, FlagsClient> clients;
    private final SdkCore sdkCoreOverride;

    /* JADX WARN: Multi-variable type inference failed */
    public DdFlagsImplementation() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DdFlagsImplementation(SdkCore sdkCore) {
        this.sdkCoreOverride = sdkCore;
        this.clients = new LinkedHashMap();
    }

    public /* synthetic */ DdFlagsImplementation(SdkCore sdkCore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sdkCore);
    }

    private final SdkCore getSdkCore() {
        SdkCore sdkCore = this.sdkCoreOverride;
        return sdkCore == null ? Datadog.getInstance$default(null, 1, null) : sdkCore;
    }

    public final void enable(ReadableMap configuration, Promise promise) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(promise, "promise");
        FlagsConfiguration flagsConfigurationBuildFlagsConfiguration = DdFlagsImplementationKt.buildFlagsConfiguration(DdSdkBridgeExtKt.toMap(configuration));
        if (flagsConfigurationBuildFlagsConfiguration != null) {
            Flags.enable(flagsConfigurationBuildFlagsConfiguration, getSdkCore());
        } else {
            InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.reactnative.DdFlagsImplementation$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DdFlagsImplementation.enable$lambda$0();
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        promise.resolve(null);
    }

    static final String enable$lambda$0() {
        return "Invalid configuration provided for Flags. Feature initialization skipped.";
    }

    private final FlagsClient getClient(String name) {
        Map<String, FlagsClient> map = this.clients;
        FlagsClient flagsClientBuild = map.get(name);
        if (flagsClientBuild == null) {
            flagsClientBuild = new FlagsClient.Builder(name, getSdkCore()).build();
            map.put(name, flagsClientBuild);
        }
        return flagsClientBuild;
    }

    public final void setEvaluationContext(String clientName, String targetingKey, ReadableMap attributes, final Promise promise) {
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final FlagsClient client = getClient(clientName);
        final _FlagsInternalProxy _flagsinternalproxy = new _FlagsInternalProxy(client);
        client.setEvaluationContext(DdFlagsImplementationKt.buildEvaluationContext(targetingKey, attributes), new EvaluationContextCallback() { // from class: com.datadog.reactnative.DdFlagsImplementation.setEvaluationContext.1
            @Override // com.datadog.android.flags.EvaluationContextCallback
            public void onSuccess() {
                Map<String, UnparsedFlag> flagAssignmentsSnapshot = _flagsinternalproxy.getFlagAssignmentsSnapshot();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(flagAssignmentsSnapshot.size()));
                Iterator<T> it = flagAssignmentsSnapshot.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), DdFlagsImplementationKt.convertUnparsedFlagToMap((String) entry.getKey(), (UnparsedFlag) entry.getValue()));
                }
                promise.resolve(DdSdkBridgeExtKt.toWritableMap(linkedHashMap));
            }

            @Override // com.datadog.android.flags.EvaluationContextCallback
            public void onFailure(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (Intrinsics.areEqual(client.getState().getCurrentState(), FlagsClientState.Stale.INSTANCE)) {
                    Map<String, UnparsedFlag> flagAssignmentsSnapshot = _flagsinternalproxy.getFlagAssignmentsSnapshot();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(flagAssignmentsSnapshot.size()));
                    Iterator<T> it = flagAssignmentsSnapshot.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        linkedHashMap.put(entry.getKey(), DdFlagsImplementationKt.convertUnparsedFlagToMap((String) entry.getKey(), (UnparsedFlag) entry.getValue()));
                    }
                    promise.resolve(DdSdkBridgeExtKt.toWritableMap(linkedHashMap));
                    return;
                }
                promise.reject("CLIENT_NOT_INITIALIZED", error.getMessage(), error);
            }
        });
    }

    public final void trackEvaluation(String clientName, String key, ReadableMap rawFlag, String targetingKey, ReadableMap attributes, Promise promise) {
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(rawFlag, "rawFlag");
        Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new _FlagsInternalProxy(getClient(clientName)).trackFlagSnapshotEvaluation(key, DdFlagsImplementationKt.convertMapToUnparsedFlag(DdSdkBridgeExtKt.toMap(rawFlag)), DdFlagsImplementationKt.buildEvaluationContext(targetingKey, attributes));
        promise.resolve(null);
    }
}
