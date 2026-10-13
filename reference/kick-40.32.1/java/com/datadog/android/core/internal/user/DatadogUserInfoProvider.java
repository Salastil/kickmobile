package com.datadog.android.core.internal.user;

import com.datadog.android.api.context.UserInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogUserInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J:\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/core/internal/user/DatadogUserInfoProvider;", "Lcom/datadog/android/core/internal/user/MutableUserInfoProvider;", "()V", "internalUserInfo", "Lcom/datadog/android/api/context/UserInfo;", "addUserProperties", "", "properties", "", "", "", "clearUserInfo", "getUserInfo", "setAnonymousId", "id", "setUserInfo", "name", "email", "extraInfo", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogUserInfoProvider implements MutableUserInfoProvider {
    private volatile UserInfo internalUserInfo = new UserInfo(null, null, null, null, null, 31, null);

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setUserInfo(String id, String name, String email, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.internalUserInfo = UserInfo.copy$default(this.internalUserInfo, null, id, name, email, MapsKt.toMap(extraInfo), 1, null);
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setAnonymousId(String id) {
        this.internalUserInfo = UserInfo.copy$default(this.internalUserInfo, id, null, null, null, null, 30, null);
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void addUserProperties(Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.internalUserInfo = UserInfo.copy$default(this.internalUserInfo, null, null, null, null, MapsKt.plus(this.internalUserInfo.getAdditionalProperties(), properties), 15, null);
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void clearUserInfo() {
        this.internalUserInfo = new UserInfo(this.internalUserInfo.getAnonymousId(), null, null, null, null, 30, null);
    }

    @Override // com.datadog.android.core.internal.user.UserInfoProvider
    /* JADX INFO: renamed from: getUserInfo, reason: from getter */
    public UserInfo getInternalUserInfo() {
        return this.internalUserInfo;
    }
}
