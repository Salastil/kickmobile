package com.datadog.android.rum.internal;

import com.datadog.android.core.internal.persistence.Deserializer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumAnonymousIdentifierManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/AnonymousIdentifierDeserializer;", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "", "Ljava/util/UUID;", "()V", "deserialize", "model", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnonymousIdentifierDeserializer implements Deserializer<String, UUID> {
    @Override // com.datadog.android.core.internal.persistence.Deserializer
    public UUID deserialize(String model) {
        Intrinsics.checkNotNullParameter(model, "model");
        try {
            return UUID.fromString(model);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
