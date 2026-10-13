package com.datadog.android.core.internal.system;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppVersionProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/system/AppVersionProvider;", "", "version", "", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "versionCode", "", "getVersionCode", "()I", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AppVersionProvider {
    String getVersion();

    int getVersionCode();

    void setVersion(String str);
}
