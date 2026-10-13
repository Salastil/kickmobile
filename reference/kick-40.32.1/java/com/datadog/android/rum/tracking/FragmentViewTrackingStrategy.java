package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.internal.attributes.LocalAttributeKt;
import com.datadog.android.internal.attributes.ViewScopeInstrumentationType;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.tracking.AndroidXFragmentLifecycleCallbacks;
import com.datadog.android.rum.internal.tracking.FragmentLifecycleCallbacks;
import com.datadog.android.rum.internal.tracking.NoOpFragmentLifecycleCallbacks;
import com.datadog.android.rum.internal.tracking.OreoFragmentLifecycleCallbacks;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentViewTrackingStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nB3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0017J\u0010\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0017R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/datadog/android/rum/tracking/FragmentViewTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "trackArguments", "", "supportFragmentComponentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "Landroidx/fragment/app/Fragment;", "defaultFragmentComponentPredicate", "Landroid/app/Fragment;", "(ZLcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/tracking/ComponentPredicate;)V", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(ZLcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "androidXLifecycleCallbacks", "Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "Landroidx/fragment/app/FragmentActivity;", "getAndroidXLifecycleCallbacks", "()Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "androidXLifecycleCallbacks$delegate", "Lkotlin/Lazy;", "getBuildSdkVersionProvider$dd_sdk_android_rum_release", "()Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "getDefaultFragmentComponentPredicate$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/tracking/ComponentPredicate;", "oreoLifecycleCallbacks", "Landroid/app/Activity;", "getOreoLifecycleCallbacks", "oreoLifecycleCallbacks$delegate", "getSupportFragmentComponentPredicate$dd_sdk_android_rum_release", "getTrackArguments$dd_sdk_android_rum_release", "()Z", "equals", "other", "", "hashCode", "", "onActivityStarted", "", "activity", "onActivityStopped", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FragmentViewTrackingStrategy extends ActivityLifecycleTrackingStrategy implements ViewTrackingStrategy {

    /* JADX INFO: renamed from: androidXLifecycleCallbacks$delegate, reason: from kotlin metadata */
    private final Lazy androidXLifecycleCallbacks;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private final ComponentPredicate<Fragment> defaultFragmentComponentPredicate;

    /* JADX INFO: renamed from: oreoLifecycleCallbacks$delegate, reason: from kotlin metadata */
    private final Lazy oreoLifecycleCallbacks;
    private final ComponentPredicate<androidx.fragment.app.Fragment> supportFragmentComponentPredicate;
    private final boolean trackArguments;

    public FragmentViewTrackingStrategy(boolean z) {
        this(z, null, null, 6, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentViewTrackingStrategy(boolean z, ComponentPredicate<androidx.fragment.app.Fragment> supportFragmentComponentPredicate) {
        this(z, supportFragmentComponentPredicate, null, 4, null);
        Intrinsics.checkNotNullParameter(supportFragmentComponentPredicate, "supportFragmentComponentPredicate");
    }

    /* JADX INFO: renamed from: getTrackArguments$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getTrackArguments() {
        return this.trackArguments;
    }

    public final ComponentPredicate<androidx.fragment.app.Fragment> getSupportFragmentComponentPredicate$dd_sdk_android_rum_release() {
        return this.supportFragmentComponentPredicate;
    }

    public final ComponentPredicate<Fragment> getDefaultFragmentComponentPredicate$dd_sdk_android_rum_release() {
        return this.defaultFragmentComponentPredicate;
    }

    /* JADX INFO: renamed from: getBuildSdkVersionProvider$dd_sdk_android_rum_release, reason: from getter */
    public final BuildSdkVersionProvider getBuildSdkVersionProvider() {
        return this.buildSdkVersionProvider;
    }

    public FragmentViewTrackingStrategy(boolean z, ComponentPredicate<androidx.fragment.app.Fragment> supportFragmentComponentPredicate, ComponentPredicate<Fragment> defaultFragmentComponentPredicate, BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(supportFragmentComponentPredicate, "supportFragmentComponentPredicate");
        Intrinsics.checkNotNullParameter(defaultFragmentComponentPredicate, "defaultFragmentComponentPredicate");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.trackArguments = z;
        this.supportFragmentComponentPredicate = supportFragmentComponentPredicate;
        this.defaultFragmentComponentPredicate = defaultFragmentComponentPredicate;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.androidXLifecycleCallbacks = LazyKt.lazy(new Function0<FragmentLifecycleCallbacks<FragmentActivity>>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$androidXLifecycleCallbacks$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FragmentLifecycleCallbacks<FragmentActivity> invoke() {
                RumFeature rumFeature = (RumFeature) this.this$0.withSdkCore(new Function1<FeatureSdkCore, RumFeature>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$androidXLifecycleCallbacks$2$rumFeature$1
                    @Override // kotlin.jvm.functions.Function1
                    public final RumFeature invoke(FeatureSdkCore it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        FeatureScope feature = it.getFeature("rum");
                        if (feature != null) {
                            return (RumFeature) feature.unwrap();
                        }
                        return null;
                    }
                });
                RumMonitor rumMonitor = (RumMonitor) this.this$0.withSdkCore(new Function1<FeatureSdkCore, RumMonitor>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$androidXLifecycleCallbacks$2$rumMonitor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final RumMonitor invoke(FeatureSdkCore it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return GlobalRumMonitor.get(it);
                    }
                });
                if (rumFeature != null && rumMonitor != null) {
                    ComponentPredicate<androidx.fragment.app.Fragment> supportFragmentComponentPredicate$dd_sdk_android_rum_release = this.this$0.getSupportFragmentComponentPredicate$dd_sdk_android_rum_release();
                    final FragmentViewTrackingStrategy fragmentViewTrackingStrategy = this.this$0;
                    return new AndroidXFragmentLifecycleCallbacks(new Function1<androidx.fragment.app.Fragment, Map<String, ? extends Object>>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$androidXLifecycleCallbacks$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Map<String, Object> invoke(androidx.fragment.app.Fragment it) {
                            LinkedHashMap linkedHashMap;
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (fragmentViewTrackingStrategy.getTrackArguments()) {
                                linkedHashMap = MapsKt.toMutableMap(BundleExtKt.convertToRumViewAttributes(it.getArguments()));
                            } else {
                                linkedHashMap = new LinkedHashMap();
                            }
                            return LocalAttributeKt.enrichWithConstantAttribute(linkedHashMap, ViewScopeInstrumentationType.Native.FRAGMENT);
                        }
                    }, supportFragmentComponentPredicate$dd_sdk_android_rum_release, rumFeature, rumMonitor);
                }
                return new NoOpFragmentLifecycleCallbacks();
            }
        });
        this.oreoLifecycleCallbacks = LazyKt.lazy(new Function0<FragmentLifecycleCallbacks<Activity>>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$oreoLifecycleCallbacks$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FragmentLifecycleCallbacks<Activity> invoke() {
                RumFeature rumFeature = (RumFeature) this.this$0.withSdkCore(new Function1<FeatureSdkCore, RumFeature>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$oreoLifecycleCallbacks$2$rumFeature$1
                    @Override // kotlin.jvm.functions.Function1
                    public final RumFeature invoke(FeatureSdkCore it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        FeatureScope feature = it.getFeature("rum");
                        if (feature != null) {
                            return (RumFeature) feature.unwrap();
                        }
                        return null;
                    }
                });
                RumMonitor rumMonitor = (RumMonitor) this.this$0.withSdkCore(new Function1<FeatureSdkCore, RumMonitor>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$oreoLifecycleCallbacks$2$rumMonitor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final RumMonitor invoke(FeatureSdkCore it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return GlobalRumMonitor.get(it);
                    }
                });
                if (this.this$0.getBuildSdkVersionProvider().getIsAtLeastO() && rumFeature != null && rumMonitor != null) {
                    ComponentPredicate<Fragment> defaultFragmentComponentPredicate$dd_sdk_android_rum_release = this.this$0.getDefaultFragmentComponentPredicate$dd_sdk_android_rum_release();
                    BuildSdkVersionProvider buildSdkVersionProvider2 = this.this$0.getBuildSdkVersionProvider();
                    final FragmentViewTrackingStrategy fragmentViewTrackingStrategy = this.this$0;
                    return new OreoFragmentLifecycleCallbacks(new Function1<Fragment, Map<String, ? extends Object>>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy$oreoLifecycleCallbacks$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Map<String, Object> invoke(Fragment it) {
                            LinkedHashMap linkedHashMap;
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (fragmentViewTrackingStrategy.getTrackArguments()) {
                                linkedHashMap = MapsKt.toMutableMap(BundleExtKt.convertToRumViewAttributes(it.getArguments()));
                            } else {
                                linkedHashMap = new LinkedHashMap();
                            }
                            return LocalAttributeKt.enrichWithConstantAttribute(linkedHashMap, ViewScopeInstrumentationType.Native.FRAGMENT);
                        }
                    }, defaultFragmentComponentPredicate$dd_sdk_android_rum_release, rumFeature, rumMonitor, buildSdkVersionProvider2);
                }
                return new NoOpFragmentLifecycleCallbacks();
            }
        });
    }

    public /* synthetic */ FragmentViewTrackingStrategy(boolean z, AcceptAllSupportFragments acceptAllSupportFragments, AcceptAllDefaultFragment acceptAllDefaultFragment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? new AcceptAllSupportFragments() : acceptAllSupportFragments, (i & 4) != 0 ? new AcceptAllDefaultFragment() : acceptAllDefaultFragment);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentViewTrackingStrategy(boolean z, ComponentPredicate<androidx.fragment.app.Fragment> supportFragmentComponentPredicate, ComponentPredicate<Fragment> defaultFragmentComponentPredicate) {
        this(z, supportFragmentComponentPredicate, defaultFragmentComponentPredicate, BuildSdkVersionProvider.INSTANCE.getDEFAULT());
        Intrinsics.checkNotNullParameter(supportFragmentComponentPredicate, "supportFragmentComponentPredicate");
        Intrinsics.checkNotNullParameter(defaultFragmentComponentPredicate, "defaultFragmentComponentPredicate");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLifecycleCallbacks<FragmentActivity> getAndroidXLifecycleCallbacks() {
        return (FragmentLifecycleCallbacks) this.androidXLifecycleCallbacks.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLifecycleCallbacks<Activity> getOreoLifecycleCallbacks() {
        return (FragmentLifecycleCallbacks) this.oreoLifecycleCallbacks.getValue();
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStarted(activity);
        withSdkCore(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.tracking.FragmentViewTrackingStrategy.onActivityStarted.1
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
                boolean zIsAssignableFrom = FragmentActivity.class.isAssignableFrom(activity.getClass());
                FragmentViewTrackingStrategy fragmentViewTrackingStrategy = this;
                if (zIsAssignableFrom) {
                    FragmentLifecycleCallbacks androidXLifecycleCallbacks = fragmentViewTrackingStrategy.getAndroidXLifecycleCallbacks();
                    Activity activity2 = activity;
                    Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    androidXLifecycleCallbacks.register((FragmentActivity) activity2, sdkCore);
                    return;
                }
                fragmentViewTrackingStrategy.getOreoLifecycleCallbacks().register(activity, sdkCore);
            }
        });
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStopped(activity);
        if (FragmentActivity.class.isAssignableFrom(activity.getClass())) {
            getAndroidXLifecycleCallbacks().unregister((FragmentActivity) activity);
        } else {
            getOreoLifecycleCallbacks().unregister(activity);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.rum.tracking.FragmentViewTrackingStrategy");
        FragmentViewTrackingStrategy fragmentViewTrackingStrategy = (FragmentViewTrackingStrategy) other;
        return this.trackArguments == fragmentViewTrackingStrategy.trackArguments && Intrinsics.areEqual(this.supportFragmentComponentPredicate, fragmentViewTrackingStrategy.supportFragmentComponentPredicate) && Intrinsics.areEqual(this.defaultFragmentComponentPredicate, fragmentViewTrackingStrategy.defaultFragmentComponentPredicate);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.trackArguments) * 31) + this.supportFragmentComponentPredicate.hashCode()) * 31) + this.defaultFragmentComponentPredicate.hashCode();
    }
}
