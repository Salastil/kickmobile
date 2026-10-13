package com.datadog.android.core.internal.account;

import com.datadog.android.api.context.AccountInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpMutableAccountInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/account/NoOpMutableAccountInfoProvider;", "Lcom/datadog/android/core/internal/account/MutableAccountInfoProvider;", "()V", "addExtraInfo", "", "extraInfo", "", "", "", "clearAccountInfo", "getAccountInfo", "Lcom/datadog/android/api/context/AccountInfo;", "setAccountInfo", "id", "name", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpMutableAccountInfoProvider implements MutableAccountInfoProvider {
    @Override // com.datadog.android.core.internal.account.MutableAccountInfoProvider
    public void addExtraInfo(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.core.internal.account.MutableAccountInfoProvider
    public void clearAccountInfo() {
    }

    @Override // com.datadog.android.core.internal.account.AccountInfoProvider
    public AccountInfo getAccountInfo() {
        return null;
    }

    @Override // com.datadog.android.core.internal.account.MutableAccountInfoProvider
    public void setAccountInfo(String id, String name, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }
}
