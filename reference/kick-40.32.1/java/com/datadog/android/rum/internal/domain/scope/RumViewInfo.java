package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.rum.internal.RumFeature;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumViewChangedListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewInfo;", "", "key", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "isActive", "", "(Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;Ljava/util/Map;Z)V", "getAttributes", "()Ljava/util/Map;", "()Z", "getKey", "()Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumViewInfo {
    private final Map<String, Object> attributes;
    private final boolean isActive;
    private final RumScopeKey key;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RumViewInfo copy$default(RumViewInfo rumViewInfo, RumScopeKey rumScopeKey, Map map, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            rumScopeKey = rumViewInfo.key;
        }
        if ((i & 2) != 0) {
            map = rumViewInfo.attributes;
        }
        if ((i & 4) != 0) {
            z = rumViewInfo.isActive;
        }
        return rumViewInfo.copy(rumScopeKey, map, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RumScopeKey getKey() {
        return this.key;
    }

    public final Map<String, Object> component2() {
        return this.attributes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final RumViewInfo copy(RumScopeKey key, Map<String, ? extends Object> attributes, boolean isActive) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new RumViewInfo(key, attributes, isActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumViewInfo)) {
            return false;
        }
        RumViewInfo rumViewInfo = (RumViewInfo) other;
        return Intrinsics.areEqual(this.key, rumViewInfo.key) && Intrinsics.areEqual(this.attributes, rumViewInfo.attributes) && this.isActive == rumViewInfo.isActive;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.attributes.hashCode()) * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        return "RumViewInfo(key=" + this.key + ", attributes=" + this.attributes + ", isActive=" + this.isActive + ")";
    }

    public RumViewInfo(RumScopeKey key, Map<String, ? extends Object> attributes, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.key = key;
        this.attributes = attributes;
        this.isActive = z;
    }

    public final RumScopeKey getKey() {
        return this.key;
    }

    public final Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public final boolean isActive() {
        return this.isActive;
    }
}
