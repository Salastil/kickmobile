package com.datadog.android.core.internal.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadSafeReceiver.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/core/internal/receiver/ThreadSafeReceiver;", "Landroid/content/BroadcastReceiver;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "isRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "registerReceiver", "Landroid/content/Intent;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", ViewProps.FILTER, "Landroid/content/IntentFilter;", "handler", "Landroid/os/Handler;", "unregisterReceiver", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ThreadSafeReceiver extends BroadcastReceiver {
    public static final int RECEIVER_NOT_EXPORTED_COMPAT = 4;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private final AtomicBoolean isRegistered;

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadSafeReceiver() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ThreadSafeReceiver(BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    public ThreadSafeReceiver(BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.isRegistered = new AtomicBoolean(false);
    }

    /* JADX INFO: renamed from: isRegistered, reason: from getter */
    public final AtomicBoolean getIsRegistered() {
        return this.isRegistered;
    }

    public final Intent registerReceiver(Context context, IntentFilter filter, Handler handler) {
        Intent intentRegisterReceiver;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.buildSdkVersionProvider.getIsAtLeastTiramisu() || this.buildSdkVersionProvider.getIsAtLeastO()) {
            intentRegisterReceiver = context.registerReceiver(this, filter, null, handler, 4);
        } else {
            intentRegisterReceiver = context.registerReceiver(this, filter, null, handler);
        }
        this.isRegistered.set(true);
        return intentRegisterReceiver;
    }

    public final void unregisterReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isRegistered.compareAndSet(true, false)) {
            context.unregisterReceiver(this);
        }
    }
}
