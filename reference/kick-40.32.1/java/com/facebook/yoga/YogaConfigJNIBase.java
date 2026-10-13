package com.facebook.yoga;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YogaConfigJNIBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0010¢\u0006\u0004\b\u0004\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/yoga/YogaConfigJNIBase;", "Lcom/facebook/yoga/YogaConfig;", "nativePointer", "", "<init>", "(J)V", "()V", "useVanillaJNI", "", "(Z)V", "_logger", "Lcom/facebook/yoga/YogaLogger;", "setExperimentalFeatureEnabled", "", "feature", "Lcom/facebook/yoga/YogaExperimentalFeature;", "enabled", "setUseWebDefaults", "useWebDefaults", "setPointScaleFactor", "pixelsInPoint", "", "setErrata", "errata", "Lcom/facebook/yoga/YogaErrata;", "", "getErrata", "getErrataInt", "setLogger", "logger", "getLogger", "getNativePointer", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class YogaConfigJNIBase extends YogaConfig {
    private YogaLogger _logger;
    protected long nativePointer;

    private YogaConfigJNIBase(long j) {
        this.nativePointer = j;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory".toString());
        }
    }

    public YogaConfigJNIBase() {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    public YogaConfigJNIBase(boolean z) {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setExperimentalFeatureEnabled(YogaExperimentalFeature feature, boolean enabled) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        YogaNative.jni_YGConfigSetExperimentalFeatureEnabledJNI(this.nativePointer, feature.intValue(), enabled);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setUseWebDefaults(boolean useWebDefaults) {
        YogaNative.jni_YGConfigSetUseWebDefaultsJNI(this.nativePointer, useWebDefaults);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setPointScaleFactor(float pixelsInPoint) {
        YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.nativePointer, pixelsInPoint);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setErrata(YogaErrata errata) {
        Intrinsics.checkNotNullParameter(errata, "errata");
        YogaNative.jni_YGConfigSetErrataJNI(this.nativePointer, errata.intValue());
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setErrata(int errata) {
        YogaNative.jni_YGConfigSetErrataJNI(this.nativePointer, errata);
    }

    @Override // com.facebook.yoga.YogaConfig
    public YogaErrata getErrata() {
        return YogaErrata.INSTANCE.fromInt(YogaNative.jni_YGConfigGetErrataJNI(this.nativePointer));
    }

    @Override // com.facebook.yoga.YogaConfig
    public int getErrataInt() {
        return YogaNative.jni_YGConfigGetErrataJNI(this.nativePointer);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setLogger(YogaLogger logger) {
        this._logger = logger;
        YogaNative.jni_YGConfigSetLoggerJNI(this.nativePointer, logger);
    }

    @Override // com.facebook.yoga.YogaConfig
    /* JADX INFO: renamed from: getLogger, reason: from getter */
    public YogaLogger get_logger() {
        return this._logger;
    }

    @Override // com.facebook.yoga.YogaConfig
    public long getNativePointer() {
        return this.nativePointer;
    }
}
