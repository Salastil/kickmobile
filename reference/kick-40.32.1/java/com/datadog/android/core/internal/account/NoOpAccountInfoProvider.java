package com.datadog.android.core.internal.account;

import com.datadog.android.api.context.AccountInfo;
import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpAccountInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/internal/account/NoOpAccountInfoProvider;", "Lcom/datadog/android/core/internal/account/AccountInfoProvider;", "()V", "getAccountInfo", "Lcom/datadog/android/api/context/AccountInfo;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpAccountInfoProvider implements AccountInfoProvider {
    @Override // com.datadog.android.core.internal.account.AccountInfoProvider
    public AccountInfo getAccountInfo() {
        return null;
    }
}
