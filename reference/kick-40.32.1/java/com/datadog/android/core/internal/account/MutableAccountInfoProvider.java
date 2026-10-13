package com.datadog.android.core.internal.account;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: MutableAccountInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J0\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H&¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/account/MutableAccountInfoProvider;", "Lcom/datadog/android/core/internal/account/AccountInfoProvider;", "addExtraInfo", "", "extraInfo", "", "", "", "clearAccountInfo", "setAccountInfo", "id", "name", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MutableAccountInfoProvider extends AccountInfoProvider {
    void addExtraInfo(Map<String, ? extends Object> extraInfo);

    void clearAccountInfo();

    void setAccountInfo(String id, String name, Map<String, ? extends Object> extraInfo);
}
