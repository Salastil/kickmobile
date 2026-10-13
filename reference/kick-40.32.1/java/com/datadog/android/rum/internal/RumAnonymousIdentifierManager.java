package com.datadog.android.rum.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumAnonymousIdentifierManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/internal/RumAnonymousIdentifierManager;", "", "dataStore", "Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "core", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "(Lcom/datadog/android/api/storage/datastore/DataStoreHandler;Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "clearAnonymousId", "", "createAndStoreAnonymousId", "handleAnonymousIdTracking", "manageAnonymousId", "shouldTrack", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumAnonymousIdentifierManager {
    private static final String ANONYMOUS_ID_KEY = "anonymous_id_key";
    private final FeatureSdkCore core;
    private final DataStoreHandler dataStore;

    public RumAnonymousIdentifierManager(DataStoreHandler dataStore, FeatureSdkCore core) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(core, "core");
        this.dataStore = dataStore;
        this.core = core;
    }

    public final void manageAnonymousId(boolean shouldTrack) {
        DataStoreHandler dataStoreHandler = this.dataStore;
        if (shouldTrack) {
            handleAnonymousIdTracking(dataStoreHandler, this.core);
        } else {
            clearAnonymousId(dataStoreHandler, this.core);
        }
    }

    private final void handleAnonymousIdTracking(final DataStoreHandler dataStore, final FeatureSdkCore core) {
        dataStore.value(ANONYMOUS_ID_KEY, null, new AnonymousIdentifierReadCallback(new Function1<UUID, Unit>() { // from class: com.datadog.android.rum.internal.RumAnonymousIdentifierManager.handleAnonymousIdTracking.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UUID uuid) {
                invoke2(uuid);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UUID uuid) {
                if (uuid == null) {
                    RumAnonymousIdentifierManager.this.createAndStoreAnonymousId(dataStore, core);
                } else {
                    core.setAnonymousId(uuid);
                }
            }
        }), new AnonymousIdentifierDeserializer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAndStoreAnonymousId(DataStoreHandler dataStore, FeatureSdkCore core) {
        UUID newAnonymousId = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(newAnonymousId, "newAnonymousId");
        dataStore.setValue(ANONYMOUS_ID_KEY, newAnonymousId, 0, null, new AnonymousIdentifierSerializer());
        core.setAnonymousId(newAnonymousId);
    }

    private final void clearAnonymousId(DataStoreHandler dataStore, FeatureSdkCore core) {
        DataStoreHandler.DefaultImpls.removeValue$default(dataStore, ANONYMOUS_ID_KEY, null, 2, null);
        core.setAnonymousId(null);
    }
}
