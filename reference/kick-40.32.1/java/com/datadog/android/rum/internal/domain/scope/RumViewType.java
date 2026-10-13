package com.datadog.android.rum.internal.domain.scope;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.trace.api.config.ProfilingConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumViewType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", "", "asString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAsString", "()Ljava/lang/String;", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "FOREGROUND", "BACKGROUND", "APPLICATION_LAUNCH", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum RumViewType {
    NONE(ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT),
    FOREGROUND("FOREGROUND"),
    BACKGROUND("BACKGROUND"),
    APPLICATION_LAUNCH("APPLICATION_LAUNCH");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String asString;

    RumViewType(String str) {
        this.asString = str;
    }

    public final String getAsString() {
        return this.asString;
    }

    /* JADX INFO: compiled from: RumViewType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewType$Companion;", "", "()V", "fromString", "Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", TypedValues.Custom.S_STRING, "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumViewType fromString(String string) {
            for (RumViewType rumViewType : RumViewType.values()) {
                if (Intrinsics.areEqual(rumViewType.getAsString(), string)) {
                    return rumViewType;
                }
            }
            return null;
        }
    }
}
