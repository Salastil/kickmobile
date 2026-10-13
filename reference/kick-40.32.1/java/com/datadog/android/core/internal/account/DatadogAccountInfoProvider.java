package com.datadog.android.core.internal.account;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.AccountInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogAccountInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/core/internal/account/DatadogAccountInfoProvider;", "Lcom/datadog/android/core/internal/account/MutableAccountInfoProvider;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "internalAccountInfo", "Lcom/datadog/android/api/context/AccountInfo;", "addExtraInfo", "", "extraInfo", "", "", "", "clearAccountInfo", "getAccountInfo", "setAccountInfo", "id", "name", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogAccountInfoProvider implements MutableAccountInfoProvider {
    public static final String MSG_ACCOUNT_NULL = "Failed to add Account ExtraInfo because no Account Info exist yet. Please call `setAccountInfo` first.";
    private volatile AccountInfo internalAccountInfo;
    private final InternalLogger internalLogger;

    public DatadogAccountInfoProvider(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.account.MutableAccountInfoProvider
    public void setAccountInfo(String id, String name, Map<String, ? extends Object> extraInfo) {
        AccountInfo accountInfo;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        AccountInfo accountInfo2 = this.internalAccountInfo;
        if (accountInfo2 == null || (accountInfo = accountInfo2.copy(id, name, MapsKt.toMap(extraInfo))) == null) {
            accountInfo = new AccountInfo(id, name, MapsKt.toMap(extraInfo));
        }
        this.internalAccountInfo = accountInfo;
    }

    @Override // com.datadog.android.core.internal.account.MutableAccountInfoProvider
    public void addExtraInfo(Map<String, ? extends Object> extraInfo) {
        Unit unit;
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        AccountInfo accountInfo = this.internalAccountInfo;
        if (accountInfo != null) {
            this.internalAccountInfo = AccountInfo.copy$default(accountInfo, null, null, MapsKt.plus(accountInfo.getExtraInfo(), extraInfo), 3, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.account.DatadogAccountInfoProvider$addExtraInfo$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogAccountInfoProvider.MSG_ACCOUNT_NULL;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.core.internal.account.MutableAccountInfoProvider
    public void clearAccountInfo() {
        this.internalAccountInfo = null;
    }

    @Override // com.datadog.android.core.internal.account.AccountInfoProvider
    /* JADX INFO: renamed from: getAccountInfo, reason: from getter */
    public AccountInfo getInternalAccountInfo() {
        return this.internalAccountInfo;
    }
}
