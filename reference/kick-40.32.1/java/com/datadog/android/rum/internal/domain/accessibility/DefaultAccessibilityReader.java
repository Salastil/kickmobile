package com.datadog.android.rum.internal.domain.accessibility;

import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.GapComposerKt;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultAccessibilityReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\u0018\u001b\u001f\b\u0000\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001@B]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020,H\u0002J\u000f\u0010-\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010.J\u000f\u0010/\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010.J\u000f\u00100\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010.J\u000f\u00101\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010.J\u0019\u00102\u001a\u0004\u0018\u00010)2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u00103J\u0017\u00104\u001a\u0004\u0018\u00010)2\u0006\u00105\u001a\u00020,H\u0002¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020&H\u0017J\b\u0010;\u001a\u00020&H\u0002J\b\u0010<\u001a\u00020&H\u0002J\u001c\u0010=\u001a\u00020&2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020?H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilityReader;", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilityInfo;", "Landroid/content/ComponentCallbacks;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "applicationContext", "Landroid/content/Context;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "activityManager", "Landroid/app/ActivityManager;", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "secureWrapper", "Lcom/datadog/android/rum/internal/domain/accessibility/SecureWrapper;", "globalWrapper", "Lcom/datadog/android/rum/internal/domain/accessibility/GlobalWrapper;", "handler", "Landroid/os/Handler;", "(Lcom/datadog/android/api/InternalLogger;Landroid/content/Context;Lcom/datadog/android/internal/time/TimeProvider;Landroid/content/res/Resources;Landroid/app/ActivityManager;Landroid/view/accessibility/AccessibilityManager;Lcom/datadog/android/rum/internal/domain/accessibility/SecureWrapper;Lcom/datadog/android/rum/internal/domain/accessibility/GlobalWrapper;Landroid/os/Handler;)V", "animationDurationListener", "com/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilityReader$animationDurationListener$1", "Lcom/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilityReader$animationDurationListener$1;", "captioningListener", "com/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilityReader$captioningListener$1", "Lcom/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilityReader$captioningListener$1;", "currentState", "displayInversionListener", "com/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilityReader$displayInversionListener$1", "Lcom/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilityReader$displayInversionListener$1;", "lastPollTime", "Ljava/util/concurrent/atomic/AtomicLong;", "touchListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "buildInitialState", "", "cleanup", "getRtlEnabled", "", "getState", "getTextSize", "", "isClosedCaptioningEnabled", "()Ljava/lang/Boolean;", "isDisplayInversionEnabled", "isLockToScreenEnabled", "isReducedAnimationsEnabled", "isScreenReaderEnabled", "(Landroid/view/accessibility/AccessibilityManager;)Ljava/lang/Boolean;", "isSettingEnabled", "key", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onLowMemory", "pollForAttributesWithoutListeners", "registerListeners", "updateState", "updater", "Lkotlin/Function1;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultAccessibilityReader implements InfoProvider<AccessibilityInfo>, ComponentCallbacks {
    public static final String CAPTIONING_ENABLED_KEY = "accessibility_captioning_enabled";
    public static final long POLL_THRESHOLD = 30000;
    private final AccessibilityManager accessibilityManager;
    private final ActivityManager activityManager;
    private final DefaultAccessibilityReader$animationDurationListener$1 animationDurationListener;
    private final Context applicationContext;
    private final DefaultAccessibilityReader$captioningListener$1 captioningListener;
    private volatile AccessibilityInfo currentState;
    private final DefaultAccessibilityReader$displayInversionListener$1 displayInversionListener;
    private final GlobalWrapper globalWrapper;
    private final Handler handler;
    private final InternalLogger internalLogger;
    private final AtomicLong lastPollTime;
    private final Resources resources;
    private final SecureWrapper secureWrapper;
    private final TimeProvider timeProvider;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchListener;

    @Override // android.content.ComponentCallbacks
    @Deprecated(message = "Deprecated in Java")
    public void onLowMemory() {
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$displayInversionListener$1] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$captioningListener$1] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$animationDurationListener$1] */
    public DefaultAccessibilityReader(InternalLogger internalLogger, Context applicationContext, TimeProvider timeProvider, Resources resources, ActivityManager activityManager, AccessibilityManager accessibilityManager, SecureWrapper secureWrapper, GlobalWrapper globalWrapper, final Handler handler) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(secureWrapper, "secureWrapper");
        Intrinsics.checkNotNullParameter(globalWrapper, "globalWrapper");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.internalLogger = internalLogger;
        this.applicationContext = applicationContext;
        this.timeProvider = timeProvider;
        this.resources = resources;
        this.activityManager = activityManager;
        this.accessibilityManager = accessibilityManager;
        this.secureWrapper = secureWrapper;
        this.globalWrapper = globalWrapper;
        this.handler = handler;
        this.displayInversionListener = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$displayInversionListener$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                final Boolean boolIsDisplayInversionEnabled = this.this$0.isDisplayInversionEnabled();
                this.this$0.updateState(new Function1<AccessibilityInfo, AccessibilityInfo>() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$displayInversionListener$1$onChange$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AccessibilityInfo invoke(AccessibilityInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return AccessibilityInfo.copy$default(it, null, null, boolIsDisplayInversionEnabled, null, null, null, null, 123, null);
                    }
                });
            }
        };
        this.captioningListener = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$captioningListener$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                final Boolean boolIsClosedCaptioningEnabled = this.this$0.isClosedCaptioningEnabled();
                this.this$0.updateState(new Function1<AccessibilityInfo, AccessibilityInfo>() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$captioningListener$1$onChange$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AccessibilityInfo invoke(AccessibilityInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return AccessibilityInfo.copy$default(it, null, null, null, boolIsClosedCaptioningEnabled, null, null, null, 119, null);
                    }
                });
            }
        };
        this.animationDurationListener = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$animationDurationListener$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                final Boolean boolIsReducedAnimationsEnabled = this.this$0.isReducedAnimationsEnabled();
                this.this$0.updateState(new Function1<AccessibilityInfo, AccessibilityInfo>() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$animationDurationListener$1$onChange$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AccessibilityInfo invoke(AccessibilityInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return AccessibilityInfo.copy$default(it, null, null, null, null, boolIsReducedAnimationsEnabled, null, null, 111, null);
                    }
                });
            }
        };
        this.touchListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                DefaultAccessibilityReader.touchListener$lambda$0(this.f$0, z);
            }
        };
        this.currentState = new AccessibilityInfo(null, null, null, null, null, null, null, 127, null);
        this.lastPollTime = new AtomicLong(0L);
        registerListeners();
        buildInitialState();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultAccessibilityReader(InternalLogger internalLogger, Context context, TimeProvider timeProvider, Resources resources, ActivityManager activityManager, AccessibilityManager accessibilityManager, SecureWrapper secureWrapper, GlobalWrapper globalWrapper, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Resources resources2;
        ActivityManager activityManager2;
        AccessibilityManager accessibilityManager2;
        if ((i & 8) != 0) {
            Resources resources3 = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "applicationContext.resources");
            resources2 = resources3;
        } else {
            resources2 = resources;
        }
        if ((i & 16) != 0) {
            Object systemService = context.getSystemService("activity");
            activityManager2 = (ActivityManager) (systemService instanceof ActivityManager ? systemService : null);
        } else {
            activityManager2 = activityManager;
        }
        if ((i & 32) != 0) {
            Object systemService2 = context.getSystemService("accessibility");
            accessibilityManager2 = (AccessibilityManager) (systemService2 instanceof AccessibilityManager ? systemService2 : null);
        } else {
            accessibilityManager2 = accessibilityManager;
        }
        this(internalLogger, context, timeProvider, resources2, activityManager2, accessibilityManager2, (i & 64) != 0 ? new SecureWrapper() : secureWrapper, (i & 128) != 0 ? new GlobalWrapper() : globalWrapper, (i & 256) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    static final void touchListener$lambda$0(DefaultAccessibilityReader defaultAccessibilityReader, boolean z) {
        final Boolean boolIsScreenReaderEnabled = defaultAccessibilityReader.isScreenReaderEnabled(defaultAccessibilityReader.accessibilityManager);
        defaultAccessibilityReader.updateState(new Function1<AccessibilityInfo, AccessibilityInfo>() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader$touchListener$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AccessibilityInfo invoke(AccessibilityInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessibilityInfo.copy$default(it, null, boolIsScreenReaderEnabled, null, null, null, null, null, GapComposerKt.nodeKey, null);
            }
        });
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(this.touchListener);
        }
        this.applicationContext.getContentResolver().unregisterContentObserver(this.animationDurationListener);
        this.applicationContext.getContentResolver().unregisterContentObserver(this.captioningListener);
        this.applicationContext.getContentResolver().unregisterContentObserver(this.displayInversionListener);
        this.applicationContext.unregisterComponentCallbacks(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        final boolean rtlEnabled = getRtlEnabled();
        final String textSize = getTextSize();
        updateState(new Function1<AccessibilityInfo, AccessibilityInfo>() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader.onConfigurationChanged.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AccessibilityInfo invoke(AccessibilityInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessibilityInfo.copy$default(it, textSize, null, null, null, null, null, Boolean.valueOf(rtlEnabled), 62, null);
            }
        });
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    /* JADX INFO: renamed from: getState */
    public synchronized AccessibilityInfo getCurrentState() {
        long deviceTimestampMillis = this.timeProvider.getDeviceTimestampMillis();
        if (deviceTimestampMillis - this.lastPollTime.get() >= 30000) {
            this.lastPollTime.set(deviceTimestampMillis);
            pollForAttributesWithoutListeners();
        }
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void updateState(Function1<? super AccessibilityInfo, AccessibilityInfo> updater) {
        this.currentState = updater.invoke(this.currentState);
    }

    private final void buildInitialState() {
        String textSize = getTextSize();
        Boolean boolIsScreenReaderEnabled = isScreenReaderEnabled(this.accessibilityManager);
        Boolean boolIsDisplayInversionEnabled = isDisplayInversionEnabled();
        Boolean boolIsLockToScreenEnabled = isLockToScreenEnabled();
        this.currentState = new AccessibilityInfo(textSize, boolIsScreenReaderEnabled, boolIsDisplayInversionEnabled, isClosedCaptioningEnabled(), isReducedAnimationsEnabled(), boolIsLockToScreenEnabled, Boolean.valueOf(getRtlEnabled()));
    }

    private final void registerListeners() {
        this.applicationContext.registerComponentCallbacks(this);
        this.applicationContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_display_inversion_enabled"), false, this.displayInversionListener);
        this.applicationContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor(CAPTIONING_ENABLED_KEY), false, this.captioningListener);
        this.applicationContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("animator_duration_scale"), false, this.animationDurationListener);
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.touchListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean isDisplayInversionEnabled() {
        return isSettingEnabled("accessibility_display_inversion_enabled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean isClosedCaptioningEnabled() {
        return isSettingEnabled(CAPTIONING_ENABLED_KEY);
    }

    private final Boolean isLockToScreenEnabled() {
        ActivityManager activityManager = this.activityManager;
        if (activityManager == null) {
            return null;
        }
        return Boolean.valueOf(activityManager.getLockTaskModeState() != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean isReducedAnimationsEnabled() {
        Float float$dd_sdk_android_rum_release = this.globalWrapper.getFloat$dd_sdk_android_rum_release(this.internalLogger, this.applicationContext, "animator_duration_scale");
        if (float$dd_sdk_android_rum_release != null) {
            return Boolean.valueOf(float$dd_sdk_android_rum_release.floatValue() == 0.0f);
        }
        return null;
    }

    private final Boolean isSettingEnabled(String key) {
        Integer int$dd_sdk_android_rum_release = this.secureWrapper.getInt$dd_sdk_android_rum_release(this.internalLogger, this.applicationContext, key);
        if (int$dd_sdk_android_rum_release != null) {
            return Boolean.valueOf(int$dd_sdk_android_rum_release.intValue() == 1);
        }
        return null;
    }

    private final String getTextSize() {
        return String.valueOf(this.resources.getConfiguration().fontScale);
    }

    private final boolean getRtlEnabled() {
        return this.resources.getConfiguration().getLayoutDirection() == 1;
    }

    private final Boolean isScreenReaderEnabled(AccessibilityManager accessibilityManager) {
        if (accessibilityManager != null) {
            return Boolean.valueOf(accessibilityManager.isTouchExplorationEnabled());
        }
        return null;
    }

    private final void pollForAttributesWithoutListeners() {
        final Boolean boolIsLockToScreenEnabled = isLockToScreenEnabled();
        updateState(new Function1<AccessibilityInfo, AccessibilityInfo>() { // from class: com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader.pollForAttributesWithoutListeners.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AccessibilityInfo invoke(AccessibilityInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return AccessibilityInfo.copy$default(it, null, null, null, null, null, boolIsLockToScreenEnabled, null, 95, null);
            }
        });
    }
}
