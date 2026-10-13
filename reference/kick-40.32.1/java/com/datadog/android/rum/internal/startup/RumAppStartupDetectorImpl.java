package com.datadog.android.rum.internal.startup;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.startup.AppStartupActivityPredicate;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: RumAppStartupDetectorImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u001a\u0010+\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u0018\u0010-\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u0010\u00100\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u001a\u00101\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J \u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0017H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010\u001d\u001a&\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00140\u0014 \u001f*\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00140\u0014\u0018\u00010 0\u001eX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"¨\u00066"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumAppStartupDetectorImpl;", "Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "application", "Landroid/app/Application;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "appStartupTime", "Lkotlin/Function0;", "Lcom/datadog/android/rum/internal/domain/Time;", "currentTime", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector$Listener;", "appStartupActivityPredicate", "Lcom/datadog/android/rum/startup/AppStartupActivityPredicate;", "rumFirstDrawTimeReporter", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter;", "(Landroid/app/Application;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector$Listener;Lcom/datadog/android/rum/startup/AppStartupActivityPredicate;Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter;)V", "firstFrameHandles", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Handle;", "isChangingConfigurations", "", "isFirstActivityForProcess", "numberOfActivities", "", "pendingScenario", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "trackedActivities", "", "kotlin.jvm.PlatformType", "", "getTrackedActivities$annotations", "()V", "destroy", "", "onActivityCreated", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPreCreated", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onBeforeActivityCreated", "subscribeToFirstFrameDrawn", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "wasForwarded", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumAppStartupDetectorImpl implements RumAppStartupDetector, Application.ActivityLifecycleCallbacks {
    private static final long START_GAP_THRESHOLD_NS;
    private final AppStartupActivityPredicate appStartupActivityPredicate;
    private final Function0<Time> appStartupTime;
    private final Application application;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private final Function0<Time> currentTime;
    private final WeakHashMap<Activity, RumFirstDrawTimeReporter.Handle> firstFrameHandles;
    private boolean isChangingConfigurations;
    private boolean isFirstActivityForProcess;
    private final RumAppStartupDetector.Listener listener;
    private int numberOfActivities;
    private RumStartupScenario pendingScenario;
    private final RumFirstDrawTimeReporter rumFirstDrawTimeReporter;
    private final Set<Activity> trackedActivities;

    private static /* synthetic */ void getTrackedActivities$annotations() {
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public RumAppStartupDetectorImpl(Application application, BuildSdkVersionProvider buildSdkVersionProvider, Function0<Time> appStartupTime, Function0<Time> currentTime, RumAppStartupDetector.Listener listener, AppStartupActivityPredicate appStartupActivityPredicate, RumFirstDrawTimeReporter rumFirstDrawTimeReporter) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        Intrinsics.checkNotNullParameter(appStartupTime, "appStartupTime");
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(appStartupActivityPredicate, "appStartupActivityPredicate");
        Intrinsics.checkNotNullParameter(rumFirstDrawTimeReporter, "rumFirstDrawTimeReporter");
        this.application = application;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.appStartupTime = appStartupTime;
        this.currentTime = currentTime;
        this.listener = listener;
        this.appStartupActivityPredicate = appStartupActivityPredicate;
        this.rumFirstDrawTimeReporter = rumFirstDrawTimeReporter;
        this.isFirstActivityForProcess = true;
        this.trackedActivities = Collections.newSetFromMap(new WeakHashMap());
        this.firstFrameHandles = new WeakHashMap<>();
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.buildSdkVersionProvider.getIsAtLeastQ()) {
            onBeforeActivityCreated(activity, savedInstanceState);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.buildSdkVersionProvider.getIsAtLeastQ()) {
            return;
        }
        onBeforeActivityCreated(activity, savedInstanceState);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.numberOfActivities--;
        this.trackedActivities.remove(activity);
        RumFirstDrawTimeReporter.Handle handleRemove = this.firstFrameHandles.remove(activity);
        if (handleRemove != null) {
            handleRemove.unsubscribe();
        }
        if (this.numberOfActivities == 0) {
            this.isChangingConfigurations = activity.isChangingConfigurations();
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r16v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v0 'this'  ??, new type: com.datadog.android.rum.internal.startup.RumAppStartupDetectorImpl
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r16v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v0 'this'  ??, new type: com.datadog.android.rum.internal.startup.RumAppStartupDetectorImpl
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v0 'this'  com.datadog.android.rum.internal.startup.RumAppStartupDetectorImpl, new type: com.datadog.android.rum.internal.startup.RumAppStartupDetectorImpl
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    private final void onBeforeActivityCreated(Activity activity, Bundle savedInstanceState) {
        RumStartupScenario.WarmAfterActivityDestroyed warmAfterActivityDestroyed;
        this.numberOfActivities++;
        Time timeInvoke = this.currentTime.invoke();
        boolean zShouldTrackStartup = this.appStartupActivityPredicate.shouldTrackStartup(activity);
        if (zShouldTrackStartup) {
            this.trackedActivities.add(activity);
        }
        RumStartupScenario rumStartupScenario = this.pendingScenario;
        if (rumStartupScenario != null && timeInvoke.getNanoTime() - rumStartupScenario.getInitialTime().getNanoTime() > RumSessionScopeStartupManagerImpl.INSTANCE.getMAX_TTID_DURATION_NS$dd_sdk_android_rum_release()) {
            this.pendingScenario = null;
        }
        if (this.trackedActivities.size() == 1 && !this.isChangingConfigurations && zShouldTrackStartup && this.pendingScenario == null) {
            Time timeInvoke2 = this.appStartupTime.invoke();
            long nanoTime = timeInvoke.getNanoTime() - timeInvoke2.getNanoTime();
            boolean z = savedInstanceState != null;
            WeakReference weakReference = new WeakReference(activity);
            if (!this.isFirstActivityForProcess) {
                warmAfterActivityDestroyed = new RumStartupScenario.WarmAfterActivityDestroyed(z, weakReference, timeInvoke);
            } else if (nanoTime > START_GAP_THRESHOLD_NS) {
                warmAfterActivityDestroyed = new RumStartupScenario.WarmFirstActivity(z, weakReference, nanoTime, timeInvoke);
            } else {
                warmAfterActivityDestroyed = new RumStartupScenario.Cold(z, weakReference, nanoTime, timeInvoke2);
            }
            this.pendingScenario = warmAfterActivityDestroyed;
            this.listener.onAppStartupDetected(warmAfterActivityDestroyed);
            subscribeToFirstFrameDrawn(warmAfterActivityDestroyed, activity, r10);
            this.isFirstActivityForProcess = 0;
        }
        RumStartupScenario rumStartupScenario2 = this.pendingScenario;
        if (rumStartupScenario2 == null || !zShouldTrackStartup || rumStartupScenario2.getActivity().get() == activity) {
            return;
        }
        subscribeToFirstFrameDrawn(rumStartupScenario2, activity, true);
    }

    private final void subscribeToFirstFrameDrawn(final RumStartupScenario scenario, final Activity activity, final boolean wasForwarded) {
        this.firstFrameHandles.put(activity, this.rumFirstDrawTimeReporter.subscribeToFirstFrameDrawn(activity, new RumFirstDrawTimeReporter.Callback() { // from class: com.datadog.android.rum.internal.startup.RumAppStartupDetectorImpl$subscribeToFirstFrameDrawn$callback$1
            @Override // com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporter.Callback
            public void onFirstFrameDrawn(long timestampNs) {
                this.this$0.firstFrameHandles.remove(activity);
                RumStartupScenario rumStartupScenario = this.this$0.pendingScenario;
                RumStartupScenario rumStartupScenario2 = scenario;
                if (rumStartupScenario != rumStartupScenario2) {
                    return;
                }
                this.this$0.listener.onTTIDComputed(scenario, timestampNs - rumStartupScenario2.getInitialTime().getNanoTime(), wasForwarded);
                this.this$0.pendingScenario = null;
            }
        }));
    }

    @Override // com.datadog.android.rum.internal.startup.RumAppStartupDetector
    public void destroy() {
        this.pendingScenario = null;
        this.application.unregisterActivityLifecycleCallbacks(this);
        Iterator<Map.Entry<Activity, RumFirstDrawTimeReporter.Handle>> it = this.firstFrameHandles.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().unsubscribe();
        }
        this.firstFrameHandles.clear();
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        START_GAP_THRESHOLD_NS = Duration.m14077getInWholeNanosecondsimpl(DurationKt.toDuration(10, DurationUnit.SECONDS));
    }
}
