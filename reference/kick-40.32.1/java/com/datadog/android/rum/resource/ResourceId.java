package com.datadog.android.rum.resource;

import expo.modules.notifications.serverregistration.InstallationId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResourceId.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/resource/ResourceId;", "", "key", "", InstallationId.LEGACY_PREFERENCES_UUID_KEY, "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getUuid", "equals", "", "other", "hashCode", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceId {
    private final String key;
    private final String uuid;

    public ResourceId(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.uuid = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public boolean equals(Object other) {
        ResourceId resourceId;
        String str;
        if (!(other instanceof ResourceId)) {
            return false;
        }
        String str2 = this.uuid;
        if (str2 == null || StringsKt.isBlank(str2) || (str = (resourceId = (ResourceId) other).uuid) == null || StringsKt.isBlank(str)) {
            return Intrinsics.areEqual(this.key, ((ResourceId) other).key);
        }
        return Intrinsics.areEqual(this.uuid, resourceId.uuid) && Intrinsics.areEqual(this.key, resourceId.key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }
}
