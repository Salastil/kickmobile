package com.datadog.android.core.internal.user;

import com.datadog.android.api.context.UserInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpMutableUserInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J:\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/core/internal/user/NoOpMutableUserInfoProvider;", "Lcom/datadog/android/core/internal/user/MutableUserInfoProvider;", "()V", "addUserProperties", "", "properties", "", "", "", "clearUserInfo", "getUserInfo", "Lcom/datadog/android/api/context/UserInfo;", "setAnonymousId", "id", "setUserInfo", "name", "email", "extraInfo", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpMutableUserInfoProvider implements MutableUserInfoProvider {
    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void addUserProperties(Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void clearUserInfo() {
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setAnonymousId(String id) {
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setUserInfo(String id, String name, String email, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.core.internal.user.UserInfoProvider
    public UserInfo getUserInfo() {
        return new UserInfo(null, null, null, null, null, 31, null);
    }
}
