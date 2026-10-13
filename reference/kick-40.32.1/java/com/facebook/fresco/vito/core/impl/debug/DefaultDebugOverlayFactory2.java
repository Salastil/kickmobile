package com.facebook.fresco.vito.core.impl.debug;

import android.graphics.PointF;
import android.graphics.Rect;
import com.facebook.common.internal.Supplier;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.VitoUtils;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.core.impl.FrescoDrawable2;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultDebugOverlayFactory2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/DefaultDebugOverlayFactory2;", "Lcom/facebook/fresco/vito/core/impl/debug/BaseDebugOverlayFactory2;", "showExtendedInformation", "", "showExtendedImageSourceExtraInformation", "debugOverlayEnabled", "Lcom/facebook/common/internal/Supplier;", "<init>", "(ZZLcom/facebook/common/internal/Supplier;)V", "getShowExtendedInformation", "()Z", "setShowExtendedInformation", "(Z)V", "setShowExtendedImageSourceExtraInformation", "", "setData", "overlay", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;", "drawable", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "setBasicData", "setImageOriginData", "setImageFormatData", "setImageSourceExtra", "setImageRequestData", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DefaultDebugOverlayFactory2 extends BaseDebugOverlayFactory2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean showExtendedImageSourceExtraInformation;
    private boolean showExtendedInformation;

    @JvmStatic
    protected static final String formatDimensions(int i, int i2) {
        return INSTANCE.formatDimensions(i, i2);
    }

    public /* synthetic */ DefaultDebugOverlayFactory2(boolean z, boolean z2, Supplier supplier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2, supplier);
    }

    public final boolean getShowExtendedInformation() {
        return this.showExtendedInformation;
    }

    public final void setShowExtendedInformation(boolean z) {
        this.showExtendedInformation = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDebugOverlayFactory2(boolean z, boolean z2, Supplier<Boolean> debugOverlayEnabled) {
        super(debugOverlayEnabled);
        Intrinsics.checkNotNullParameter(debugOverlayEnabled, "debugOverlayEnabled");
        this.showExtendedInformation = z;
        this.showExtendedImageSourceExtraInformation = z2;
    }

    public final void setShowExtendedImageSourceExtraInformation(boolean showExtendedImageSourceExtraInformation) {
        this.showExtendedImageSourceExtraInformation = showExtendedImageSourceExtraInformation;
    }

    @Override // com.facebook.fresco.vito.core.impl.debug.BaseDebugOverlayFactory2
    protected void setData(DebugOverlayDrawable overlay, FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(overlay, "overlay");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setBasicData(overlay, drawable);
        setImageRequestData(overlay, drawable.getImageRequest());
        setImageOriginData(overlay, extras);
        setImageFormatData(overlay, extras);
        setImageSourceExtra(overlay, extras);
    }

    private final void setBasicData(DebugOverlayDrawable overlay, FrescoDrawableInterface drawable) {
        overlay.setDrawIdentifier(this.showExtendedInformation);
        DebugOverlayDrawable.addDebugData$default(overlay, this.showExtendedInformation ? "ID" : overlay.getIdentifier(), VitoUtils.getStringId(drawable.get_imageId()), 0, 4, null);
        FrescoDrawable2 frescoDrawable2 = drawable instanceof FrescoDrawable2 ? (FrescoDrawable2) drawable : null;
        if (frescoDrawable2 == null) {
            return;
        }
        Rect bounds = frescoDrawable2.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        DebugOverlayDrawable.addDebugData$default(overlay, "D", formatDimensions(bounds.width(), bounds.height()), 0, 4, null);
        if (this.showExtendedInformation) {
            DebugOverlayDrawable.addDebugData$default(overlay, "DAR", String.valueOf(bounds.width() / bounds.height()), 0, 4, null);
        }
        DebugOverlayDrawable.addDebugData$default(overlay, "I", formatDimensions(frescoDrawable2.getActualImageWidthPx(), frescoDrawable2.getActualImageHeightPx()), 0, 4, null);
        if (this.showExtendedInformation && frescoDrawable2.getActualImageHeightPx() > 0) {
            DebugOverlayDrawable.addDebugData$default(overlay, "IAR", String.valueOf(frescoDrawable2.getActualImageWidthPx() / frescoDrawable2.getActualImageHeightPx()), 0, 4, null);
        }
        PointF actualImageFocusPoint = frescoDrawable2.getActualImageFocusPoint();
        if (actualImageFocusPoint != null) {
            DebugOverlayDrawable.addDebugData$default(overlay, "FocusPointX", String.valueOf(actualImageFocusPoint.x), 0, 4, null);
            DebugOverlayDrawable.addDebugData$default(overlay, "FocusPointY", String.valueOf(actualImageFocusPoint.y), 0, 4, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f  */
    private final void setImageOriginData(DebugOverlayDrawable overlay, ControllerListener2.Extras extras) {
        String strValueOf;
        String strValueOf2;
        if (extras != null) {
            Map<String, ? extends Object> map = extras.datasourceExtras;
            if (map == null) {
                map = extras.shortcutExtras;
            }
            if (map != null) {
                strValueOf = String.valueOf(map.get("origin"));
                strValueOf2 = String.valueOf(map.get("origin_sub"));
            } else {
                strValueOf = "unknown";
                strValueOf2 = "unknown";
            }
        } else {
            strValueOf = "unknown";
            strValueOf2 = "unknown";
        }
        if (this.showExtendedInformation) {
            overlay.addDebugData("origin", strValueOf, DebugOverlayImageOriginColor.getImageOriginColor(strValueOf));
            overlay.addDebugData("origin_sub", strValueOf2, -7829368);
            return;
        }
        overlay.addDebugData("o", strValueOf + " | " + strValueOf2, DebugOverlayImageOriginColor.getImageOriginColor(strValueOf));
    }

    private final void setImageFormatData(DebugOverlayDrawable overlay, ControllerListener2.Extras extras) {
        String string;
        Map<String, ? extends Object> map;
        Object obj;
        Map<String, ? extends Object> map2;
        Object obj2;
        Map<String, ? extends Object> map3;
        Object obj3;
        if (extras == null || (map3 = extras.imageExtras) == null || (obj3 = map3.get("image_format")) == null || (string = obj3.toString()) == null) {
            if (extras == null || (map2 = extras.shortcutExtras) == null || (obj2 = map2.get("image_format")) == null) {
                string = (extras == null || (map = extras.datasourceExtras) == null || (obj = map.get("image_format")) == null) ? null : obj.toString();
            } else {
                string = obj2.toString();
            }
        }
        String str = string;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        DebugOverlayDrawable.addDebugData$default(overlay, "format", str, 0, 4, null);
    }

    private final void setImageSourceExtra(DebugOverlayDrawable overlay, ControllerListener2.Extras extras) {
        Map<String, ? extends Object> map;
        if (!this.showExtendedImageSourceExtraInformation || extras == null || (map = extras.imageSourceExtras) == null) {
            return;
        }
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            DebugOverlayDrawable.addDebugData$default(overlay, entry.getKey(), entry.getValue().toString(), 0, 4, null);
        }
    }

    private final void setImageRequestData(DebugOverlayDrawable overlay, VitoImageRequest imageRequest) {
        if (imageRequest == null || !this.showExtendedInformation) {
            return;
        }
        DebugOverlayDrawable.addDebugData$default(overlay, "scale", imageRequest.imageOptions.getActualImageScaleType().toString(), 0, 4, null);
    }

    /* JADX INFO: compiled from: DefaultDebugOverlayFactory2.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0005¨\u0006\t"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/DefaultDebugOverlayFactory2$Companion;", "", "<init>", "()V", "formatDimensions", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        protected final String formatDimensions(int width, int height) {
            return width + ViewDeviceOrientationData.DEVICE_ORIENTATION_X + height;
        }
    }
}
