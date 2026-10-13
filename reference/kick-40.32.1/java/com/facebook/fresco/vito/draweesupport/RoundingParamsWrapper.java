package com.facebook.fresco.vito.draweesupport;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.fresco.vito.options.BorderOptions;
import com.facebook.fresco.vito.options.RoundingOptions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundingParamsWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/facebook/fresco/vito/draweesupport/RoundingParamsWrapper;", "", "<init>", "()V", "roundingOptionsFromRoundingParams", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "roundingParams", "Lcom/facebook/drawee/generic/RoundingParams;", "roundAtRenderTime", "", "borderOptionsFromRoundingParams", "Lcom/facebook/fresco/vito/options/BorderOptions;", "drawee-support_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoundingParamsWrapper {
    public static final RoundingParamsWrapper INSTANCE = new RoundingParamsWrapper();

    @JvmStatic
    public static final RoundingOptions roundingOptionsFromRoundingParams(RoundingParams roundingParams) {
        return roundingOptionsFromRoundingParams$default(roundingParams, false, 2, null);
    }

    private RoundingParamsWrapper() {
    }

    public static /* synthetic */ RoundingOptions roundingOptionsFromRoundingParams$default(RoundingParams roundingParams, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return roundingOptionsFromRoundingParams(roundingParams, z);
    }

    @JvmStatic
    public static final RoundingOptions roundingOptionsFromRoundingParams(RoundingParams roundingParams, boolean roundAtRenderTime) {
        if (roundingParams == null) {
            return null;
        }
        if (roundingParams.getRoundAsCircle()) {
            if (roundAtRenderTime) {
                return RoundingOptions.INSTANCE.asCircle(true, true);
            }
            return RoundingOptions.INSTANCE.asCircle();
        }
        if (roundingParams.getCornersRadii() == null) {
            return null;
        }
        if (roundAtRenderTime) {
            float[] cornersRadii = roundingParams.getCornersRadii();
            Intrinsics.checkNotNull(cornersRadii);
            return new RoundingOptions(false, 0.0f, cornersRadii, true, true);
        }
        RoundingOptions.Companion companion = RoundingOptions.INSTANCE;
        float[] cornersRadii2 = roundingParams.getCornersRadii();
        Intrinsics.checkNotNull(cornersRadii2);
        return companion.forCornerRadii(cornersRadii2, true);
    }

    @JvmStatic
    public static final BorderOptions borderOptionsFromRoundingParams(RoundingParams roundingParams) {
        if (roundingParams == null || roundingParams.getBorderWidth() <= 0.0f) {
            return null;
        }
        return BorderOptions.INSTANCE.create(roundingParams.getBorderColor(), roundingParams.getBorderWidth(), roundingParams.getPadding(), roundingParams.getScaleDownInsideBorders());
    }
}
