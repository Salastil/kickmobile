package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u0087\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\u001a2\b\b\u0002\u0010%\u001a\u00020\u001aH\u0007¢\u0006\u0004\b&\u0010'JK\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u0005H\u0007¢\u0006\u0004\b4\u00105J[\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u00020\u001a2\b\b\u0002\u0010<\u001a\u00020\u001a2\b\b\u0002\u0010=\u001a\u00020\u001a2\b\b\u0002\u0010>\u001a\u00020\u001a2\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u0005H\u0007¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u0087\u0001\u0010C\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\u001a2\b\b\u0002\u0010%\u001a\u00020\u001aH\u0007¢\u0006\u0004\bD\u0010'JK\u0010G\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u0005H\u0007¢\u0006\u0004\bH\u00105R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010(\u001a\u00020\u0017*\u00020)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0018\u0010E\u001a\u00020\u0017*\u00020)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010+R\u0011\u0010I\u001a\u00020J8G¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006M"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "HorizontalSpacing", "getHorizontalSpacing-D9Ej5fM", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "spacing", "horizontalArrangement-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "filterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "filterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultFilterChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "filterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "filterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", ViewProps.BORDER_COLOR, "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", ViewProps.BORDER_WIDTH, "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "elevatedFilterChipColors", "elevatedFilterChipColors-XqyqHi0", "defaultElevatedFilterChipColors", "getDefaultElevatedFilterChipColors$material3", "elevatedFilterChipElevation", "elevatedFilterChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterChipDefaults {
    public static final int $stable = 0;
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float Height = FilterChipTokens.INSTANCE.m5869getContainerHeightD9Ej5fM();
    private static final float IconSize = FilterChipTokens.INSTANCE.m5885getIconSizeD9Ej5fM();
    private static final float HorizontalSpacing = Dp.m10168constructorimpl(8.0f);
    private static final PaddingValues ContentPadding = PaddingKt.m2345PaddingValuesYgX7TsA$default(Dp.m10168constructorimpl(8.0f), 0.0f, 2, null);

    private FilterChipDefaults() {
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m3972getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3974getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getHorizontalSpacing-D9Ej5fM, reason: not valid java name */
    public final float m3973getHorizontalSpacingD9Ej5fM() {
        return HorizontalSpacing;
    }

    public final Arrangement.Horizontal horizontalArrangement() {
        return ChipKt.DefaultHorizontalArrangement;
    }

    /* JADX INFO: renamed from: horizontalArrangement-0680j_4, reason: not valid java name */
    public final Arrangement.Horizontal m3975horizontalArrangement0680j_4(float spacing) {
        if (Dp.m10173equalsimpl0(spacing, HorizontalSpacing)) {
            return ChipKt.DefaultHorizontalArrangement;
        }
        return new ChipArrangement(spacing, null);
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final SelectableChipColors filterChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1743772077, "C(filterChipColors)1940@95756L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1743772077, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1940)");
        }
        SelectableChipColors defaultFilterChipColors$material3 = getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilterChipColors$material3;
    }

    /* JADX INFO: renamed from: filterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m3970filterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1831479801, "C(filterChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)1975@97755L11:Chip.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        long jM7374getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j7;
        long jM7374getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j8;
        long jM7374getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j9;
        long jM7374getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j10;
        long jM7374getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j11;
        long jM7374getUnspecified0d7_KjU12 = (i3 & 2048) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, i, i2, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1975)");
        }
        SelectableChipColors selectableChipColorsM4626copydaRQuJA = getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4626copydaRQuJA(jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, jM7374getUnspecified0d7_KjU6, jM7374getUnspecified0d7_KjU7, jM7374getUnspecified0d7_KjU8, jM7374getUnspecified0d7_KjU9, jM7374getUnspecified0d7_KjU10, jM7374getUnspecified0d7_KjU11, jM7374getUnspecified0d7_KjU12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipColorsM4626copydaRQuJA;
    }

    public final SelectableChipColors getDefaultFilterChipColors$material3(ColorScheme colorScheme) {
        SelectableChipColors defaultFilterChipColorsCached = colorScheme.getDefaultFilterChipColorsCached();
        if (defaultFilterChipColorsCached != null) {
            return defaultFilterChipColorsCached;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(Color.INSTANCE.m7373getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.INSTANCE.m7373getTransparent0d7_KjU(), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledTrailingIconColor()), FilterChipTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getFlatSelectedContainerColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor()), FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
        colorScheme.setDefaultFilterChipColorsCached$material3(selectableChipColors);
        return selectableChipColors;
    }

    /* JADX INFO: renamed from: filterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m3971filterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -757972185, "C(filterChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m5876getFlatContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = FilterChipTokens.INSTANCE.m5880getFlatSelectedPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilterChipTokens.INSTANCE.m5877getFlatSelectedFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilterChipTokens.INSTANCE.m5878getFlatSelectedHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float fM5870getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m5870getDraggedContainerElevationD9Ej5fM() : f5;
        float f11 = (i2 & 32) != 0 ? f7 : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:2045)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f7, f8, f9, f10, fM5870getDraggedContainerElevationD9Ej5fM, f11, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }

    /* JADX INFO: renamed from: filterChipBorder-_7El2pE, reason: not valid java name */
    public final BorderStroke m3969filterChipBorder_7El2pE(boolean z, boolean z2, long j, long j2, long j3, long j4, float f, float f2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1138342447, "C(filterChipBorder)N(enabled,selected,borderColor:c#ui.graphics.Color,selectedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,disabledSelectedBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp,selectedBorderWidth:c#ui.unit.Dp)2073@103346L5,2076@103510L5:Chip.kt#uh7d8r");
        long value = (i2 & 4) != 0 ? ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer, 6) : j;
        long jM7373getTransparent0d7_KjU = (i2 & 8) != 0 ? Color.INSTANCE.m7373getTransparent0d7_KjU() : j2;
        long jM7337copywmQWz5c$default = (i2 & 16) != 0 ? Color.m7337copywmQWz5c$default(ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer, 6), FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM7373getTransparent0d7_KjU2 = (i2 & 32) != 0 ? Color.INSTANCE.m7373getTransparent0d7_KjU() : j4;
        float fM5883getFlatUnselectedOutlineWidthD9Ej5fM = (i2 & 64) != 0 ? FilterChipTokens.INSTANCE.m5883getFlatUnselectedOutlineWidthD9Ej5fM() : f;
        float fM5879getFlatSelectedOutlineWidthD9Ej5fM = (i2 & 128) != 0 ? FilterChipTokens.INSTANCE.m5879getFlatSelectedOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1138342447, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:2082)");
        }
        if (!z) {
            value = z2 ? jM7373getTransparent0d7_KjU2 : jM7337copywmQWz5c$default;
        } else if (z2) {
            value = jM7373getTransparent0d7_KjU;
        }
        if (z2) {
            fM5883getFlatUnselectedOutlineWidthD9Ej5fM = fM5879getFlatSelectedOutlineWidthD9Ej5fM;
        }
        BorderStroke borderStrokeM1584BorderStrokecXLIe8U = BorderStrokeKt.m1584BorderStrokecXLIe8U(fM5883getFlatUnselectedOutlineWidthD9Ej5fM, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM1584BorderStrokecXLIe8U;
    }

    public final SelectableChipColors elevatedFilterChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1082953289, "C(elevatedFilterChipColors)2097@104396L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1082953289, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:2097)");
        }
        SelectableChipColors defaultElevatedFilterChipColors$material3 = getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedFilterChipColors$material3;
    }

    /* JADX INFO: renamed from: elevatedFilterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m3967elevatedFilterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -915841711, "C(elevatedFilterChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)2132@106416L11:Chip.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        long jM7374getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j7;
        long jM7374getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j8;
        long jM7374getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j9;
        long jM7374getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j10;
        long jM7374getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j11;
        long jM7374getUnspecified0d7_KjU12 = (i3 & 2048) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, i, i2, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:2132)");
        }
        SelectableChipColors selectableChipColorsM4626copydaRQuJA = getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4626copydaRQuJA(jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, jM7374getUnspecified0d7_KjU6, jM7374getUnspecified0d7_KjU7, jM7374getUnspecified0d7_KjU8, jM7374getUnspecified0d7_KjU9, jM7374getUnspecified0d7_KjU10, jM7374getUnspecified0d7_KjU11, jM7374getUnspecified0d7_KjU12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipColorsM4626copydaRQuJA;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColors$material3(ColorScheme colorScheme) {
        SelectableChipColors defaultElevatedFilterChipColorsCached = colorScheme.getDefaultElevatedFilterChipColorsCached();
        if (defaultElevatedFilterChipColorsCached != null) {
            return defaultElevatedFilterChipColorsCached;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledTrailingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
        colorScheme.setDefaultElevatedFilterChipColorsCached$material3(selectableChipColors);
        return selectableChipColors;
    }

    /* JADX INFO: renamed from: elevatedFilterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m3968elevatedFilterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 684803697, "C(elevatedFilterChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m5871getElevatedContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = FilterChipTokens.INSTANCE.m5875getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilterChipTokens.INSTANCE.m5873getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilterChipTokens.INSTANCE.m5874getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float fM5870getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m5870getDraggedContainerElevationD9Ej5fM() : f5;
        float fM5872getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? FilterChipTokens.INSTANCE.m5872getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:2203)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f7, f8, f9, f10, fM5870getDraggedContainerElevationD9Ej5fM, fM5872getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1598643637, "C(<get-shape>)2214@111247L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, i, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:2214)");
        }
        Shape value = ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }
}
