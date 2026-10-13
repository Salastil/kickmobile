package com.datadog.android.rum.internal.domain.accessibility;

import android.content.Context;
import android.provider.Settings;
import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/domain/accessibility/GlobalWrapper;", "", "()V", "getFloat", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "applicationContext", "Landroid/content/Context;", "key", "", "getFloat$dd_sdk_android_rum_release", "(Lcom/datadog/android/api/InternalLogger;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Float;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalWrapper {
    public final Float getFloat$dd_sdk_android_rum_release(InternalLogger internalLogger, Context applicationContext, final String key) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return Float.valueOf(Settings.Global.getFloat(applicationContext.getContentResolver(), key));
        } catch (Settings.SettingNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf(InternalLogger.Target.MAINTAINER), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.accessibility.GlobalWrapper$getFloat$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Setting not found " + key;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
