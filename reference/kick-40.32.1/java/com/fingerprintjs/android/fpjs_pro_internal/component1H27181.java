package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "", "", "p0", "p1", "<init>", "(JJ)V", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "vD14832N6715", "J", "D8871", "component5"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class component1H27181 {

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: D8871, reason: from kotlin metadata */
    public final long component5;
    public final long vD14832N6715;

    public component1H27181(long j, long j2) {
        this.component5 = j;
        this.vD14832N6715 = j2;
    }

    public final String toString() {
        return "";
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.component1H27181$component5, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181$component5;", "", "<init>", "()V", "Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;", "setPivotYN16904", "()Lcom/fingerprintjs/android/fpjs_pro_internal/component1H27181;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public static component1H27181 setPivotYN16904() {
            return new component1H27181(0L, 0L);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (!(p0 instanceof component1H27181)) {
            return false;
        }
        component1H27181 component1h27181 = (component1H27181) p0;
        return this.component5 == component1h27181.component5 && this.vD14832N6715 == component1h27181.vD14832N6715;
    }

    public final int hashCode() {
        return (Long.hashCode(this.component5) * 31) + Long.hashCode(this.vD14832N6715);
    }
}
