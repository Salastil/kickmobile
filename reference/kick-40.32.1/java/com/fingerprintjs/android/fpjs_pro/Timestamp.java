package com.fingerprintjs.android.fpjs_pro;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/Timestamp;", "", "", "global", FirebaseAnalytics.Param.SUBSCRIPTION, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro/Timestamp;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getGlobal", "getSubscription"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Timestamp {
    private final String global;
    private final String subscription;

    public Timestamp(String str, String str2) {
        this.global = str;
        this.subscription = str2;
    }

    public final String getGlobal() {
        return this.global;
    }

    public final String getSubscription() {
        return this.subscription;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Timestamp)) {
            return false;
        }
        Timestamp timestamp = (Timestamp) other;
        return Intrinsics.areEqual(this.global, timestamp.global) && Intrinsics.areEqual(this.subscription, timestamp.subscription);
    }

    public final int hashCode() {
        return (this.global.hashCode() * 31) + this.subscription.hashCode();
    }

    public final String toString() {
        return "Timestamp(global=" + this.global + ", subscription=" + this.subscription + ")";
    }

    public static /* synthetic */ Timestamp copy$default(Timestamp timestamp, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timestamp.global;
        }
        if ((i & 2) != 0) {
            str2 = timestamp.subscription;
        }
        return timestamp.copy(str, str2);
    }

    public final Timestamp copy(String global, String subscription) {
        return new Timestamp(global, subscription);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubscription() {
        return this.subscription;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGlobal() {
        return this.global;
    }
}
