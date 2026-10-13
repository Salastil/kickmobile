package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001aJA\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001cH\u0007¢\u0006\u0004\b!\u0010\"J7\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001cH\u0007¢\u0006\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010)\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0007R\u001a\u0010-\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010+\u001a\u0004\b/\u0010\u0007R\u0014\u0010\u001b\u001a\u00020\u001c8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u0010\u001e\u001a\u00020\u001c8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00101R\u0018\u00103\u001a\u00020\u0019*\u0002048CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00067"}, d2 = {"Landroidx/compose/material3/WideNavigationRailDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "modalCollapsedShape", "getModalCollapsedShape", "modalExpandedShape", "getModalExpandedShape", "ModalExpandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "getModalExpandedProperties", "()Landroidx/compose/material3/ModalWideNavigationRailProperties;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WideNavigationRailColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailColors;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailColors;", "containerShape", "getContainerShape$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getContainerShape", "modalContainerShape", "getModalContainerShape$annotations", "getModalContainerShape", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "getModalContainerColor", "defaultWideWideNavigationRailColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultWideWideNavigationRailColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WideNavigationRailColors;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WideNavigationRailDefaults {
    public static final int $stable = 0;
    public static final WideNavigationRailDefaults INSTANCE = new WideNavigationRailDefaults();
    private static final ModalWideNavigationRailProperties ModalExpandedProperties = WideNavigationRail_androidKt.createDefaultModalWideNavigationRailProperties();
    private static final PaddingValues ContentPadding = PaddingKt.m2346PaddingValuesa9UjIt4(Dp.m10168constructorimpl(0.0f), WideNavigationRailKt.WNRVerticalPadding, Dp.m10168constructorimpl(0.0f), WideNavigationRailKt.WNRVerticalPadding);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of shape.", replaceWith = @ReplaceWith(expression = "WideNavigationRailDefaults.shape", imports = {}))
    public static /* synthetic */ void getContainerShape$annotations(Composer composer, int i) {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of modalExpandedShape.", replaceWith = @ReplaceWith(expression = "WideNavigationRailDefaults.modalExpandedShape", imports = {}))
    public static /* synthetic */ void getModalContainerShape$annotations(Composer composer, int i) {
    }

    private WideNavigationRailDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1756160851, "C(<get-shape>)1127@54294L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1756160851, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-shape> (WideNavigationRail.kt:1127)");
        }
        Shape value = ShapesKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Arrangement.Vertical getArrangement() {
        return Arrangement.INSTANCE.getTop();
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1769402286, "C(<get-windowInsets>)1137@54592L29:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1769402286, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-windowInsets> (WideNavigationRail.kt:1137)");
        }
        WindowInsets windowInsetsM2445onlybOOhFvg = WindowInsetsKt.m2445onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m2457plusgK_yJZ4(WindowInsetsSides.INSTANCE.m2472getVerticalJoeWqyM(), WindowInsetsSides.INSTANCE.m2470getStartJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM2445onlybOOhFvg;
    }

    public final Shape getModalCollapsedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 926228775, "C(<get-modalCollapsedShape>)1143@54852L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(926228775, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalCollapsedShape> (WideNavigationRail.kt:1143)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    public final Shape getModalExpandedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1865689797, "C(<get-modalExpandedShape>)1147@55046L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1865689797, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalExpandedShape> (WideNavigationRail.kt:1147)");
        }
        Shape value = ShapesKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final ModalWideNavigationRailProperties getModalExpandedProperties() {
        return ModalExpandedProperties;
    }

    public final WideNavigationRailColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 255272712, "C(colors)1157@55450L11,1157@55462L35:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(255272712, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:1157)");
        }
        WideNavigationRailColors defaultWideWideNavigationRailColors = getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultWideWideNavigationRailColors;
    }

    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final WideNavigationRailColors m5244colorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 239918099, "C(colors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,modalContainerColor:c#ui.graphics.Color,modalScrimColor:c#ui.graphics.Color,modalContentColor:c#ui.graphics.Color)1176@56611L14,1177@56657L31,1178@56776L5,1180@56855L5,1181@56932L36,1183@57026L11,1183@57038L35:WideNavigationRail.kt#uh7d8r");
        long containerColor = (i2 & 1) != 0 ? INSTANCE.getContainerColor(composer, 6) : j;
        long jM3712contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composer, i & 14) : j2;
        long value = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), composer, 6) : j3;
        long jM7337copywmQWz5c$default = (i2 & 8) != 0 ? Color.m7337copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM3712contentColorForek8zF_U2 = (i2 & 16) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(value, composer, (i >> 6) & 14) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239918099, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:1183)");
        }
        WideNavigationRailColors wideNavigationRailColorsM5237copyt635Npw = getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i >> 12) & 112).m5237copyt635Npw(containerColor, jM3712contentColorForek8zF_U, value, jM7337copywmQWz5c$default, jM3712contentColorForek8zF_U2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return wideNavigationRailColorsM5237copyt635Npw;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with modalContentColor parameter")
    /* JADX INFO: renamed from: colors-ro_MJ88, reason: not valid java name */
    public final /* synthetic */ WideNavigationRailColors m5243colorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1139423876, "C(colors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,modalContainerColor:c#ui.graphics.Color,modalScrimColor:c#ui.graphics.Color)1219@58635L14,1220@58681L31,1221@58800L5,1222@58867L5,1224@58965L11,1224@58977L35,1229@59239L36:WideNavigationRail.kt#uh7d8r");
        long containerColor = (i2 & 1) != 0 ? INSTANCE.getContainerColor(composer, 6) : j;
        long jM3712contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composer, i & 14) : j2;
        long value = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), composer, 6) : j3;
        long jM7337copywmQWz5c$default = (i2 & 8) != 0 ? Color.m7337copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1139423876, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:1224)");
        }
        WideNavigationRailColors wideNavigationRailColorsM5237copyt635Npw = getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i >> 9) & 112).m5237copyt635Npw(containerColor, jM3712contentColorForek8zF_U, value, jM7337copywmQWz5c$default, ColorSchemeKt.m3712contentColorForek8zF_U(value, composer, (i >> 6) & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return wideNavigationRailColorsM5237copyt635Npw;
    }

    public final Shape getContainerShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2020122139, "C(<get-containerShape>)1240@59680L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020122139, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-containerShape> (WideNavigationRail.kt:1240)");
        }
        Shape value = ShapesKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getModalContainerShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -5121925, "C(<get-modalContainerShape>)1250@60120L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-5121925, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalContainerShape> (WideNavigationRail.kt:1250)");
        }
        Shape value = ShapesKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    private final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2034736487, "C(<get-containerColor>)1253@60238L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2034736487, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-containerColor> (WideNavigationRail.kt:1253)");
        }
        long value = ColorSchemeKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    private final long getModalContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1008951947, "C(<get-modalContainerColor>)1256@60365L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1008951947, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalContainerColor> (WideNavigationRail.kt:1256)");
        }
        long value = ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    private final WideNavigationRailColors getDefaultWideWideNavigationRailColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1969597361, "C(<get-defaultWideWideNavigationRailColors>):WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1969597361, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-defaultWideWideNavigationRailColors> (WideNavigationRail.kt:1260)");
        }
        WideNavigationRailColors defaultWideWideNavigationRailColorsCached = colorScheme.getDefaultWideWideNavigationRailColorsCached();
        if (defaultWideWideNavigationRailColorsCached != null) {
            composer.startReplaceGroup(1297515721);
        } else {
            composer.startReplaceGroup(1297532678);
            ComposerKt.sourceInformation(composer, "1263@60645L14,1264@60716L14,1265@60779L19,1266@60860L19,1268@60979L5");
            int i2 = (i >> 3) & 14;
            defaultWideWideNavigationRailColorsCached = new WideNavigationRailColors(getContainerColor(composer, i2), ColorSchemeKt.m3711contentColorFor4WTKRHQ(colorScheme, getContainerColor(composer, i2)), getModalContainerColor(composer, i2), Color.m7337copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m3711contentColorFor4WTKRHQ(colorScheme, getModalContainerColor(composer, i2)), null);
            colorScheme.setDefaultWideWideNavigationRailColorsCached$material3(defaultWideWideNavigationRailColorsCached);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultWideWideNavigationRailColorsCached;
    }
}
