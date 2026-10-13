package com.facebook.react.util;

import android.content.Context;
import android.os.Build;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidVersion.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/util/AndroidVersion;", "", "<init>", "()V", "VERSION_CODE_VANILLA_ICE_CREAM", "", "VERSION_CODE_BAKLAVA", "VERSION_CODE_CINNAMON_BUN", "ATTR_WINDOW_OPT_OUT_EDGE_TO_EDGE_ENFORCEMENT", "isAtLeastTargetSdk35", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "isAtLeastTargetSdk35$ReactAndroid", "isAtLeastTargetSdk36", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidVersion {
    public static final int ATTR_WINDOW_OPT_OUT_EDGE_TO_EDGE_ENFORCEMENT = 16844442;
    public static final AndroidVersion INSTANCE = new AndroidVersion();
    public static final int VERSION_CODE_BAKLAVA = 36;
    public static final int VERSION_CODE_CINNAMON_BUN = 37;
    public static final int VERSION_CODE_VANILLA_ICE_CREAM = 35;

    private AndroidVersion() {
    }

    @JvmStatic
    public static final boolean isAtLeastTargetSdk35$ReactAndroid(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 35 && context.getApplicationInfo().targetSdkVersion >= 35;
    }

    @JvmStatic
    public static final boolean isAtLeastTargetSdk36(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 36 && context.getApplicationInfo().targetSdkVersion >= 36;
    }
}
