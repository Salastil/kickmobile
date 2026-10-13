package com.datadog.android.flags.internal.repository;

import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpFlagsRepository.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/flags/internal/repository/NoOpFlagsRepository;", "Lcom/datadog/android/flags/internal/repository/FlagsRepository;", "()V", "getEvaluationContext", "Lcom/datadog/android/flags/model/EvaluationContext;", "getFlagsSnapshot", "", "", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "getPrecomputedFlag", "key", "getPrecomputedFlagWithContext", "Lkotlin/Pair;", "hasFlags", "", "setFlagsAndContext", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "flags", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpFlagsRepository implements FlagsRepository {
    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public EvaluationContext getEvaluationContext() {
        return null;
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public PrecomputedFlag getPrecomputedFlag(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public Pair<PrecomputedFlag, EvaluationContext> getPrecomputedFlagWithContext(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public boolean hasFlags() {
        return false;
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public void setFlagsAndContext(EvaluationContext context, Map<String, PrecomputedFlag> flags) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flags, "flags");
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public Map<String, PrecomputedFlag> getFlagsSnapshot() {
        return MapsKt.emptyMap();
    }
}
