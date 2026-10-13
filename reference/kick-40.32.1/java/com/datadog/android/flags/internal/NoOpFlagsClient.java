package com.datadog.android.flags.internal;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.flags.EvaluationContextCallback;
import com.datadog.android.flags.FlagsClient;
import com.datadog.android.flags.FlagsStateListener;
import com.datadog.android.flags.StateObservable;
import com.datadog.android.flags.model.ErrorCode;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.FlagsClientState;
import com.datadog.android.flags.model.ResolutionDetails;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: NoOpFlagsClient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J-\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u0002H\u0014H\u0016¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J4\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00150!2\u0006\u0010\u0016\u001a\u00020\u00032\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00150!H\u0016J\u0018\u0010 \u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R$\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("}, d2 = {"Lcom/datadog/android/flags/internal/NoOpFlagsClient;", "Lcom/datadog/android/flags/FlagsClient;", "name", "", "reason", "logWithPolicy", "Lkotlin/Function2;", "Lcom/datadog/android/api/InternalLogger$Level;", "", "Lcom/datadog/android/flags/internal/LogWithPolicy;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "state", "Lcom/datadog/android/flags/StateObservable;", "getState", "()Lcom/datadog/android/flags/StateObservable;", "logOperation", "operation", FirebaseAnalytics.Param.LEVEL, "resolve", "Lcom/datadog/android/flags/model/ResolutionDetails;", ExifInterface.GPS_DIRECTION_TRUE, "", "flagKey", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/datadog/android/flags/model/ResolutionDetails;", "resolveBooleanValue", "", "resolveDoubleValue", "", "resolveIntValue", "", "resolveStringValue", "resolveStructureValue", "", "Lorg/json/JSONObject;", "setEvaluationContext", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "callback", "Lcom/datadog/android/flags/EvaluationContextCallback;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpFlagsClient implements FlagsClient {
    private final Function2<String, InternalLogger.Level, Unit> logWithPolicy;
    private final String name;
    private final String reason;
    private final StateObservable state;

    /* JADX WARN: Multi-variable type inference failed */
    public NoOpFlagsClient(String name, String reason, Function2<? super String, ? super InternalLogger.Level, Unit> logWithPolicy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(logWithPolicy, "logWithPolicy");
        this.name = name;
        this.reason = reason;
        this.logWithPolicy = logWithPolicy;
        this.state = new StateObservable() { // from class: com.datadog.android.flags.internal.NoOpFlagsClient$state$1
            @Override // com.datadog.android.flags.StateObservable
            public void addListener(FlagsStateListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
            }

            @Override // com.datadog.android.flags.StateObservable
            public void removeListener(FlagsStateListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
            }

            @Override // com.datadog.android.flags.StateObservable
            public FlagsClientState getCurrentState() {
                return FlagsClientState.NotReady.INSTANCE;
            }
        };
    }

    @Override // com.datadog.android.flags.FlagsClient
    public StateObservable getState() {
        return this.state;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public void setEvaluationContext(EvaluationContext context, EvaluationContextCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        logOperation("setEvaluationContext", InternalLogger.Level.WARN);
        if (callback != null) {
            callback.onSuccess();
        }
    }

    @Override // com.datadog.android.flags.FlagsClient
    public boolean resolveBooleanValue(String flagKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        logOperation("resolveBooleanValue for flag '" + flagKey + "'", InternalLogger.Level.WARN);
        return defaultValue;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public String resolveStringValue(String flagKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        logOperation("resolveStringValue for flag '" + flagKey + "'", InternalLogger.Level.WARN);
        return defaultValue;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public double resolveDoubleValue(String flagKey, double defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        logOperation("resolveDoubleValue for flag '" + flagKey + "'", InternalLogger.Level.WARN);
        return defaultValue;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public int resolveIntValue(String flagKey, int defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        logOperation("resolveIntValue for flag '" + flagKey + "'", InternalLogger.Level.WARN);
        return defaultValue;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public <T> ResolutionDetails<T> resolve(String flagKey, T defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        logOperation("resolve for flag '" + flagKey + "'", InternalLogger.Level.WARN);
        return new ResolutionDetails<>(defaultValue, null, null, ErrorCode.PROVIDER_NOT_READY, "Provider not ready - using fallback client", null, 38, null);
    }

    @Override // com.datadog.android.flags.FlagsClient
    public JSONObject resolveStructureValue(String flagKey, JSONObject defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        logOperation("resolveStructureValue for flag '" + flagKey + "'", InternalLogger.Level.WARN);
        return defaultValue;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public Map<String, Object> resolveStructureValue(String flagKey, Map<String, ? extends Object> defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        logOperation("resolveStructureValue for flag '" + flagKey + "'", InternalLogger.Level.WARN);
        return defaultValue;
    }

    private final void logOperation(String operation, InternalLogger.Level level) {
        Function2<String, InternalLogger.Level, Unit> function2 = this.logWithPolicy;
        String str = this.name;
        function2.invoke(operation + " called on NoOpFlagsClient for client '" + str + "' (reason: " + this.reason + "). Ensure that a FlagsClient named '" + str + "' is created with FlagsClient.Builder(\"" + str + "\").build() before using it.", level);
    }
}
