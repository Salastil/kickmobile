package com.datadog.android.core.internal.user;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: MutableUserInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&J:\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/user/MutableUserInfoProvider;", "Lcom/datadog/android/core/internal/user/UserInfoProvider;", "addUserProperties", "", "properties", "", "", "", "clearUserInfo", "setAnonymousId", "id", "setUserInfo", "name", "email", "extraInfo", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MutableUserInfoProvider extends UserInfoProvider {
    void addUserProperties(Map<String, ? extends Object> properties);

    void clearUserInfo();

    void setAnonymousId(String id);

    void setUserInfo(String id, String name, String email, Map<String, ? extends Object> extraInfo);
}
