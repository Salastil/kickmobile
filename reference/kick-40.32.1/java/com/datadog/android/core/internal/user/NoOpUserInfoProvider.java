package com.datadog.android.core.internal.user;

import com.datadog.android.api.context.UserInfo;
import kotlin.Metadata;

/* JADX INFO: compiled from: NoOpUserInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/internal/user/NoOpUserInfoProvider;", "Lcom/datadog/android/core/internal/user/UserInfoProvider;", "()V", "getUserInfo", "Lcom/datadog/android/api/context/UserInfo;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpUserInfoProvider implements UserInfoProvider {
    @Override // com.datadog.android.core.internal.user.UserInfoProvider
    public UserInfo getUserInfo() {
        return new UserInfo(null, null, null, null, null, 31, null);
    }
}
