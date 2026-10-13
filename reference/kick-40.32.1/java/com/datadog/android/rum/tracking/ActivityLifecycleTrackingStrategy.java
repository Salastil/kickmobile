package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum._RumInternalProxy;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityLifecycleTrackingStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013H\u0017J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J)\u0010 \u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H!0#H\u0004¢\u0006\u0002\u0010$R\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006&"}, d2 = {"Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "()V", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "getInternalLogger$dd_sdk_android_rum_release", "()Lcom/datadog/android/api/InternalLogger;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "getSdkCore", "()Lcom/datadog/android/api/feature/FeatureSdkCore;", "setSdkCore", "(Lcom/datadog/android/api/feature/FeatureSdkCore;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "register", "Lcom/datadog/android/api/SdkCore;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "unregister", "withSdkCore", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ActivityLifecycleTrackingStrategy implements Application.ActivityLifecycleCallbacks, TrackingStrategy {
    public static final String EXTRA_SYNTHETICS_RESULT_ID = "_dd.synthetics.result_id";
    public static final String EXTRA_SYNTHETICS_TEST_ID = "_dd.synthetics.test_id";
    protected FeatureSdkCore sdkCore;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
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

    public final InternalLogger getInternalLogger$dd_sdk_android_rum_release() {
        if (this.sdkCore != null) {
            return getSdkCore().getInternalLogger();
        }
        return InternalLogger.INSTANCE.getUNBOUND();
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Application) {
            setSdkCore((FeatureSdkCore) sdkCore);
            ((Application) context).registerActivityLifecycleCallbacks(this);
        } else {
            InternalLogger.DefaultImpls.log$default(((FeatureSdkCore) sdkCore).getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy.register.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "In order to use the RUM automatic tracking feature you will have to use the Application context when initializing the SDK";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
        if (context instanceof Application) {
            ((Application) context).unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        _RumInternalProxy _ruminternalproxy_getInternal;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.sdkCore == null || (intent = activity.getIntent()) == null || (_ruminternalproxy_getInternal = GlobalRumMonitor.get(getSdkCore())._getInternal()) == null) {
            return;
        }
        _ruminternalproxy_getInternal.setSyntheticsAttributeFromIntent(intent);
    }

    protected final <T> T withSdkCore(Function1<? super FeatureSdkCore, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.sdkCore != null) {
            return block.invoke(getSdkCore());
        }
        InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy.withSdkCore.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "RUM feature is not initialized yet, you need to register it with a SDK instance by calling SdkCore#registerFeature method. Cannot provide SDK instance for view tracking.";
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }
}
