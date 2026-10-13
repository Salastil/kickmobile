package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;

/* JADX INFO: compiled from: StackHeaderToolbarMenuMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asMapOrNull", "Lcom/facebook/react/bridge/ReadableMap;", "Lcom/facebook/react/bridge/Dynamic;", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderToolbarMenuMapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableMap asMapOrNull(Dynamic dynamic) {
        if (dynamic.isNull() || dynamic.getType() != ReadableType.Map) {
            return null;
        }
        return dynamic.asMap();
    }
}
