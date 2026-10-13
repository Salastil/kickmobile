package com.datadog.android.rum.internal.vitals;

import android.app.Activity;
import android.app.Application;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import androidx.metrics.performance.FrameData;
import androidx.metrics.performance.JankStats;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.FrameMetricsData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameStatesAggregator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002@AB/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0017J\u0010\u0010)\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0017J\u0010\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0017J\u0010\u0010+\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0017J\u0018\u0010,\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010-\u001a\u00020(H\u0017J\u0010\u0010.\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0017J\u0010\u0010/\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0017J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\u000fH\u0003J\u0018\u00105\u001a\u00020%2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020%2\u0006\u00104\u001a\u00020\u000fH\u0003J \u00107\u001a\u00020%2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0012H\u0003J\u0010\u0010:\u001a\u00020%2\u0006\u00104\u001a\u00020\u000fH\u0003J\u001c\u0010;\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0003R,\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0018\u00010!R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/FrameStatesAggregator;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroidx/metrics/performance/JankStats$OnFrameListener;", "frameStateListeners", "", "Lcom/datadog/android/rum/internal/vitals/FrameStateListener;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "jankStatsProvider", "Lcom/datadog/android/rum/internal/vitals/JankStatsProvider;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Ljava/util/List;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/rum/internal/vitals/JankStatsProvider;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "activeActivities", "Ljava/util/WeakHashMap;", "Landroid/view/Window;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getActiveActivities$dd_sdk_android_rum_release", "()Ljava/util/WeakHashMap;", "activeWindowsListener", "Landroidx/metrics/performance/JankStats;", "getActiveWindowsListener$dd_sdk_android_rum_release", "display", "Landroid/view/Display;", "getDisplay$dd_sdk_android_rum_release", "()Landroid/view/Display;", "setDisplay$dd_sdk_android_rum_release", "(Landroid/view/Display;)V", "frameMetricsData", "Lcom/datadog/android/rum/internal/domain/FrameMetricsData;", "frameMetricsListener", "Lcom/datadog/android/rum/internal/vitals/FrameStatesAggregator$DDFrameMetricsListener;", "getFrameStateListeners$dd_sdk_android_rum_release", "()Ljava/util/List;", "onActivityCreated", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onFrame", "volatileFrameData", "Landroidx/metrics/performance/FrameData;", "registerMetricListener", "window", "trackActivity", "trackWindowJankStats", "trackWindowMetrics", "isKnownWindow", "", "unregisterMetricListener", "update", "frameMetrics", "Landroid/view/FrameMetrics;", "dropCountSinceLastInvocation", "", "Companion", "DDFrameMetricsListener", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FrameStatesAggregator implements Application.ActivityLifecycleCallbacks, JankStats.OnFrameListener {
    private static final long IS_FIRST_DRAW_FRAME = 1;
    public static final String JANK_STATS_TRACKING_ALREADY_DISABLED_ERROR = "Trying to disable JankStats instance which was already disabled before, this shouldn't happen.";
    public static final String JANK_STATS_TRACKING_DISABLE_ERROR = "Failed to disable JankStats tracking";
    private static final double SIXTY_FPS = 60.0d;
    private final WeakHashMap<Window, List<WeakReference<Activity>>> activeActivities;
    private final WeakHashMap<Window, JankStats> activeWindowsListener;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private Display display;
    private final FrameMetricsData frameMetricsData;
    private DDFrameMetricsListener frameMetricsListener;
    private final List<FrameStateListener> frameStateListeners;
    private final InternalLogger internalLogger;
    private final JankStatsProvider jankStatsProvider;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrameStatesAggregator(List<? extends FrameStateListener> frameStateListeners, InternalLogger internalLogger, JankStatsProvider jankStatsProvider, BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(frameStateListeners, "frameStateListeners");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(jankStatsProvider, "jankStatsProvider");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.frameStateListeners = frameStateListeners;
        this.internalLogger = internalLogger;
        this.jankStatsProvider = jankStatsProvider;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.activeWindowsListener = new WeakHashMap<>();
        this.activeActivities = new WeakHashMap<>();
        this.frameMetricsData = new FrameMetricsData(0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, false, 0L, 0L, 0L, 0L, 0.0d, 65535, null);
    }

    public final List<FrameStateListener> getFrameStateListeners$dd_sdk_android_rum_release() {
        return this.frameStateListeners;
    }

    public /* synthetic */ FrameStatesAggregator(List list, InternalLogger internalLogger, JankStatsProvider jankStatsProvider, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, internalLogger, (i & 4) != 0 ? JankStatsProvider.INSTANCE.getDEFAULT() : jankStatsProvider, (i & 8) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    public final WeakHashMap<Window, JankStats> getActiveWindowsListener$dd_sdk_android_rum_release() {
        return this.activeWindowsListener;
    }

    public final WeakHashMap<Window, List<WeakReference<Activity>>> getActiveActivities$dd_sdk_android_rum_release() {
        return this.activeActivities;
    }

    /* JADX INFO: renamed from: getDisplay$dd_sdk_android_rum_release, reason: from getter */
    public final Display getDisplay() {
        return this.display;
    }

    public final void setDisplay$dd_sdk_android_rum_release(Display display) {
        this.display = display;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        trackActivity(window, activity);
        boolean zContainsKey = this.activeWindowsListener.containsKey(window);
        trackWindowJankStats(window);
        trackWindowMetrics(zContainsKey, window, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        final Window window = activity.getWindow();
        if (!this.activeActivities.containsKey(window)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Activity stopped but window was not tracked";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        ArrayList arrayList = this.activeActivities.get(window);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        CollectionsKt.removeAll((List) arrayList, (Function1) new Function1<WeakReference<Activity>, Boolean>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<Activity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null || Intrinsics.areEqual(it.get(), activity));
            }
        });
        this.activeActivities.put(window, arrayList);
        if (arrayList.isEmpty()) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Disabling jankStats for window " + window;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            try {
                JankStats jankStats = this.activeWindowsListener.get(window);
                if (jankStats != null) {
                    if (jankStats.getIsTrackingEnabled()) {
                        jankStats.setTrackingEnabled(false);
                    } else {
                        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$onActivityStopped$4$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return FrameStatesAggregator.JANK_STATS_TRACKING_ALREADY_DISABLED_ERROR;
                            }
                        }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    }
                }
            } catch (IllegalArgumentException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.5
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return FrameStatesAggregator.JANK_STATS_TRACKING_DISABLE_ERROR;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            } catch (NullPointerException e2) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.onActivityStopped.6
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return FrameStatesAggregator.JANK_STATS_TRACKING_DISABLE_ERROR;
                    }
                }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        List<WeakReference<Activity>> list = this.activeActivities.get(activity.getWindow());
        if (list == null || list.isEmpty()) {
            this.activeWindowsListener.remove(activity.getWindow());
            this.activeActivities.remove(activity.getWindow());
            if (this.buildSdkVersionProvider.getIsAtLeastS()) {
                Window window = activity.getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                unregisterMetricListener(window);
            }
        }
    }

    @Override // androidx.metrics.performance.JankStats.OnFrameListener
    public void onFrame(FrameData volatileFrameData) {
        Intrinsics.checkNotNullParameter(volatileFrameData, "volatileFrameData");
        int size = this.frameStateListeners.size();
        for (int i = 0; i < size; i++) {
            this.frameStateListeners.get(i).onFrame(volatileFrameData);
        }
    }

    private final void trackActivity(Window window, Activity activity) {
        ArrayList arrayList = this.activeActivities.get(window);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        List<WeakReference<Activity>> list = arrayList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), activity)) {
                    return;
                }
            }
        }
        arrayList.add(new WeakReference<>(activity));
        this.activeActivities.put(window, arrayList);
    }

    private final void trackWindowJankStats(final Window window) {
        JankStats jankStats = this.activeWindowsListener.get(window);
        InternalLogger internalLogger = this.internalLogger;
        if (jankStats != null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.trackWindowJankStats.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Resuming jankStats for window " + window;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            jankStats.setTrackingEnabled(true);
            return;
        }
        InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.trackWindowJankStats.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Starting jankStats for window " + window;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        JankStats jankStatsCreateJankStatsAndTrack = this.jankStatsProvider.createJankStatsAndTrack(window, this, this.internalLogger);
        if (jankStatsCreateJankStatsAndTrack == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.trackWindowJankStats.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to create JankStats";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            this.activeWindowsListener.put(window, jankStatsCreateJankStatsAndTrack);
        }
    }

    private final void trackWindowMetrics(boolean isKnownWindow, Window window, Activity activity) {
        if (this.buildSdkVersionProvider.getIsAtLeastS() && !isKnownWindow) {
            registerMetricListener(window);
            return;
        }
        if (this.display == null && this.buildSdkVersionProvider.getVersion() == 30) {
            Object systemService = activity.getSystemService("display");
            if (!(systemService instanceof DisplayManager)) {
                systemService = null;
            }
            DisplayManager displayManager = (DisplayManager) systemService;
            this.display = displayManager != null ? displayManager.getDisplay(0) : null;
        }
    }

    private final void registerMetricListener(final Window window) {
        if (this.frameMetricsListener == null) {
            this.frameMetricsListener = new DDFrameMetricsListener();
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        final View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.registerMetricListener.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to attach JankStatsListener to window, decorView is null";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            viewPeekDecorView.post(new Runnable() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FrameStatesAggregator.registerMetricListener$lambda$3(viewPeekDecorView, this, window, handler);
                }
            });
        }
    }

    static final void registerMetricListener$lambda$3(View view, FrameStatesAggregator frameStatesAggregator, Window window, Handler handler) {
        if (!view.isHardwareAccelerated()) {
            InternalLogger.DefaultImpls.log$default(frameStatesAggregator.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$registerMetricListener$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to attach JankStatsListener to window, decorView is not hardware accelerated";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        DDFrameMetricsListener dDFrameMetricsListener = frameStatesAggregator.frameMetricsListener;
        if (dDFrameMetricsListener != null) {
            try {
                window.addOnFrameMetricsAvailableListener(dDFrameMetricsListener, handler);
            } catch (IllegalStateException e) {
                InternalLogger.DefaultImpls.log$default(frameStatesAggregator.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator$registerMetricListener$2$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to attach JankStatsListener to window";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    private final void unregisterMetricListener(Window window) {
        try {
            window.removeOnFrameMetricsAvailableListener(this.frameMetricsListener);
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.FrameStatesAggregator.unregisterMetricListener.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to detach JankStatsListener to window, most probably because it wasn't attached";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    /* JADX INFO: compiled from: FrameStatesAggregator.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/FrameStatesAggregator$DDFrameMetricsListener;", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "(Lcom/datadog/android/rum/internal/vitals/FrameStatesAggregator;)V", "onFrameMetricsAvailable", "", "window", "Landroid/view/Window;", "frameMetrics", "Landroid/view/FrameMetrics;", "dropCountSinceLastInvocation", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DDFrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
        public DDFrameMetricsListener() {
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int dropCountSinceLastInvocation) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
            int size = FrameStatesAggregator.this.getFrameStateListeners$dd_sdk_android_rum_release().size();
            for (int i = 0; i < size; i++) {
                FrameStateListener frameStateListener = FrameStatesAggregator.this.getFrameStateListeners$dd_sdk_android_rum_release().get(i);
                FrameStatesAggregator frameStatesAggregator = FrameStatesAggregator.this;
                frameStateListener.onFrameMetricsData(frameStatesAggregator.update(frameStatesAggregator.frameMetricsData, frameMetrics, dropCountSinceLastInvocation));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameMetricsData update(FrameMetricsData frameMetricsData, FrameMetrics frameMetrics, int i) {
        Display display = this.display;
        frameMetricsData.setDisplayRefreshRate(display != null ? display.getRefreshRate() : 60.0d);
        if (this.buildSdkVersionProvider.getIsAtLeastN()) {
            frameMetricsData.setDroppedFrames(i);
            frameMetricsData.setUnknownDelayDuration(frameMetrics.getMetric(0));
            frameMetricsData.setInputHandlingDuration(frameMetrics.getMetric(1));
            frameMetricsData.setAnimationDuration(frameMetrics.getMetric(2));
            frameMetricsData.setLayoutMeasureDuration(frameMetrics.getMetric(3));
            frameMetricsData.setDrawDuration(frameMetrics.getMetric(4));
            frameMetricsData.setSyncDuration(frameMetrics.getMetric(5));
            frameMetricsData.setCommandIssueDuration(frameMetrics.getMetric(6));
            frameMetricsData.setSwapBuffersDuration(frameMetrics.getMetric(7));
            frameMetricsData.setTotalDuration(frameMetrics.getMetric(8));
            frameMetricsData.setFirstDrawFrame(frameMetrics.getMetric(9) == 1);
        }
        if (this.buildSdkVersionProvider.getIsAtLeastO()) {
            frameMetricsData.setIntendedVsyncTimestamp(frameMetrics.getMetric(10));
            frameMetricsData.setVsyncTimestamp(frameMetrics.getMetric(11));
        }
        if (this.buildSdkVersionProvider.getIsAtLeastS()) {
            frameMetricsData.setGpuDuration(frameMetrics.getMetric(12));
            frameMetricsData.setDeadline(frameMetrics.getMetric(13));
        }
        return frameMetricsData;
    }
}
