package com.datadog.android.rum.internal.startup;

import android.app.Activity;
import android.os.Handler;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.utils.window.RumWindowCallbacksRegistry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumFirstDrawTimeReporterImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporterImpl;", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "timeProviderNs", "Lkotlin/Function0;", "", "windowCallbacksRegistry", "Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbacksRegistry;", "handler", "Landroid/os/Handler;", "(Lcom/datadog/android/api/InternalLogger;Lkotlin/jvm/functions/Function0;Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbacksRegistry;Landroid/os/Handler;)V", "subscribeToFirstFrameDrawn", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Handle;", "activity", "Landroid/app/Activity;", "callback", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Callback;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumFirstDrawTimeReporterImpl implements RumFirstDrawTimeReporter {
    private final Handler handler;
    private final InternalLogger internalLogger;
    private final Function0<Long> timeProviderNs;
    private final RumWindowCallbacksRegistry windowCallbacksRegistry;

    public RumFirstDrawTimeReporterImpl(InternalLogger internalLogger, Function0<Long> timeProviderNs, RumWindowCallbacksRegistry windowCallbacksRegistry, Handler handler) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(timeProviderNs, "timeProviderNs");
        Intrinsics.checkNotNullParameter(windowCallbacksRegistry, "windowCallbacksRegistry");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.internalLogger = internalLogger;
        this.timeProviderNs = timeProviderNs;
        this.windowCallbacksRegistry = windowCallbacksRegistry;
        this.handler = handler;
    }

    @Override // com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporter
    public RumFirstDrawTimeReporter.Handle subscribeToFirstFrameDrawn(Activity activity, RumFirstDrawTimeReporter.Callback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new RumFirstDrawTimeReporterHandleImpl(callback, activity, this.internalLogger, this.timeProviderNs, this.windowCallbacksRegistry, this.handler);
    }
}
