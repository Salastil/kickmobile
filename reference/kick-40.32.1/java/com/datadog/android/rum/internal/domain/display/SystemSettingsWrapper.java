package com.datadog.android.rum.internal.domain.display;

import android.content.Context;
import android.provider.Settings;
import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemSettingsWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/display/SystemSettingsWrapper;", "", "applicationContext", "Landroid/content/Context;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Landroid/content/Context;Lcom/datadog/android/api/InternalLogger;)V", "getInt", "", "name", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SystemSettingsWrapper {
    private final Context applicationContext;
    private final InternalLogger internalLogger;

    public SystemSettingsWrapper(Context applicationContext, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.applicationContext = applicationContext;
        this.internalLogger = internalLogger;
    }

    public final int getInt(final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            return Settings.System.getInt(this.applicationContext.getContentResolver(), name);
        } catch (Settings.SettingNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.display.SystemSettingsWrapper.getInt.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Problem retrieving system value for " + name;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return Integer.MIN_VALUE;
        } catch (RuntimeException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.display.SystemSettingsWrapper.getInt.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Problem retrieving system value for " + name;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return Integer.MIN_VALUE;
        }
    }
}
