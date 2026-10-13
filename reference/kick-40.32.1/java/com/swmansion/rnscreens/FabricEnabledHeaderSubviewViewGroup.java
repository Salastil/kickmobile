package com.swmansion.rnscreens;

import android.content.Context;
import android.view.ViewGroup;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ViewProps;
import com.swmansion.rnscreens.utils.DimensionUtilsKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: FabricEnabledHeaderSubviewViewGroup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J(\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0004J(\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/swmansion/rnscreens/FabricEnabledHeaderSubviewViewGroup;", "Landroid/view/ViewGroup;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mStateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "lastWidth", "", "lastHeight", "lastOffsetX", "lastOffsetY", "setStateWrapper", "", "wrapper", "updateSubviewFrameState", ViewProps.WIDTH, "", ViewProps.HEIGHT, "offsetX", "offsetY", "updateState", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class FabricEnabledHeaderSubviewViewGroup extends ViewGroup {
    private static final float DELTA = 0.9f;
    private float lastHeight;
    private float lastOffsetX;
    private float lastOffsetY;
    private float lastWidth;
    private StateWrapper mStateWrapper;

    public FabricEnabledHeaderSubviewViewGroup(Context context) {
        super(context);
    }

    public final void setStateWrapper(StateWrapper wrapper) {
        this.mStateWrapper = wrapper;
    }

    protected final void updateSubviewFrameState(int width, int height, int offsetX, int offsetY) {
        updateState(width, height, offsetX, offsetY);
    }

    public final void updateState(int width, int height, int offsetX, int offsetY) {
        FabricEnabledHeaderSubviewViewGroup fabricEnabledHeaderSubviewViewGroup = this;
        float fPxToDp = DimensionUtilsKt.pxToDp(fabricEnabledHeaderSubviewViewGroup, width);
        float fPxToDp2 = DimensionUtilsKt.pxToDp(fabricEnabledHeaderSubviewViewGroup, height);
        float fPxToDp3 = DimensionUtilsKt.pxToDp(fabricEnabledHeaderSubviewViewGroup, offsetX);
        float fPxToDp4 = DimensionUtilsKt.pxToDp(fabricEnabledHeaderSubviewViewGroup, offsetY);
        if (Math.abs(this.lastWidth - fPxToDp) >= DELTA || Math.abs(this.lastHeight - fPxToDp2) >= DELTA || Math.abs(this.lastOffsetX - fPxToDp3) >= DELTA || Math.abs(this.lastOffsetY - fPxToDp4) >= DELTA) {
            this.lastWidth = fPxToDp;
            this.lastHeight = fPxToDp2;
            this.lastOffsetX = fPxToDp3;
            this.lastOffsetY = fPxToDp4;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("frameWidth", fPxToDp);
            writableNativeMap.putDouble("frameHeight", fPxToDp2);
            writableNativeMap.putDouble("contentOffsetX", fPxToDp3);
            writableNativeMap.putDouble("contentOffsetY", fPxToDp4);
            WritableNativeMap writableNativeMap2 = writableNativeMap;
            StateWrapper stateWrapper = this.mStateWrapper;
            if (stateWrapper != null) {
                stateWrapper.updateState(writableNativeMap2);
            }
        }
    }
}
