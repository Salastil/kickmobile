package com.datadog.android.rum.internal;

import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.core.persistence.datastore.DataStoreContent;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumAnonymousIdentifierManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/AnonymousIdentifierReadCallback;", "Lcom/datadog/android/api/storage/datastore/DataStoreReadCallback;", "Ljava/util/UUID;", "onFinished", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onFailure", "onSuccess", "dataStoreContent", "Lcom/datadog/android/core/persistence/datastore/DataStoreContent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnonymousIdentifierReadCallback implements DataStoreReadCallback<UUID> {
    private final Function1<UUID, Unit> onFinished;

    /* JADX WARN: Multi-variable type inference failed */
    public AnonymousIdentifierReadCallback(Function1<? super UUID, Unit> onFinished) {
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        this.onFinished = onFinished;
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreReadCallback
    public void onSuccess(DataStoreContent<UUID> dataStoreContent) {
        this.onFinished.invoke(dataStoreContent != null ? dataStoreContent.getData() : null);
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreReadCallback
    public void onFailure() {
        this.onFinished.invoke(null);
    }
}
