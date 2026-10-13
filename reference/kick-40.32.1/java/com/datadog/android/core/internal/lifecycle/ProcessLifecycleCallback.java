package com.datadog.android.core.internal.lifecycle;

import android.content.Context;
import androidx.work.WorkManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.WorkManagerUtilsKt;
import com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProcessLifecycleCallback.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleCallback;", "Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "appContext", "Landroid/content/Context;", "instanceName", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Landroid/content/Context;Ljava/lang/String;Lcom/datadog/android/api/InternalLogger;)V", "contextWeakRef", "Ljava/lang/ref/Reference;", "getContextWeakRef$dd_sdk_android_core_release", "()Ljava/lang/ref/Reference;", "getInstanceName$dd_sdk_android_core_release", "()Ljava/lang/String;", "onPaused", "", "onResumed", "onStarted", "onStopped", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessLifecycleCallback implements ProcessLifecycleMonitor.Callback {
    private final Reference<Context> contextWeakRef;
    private final String instanceName;
    private final InternalLogger internalLogger;

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onPaused() {
    }

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onResumed() {
    }

    public ProcessLifecycleCallback(Context appContext, String instanceName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.instanceName = instanceName;
        this.internalLogger = internalLogger;
        this.contextWeakRef = new WeakReference(appContext);
    }

    /* JADX INFO: renamed from: getInstanceName$dd_sdk_android_core_release, reason: from getter */
    public final String getInstanceName() {
        return this.instanceName;
    }

    public final Reference<Context> getContextWeakRef$dd_sdk_android_core_release() {
        return this.contextWeakRef;
    }

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStarted() {
        Context context = this.contextWeakRef.get();
        if (context == null || !WorkManager.isInitialized()) {
            return;
        }
        WorkManagerUtilsKt.cancelUploadWorker(context, this.instanceName, this.internalLogger);
    }

    @Override // com.datadog.android.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStopped() {
        Context context = this.contextWeakRef.get();
        if (context == null || !WorkManager.isInitialized()) {
            return;
        }
        WorkManagerUtilsKt.triggerUploadWorker(context, this.instanceName, this.internalLogger);
    }
}
