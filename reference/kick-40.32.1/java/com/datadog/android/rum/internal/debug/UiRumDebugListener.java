package com.datadog.android.rum.internal.debug;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.monitor.NoOpAdvancedRumMonitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiRumDebugListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010#\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010$\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010%\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010&\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\"H\u0017J\u0010\u0010(\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010)\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0016\u0010*\u001a\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0017J\u0016\u0010-\u001a\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/datadog/android/rum/internal/debug/UiRumDebugListener;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Lcom/datadog/android/rum/internal/debug/RumDebugListener;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "advancedRumMonitor", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;)V", "rumViewsContainer", "Landroid/widget/LinearLayout;", "getRumViewsContainer$dd_sdk_android_rum_release", "()Landroid/widget/LinearLayout;", "setRumViewsContainer$dd_sdk_android_rum_release", "(Landroid/widget/LinearLayout;)V", "viewsSnapshot", "", "", "createDebugTextView", "Landroid/widget/TextView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "viewName", "alpha", "", "dpToPx", "dp", "", "findContentView", "Landroid/widget/FrameLayout;", "activity", "Landroid/app/Activity;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onReceiveRumActiveViews", "viewNames", "", "showRumViewsInfo", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UiRumDebugListener implements Application.ActivityLifecycleCallbacks, RumDebugListener {
    public static final String CANNOT_FIND_CONTENT_VIEW_MESSAGE = "Cannot enable RUM debugging, because root content view can't be found";
    public static final int DEFAULT_ALPHA = 200;
    private final AdvancedRumMonitor advancedRumMonitor;
    private LinearLayout rumViewsContainer;
    private final FeatureSdkCore sdkCore;
    private final List<String> viewsSnapshot;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ACTIVE_COLOR = Color.rgb(99, 44, WebmConstants.MkvEbmlElement.BLOCK_MORE);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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

    public UiRumDebugListener(FeatureSdkCore sdkCore, AdvancedRumMonitor advancedRumMonitor) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(advancedRumMonitor, "advancedRumMonitor");
        this.sdkCore = sdkCore;
        this.advancedRumMonitor = advancedRumMonitor;
        this.viewsSnapshot = new ArrayList();
    }

    /* JADX INFO: renamed from: getRumViewsContainer$dd_sdk_android_rum_release, reason: from getter */
    public final LinearLayout getRumViewsContainer() {
        return this.rumViewsContainer;
    }

    public final void setRumViewsContainer$dd_sdk_android_rum_release(LinearLayout linearLayout) {
        this.rumViewsContainer = linearLayout;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.advancedRumMonitor instanceof NoOpAdvancedRumMonitor) {
            return;
        }
        FrameLayout frameLayoutFindContentView = findContentView(activity);
        if (frameLayoutFindContentView == null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.debug.UiRumDebugListener.onActivityResumed.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return UiRumDebugListener.CANNOT_FIND_CONTENT_VIEW_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        this.rumViewsContainer = linearLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        frameLayoutFindContentView.addView(linearLayout, layoutParams);
        this.advancedRumMonitor.setDebugListener(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.advancedRumMonitor instanceof NoOpAdvancedRumMonitor) {
            return;
        }
        FrameLayout frameLayoutFindContentView = findContentView(activity);
        if (frameLayoutFindContentView != null) {
            frameLayoutFindContentView.removeView(this.rumViewsContainer);
        }
        this.rumViewsContainer = null;
        this.advancedRumMonitor.setDebugListener(null);
        this.viewsSnapshot.clear();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065 A[Catch: all -> 0x0071, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x0010, B:8:0x001c, B:10:0x0028, B:21:0x006d, B:13:0x0032, B:14:0x0036, B:16:0x003c, B:18:0x0054, B:20:0x0065), top: B:27:0x0008 }] */
    @Override // com.datadog.android.rum.internal.debug.RumDebugListener
    public void onReceiveRumActiveViews(final List<String> viewNames) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(viewNames, "viewNames");
        synchronized (this.viewsSnapshot) {
            if (!this.viewsSnapshot.isEmpty() && this.viewsSnapshot.size() == viewNames.size()) {
                Iterable iterableWithIndex = CollectionsKt.withIndex(this.viewsSnapshot);
                if (!(iterableWithIndex instanceof Collection) || !((Collection) iterableWithIndex).isEmpty()) {
                    Iterator it = iterableWithIndex.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            IndexedValue indexedValue = (IndexedValue) it.next();
                            if (!Intrinsics.areEqual(indexedValue.getValue(), CollectionsKt.getOrNull(viewNames, indexedValue.getIndex()))) {
                                this.viewsSnapshot.clear();
                                this.viewsSnapshot.addAll(viewNames);
                                linearLayout = this.rumViewsContainer;
                                if (linearLayout != null) {
                                    linearLayout.post(new Runnable() { // from class: com.datadog.android.rum.internal.debug.UiRumDebugListener$$ExternalSyntheticLambda0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.showRumViewsInfo(viewNames);
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            } else {
                this.viewsSnapshot.clear();
                this.viewsSnapshot.addAll(viewNames);
                linearLayout = this.rumViewsContainer;
                if (linearLayout != null) {
                    linearLayout.post(new Runnable() { // from class: com.datadog.android.rum.internal.debug.UiRumDebugListener$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.showRumViewsInfo(viewNames);
                        }
                    });
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRumViewsInfo(List<String> viewNames) {
        LinearLayout linearLayout = this.rumViewsContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (viewNames.isEmpty()) {
                Context context = linearLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                linearLayout.addView(createDebugTextView(context, "No active RUM View", 200));
            } else {
                for (IndexedValue indexedValue : CollectionsKt.withIndex(CollectionsKt.reversed(viewNames))) {
                    Context context2 = linearLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    linearLayout.addView(createDebugTextView(context2, (String) indexedValue.getValue(), (int) (255.0d * Math.pow(0.75d, indexedValue.getIndex() + 1))));
                }
            }
        }
    }

    private final TextView createDebugTextView(Context context, String viewName, int alpha) {
        TextView textView = new TextView(context);
        textView.setGravity(1);
        int i = ACTIVE_COLOR;
        textView.setBackgroundColor(Color.argb(alpha, Color.red(i), Color.green(i), Color.blue(i)));
        textView.setTextColor(-1);
        int iDpToPx = dpToPx(2.0f, context);
        textView.setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        textView.setText(viewName);
        return textView;
    }

    private final FrameLayout findContentView(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        View viewFindViewById = viewGroup != null ? viewGroup.findViewById(R.id.content) : null;
        if (viewFindViewById instanceof FrameLayout) {
            return (FrameLayout) viewFindViewById;
        }
        return null;
    }

    private final int dpToPx(float dp, Context context) {
        return (int) (((double) (dp * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    /* JADX INFO: compiled from: UiRumDebugListener.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/internal/debug/UiRumDebugListener$Companion;", "", "()V", "ACTIVE_COLOR", "", "getACTIVE_COLOR", "()I", "CANNOT_FIND_CONTENT_VIEW_MESSAGE", "", "DEFAULT_ALPHA", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getACTIVE_COLOR() {
            return UiRumDebugListener.ACTIVE_COLOR;
        }
    }
}
