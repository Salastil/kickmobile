package com.facebook.fresco.vito.core.impl.debug;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugOverlayImageOriginColor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayImageOriginColor;", "", "<init>", "()V", "imageOriginColorMap", "", "", "", "getImageOriginColor", "imageOrigin", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DebugOverlayImageOriginColor {
    public static final DebugOverlayImageOriginColor INSTANCE = new DebugOverlayImageOriginColor();
    private static final Map<String, Integer> imageOriginColorMap = MapsKt.hashMapOf(TuplesKt.to("unknown", -7829368), TuplesKt.to("network", Integer.valueOf(SupportMenu.CATEGORY_MASK)), TuplesKt.to("disk", -256), TuplesKt.to("memory_encoded", -256), TuplesKt.to("memory_bitmap", -16711936), TuplesKt.to(ImagesContract.LOCAL, -16711936));

    private DebugOverlayImageOriginColor() {
    }

    @JvmStatic
    public static final int getImageOriginColor(String imageOrigin) {
        Intrinsics.checkNotNullParameter(imageOrigin, "imageOrigin");
        Integer num = imageOriginColorMap.get(imageOrigin);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
