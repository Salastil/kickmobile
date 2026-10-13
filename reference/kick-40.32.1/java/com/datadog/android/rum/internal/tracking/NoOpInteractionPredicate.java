package com.datadog.android.rum.internal.tracking;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.rum.tracking.InteractionPredicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpInteractionPredicate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/tracking/NoOpInteractionPredicate;", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "()V", "equals", "", "other", "", "getTargetName", "", TypedValues.Attributes.S_TARGET, "hashCode", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpInteractionPredicate implements InteractionPredicate {
    @Override // com.datadog.android.rum.tracking.InteractionPredicate
    public String getTargetName(Object target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object other) {
        return other instanceof NoOpInteractionPredicate;
    }
}
