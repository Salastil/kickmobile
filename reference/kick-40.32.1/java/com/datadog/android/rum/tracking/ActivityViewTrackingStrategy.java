package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.internal.attributes.LocalAttributeKt;
import com.datadog.android.internal.attributes.ViewScopeInstrumentationType;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.utils.ComponentPredicateExtKt;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ActivityViewTrackingStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0002J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007H\u0017J\u0010\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007H\u0017R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/datadog/android/rum/tracking/ActivityViewTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "trackExtras", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "Landroid/app/Activity;", "(ZLcom/datadog/android/rum/tracking/ComponentPredicate;)V", "getComponentPredicate$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/tracking/ComponentPredicate;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "executor$delegate", "Lkotlin/Lazy;", "getTrackExtras$dd_sdk_android_rum_release", "()Z", "safeExtras", "Landroid/os/Bundle;", "Landroid/content/Intent;", "getSafeExtras", "(Landroid/content/Intent;)Landroid/os/Bundle;", "convertToRumAttributes", "", "", "", "intent", "equals", "other", "getRumMonitor", "Lcom/datadog/android/rum/RumMonitor;", "hashCode", "", "onActivityResumed", "", "activity", "onActivityStopped", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityViewTrackingStrategy extends ActivityLifecycleTrackingStrategy implements ViewTrackingStrategy {
    public static final String INTENT_ACTION_TAG = "view.intent.action";
    public static final String INTENT_URI_TAG = "view.intent.uri";
    private static final long STOP_VIEW_DELAY_MS = 200;
    private final ComponentPredicate<Activity> componentPredicate;

    /* JADX INFO: renamed from: executor$delegate, reason: from kotlin metadata */
    private final Lazy executor;
    private final boolean trackExtras;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityViewTrackingStrategy(boolean z) {
        this(z, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: getTrackExtras$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getTrackExtras() {
        return this.trackExtras;
    }

    public /* synthetic */ ActivityViewTrackingStrategy(boolean z, AcceptAllActivities acceptAllActivities, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? new AcceptAllActivities() : acceptAllActivities);
    }

    public final ComponentPredicate<Activity> getComponentPredicate$dd_sdk_android_rum_release() {
        return this.componentPredicate;
    }

    public ActivityViewTrackingStrategy(boolean z, ComponentPredicate<Activity> componentPredicate) {
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        this.trackExtras = z;
        this.componentPredicate = componentPredicate;
        this.executor = LazyKt.lazy(new Function0<ScheduledExecutorService>() { // from class: com.datadog.android.rum.tracking.ActivityViewTrackingStrategy$executor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ScheduledExecutorService invoke() {
                return this.this$0.getSdkCore().createScheduledExecutorService("rum-activity-tracking");
            }
        });
    }

    private final ScheduledExecutorService getExecutor() {
        return (ScheduledExecutorService) this.executor.getValue();
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Map<String, ? extends Object> mapEmptyMap;
        Intent intent;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityResumed(activity);
        ComponentPredicate<Activity> componentPredicate = this.componentPredicate;
        InternalLogger internalLogger$dd_sdk_android_rum_release = getInternalLogger$dd_sdk_android_rum_release();
        if (componentPredicate.accept(activity)) {
            try {
                String viewName = this.componentPredicate.getViewName(activity);
                String str = viewName;
                if (str == null || StringsKt.isBlank(str)) {
                    viewName = ViewUtilsKt.resolveViewUrl(activity);
                }
                if (this.trackExtras && (intent = activity.getIntent()) != null) {
                    mapEmptyMap = convertToRumAttributes(intent);
                } else {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                RumMonitor rumMonitor = getRumMonitor();
                if (rumMonitor != null) {
                    rumMonitor.startView(activity, viewName, mapEmptyMap);
                }
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger$dd_sdk_android_rum_release, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) ComponentPredicateExtKt.AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStopped(activity);
        ConcurrencyExtKt.scheduleSafe(getExecutor(), "Delayed view stop", 200L, TimeUnit.MILLISECONDS, getInternalLogger$dd_sdk_android_rum_release(), new Runnable() { // from class: com.datadog.android.rum.tracking.ActivityViewTrackingStrategy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ActivityViewTrackingStrategy.onActivityStopped$lambda$2(this.f$0, activity);
            }
        });
    }

    static final void onActivityStopped$lambda$2(ActivityViewTrackingStrategy activityViewTrackingStrategy, Activity activity) {
        ComponentPredicate<Activity> componentPredicate = activityViewTrackingStrategy.componentPredicate;
        InternalLogger internalLogger$dd_sdk_android_rum_release = activityViewTrackingStrategy.getInternalLogger$dd_sdk_android_rum_release();
        if (componentPredicate.accept(activity)) {
            try {
                RumMonitor rumMonitor = activityViewTrackingStrategy.getRumMonitor();
                if (rumMonitor != null) {
                    RumMonitor.DefaultImpls.stopView$default(rumMonitor, activity, null, 2, null);
                }
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger$dd_sdk_android_rum_release, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) ComponentPredicateExtKt.AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.rum.tracking.ActivityViewTrackingStrategy");
        ActivityViewTrackingStrategy activityViewTrackingStrategy = (ActivityViewTrackingStrategy) other;
        return this.trackExtras == activityViewTrackingStrategy.trackExtras && Intrinsics.areEqual(this.componentPredicate, activityViewTrackingStrategy.componentPredicate);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.trackExtras) * 31) + this.componentPredicate.hashCode();
    }

    private final RumMonitor getRumMonitor() {
        return (RumMonitor) withSdkCore(new Function1<FeatureSdkCore, RumMonitor>() { // from class: com.datadog.android.rum.tracking.ActivityViewTrackingStrategy.getRumMonitor.1
            @Override // kotlin.jvm.functions.Function1
            public final RumMonitor invoke(FeatureSdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return GlobalRumMonitor.get(it);
            }
        });
    }

    private final Map<String, Object> convertToRumAttributes(Intent intent) {
        if (intent == null) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String action = intent.getAction();
        if (action != null) {
            linkedHashMap.put(INTENT_ACTION_TAG, action);
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            linkedHashMap.put(INTENT_URI_TAG, dataString);
        }
        linkedHashMap.putAll(BundleExtKt.convertToRumViewAttributes(getSafeExtras(intent)));
        LocalAttributeKt.enrichWithConstantAttribute(linkedHashMap, ViewScopeInstrumentationType.Native.ACTIVITY);
        return linkedHashMap;
    }

    private final Bundle getSafeExtras(Intent intent) {
        try {
            return intent.getExtras();
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(getInternalLogger$dd_sdk_android_rum_release(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.tracking.ActivityViewTrackingStrategy$safeExtras$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error getting Intent extras, ignoring it.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
