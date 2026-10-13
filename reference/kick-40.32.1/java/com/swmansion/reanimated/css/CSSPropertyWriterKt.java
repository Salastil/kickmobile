package com.swmansion.reanimated.css;

import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: CSSPropertyWriter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"cssPropertyWriterFor", "Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "propertyId", "", "fromBits", "", "toBits", "toColorInt", "react-native-reanimated_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CSSPropertyWriterKt {
    private static final int toColorInt(double d) {
        return (int) d;
    }

    public static final CSSPropertyWriter cssPropertyWriterFor(int i, double d, double d2) {
        if (i == 0) {
            return AlphaProperty.INSTANCE;
        }
        if (i == 1) {
            return new ColorBlendWriter(ViewProps.BACKGROUND_COLOR, toColorInt(d), toColorInt(d2), BackgroundColorAccess.INSTANCE);
        }
        if (i == 2) {
            return new ColorBlendWriter(ViewProps.BORDER_COLOR, toColorInt(d), toColorInt(d2), BorderColorAccess.INSTANCE);
        }
        if (i == 3) {
            return BorderRadiusWriter.INSTANCE;
        }
        if (i != 4) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 28 ? new ColorBlendWriter(ViewProps.SHADOW_COLOR, toColorInt(d), toColorInt(d2), ShadowColorAccess.INSTANCE) : null;
    }
}
