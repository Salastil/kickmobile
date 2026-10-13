package com.datadog.android.rum.internal.tracking;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker;
import com.datadog.android.rum.internal.utils.ComponentPredicateExtKt;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.datadog.android.rum.tracking.ComponentPredicate;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidXFragmentLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00015BE\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0017J\u0018\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0017J*\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0006H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0006H\u0002J\u0010\u00104\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0002H\u0016R.\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00066"}, d2 = {"Lcom/datadog/android/rum/internal/tracking/AndroidXFragmentLifecycleCallbacks;", "Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "argumentsProvider", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "rumFeature", "Lcom/datadog/android/rum/internal/RumFeature;", "rumMonitor", "Lcom/datadog/android/rum/RumMonitor;", "(Lkotlin/jvm/functions/Function1;Lcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/internal/RumFeature;Lcom/datadog/android/rum/RumMonitor;)V", "getArgumentsProvider$dd_sdk_android_rum_release", "()Lkotlin/jvm/functions/Function1;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "executor$delegate", "Lkotlin/Lazy;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "getSdkCore", "()Lcom/datadog/android/api/feature/FeatureSdkCore;", "setSdkCore", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "onFragmentResumed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "onFragmentStopped", "onFragmentViewCreated", "v", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "register", "activity", "Lcom/datadog/android/api/SdkCore;", "resolveKey", "fragment", "startGesturesTracking", "unregister", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class AndroidXFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks implements FragmentLifecycleCallbacks<FragmentActivity> {
    public static final long STOP_VIEW_DELAY_MS = 200;
    private final Function1<Fragment, Map<String, Object>> argumentsProvider;
    private final ComponentPredicate<Fragment> componentPredicate;

    /* JADX INFO: renamed from: executor$delegate, reason: from kotlin metadata */
    private final Lazy executor;
    private final RumFeature rumFeature;
    private final RumMonitor rumMonitor;
    protected FeatureSdkCore sdkCore;

    public Object resolveKey(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return fragment;
    }

    public final Function1<Fragment, Map<String, Object>> getArgumentsProvider$dd_sdk_android_rum_release() {
        return this.argumentsProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidXFragmentLifecycleCallbacks(Function1<? super Fragment, ? extends Map<String, ? extends Object>> argumentsProvider, ComponentPredicate<Fragment> componentPredicate, RumFeature rumFeature, RumMonitor rumMonitor) {
        Intrinsics.checkNotNullParameter(argumentsProvider, "argumentsProvider");
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        Intrinsics.checkNotNullParameter(rumFeature, "rumFeature");
        Intrinsics.checkNotNullParameter(rumMonitor, "rumMonitor");
        this.argumentsProvider = argumentsProvider;
        this.componentPredicate = componentPredicate;
        this.rumFeature = rumFeature;
        this.rumMonitor = rumMonitor;
        this.executor = LazyKt.lazy(new Function0<ScheduledExecutorService>() { // from class: com.datadog.android.rum.internal.tracking.AndroidXFragmentLifecycleCallbacks$executor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ScheduledExecutorService invoke() {
                return this.this$0.getSdkCore().createScheduledExecutorService("rum-fragmentx-lifecycle");
            }
        });
    }

    protected final FeatureSdkCore getSdkCore() {
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore != null) {
            return featureSdkCore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sdkCore");
        return null;
    }

    protected final void setSdkCore(FeatureSdkCore featureSdkCore) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<set-?>");
        this.sdkCore = featureSdkCore;
    }

    private final ScheduledExecutorService getExecutor() {
        return (ScheduledExecutorService) this.executor.getValue();
    }

    private final InternalLogger getInternalLogger() {
        if (this.sdkCore != null) {
            return getSdkCore().getInternalLogger();
        }
        return InternalLogger.INSTANCE.getUNBOUND();
    }

    @Override // com.datadog.android.rum.internal.tracking.FragmentLifecycleCallbacks
    public void register(FragmentActivity activity, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        setSdkCore((FeatureSdkCore) sdkCore);
        activity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(this, true);
    }

    @Override // com.datadog.android.rum.internal.tracking.FragmentLifecycleCallbacks
    public void unregister(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(v, "v");
        super.onFragmentViewCreated(fm, f, v, savedInstanceState);
        startGesturesTracking(f);
    }

    private final void startGesturesTracking(Fragment f) {
        Context context = f.getContext();
        if (context == null || !(f instanceof DialogFragment) || this.sdkCore == null) {
            return;
        }
        GesturesTracker gesturesTracker = this.rumFeature.getActionTrackingStrategy().getGesturesTracker();
        Dialog dialog = ((DialogFragment) f).getDialog();
        gesturesTracker.startTracking(dialog != null ? dialog.getWindow() : null, context, getSdkCore());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fm, Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        super.onFragmentResumed(fm, f);
        ComponentPredicate<Fragment> componentPredicate = this.componentPredicate;
        InternalLogger internalLogger = getInternalLogger();
        if (componentPredicate.accept(f)) {
            try {
                Object objResolveKey = resolveKey(f);
                String viewName = this.componentPredicate.getViewName(f);
                String str = viewName;
                if (str == null || StringsKt.isBlank(str)) {
                    viewName = ViewUtilsKt.resolveViewUrl(f);
                }
                this.rumMonitor.startView(objResolveKey, viewName, (Map) this.argumentsProvider.invoke(f));
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) ComponentPredicateExtKt.AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fm, final Fragment f) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(f, "f");
        super.onFragmentStopped(fm, f);
        ConcurrencyExtKt.scheduleSafe(getExecutor(), "Delayed view stop", 200L, TimeUnit.MILLISECONDS, getSdkCore().getInternalLogger(), new Runnable() { // from class: com.datadog.android.rum.internal.tracking.AndroidXFragmentLifecycleCallbacks$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidXFragmentLifecycleCallbacks.onFragmentStopped$lambda$2(this.f$0, f);
            }
        });
    }

    static final void onFragmentStopped$lambda$2(AndroidXFragmentLifecycleCallbacks androidXFragmentLifecycleCallbacks, Fragment fragment) {
        ComponentPredicate<Fragment> componentPredicate = androidXFragmentLifecycleCallbacks.componentPredicate;
        InternalLogger internalLogger = androidXFragmentLifecycleCallbacks.getInternalLogger();
        if (componentPredicate.accept(fragment)) {
            try {
                RumMonitor.DefaultImpls.stopView$default(androidXFragmentLifecycleCallbacks.rumMonitor, androidXFragmentLifecycleCallbacks.resolveKey(fragment), null, 2, null);
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) ComponentPredicateExtKt.AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }
}
