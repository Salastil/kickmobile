package com.datadog.android.core.internal.system;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultAppVersionProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/system/DefaultAppVersionProvider;", "Lcom/datadog/android/core/internal/system/AppVersionProvider;", "initialVersion", "", "versionCode", "", "(Ljava/lang/String;I)V", "value", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "version", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getVersionCode", "()I", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultAppVersionProvider implements AppVersionProvider {
    private final AtomicReference<String> value;
    private final int versionCode;

    public DefaultAppVersionProvider(String initialVersion, int i) {
        Intrinsics.checkNotNullParameter(initialVersion, "initialVersion");
        this.versionCode = i;
        this.value = new AtomicReference<>(initialVersion);
    }

    @Override // com.datadog.android.core.internal.system.AppVersionProvider
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.datadog.android.core.internal.system.AppVersionProvider
    public String getVersion() {
        String str = this.value.get();
        Intrinsics.checkNotNullExpressionValue(str, "value.get()");
        return str;
    }

    @Override // com.datadog.android.core.internal.system.AppVersionProvider
    public void setVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value.set(value);
    }
}
