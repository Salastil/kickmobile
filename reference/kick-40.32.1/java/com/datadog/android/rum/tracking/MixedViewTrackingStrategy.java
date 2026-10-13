package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MixedViewTrackingStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B?\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fB\u0017\b\u0000\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/tracking/MixedViewTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "trackExtras", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "Landroid/app/Activity;", "supportFragmentComponentPredicate", "Landroidx/fragment/app/Fragment;", "defaultFragmentComponentPredicate", "Landroid/app/Fragment;", "(ZLcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/tracking/ComponentPredicate;)V", "activityViewTrackingStrategy", "Lcom/datadog/android/rum/tracking/ActivityViewTrackingStrategy;", "fragmentViewTrackingStrategy", "Lcom/datadog/android/rum/tracking/FragmentViewTrackingStrategy;", "(Lcom/datadog/android/rum/tracking/ActivityViewTrackingStrategy;Lcom/datadog/android/rum/tracking/FragmentViewTrackingStrategy;)V", "getActivityViewTrackingStrategy$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/tracking/ActivityViewTrackingStrategy;", "getFragmentViewTrackingStrategy$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/tracking/FragmentViewTrackingStrategy;", "equals", "other", "", "hashCode", "", "register", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "unregister", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MixedViewTrackingStrategy extends ActivityLifecycleTrackingStrategy implements ViewTrackingStrategy {
    private final ActivityViewTrackingStrategy activityViewTrackingStrategy;
    private final FragmentViewTrackingStrategy fragmentViewTrackingStrategy;

    public MixedViewTrackingStrategy(boolean z) {
        this(z, null, null, null, 14, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MixedViewTrackingStrategy(boolean z, ComponentPredicate<Activity> componentPredicate) {
        this(z, componentPredicate, null, null, 12, null);
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MixedViewTrackingStrategy(boolean z, ComponentPredicate<Activity> componentPredicate, ComponentPredicate<Fragment> supportFragmentComponentPredicate) {
        this(z, componentPredicate, supportFragmentComponentPredicate, null, 8, null);
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        Intrinsics.checkNotNullParameter(supportFragmentComponentPredicate, "supportFragmentComponentPredicate");
    }

    /* JADX INFO: renamed from: getActivityViewTrackingStrategy$dd_sdk_android_rum_release, reason: from getter */
    public final ActivityViewTrackingStrategy getActivityViewTrackingStrategy() {
        return this.activityViewTrackingStrategy;
    }

    /* JADX INFO: renamed from: getFragmentViewTrackingStrategy$dd_sdk_android_rum_release, reason: from getter */
    public final FragmentViewTrackingStrategy getFragmentViewTrackingStrategy() {
        return this.fragmentViewTrackingStrategy;
    }

    public MixedViewTrackingStrategy(ActivityViewTrackingStrategy activityViewTrackingStrategy, FragmentViewTrackingStrategy fragmentViewTrackingStrategy) {
        Intrinsics.checkNotNullParameter(activityViewTrackingStrategy, "activityViewTrackingStrategy");
        Intrinsics.checkNotNullParameter(fragmentViewTrackingStrategy, "fragmentViewTrackingStrategy");
        this.activityViewTrackingStrategy = activityViewTrackingStrategy;
        this.fragmentViewTrackingStrategy = fragmentViewTrackingStrategy;
    }

    public /* synthetic */ MixedViewTrackingStrategy(boolean z, AcceptAllActivities acceptAllActivities, AcceptAllSupportFragments acceptAllSupportFragments, AcceptAllDefaultFragment acceptAllDefaultFragment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? new AcceptAllActivities() : acceptAllActivities, (i & 4) != 0 ? new AcceptAllSupportFragments() : acceptAllSupportFragments, (i & 8) != 0 ? new AcceptAllDefaultFragment() : acceptAllDefaultFragment);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MixedViewTrackingStrategy(boolean z, ComponentPredicate<Activity> componentPredicate, ComponentPredicate<Fragment> supportFragmentComponentPredicate, ComponentPredicate<android.app.Fragment> defaultFragmentComponentPredicate) {
        this(new ActivityViewTrackingStrategy(z, componentPredicate), new FragmentViewTrackingStrategy(z, supportFragmentComponentPredicate, defaultFragmentComponentPredicate));
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        Intrinsics.checkNotNullParameter(supportFragmentComponentPredicate, "supportFragmentComponentPredicate");
        Intrinsics.checkNotNullParameter(defaultFragmentComponentPredicate, "defaultFragmentComponentPredicate");
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
        super.register(sdkCore, context);
        this.activityViewTrackingStrategy.register(sdkCore, context);
        this.fragmentViewTrackingStrategy.register(sdkCore, context);
    }

    @Override // com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy, com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
        this.activityViewTrackingStrategy.unregister(context);
        this.fragmentViewTrackingStrategy.unregister(context);
        super.unregister(context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.rum.tracking.MixedViewTrackingStrategy");
        MixedViewTrackingStrategy mixedViewTrackingStrategy = (MixedViewTrackingStrategy) other;
        return Intrinsics.areEqual(this.activityViewTrackingStrategy, mixedViewTrackingStrategy.activityViewTrackingStrategy) && Intrinsics.areEqual(this.fragmentViewTrackingStrategy, mixedViewTrackingStrategy.fragmentViewTrackingStrategy);
    }

    public int hashCode() {
        return (this.activityViewTrackingStrategy.hashCode() * 31) + this.fragmentViewTrackingStrategy.hashCode();
    }
}
