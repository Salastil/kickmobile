package com.datadog.android.rum.internal.tracking;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager$FragmentLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.canhub.cropper.BitmapUtils$$ExternalSyntheticApiModelOutline0;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker;
import com.datadog.android.rum.internal.utils.ComponentPredicateExtKt;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.datadog.android.rum.tracking.ComponentPredicate;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OreoFragmentLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/BO\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006H\u0002J\"\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(H\u0017J\u0018\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0017J\u0018\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0017J\u0018\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0002H\u0016R(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/datadog/android/rum/internal/tracking/OreoFragmentLifecycleCallbacks;", "Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "Landroid/app/Activity;", "Landroid/app/FragmentManager$FragmentLifecycleCallbacks;", "argumentsProvider", "Lkotlin/Function1;", "Landroid/app/Fragment;", "", "", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "rumFeature", "Lcom/datadog/android/rum/internal/RumFeature;", "rumMonitor", "Lcom/datadog/android/rum/RumMonitor;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Lkotlin/jvm/functions/Function1;Lcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/internal/RumFeature;Lcom/datadog/android/rum/RumMonitor;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "executor$delegate", "Lkotlin/Lazy;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "isNotAViewFragment", "", "fragment", "onFragmentActivityCreated", "", "fm", "Landroid/app/FragmentManager;", "f", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentResumed", "onFragmentStopped", "register", "activity", "Lcom/datadog/android/api/SdkCore;", "unregister", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OreoFragmentLifecycleCallbacks extends FragmentManager$FragmentLifecycleCallbacks implements FragmentLifecycleCallbacks<Activity> {
    private static final Companion Companion = new Companion(null);
    private static final String REPORT_FRAGMENT_NAME = "androidx.lifecycle.ReportFragment";
    private static final long STOP_VIEW_DELAY_MS = 200;
    private final Function1<Fragment, Map<String, Object>> argumentsProvider;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private final ComponentPredicate<Fragment> componentPredicate;

    /* JADX INFO: renamed from: executor$delegate, reason: from kotlin metadata */
    private final Lazy executor;
    private final RumFeature rumFeature;
    private final RumMonitor rumMonitor;
    private FeatureSdkCore sdkCore;

    public /* synthetic */ OreoFragmentLifecycleCallbacks(Function1 function1, ComponentPredicate componentPredicate, RumFeature rumFeature, RumMonitor rumMonitor, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, componentPredicate, rumFeature, rumMonitor, (i & 16) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OreoFragmentLifecycleCallbacks(Function1<? super Fragment, ? extends Map<String, ? extends Object>> argumentsProvider, ComponentPredicate<Fragment> componentPredicate, RumFeature rumFeature, RumMonitor rumMonitor, BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(argumentsProvider, "argumentsProvider");
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        Intrinsics.checkNotNullParameter(rumFeature, "rumFeature");
        Intrinsics.checkNotNullParameter(rumMonitor, "rumMonitor");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.argumentsProvider = argumentsProvider;
        this.componentPredicate = componentPredicate;
        this.rumFeature = rumFeature;
        this.rumMonitor = rumMonitor;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.executor = LazyKt.lazy(new Function0<ScheduledExecutorService>() { // from class: com.datadog.android.rum.internal.tracking.OreoFragmentLifecycleCallbacks$executor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ScheduledExecutorService invoke() {
                FeatureSdkCore featureSdkCore = this.this$0.sdkCore;
                if (featureSdkCore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
                    featureSdkCore = null;
                }
                return featureSdkCore.createScheduledExecutorService("rum-fragment-lifecycle");
            }
        });
    }

    private final ScheduledExecutorService getExecutor() {
        return (ScheduledExecutorService) this.executor.getValue();
    }

    private final InternalLogger getInternalLogger() {
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore == null) {
            return InternalLogger.INSTANCE.getUNBOUND();
        }
        if (featureSdkCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
            featureSdkCore = null;
        }
        return featureSdkCore.getInternalLogger();
    }

    @Override // com.datadog.android.rum.internal.tracking.FragmentLifecycleCallbacks
    public void register(Activity activity, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = (FeatureSdkCore) sdkCore;
        if (this.buildSdkVersionProvider.getIsAtLeastO()) {
            activity.getFragmentManager().registerFragmentLifecycleCallbacks(BitmapUtils$$ExternalSyntheticApiModelOutline0.m11118m((Object) this), true);
        }
    }

    @Override // com.datadog.android.rum.internal.tracking.FragmentLifecycleCallbacks
    public void unregister(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.buildSdkVersionProvider.getIsAtLeastO()) {
            activity.getFragmentManager().unregisterFragmentLifecycleCallbacks(BitmapUtils$$ExternalSyntheticApiModelOutline0.m11118m((Object) this));
        }
    }

    @Deprecated(message = "Deprecated in Java")
    public void onFragmentActivityCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        super.onFragmentActivityCreated(fm, f, savedInstanceState);
        if (isNotAViewFragment(f)) {
            return;
        }
        Context context = f.getContext();
        if (!(f instanceof DialogFragment) || context == null || this.sdkCore == null) {
            return;
        }
        Dialog dialog = ((DialogFragment) f).getDialog();
        FeatureSdkCore featureSdkCore = null;
        Window window = dialog != null ? dialog.getWindow() : null;
        GesturesTracker gesturesTracker = this.rumFeature.getActionTrackingStrategy().getGesturesTracker();
        FeatureSdkCore featureSdkCore2 = this.sdkCore;
        if (featureSdkCore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
        } else {
            featureSdkCore = featureSdkCore2;
        }
        gesturesTracker.startTracking(window, context, featureSdkCore);
    }

    @Deprecated(message = "Deprecated in Java")
    public void onFragmentResumed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        super.onFragmentResumed(fm, f);
        if (isNotAViewFragment(f)) {
            return;
        }
        ComponentPredicate<Fragment> componentPredicate = this.componentPredicate;
        InternalLogger internalLogger = getInternalLogger();
        if (componentPredicate.accept(f)) {
            try {
                String viewName = this.componentPredicate.getViewName(f);
                String str = viewName;
                if (str == null || StringsKt.isBlank(str)) {
                    viewName = ViewUtilsKt.resolveViewUrl(f);
                }
                this.rumMonitor.startView(f, viewName, (Map) this.argumentsProvider.invoke(f));
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) ComponentPredicateExtKt.AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    @Deprecated(message = "Deprecated in Java")
    public void onFragmentStopped(FragmentManager fm, final Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        super.onFragmentStopped(fm, f);
        if (isNotAViewFragment(f)) {
            return;
        }
        ScheduledExecutorService executor = getExecutor();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
            featureSdkCore = null;
        }
        ConcurrencyExtKt.scheduleSafe(executor, "Delayed view stop", 200L, timeUnit, featureSdkCore.getInternalLogger(), new Runnable() { // from class: com.datadog.android.rum.internal.tracking.OreoFragmentLifecycleCallbacks$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                OreoFragmentLifecycleCallbacks.onFragmentStopped$lambda$2(this.f$0, f);
            }
        });
    }

    static final void onFragmentStopped$lambda$2(OreoFragmentLifecycleCallbacks oreoFragmentLifecycleCallbacks, Fragment fragment) {
        ComponentPredicate<Fragment> componentPredicate = oreoFragmentLifecycleCallbacks.componentPredicate;
        InternalLogger internalLogger = oreoFragmentLifecycleCallbacks.getInternalLogger();
        if (componentPredicate.accept(fragment)) {
            try {
                RumMonitor.DefaultImpls.stopView$default(oreoFragmentLifecycleCallbacks.rumMonitor, fragment, null, 2, null);
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) ComponentPredicateExtKt.AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    private final boolean isNotAViewFragment(Fragment fragment) {
        return Intrinsics.areEqual(fragment.getClass().getName(), REPORT_FRAGMENT_NAME);
    }

    /* JADX INFO: compiled from: OreoFragmentLifecycleCallbacks.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/tracking/OreoFragmentLifecycleCallbacks$Companion;", "", "()V", "REPORT_FRAGMENT_NAME", "", "STOP_VIEW_DELAY_MS", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
