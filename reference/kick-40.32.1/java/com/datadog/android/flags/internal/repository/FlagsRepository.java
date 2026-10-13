package com.datadog.android.flags.internal.repository;

import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: FlagsRepository.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006H&J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\rH&J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/internal/repository/FlagsRepository;", "", "getEvaluationContext", "Lcom/datadog/android/flags/model/EvaluationContext;", "getFlagsSnapshot", "", "", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "getPrecomputedFlag", "key", "getPrecomputedFlagWithContext", "Lkotlin/Pair;", "hasFlags", "", "setFlagsAndContext", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "flags", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlagsRepository {
    EvaluationContext getEvaluationContext();

    Map<String, PrecomputedFlag> getFlagsSnapshot();

    PrecomputedFlag getPrecomputedFlag(String key);

    Pair<PrecomputedFlag, EvaluationContext> getPrecomputedFlagWithContext(String key);

    boolean hasFlags();

    void setFlagsAndContext(EvaluationContext context, Map<String, PrecomputedFlag> flags);
}
