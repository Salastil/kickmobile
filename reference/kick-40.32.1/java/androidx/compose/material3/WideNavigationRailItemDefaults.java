package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationRailColorTokens;
import androidx.compose.material3.tokens.NavigationRailHorizontalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011JU\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0018\u0010!\u001a\u00020\u0010*\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/material3/WideNavigationRailItemDefaults;", "", "<init>", "()V", "indicatorPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "railExpanded", "", "collapsedPadding", "expandedPadding", "(ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/PaddingValues;", "iconPositionFor", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPositionFor-s8pcRp0", "(Z)I", "colors", "Landroidx/compose/material3/NavigationItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationItemColors;", "IndicatorCollapsedPadding", "getIndicatorCollapsedPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "IndicatorExpandedPadding", "getIndicatorExpandedPadding", "defaultWideNavigationRailItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultWideNavigationRailItemColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WideNavigationRailItemDefaults {
    public static final int $stable = 0;
    public static final WideNavigationRailItemDefaults INSTANCE = new WideNavigationRailItemDefaults();
    private static final PaddingValues IndicatorCollapsedPadding = PaddingKt.m2344PaddingValuesYgX7TsA(WideNavigationRailKt.ItemTopIconIndicatorHorizontalPadding, WideNavigationRailKt.ItemTopIconIndicatorVerticalPadding);
    private static final PaddingValues IndicatorExpandedPadding = PaddingKt.m2344PaddingValuesYgX7TsA(NavigationRailHorizontalItemTokens.INSTANCE.m5995getFullWidthLeadingSpaceD9Ej5fM(), WideNavigationRailKt.ItemStartIconIndicatorVerticalPadding);

    private WideNavigationRailItemDefaults() {
    }

    public final PaddingValues indicatorPadding(boolean z, PaddingValues paddingValues, PaddingValues paddingValues2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 273422139, "C(indicatorPadding)N(railExpanded,collapsedPadding,expandedPadding)1292@61889L151:WideNavigationRail.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            paddingValues = IndicatorCollapsedPadding;
        }
        if ((i2 & 4) != 0) {
            paddingValues2 = IndicatorExpandedPadding;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(273422139, i, -1, "androidx.compose.material3.WideNavigationRailItemDefaults.indicatorPadding (WideNavigationRail.kt:1292)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 765677714, "CC(remember):WideNavigationRail.kt#9igjgp");
        boolean z2 = ((((i & 112) ^ 48) > 32 && composer.changed(paddingValues)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(paddingValues2)) || (i & 384) == 256) | ((((i & 14) ^ 6) > 4 && composer.changed(z)) || (i & 6) == 4);
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new DynamicPaddingValues(paddingValues, paddingValues2, z);
            composer.updateRememberedValue(objRememberedValue);
        }
        DynamicPaddingValues dynamicPaddingValues = (DynamicPaddingValues) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dynamicPaddingValues;
    }

    /* JADX INFO: renamed from: iconPositionFor-s8pcRp0, reason: not valid java name */
    public final int m5246iconPositionFors8pcRp0(boolean railExpanded) {
        NavigationItemIconPosition.Companion companion = NavigationItemIconPosition.INSTANCE;
        return railExpanded ? companion.m4420getStartxw1Ddg() : companion.m4421getTopxw1Ddg();
    }

    public final NavigationItemColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 911821421, "C(colors)1307@62523L11:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(911821421, i, -1, "androidx.compose.material3.WideNavigationRailItemDefaults.colors (WideNavigationRail.kt:1307)");
        }
        NavigationItemColors defaultWideNavigationRailItemColors = getDefaultWideNavigationRailItemColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultWideNavigationRailItemColors;
    }

    /* JADX INFO: renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationItemColors m5245colors69fazGs(long j, long j2, long j3, long j4, long j5, long j6, long j7, Composer composer, int i, int i2) {
        long j8;
        long jM7337copywmQWz5c$default;
        long j9;
        long jM7337copywmQWz5c$default2;
        ComposerKt.sourceInformationMarkerStart(composer, 1759081702, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedIndicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color,disabledIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color)1324@63561L5,1325@63649L5,1326@63742L5,1327@63829L5,1328@63921L5,1332@64148L11:WideNavigationRail.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIcon(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveLabelText(), composer, 6) : j2;
        long value3 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIndicator(), composer, 6) : j3;
        long value4 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveIcon(), composer, 6) : j4;
        long value5 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText(), composer, 6) : j5;
        if ((i2 & 32) != 0) {
            long j10 = value4;
            jM7337copywmQWz5c$default = Color.m7337copywmQWz5c$default(j10, 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            j8 = j10;
        } else {
            j8 = value4;
            jM7337copywmQWz5c$default = j6;
        }
        if ((i2 & 64) != 0) {
            long j11 = value5;
            jM7337copywmQWz5c$default2 = Color.m7337copywmQWz5c$default(j11, 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            j9 = j11;
        } else {
            j9 = value5;
            jM7337copywmQWz5c$default2 = j7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1759081702, i, -1, "androidx.compose.material3.WideNavigationRailItemDefaults.colors (WideNavigationRail.kt:1332)");
        }
        NavigationItemColors navigationItemColorsM4403copy4JmcsL4 = getDefaultWideNavigationRailItemColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4403copy4JmcsL4(value, value2, value3, j8, j9, jM7337copywmQWz5c$default, jM7337copywmQWz5c$default2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return navigationItemColorsM4403copy4JmcsL4;
    }

    public final PaddingValues getIndicatorCollapsedPadding() {
        return IndicatorCollapsedPadding;
    }

    public final PaddingValues getIndicatorExpandedPadding() {
        return IndicatorExpandedPadding;
    }

    private final NavigationItemColors getDefaultWideNavigationRailItemColors(ColorScheme colorScheme) {
        NavigationItemColors defaultWideNavigationRailItemColorsCached = colorScheme.getDefaultWideNavigationRailItemColorsCached();
        if (defaultWideNavigationRailItemColorsCached != null) {
            return defaultWideNavigationRailItemColorsCached;
        }
        NavigationItemColors navigationItemColors = new NavigationItemColors(ColorSchemeKt.fromToken(colorScheme, NavigationRailColorTokens.INSTANCE.getItemActiveIcon()), ColorSchemeKt.fromToken(colorScheme, NavigationRailColorTokens.INSTANCE.getItemActiveLabelText()), ColorSchemeKt.fromToken(colorScheme, NavigationRailColorTokens.INSTANCE.getItemActiveIndicator()), ColorSchemeKt.fromToken(colorScheme, NavigationRailColorTokens.INSTANCE.getItemInactiveIcon()), ColorSchemeKt.fromToken(colorScheme, NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationRailColorTokens.INSTANCE.getItemInactiveIcon()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultWideNavigationRailItemColorsCached$material3(navigationItemColors);
        return navigationItemColors;
    }
}
