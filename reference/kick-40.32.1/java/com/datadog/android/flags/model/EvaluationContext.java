package com.datadog.android.flags.model;

import com.datadog.android.rum.internal.RumFeature;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationContext.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/flags/model/EvaluationContext;", "", "targetingKey", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "(Ljava/lang/String;Ljava/util/Map;)V", "getAttributes", "()Ljava/util/Map;", "getTargetingKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final EvaluationContext EMPTY = new EvaluationContext("", 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    private final Map<String, String> attributes;
    private final String targetingKey;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EvaluationContext copy$default(EvaluationContext evaluationContext, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = evaluationContext.targetingKey;
        }
        if ((i & 2) != 0) {
            map = evaluationContext.attributes;
        }
        return evaluationContext.copy(str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTargetingKey() {
        return this.targetingKey;
    }

    public final Map<String, String> component2() {
        return this.attributes;
    }

    public final EvaluationContext copy(String targetingKey, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new EvaluationContext(targetingKey, attributes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationContext)) {
            return false;
        }
        EvaluationContext evaluationContext = (EvaluationContext) other;
        return Intrinsics.areEqual(this.targetingKey, evaluationContext.targetingKey) && Intrinsics.areEqual(this.attributes, evaluationContext.attributes);
    }

    public int hashCode() {
        return (this.targetingKey.hashCode() * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "EvaluationContext(targetingKey=" + this.targetingKey + ", attributes=" + this.attributes + ")";
    }

    public EvaluationContext(String targetingKey, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.targetingKey = targetingKey;
        this.attributes = attributes;
    }

    public final String getTargetingKey() {
        return this.targetingKey;
    }

    public /* synthetic */ EvaluationContext(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getAttributes() {
        return this.attributes;
    }

    /* JADX INFO: compiled from: EvaluationContext.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/flags/model/EvaluationContext$Companion;", "", "()V", "EMPTY", "Lcom/datadog/android/flags/model/EvaluationContext;", "getEMPTY", "()Lcom/datadog/android/flags/model/EvaluationContext;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EvaluationContext getEMPTY() {
            return EvaluationContext.EMPTY;
        }
    }
}
