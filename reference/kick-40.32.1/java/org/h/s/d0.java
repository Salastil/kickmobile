package org.h.s;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u000b"}, d2 = {"Lorg/h/s/d0;", "", "", "Lorg/h/s/f3;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "remoteConfig", "Lorg/h/s/b0;", "featureFlags", "sdk_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @SerializedName("remoteConfig")
    private final List<f3> remoteConfig;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @SerializedName("featureFlags")
    private final List<b0> featureFlags;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final List getFeatureFlags() {
        return this.featureFlags;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final List getRemoteConfig() {
        return this.remoteConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return Intrinsics.areEqual(this.remoteConfig, d0Var.remoteConfig) && Intrinsics.areEqual(this.featureFlags, d0Var.featureFlags);
    }

    public final int hashCode() {
        return this.featureFlags.hashCode() + (this.remoteConfig.hashCode() * 31);
    }

    public final String toString() {
        return "FlagAndConfigResponse(remoteConfig=" + this.remoteConfig + ", featureFlags=" + this.featureFlags + ")";
    }
}
