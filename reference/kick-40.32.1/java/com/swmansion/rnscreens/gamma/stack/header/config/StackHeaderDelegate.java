package com.swmansion.rnscreens.gamma.stack.header.config;

import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: StackHeaderDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderDelegate;", "", "onHeaderFrameChanged", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "contentOffsetY", "onMenuItemClicked", "id", "", "onGroupSelectionChanged", "groupId", "selectedIds", "", "onSubviewOriginChanged", "type", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewType;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StackHeaderDelegate {
    void onGroupSelectionChanged(String groupId, List<String> selectedIds);

    void onHeaderFrameChanged(int width, int height, int contentOffsetY);

    void onMenuItemClicked(String id);

    void onSubviewOriginChanged(StackHeaderSubviewType type, int x, int y);
}
