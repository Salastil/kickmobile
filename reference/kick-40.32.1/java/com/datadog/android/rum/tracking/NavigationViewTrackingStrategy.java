package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.internal.attributes.LocalAttributeKt;
import com.datadog.android.internal.attributes.ViewScopeInstrumentationType;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.NoOpRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.tracking.AndroidXFragmentLifecycleCallbacks;
import com.datadog.android.rum.internal.utils.ComponentPredicateExtKt;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NavigationViewTrackingStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001$B'\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0017J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0017J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0017J\"\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\u0014J\u0018\u0010 \u001a\u0004\u0018\u00010\u001a*\u00020!2\b\b\u0001\u0010\"\u001a\u00020\u0005H\u0002J\u0018\u0010#\u001a\u0004\u0018\u00010\u001a*\u00020\u000e2\b\b\u0001\u0010\"\u001a\u00020\u0005H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "navigationViewId", "", "trackArguments", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "Landroidx/navigation/NavDestination;", "(IZLcom/datadog/android/rum/tracking/ComponentPredicate;)V", "lifecycleCallbackRefs", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$NavControllerFragmentLifecycleCallbacks;", "predicate", "Landroidx/fragment/app/Fragment;", "startedActivity", "onActivityPaused", "", "activity", "onActivityStarted", "onActivityStopped", "onDestinationChanged", "controller", "Landroidx/navigation/NavController;", FirebaseAnalytics.Param.DESTINATION, "arguments", "Landroid/os/Bundle;", "startTracking", "stopTracking", "findNavControllerFromNavHostFragmentOrNull", "Landroidx/fragment/app/FragmentActivity;", RumEventMeta.VIEW_ID_KEY, "findNavControllerOrNull", "NavControllerFragmentLifecycleCallbacks", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavigationViewTrackingStrategy extends ActivityLifecycleTrackingStrategy implements ViewTrackingStrategy, NavController.OnDestinationChangedListener {
    private final ComponentPredicate<NavDestination> componentPredicate;
    private final WeakHashMap<Activity, NavControllerFragmentLifecycleCallbacks> lifecycleCallbackRefs;
    private final int navigationViewId;
    private final ComponentPredicate<Fragment> predicate;
    private Activity startedActivity;
    private final boolean trackArguments;

    public /* synthetic */ NavigationViewTrackingStrategy(int i, boolean z, AcceptAllNavDestinations acceptAllNavDestinations, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, (i2 & 4) != 0 ? new AcceptAllNavDestinations() : acceptAllNavDestinations);
    }

    public NavigationViewTrackingStrategy(int i, boolean z, ComponentPredicate<NavDestination> componentPredicate) {
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        this.navigationViewId = i;
        this.trackArguments = z;
        this.componentPredicate = componentPredicate;
        this.lifecycleCallbackRefs = new WeakHashMap<>();
        this.predicate = new ComponentPredicate<Fragment>() { // from class: com.datadog.android.rum.tracking.NavigationViewTrackingStrategy$predicate$1
            @Override // com.datadog.android.rum.tracking.ComponentPredicate
            public String getViewName(Fragment component) {
                Intrinsics.checkNotNullParameter(component, "component");
                return null;
            }

            @Override // com.datadog.android.rum.tracking.ComponentPredicate
            public boolean accept(Fragment component) {
                Intrinsics.checkNotNullParameter(component, "component");
                return !NavHostFragment.class.isAssignableFrom(component.getClass());
            }
        };
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStarted(activity);
        this.startedActivity = activity;
        startTracking();
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStopped(activity);
        stopTracking();
        this.startedActivity = null;
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        NavDestination currentDestination;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityPaused(activity);
        RumMonitor rumMonitor = (RumMonitor) withSdkCore(new Function1<FeatureSdkCore, RumMonitor>() { // from class: com.datadog.android.rum.tracking.NavigationViewTrackingStrategy$onActivityPaused$rumMonitor$1
            @Override // kotlin.jvm.functions.Function1
            public final RumMonitor invoke(FeatureSdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return GlobalRumMonitor.get(it);
            }
        });
        NavController navControllerFindNavControllerOrNull = findNavControllerOrNull(activity, this.navigationViewId);
        if (navControllerFindNavControllerOrNull == null || (currentDestination = navControllerFindNavControllerOrNull.getCurrentDestination()) == null || rumMonitor == null) {
            return;
        }
        RumMonitor.DefaultImpls.stopView$default(rumMonitor, currentDestination, null, 2, null);
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
        RumMonitor rumMonitor = (RumMonitor) withSdkCore(new Function1<FeatureSdkCore, RumMonitor>() { // from class: com.datadog.android.rum.tracking.NavigationViewTrackingStrategy$onDestinationChanged$rumMonitor$1
            @Override // kotlin.jvm.functions.Function1
            public final RumMonitor invoke(FeatureSdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return GlobalRumMonitor.get(it);
            }
        });
        ComponentPredicate<NavDestination> componentPredicate = this.componentPredicate;
        InternalLogger internalLogger$dd_sdk_android_rum_release = getInternalLogger$dd_sdk_android_rum_release();
        if (componentPredicate.accept(destination)) {
            try {
                if (this.trackArguments) {
                    linkedHashMap = MapsKt.toMutableMap(BundleExtKt.convertToRumViewAttributes(arguments));
                } else {
                    linkedHashMap = new LinkedHashMap();
                }
                LocalAttributeKt.enrichWithConstantAttribute(linkedHashMap, ViewScopeInstrumentationType.Native.FRAGMENT);
                String viewName = this.componentPredicate.getViewName(destination);
                String str = viewName;
                if (str == null || StringsKt.isBlank(str)) {
                    viewName = ViewUtilsKt.resolveViewUrl(destination);
                }
                if (rumMonitor != null) {
                    rumMonitor.startView(destination, viewName, linkedHashMap);
                }
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger$dd_sdk_android_rum_release, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) ComponentPredicateExtKt.AnonymousClass1.INSTANCE, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
    }

    public final void startTracking() {
        final Activity activity = this.startedActivity;
        if (activity == null) {
            return;
        }
        withSdkCore(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.tracking.NavigationViewTrackingStrategy.startTracking.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeatureSdkCore featureSdkCore) {
                invoke2(featureSdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeatureSdkCore sdkCore) {
                Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
                FeatureScope feature = sdkCore.getFeature("rum");
                RumFeature rumFeature = feature != null ? (RumFeature) feature.unwrap() : null;
                Activity activity2 = activity;
                FragmentActivity fragmentActivity = activity2 instanceof FragmentActivity ? (FragmentActivity) activity2 : null;
                NavigationViewTrackingStrategy navigationViewTrackingStrategy = this;
                NavController navControllerFindNavControllerOrNull = navigationViewTrackingStrategy.findNavControllerOrNull(activity2, navigationViewTrackingStrategy.navigationViewId);
                if (fragmentActivity == null || navControllerFindNavControllerOrNull == null || rumFeature == null) {
                    return;
                }
                NavControllerFragmentLifecycleCallbacks navControllerFragmentLifecycleCallbacks = new NavControllerFragmentLifecycleCallbacks(navControllerFindNavControllerOrNull, new Function1<Fragment, Map<String, ? extends Object>>() { // from class: com.datadog.android.rum.tracking.NavigationViewTrackingStrategy$startTracking$1$navControllerFragmentCallbacks$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Map<String, Object> invoke(Fragment it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return MapsKt.emptyMap();
                    }
                }, this.predicate, rumFeature);
                Activity activity3 = this.startedActivity;
                Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                navControllerFragmentLifecycleCallbacks.register((FragmentActivity) activity3, (SdkCore) sdkCore);
                this.lifecycleCallbackRefs.put(this.startedActivity, navControllerFragmentLifecycleCallbacks);
                navControllerFindNavControllerOrNull.addOnDestinationChangedListener(this);
            }
        });
    }

    public final void stopTracking() {
        NavController navControllerFindNavControllerOrNull;
        NavControllerFragmentLifecycleCallbacks navControllerFragmentLifecycleCallbacksRemove;
        Activity activity = this.startedActivity;
        if (activity == null || (navControllerFindNavControllerOrNull = findNavControllerOrNull(activity, this.navigationViewId)) == null) {
            return;
        }
        navControllerFindNavControllerOrNull.removeOnDestinationChangedListener(this);
        if (!FragmentActivity.class.isAssignableFrom(activity.getClass()) || (navControllerFragmentLifecycleCallbacksRemove = this.lifecycleCallbackRefs.remove(activity)) == null) {
            return;
        }
        navControllerFragmentLifecycleCallbacksRemove.unregister((FragmentActivity) activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController findNavControllerOrNull(Activity activity, int i) {
        try {
            NavController navControllerFindNavControllerFromNavHostFragmentOrNull = activity instanceof FragmentActivity ? findNavControllerFromNavHostFragmentOrNull((FragmentActivity) activity, i) : null;
            return navControllerFindNavControllerFromNavHostFragmentOrNull == null ? Navigation.findNavController(activity, i) : navControllerFindNavControllerFromNavHostFragmentOrNull;
        } catch (IllegalArgumentException | IllegalStateException unused) {
            return null;
        }
    }

    private final NavController findNavControllerFromNavHostFragmentOrNull(FragmentActivity fragmentActivity, int i) {
        Fragment fragmentFindFragmentById = fragmentActivity.getSupportFragmentManager().findFragmentById(i);
        NavHostFragment navHostFragment = fragmentFindFragmentById instanceof NavHostFragment ? (NavHostFragment) fragmentFindFragmentById : null;
        if (navHostFragment != null) {
            return navHostFragment.getNavController();
        }
        return null;
    }

    /* JADX INFO: compiled from: NavigationViewTrackingStrategy.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$NavControllerFragmentLifecycleCallbacks;", "Lcom/datadog/android/rum/internal/tracking/AndroidXFragmentLifecycleCallbacks;", "navController", "Landroidx/navigation/NavController;", "argumentsProvider", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "rumFeature", "Lcom/datadog/android/rum/internal/RumFeature;", "(Landroidx/navigation/NavController;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/internal/RumFeature;)V", "resolveKey", "fragment", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NavControllerFragmentLifecycleCallbacks extends AndroidXFragmentLifecycleCallbacks {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Object NO_DESTINATION_FOUND = new Object();
        private final NavController navController;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavControllerFragmentLifecycleCallbacks(NavController navController, Function1<? super Fragment, ? extends Map<String, ? extends Object>> argumentsProvider, ComponentPredicate<Fragment> componentPredicate, RumFeature rumFeature) {
            super(argumentsProvider, componentPredicate, rumFeature, new NoOpRumMonitor());
            Intrinsics.checkNotNullParameter(navController, "navController");
            Intrinsics.checkNotNullParameter(argumentsProvider, "argumentsProvider");
            Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
            Intrinsics.checkNotNullParameter(rumFeature, "rumFeature");
            this.navController = navController;
        }

        @Override // com.datadog.android.rum.internal.tracking.AndroidXFragmentLifecycleCallbacks
        public Object resolveKey(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            NavDestination currentDestination = this.navController.getCurrentDestination();
            return currentDestination == null ? NO_DESTINATION_FOUND : currentDestination;
        }

        /* JADX INFO: compiled from: NavigationViewTrackingStrategy.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/tracking/NavigationViewTrackingStrategy$NavControllerFragmentLifecycleCallbacks$Companion;", "", "()V", "NO_DESTINATION_FOUND", "getNO_DESTINATION_FOUND", "()Ljava/lang/Object;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getNO_DESTINATION_FOUND() {
                return NavControllerFragmentLifecycleCallbacks.NO_DESTINATION_FOUND;
            }
        }
    }
}
