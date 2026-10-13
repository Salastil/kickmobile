package expo.modules.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawablePainter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"rememberDrawablePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DrawablePainterKt {
    public static final Painter rememberDrawablePainter(Drawable drawable, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 57873960, "C(rememberDrawablePainter)N(drawable)16@667L194:DrawablePainter.kt#65hdq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(57873960, i, -1, "expo.modules.ui.graphics.rememberDrawablePainter (DrawablePainter.kt:15)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -217696182, "CC(remember):DrawablePainter.kt#9igjgp");
        boolean zChanged = composer.changed(drawable);
        BitmapPainter bitmapPainterRememberedValue = composer.rememberedValue();
        if (zChanged || bitmapPainterRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (drawable == null) {
                bitmapPainterRememberedValue = null;
            } else if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                bitmapPainterRememberedValue = new BitmapPainter(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), 0L, 0L, 6, null);
            } else {
                Drawable drawableMutate = drawable.mutate();
                Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
                bitmapPainterRememberedValue = new DrawablePainter(drawableMutate);
            }
            composer.updateRememberedValue(bitmapPainterRememberedValue);
        }
        Painter painter = (Painter) bitmapPainterRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return painter;
    }
}
