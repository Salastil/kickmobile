package com.datadog.android.rum.internal.domain.display;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.InfoProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DefaultDisplayInfoProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u000f\b\u0000\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/domain/display/DefaultDisplayInfoProvider;", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "applicationContext", "Landroid/content/Context;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "systemSettingsWrapper", "Lcom/datadog/android/rum/internal/domain/display/SystemSettingsWrapper;", "contentResolver", "Landroid/content/ContentResolver;", "handler", "Landroid/os/Handler;", "(Landroid/content/Context;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/rum/internal/domain/display/SystemSettingsWrapper;Landroid/content/ContentResolver;Landroid/os/Handler;)V", "brightnessObserver", "com/datadog/android/rum/internal/domain/display/DefaultDisplayInfoProvider$brightnessObserver$1", "Lcom/datadog/android/rum/internal/domain/display/DefaultDisplayInfoProvider$brightnessObserver$1;", "currentState", "buildInitialState", "", "cleanup", "getState", "normalizeValue", "", "value", "", "registerListeners", "roundToOneDecimalPlace", "input", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultDisplayInfoProvider implements InfoProvider<DisplayInfo> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float DECIMAL_SCALING = 10.0f;

    @Deprecated
    public static final float MAX_BRIGHTNESS = 255.0f;
    private final Context applicationContext;
    private final DefaultDisplayInfoProvider$brightnessObserver$1 brightnessObserver;
    private final ContentResolver contentResolver;
    private volatile DisplayInfo currentState;
    private final Handler handler;
    private final InternalLogger internalLogger;
    private final SystemSettingsWrapper systemSettingsWrapper;

    /* JADX WARN: Type inference failed for: r2v2, types: [com.datadog.android.rum.internal.domain.display.DefaultDisplayInfoProvider$brightnessObserver$1] */
    public DefaultDisplayInfoProvider(Context applicationContext, InternalLogger internalLogger, SystemSettingsWrapper systemSettingsWrapper, ContentResolver contentResolver, final Handler handler) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(systemSettingsWrapper, "systemSettingsWrapper");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.applicationContext = applicationContext;
        this.internalLogger = internalLogger;
        this.systemSettingsWrapper = systemSettingsWrapper;
        this.contentResolver = contentResolver;
        this.handler = handler;
        this.currentState = new DisplayInfo(null, 1, null);
        this.brightnessObserver = new ContentObserver(handler) { // from class: com.datadog.android.rum.internal.domain.display.DefaultDisplayInfoProvider$brightnessObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                int i = this.this$0.systemSettingsWrapper.getInt("screen_brightness");
                if (i != Integer.MIN_VALUE) {
                    float fNormalizeValue = this.this$0.normalizeValue(i);
                    DefaultDisplayInfoProvider defaultDisplayInfoProvider = this.this$0;
                    defaultDisplayInfoProvider.currentState = defaultDisplayInfoProvider.currentState.copy(Float.valueOf(fNormalizeValue));
                }
            }
        };
        registerListeners();
        buildInitialState();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultDisplayInfoProvider(Context context, InternalLogger internalLogger, SystemSettingsWrapper systemSettingsWrapper, ContentResolver contentResolver, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        SystemSettingsWrapper systemSettingsWrapper2 = (i & 4) != 0 ? new SystemSettingsWrapper(context, internalLogger) : systemSettingsWrapper;
        if ((i & 8) != 0) {
            contentResolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "applicationContext.contentResolver");
        }
        this(context, internalLogger, systemSettingsWrapper2, contentResolver, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    /* JADX INFO: renamed from: getState, reason: from getter */
    public DisplayInfo getCurrentState() {
        return this.currentState;
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
        this.contentResolver.unregisterContentObserver(this.brightnessObserver);
    }

    private final void registerListeners() {
        Uri uriFor = Settings.System.getUriFor("screen_brightness");
        if (uriFor != null) {
            this.contentResolver.registerContentObserver(uriFor, false, this.brightnessObserver);
        }
    }

    private final void buildInitialState() {
        int i = this.systemSettingsWrapper.getInt("screen_brightness");
        if (i != Integer.MIN_VALUE) {
            this.currentState = new DisplayInfo(Float.valueOf(normalizeValue(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float normalizeValue(int value) {
        return roundToOneDecimalPlace(value / 255.0f);
    }

    private final float roundToOneDecimalPlace(float input) {
        return MathKt.roundToInt(input * 10.0f) / 10.0f;
    }

    /* JADX INFO: compiled from: DefaultDisplayInfoProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/internal/domain/display/DefaultDisplayInfoProvider$Companion;", "", "()V", "DECIMAL_SCALING", "", "MAX_BRIGHTNESS", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
