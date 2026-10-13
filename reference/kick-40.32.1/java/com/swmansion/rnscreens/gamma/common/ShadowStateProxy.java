package com.swmansion.rnscreens.gamma.common;

import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.StateWrapper;
import com.swmansion.rnscreens.utils.DimensionUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ShadowStateProxy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JC\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/common/ShadowStateProxy;", "", "includesFrameSize", "", "<init>", "(Z)V", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper$react_native_screens_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_screens_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "lastFrameWidthInDp", "", "lastFrameHeightInDp", "lastContentOffsetXInDp", "lastContentOffsetYInDp", "updateStateIfNeeded", "", "density", "frameWidth", "", "frameHeight", "contentOffsetX", "contentOffsetY", "(FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShadowStateProxy {
    private static final float DELTA = 0.1f;
    private final boolean includesFrameSize;
    private float lastContentOffsetXInDp;
    private float lastContentOffsetYInDp;
    private float lastFrameHeightInDp;
    private float lastFrameWidthInDp;
    private StateWrapper stateWrapper;

    public ShadowStateProxy() {
        this(false, 1, null);
    }

    public ShadowStateProxy(boolean z) {
        this.includesFrameSize = z;
    }

    public /* synthetic */ ShadowStateProxy(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    /* JADX INFO: renamed from: getStateWrapper$react_native_screens_release, reason: from getter */
    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper$react_native_screens_release(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public static /* synthetic */ void updateStateIfNeeded$default(ShadowStateProxy shadowStateProxy, float f, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        if ((i & 16) != 0) {
            num4 = null;
        }
        shadowStateProxy.updateStateIfNeeded(f, num, num2, num3, num4);
    }

    public final void updateStateIfNeeded(float density, Integer frameWidth, Integer frameHeight, Integer contentOffsetX, Integer contentOffsetY) {
        float fPxToDp = frameWidth != null ? DimensionUtilsKt.pxToDp(frameWidth.intValue(), density) : this.lastFrameWidthInDp;
        float fPxToDp2 = frameHeight != null ? DimensionUtilsKt.pxToDp(frameHeight.intValue(), density) : this.lastFrameHeightInDp;
        float fPxToDp3 = contentOffsetX != null ? DimensionUtilsKt.pxToDp(contentOffsetX.intValue(), density) : this.lastContentOffsetXInDp;
        float fPxToDp4 = contentOffsetY != null ? DimensionUtilsKt.pxToDp(contentOffsetY.intValue(), density) : this.lastContentOffsetYInDp;
        if (Math.abs(this.lastFrameWidthInDp - fPxToDp) >= 0.1f || Math.abs(this.lastFrameHeightInDp - fPxToDp2) >= 0.1f || Math.abs(this.lastContentOffsetXInDp - fPxToDp3) >= 0.1f || Math.abs(this.lastContentOffsetYInDp - fPxToDp4) >= 0.1f) {
            this.lastFrameWidthInDp = fPxToDp;
            this.lastFrameHeightInDp = fPxToDp2;
            this.lastContentOffsetXInDp = fPxToDp3;
            this.lastContentOffsetYInDp = fPxToDp4;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            if (this.includesFrameSize) {
                writableNativeMap.putDouble("frameWidth", fPxToDp);
                writableNativeMap.putDouble("frameHeight", fPxToDp2);
            }
            writableNativeMap.putDouble("contentOffsetX", fPxToDp3);
            writableNativeMap.putDouble("contentOffsetY", fPxToDp4);
            StateWrapper stateWrapper = this.stateWrapper;
            if (stateWrapper != null) {
                stateWrapper.updateState(writableNativeMap);
            }
        }
    }
}
