package androidx.compose.material3;

import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: compiled from: Scrim.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/ScrimDefaults;", "", "<init>", "()V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor", "(Landroidx/compose/runtime/Composer;I)J", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrimDefaults {
    public static final int $stable = 0;
    public static final ScrimDefaults INSTANCE = new ScrimDefaults();

    private ScrimDefaults() {
    }

    public final long getColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1410314537, "C(<get-color>)86@3465L5:Scrim.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1410314537, i, -1, "androidx.compose.material3.ScrimDefaults.<get-color> (Scrim.kt:86)");
        }
        long jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM7337copywmQWz5c$default;
    }
}
