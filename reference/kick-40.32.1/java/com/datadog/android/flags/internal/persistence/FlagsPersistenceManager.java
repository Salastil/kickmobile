package com.datadog.android.flags.internal.persistence;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.core.persistence.datastore.DataStoreContent;
import com.datadog.android.flags.internal.model.FlagsStateEntry;
import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlagsPersistenceManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u001e\u0010\u0012\u001a\u00020\u000b2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J=\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/flags/internal/persistence/FlagsPersistenceManager;", "", "dataStore", "Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "instanceName", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "onStateLoaded", "Lkotlin/Function1;", "Lcom/datadog/android/flags/internal/model/FlagsStateEntry;", "", "(Lcom/datadog/android/api/storage/datastore/DataStoreHandler;Ljava/lang/String;Lcom/datadog/android/api/InternalLogger;Lkotlin/jvm/functions/Function1;)V", "deserializer", "Lcom/datadog/android/flags/internal/persistence/FlagsStateDeserializer;", "flagsStateKey", "serializer", "Lcom/datadog/android/flags/internal/persistence/FlagsStateSerializer;", "loadFlagsState", "saveFlagsState", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "flags", "", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "currentTimestamp", "", "callback", "Lcom/datadog/android/api/storage/datastore/DataStoreWriteCallback;", "saveFlagsState$dd_sdk_android_flags_release", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlagsPersistenceManager {
    private static final String FLAGS_STATE_KEY_PREFIX = "flags-state";
    private final DataStoreHandler dataStore;
    private final FlagsStateDeserializer deserializer;
    private final String flagsStateKey;
    private final InternalLogger internalLogger;
    private final FlagsStateSerializer serializer;

    public FlagsPersistenceManager(DataStoreHandler dataStore, String instanceName, InternalLogger internalLogger, Function1<? super FlagsStateEntry, Unit> onStateLoaded) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(onStateLoaded, "onStateLoaded");
        this.dataStore = dataStore;
        this.internalLogger = internalLogger;
        this.serializer = new FlagsStateSerializer(internalLogger);
        this.deserializer = new FlagsStateDeserializer(internalLogger);
        this.flagsStateKey = "flags-state-" + instanceName;
        loadFlagsState(onStateLoaded);
    }

    public static /* synthetic */ void saveFlagsState$dd_sdk_android_flags_release$default(FlagsPersistenceManager flagsPersistenceManager, EvaluationContext evaluationContext, Map map, long j, DataStoreWriteCallback dataStoreWriteCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            dataStoreWriteCallback = null;
        }
        flagsPersistenceManager.saveFlagsState$dd_sdk_android_flags_release(evaluationContext, map, j, dataStoreWriteCallback);
    }

    public final void saveFlagsState$dd_sdk_android_flags_release(EvaluationContext context, Map<String, PrecomputedFlag> flags, long currentTimestamp, DataStoreWriteCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flags, "flags");
        DataStoreHandler.DefaultImpls.setValue$default(this.dataStore, this.flagsStateKey, new FlagsStateEntry(context, flags, currentTimestamp), 0, callback, this.serializer, 4, null);
    }

    private final void loadFlagsState(final Function1<? super FlagsStateEntry, Unit> onStateLoaded) {
        DataStoreHandler.DefaultImpls.value$default(this.dataStore, this.flagsStateKey, null, new DataStoreReadCallback<FlagsStateEntry>() { // from class: com.datadog.android.flags.internal.persistence.FlagsPersistenceManager.loadFlagsState.1
            @Override // com.datadog.android.api.storage.datastore.DataStoreReadCallback
            public void onSuccess(DataStoreContent<FlagsStateEntry> dataStoreContent) {
                onStateLoaded.invoke(dataStoreContent != null ? dataStoreContent.getData() : null);
            }

            @Override // com.datadog.android.api.storage.datastore.DataStoreReadCallback
            public void onFailure() {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.persistence.FlagsPersistenceManager$loadFlagsState$1$onFailure$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "No persisted flags state found or failed to load";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                onStateLoaded.invoke(null);
            }
        }, this.deserializer, 2, null);
    }
}
