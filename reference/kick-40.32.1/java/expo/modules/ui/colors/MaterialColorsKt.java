package expo.modules.ui.colors;

import android.content.Context;
import android.os.Build;
import androidx.compose.material3.ColorScheme;
import androidx.compose.ui.graphics.ColorKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import com.google.android.material.color.utilities.SchemeTonalSpot;
import expo.modules.ui.ExpoColorScheme;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialColors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0000\u001a\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a\u0013\u0010\u000e\u001a\u00020\u0007*\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0018\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0000\u0010\u0002¨\u0006\u0013"}, d2 = {"isDynamicColorSupported", "", "()Z", "isSystemInDarkTheme", "Landroid/content/Context;", "getMaterialColorTokens", "", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "isDark", "seedColorScheme", "Landroidx/compose/material3/ColorScheme;", "seedArgb", "", "toRgbaHex", "Landroidx/compose/ui/graphics/Color;", "toRgbaHex-8_81llA", "(J)Ljava/lang/String;", "toTokenMap", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MaterialColorsKt {
    private static final boolean isDynamicColorSupported;

    static {
        isDynamicColorSupported = Build.VERSION.SDK_INT >= 31;
    }

    public static final boolean isDynamicColorSupported() {
        return isDynamicColorSupported;
    }

    public static final boolean isSystemInDarkTheme(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final Map<String, String> getMaterialColorTokens(Context context, boolean z) {
        ExpoColorScheme expoColorScheme;
        Intrinsics.checkNotNullParameter(context, "context");
        if (z) {
            expoColorScheme = ExpoColorScheme.DARK;
        } else {
            expoColorScheme = ExpoColorScheme.LIGHT;
        }
        return toTokenMap(expoColorScheme.toColorScheme(context));
    }

    public static final ColorScheme seedColorScheme(int i, boolean z) {
        SchemeTonalSpot schemeTonalSpot = new SchemeTonalSpot(Hct.fromInt(i), z, 0.0d);
        MaterialDynamicColors materialDynamicColors = new MaterialDynamicColors();
        DynamicColor dynamicColorPrimary = materialDynamicColors.primary();
        Intrinsics.checkNotNullExpressionValue(dynamicColorPrimary, "primary(...)");
        long jSeedColorScheme$argb = seedColorScheme$argb(schemeTonalSpot, dynamicColorPrimary);
        DynamicColor dynamicColorOnPrimary = materialDynamicColors.onPrimary();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnPrimary, "onPrimary(...)");
        long jSeedColorScheme$argb2 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnPrimary);
        DynamicColor dynamicColorPrimaryContainer = materialDynamicColors.primaryContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorPrimaryContainer, "primaryContainer(...)");
        long jSeedColorScheme$argb3 = seedColorScheme$argb(schemeTonalSpot, dynamicColorPrimaryContainer);
        DynamicColor dynamicColorOnPrimaryContainer = materialDynamicColors.onPrimaryContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnPrimaryContainer, "onPrimaryContainer(...)");
        long jSeedColorScheme$argb4 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnPrimaryContainer);
        DynamicColor dynamicColorInversePrimary = materialDynamicColors.inversePrimary();
        Intrinsics.checkNotNullExpressionValue(dynamicColorInversePrimary, "inversePrimary(...)");
        long jSeedColorScheme$argb5 = seedColorScheme$argb(schemeTonalSpot, dynamicColorInversePrimary);
        DynamicColor dynamicColorSecondary = materialDynamicColors.secondary();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSecondary, "secondary(...)");
        long jSeedColorScheme$argb6 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSecondary);
        DynamicColor dynamicColorOnSecondary = materialDynamicColors.onSecondary();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnSecondary, "onSecondary(...)");
        long jSeedColorScheme$argb7 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnSecondary);
        DynamicColor dynamicColorSecondaryContainer = materialDynamicColors.secondaryContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSecondaryContainer, "secondaryContainer(...)");
        long jSeedColorScheme$argb8 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSecondaryContainer);
        DynamicColor dynamicColorOnSecondaryContainer = materialDynamicColors.onSecondaryContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnSecondaryContainer, "onSecondaryContainer(...)");
        long jSeedColorScheme$argb9 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnSecondaryContainer);
        DynamicColor dynamicColorTertiary = materialDynamicColors.tertiary();
        Intrinsics.checkNotNullExpressionValue(dynamicColorTertiary, "tertiary(...)");
        long jSeedColorScheme$argb10 = seedColorScheme$argb(schemeTonalSpot, dynamicColorTertiary);
        DynamicColor dynamicColorOnTertiary = materialDynamicColors.onTertiary();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnTertiary, "onTertiary(...)");
        long jSeedColorScheme$argb11 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnTertiary);
        DynamicColor dynamicColorTertiaryContainer = materialDynamicColors.tertiaryContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorTertiaryContainer, "tertiaryContainer(...)");
        long jSeedColorScheme$argb12 = seedColorScheme$argb(schemeTonalSpot, dynamicColorTertiaryContainer);
        DynamicColor dynamicColorOnTertiaryContainer = materialDynamicColors.onTertiaryContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnTertiaryContainer, "onTertiaryContainer(...)");
        long jSeedColorScheme$argb13 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnTertiaryContainer);
        DynamicColor dynamicColorBackground = materialDynamicColors.background();
        Intrinsics.checkNotNullExpressionValue(dynamicColorBackground, "background(...)");
        long jSeedColorScheme$argb14 = seedColorScheme$argb(schemeTonalSpot, dynamicColorBackground);
        DynamicColor dynamicColorOnBackground = materialDynamicColors.onBackground();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnBackground, "onBackground(...)");
        long jSeedColorScheme$argb15 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnBackground);
        DynamicColor dynamicColorSurface = materialDynamicColors.surface();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurface, "surface(...)");
        long jSeedColorScheme$argb16 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurface);
        DynamicColor dynamicColorOnSurface = materialDynamicColors.onSurface();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnSurface, "onSurface(...)");
        long jSeedColorScheme$argb17 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnSurface);
        DynamicColor dynamicColorSurfaceVariant = materialDynamicColors.surfaceVariant();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceVariant, "surfaceVariant(...)");
        long jSeedColorScheme$argb18 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceVariant);
        DynamicColor dynamicColorOnSurfaceVariant = materialDynamicColors.onSurfaceVariant();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnSurfaceVariant, "onSurfaceVariant(...)");
        long jSeedColorScheme$argb19 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnSurfaceVariant);
        DynamicColor dynamicColorSurfaceTint = materialDynamicColors.surfaceTint();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceTint, "surfaceTint(...)");
        long jSeedColorScheme$argb20 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceTint);
        DynamicColor dynamicColorInverseSurface = materialDynamicColors.inverseSurface();
        Intrinsics.checkNotNullExpressionValue(dynamicColorInverseSurface, "inverseSurface(...)");
        long jSeedColorScheme$argb21 = seedColorScheme$argb(schemeTonalSpot, dynamicColorInverseSurface);
        DynamicColor dynamicColorInverseOnSurface = materialDynamicColors.inverseOnSurface();
        Intrinsics.checkNotNullExpressionValue(dynamicColorInverseOnSurface, "inverseOnSurface(...)");
        long jSeedColorScheme$argb22 = seedColorScheme$argb(schemeTonalSpot, dynamicColorInverseOnSurface);
        DynamicColor dynamicColorError = materialDynamicColors.error();
        Intrinsics.checkNotNullExpressionValue(dynamicColorError, "error(...)");
        long jSeedColorScheme$argb23 = seedColorScheme$argb(schemeTonalSpot, dynamicColorError);
        DynamicColor dynamicColorOnError = materialDynamicColors.onError();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnError, "onError(...)");
        long jSeedColorScheme$argb24 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnError);
        DynamicColor dynamicColorErrorContainer = materialDynamicColors.errorContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorErrorContainer, "errorContainer(...)");
        long jSeedColorScheme$argb25 = seedColorScheme$argb(schemeTonalSpot, dynamicColorErrorContainer);
        DynamicColor dynamicColorOnErrorContainer = materialDynamicColors.onErrorContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnErrorContainer, "onErrorContainer(...)");
        long jSeedColorScheme$argb26 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnErrorContainer);
        DynamicColor dynamicColorOutline = materialDynamicColors.outline();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOutline, "outline(...)");
        long jSeedColorScheme$argb27 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOutline);
        DynamicColor dynamicColorOutlineVariant = materialDynamicColors.outlineVariant();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOutlineVariant, "outlineVariant(...)");
        long jSeedColorScheme$argb28 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOutlineVariant);
        DynamicColor dynamicColorScrim = materialDynamicColors.scrim();
        Intrinsics.checkNotNullExpressionValue(dynamicColorScrim, "scrim(...)");
        long jSeedColorScheme$argb29 = seedColorScheme$argb(schemeTonalSpot, dynamicColorScrim);
        DynamicColor dynamicColorSurfaceBright = materialDynamicColors.surfaceBright();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceBright, "surfaceBright(...)");
        long jSeedColorScheme$argb30 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceBright);
        DynamicColor dynamicColorSurfaceDim = materialDynamicColors.surfaceDim();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceDim, "surfaceDim(...)");
        long jSeedColorScheme$argb31 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceDim);
        DynamicColor dynamicColorSurfaceContainer = materialDynamicColors.surfaceContainer();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceContainer, "surfaceContainer(...)");
        long jSeedColorScheme$argb32 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceContainer);
        DynamicColor dynamicColorSurfaceContainerHigh = materialDynamicColors.surfaceContainerHigh();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceContainerHigh, "surfaceContainerHigh(...)");
        long jSeedColorScheme$argb33 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceContainerHigh);
        DynamicColor dynamicColorSurfaceContainerHighest = materialDynamicColors.surfaceContainerHighest();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceContainerHighest, "surfaceContainerHighest(...)");
        long jSeedColorScheme$argb34 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceContainerHighest);
        DynamicColor dynamicColorSurfaceContainerLow = materialDynamicColors.surfaceContainerLow();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceContainerLow, "surfaceContainerLow(...)");
        long jSeedColorScheme$argb35 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceContainerLow);
        DynamicColor dynamicColorSurfaceContainerLowest = materialDynamicColors.surfaceContainerLowest();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSurfaceContainerLowest, "surfaceContainerLowest(...)");
        long jSeedColorScheme$argb36 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSurfaceContainerLowest);
        DynamicColor dynamicColorPrimaryFixed = materialDynamicColors.primaryFixed();
        Intrinsics.checkNotNullExpressionValue(dynamicColorPrimaryFixed, "primaryFixed(...)");
        long jSeedColorScheme$argb37 = seedColorScheme$argb(schemeTonalSpot, dynamicColorPrimaryFixed);
        DynamicColor dynamicColorPrimaryFixedDim = materialDynamicColors.primaryFixedDim();
        Intrinsics.checkNotNullExpressionValue(dynamicColorPrimaryFixedDim, "primaryFixedDim(...)");
        long jSeedColorScheme$argb38 = seedColorScheme$argb(schemeTonalSpot, dynamicColorPrimaryFixedDim);
        DynamicColor dynamicColorOnPrimaryFixed = materialDynamicColors.onPrimaryFixed();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnPrimaryFixed, "onPrimaryFixed(...)");
        long jSeedColorScheme$argb39 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnPrimaryFixed);
        DynamicColor dynamicColorOnPrimaryFixedVariant = materialDynamicColors.onPrimaryFixedVariant();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnPrimaryFixedVariant, "onPrimaryFixedVariant(...)");
        long jSeedColorScheme$argb40 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnPrimaryFixedVariant);
        DynamicColor dynamicColorSecondaryFixed = materialDynamicColors.secondaryFixed();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSecondaryFixed, "secondaryFixed(...)");
        long jSeedColorScheme$argb41 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSecondaryFixed);
        DynamicColor dynamicColorSecondaryFixedDim = materialDynamicColors.secondaryFixedDim();
        Intrinsics.checkNotNullExpressionValue(dynamicColorSecondaryFixedDim, "secondaryFixedDim(...)");
        long jSeedColorScheme$argb42 = seedColorScheme$argb(schemeTonalSpot, dynamicColorSecondaryFixedDim);
        DynamicColor dynamicColorOnSecondaryFixed = materialDynamicColors.onSecondaryFixed();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnSecondaryFixed, "onSecondaryFixed(...)");
        long jSeedColorScheme$argb43 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnSecondaryFixed);
        DynamicColor dynamicColorOnSecondaryFixedVariant = materialDynamicColors.onSecondaryFixedVariant();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnSecondaryFixedVariant, "onSecondaryFixedVariant(...)");
        long jSeedColorScheme$argb44 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnSecondaryFixedVariant);
        DynamicColor dynamicColorTertiaryFixed = materialDynamicColors.tertiaryFixed();
        Intrinsics.checkNotNullExpressionValue(dynamicColorTertiaryFixed, "tertiaryFixed(...)");
        long jSeedColorScheme$argb45 = seedColorScheme$argb(schemeTonalSpot, dynamicColorTertiaryFixed);
        DynamicColor dynamicColorTertiaryFixedDim = materialDynamicColors.tertiaryFixedDim();
        Intrinsics.checkNotNullExpressionValue(dynamicColorTertiaryFixedDim, "tertiaryFixedDim(...)");
        long jSeedColorScheme$argb46 = seedColorScheme$argb(schemeTonalSpot, dynamicColorTertiaryFixedDim);
        DynamicColor dynamicColorOnTertiaryFixed = materialDynamicColors.onTertiaryFixed();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnTertiaryFixed, "onTertiaryFixed(...)");
        long jSeedColorScheme$argb47 = seedColorScheme$argb(schemeTonalSpot, dynamicColorOnTertiaryFixed);
        DynamicColor dynamicColorOnTertiaryFixedVariant = materialDynamicColors.onTertiaryFixedVariant();
        Intrinsics.checkNotNullExpressionValue(dynamicColorOnTertiaryFixedVariant, "onTertiaryFixedVariant(...)");
        return new ColorScheme(jSeedColorScheme$argb, jSeedColorScheme$argb2, jSeedColorScheme$argb3, jSeedColorScheme$argb4, jSeedColorScheme$argb5, jSeedColorScheme$argb6, jSeedColorScheme$argb7, jSeedColorScheme$argb8, jSeedColorScheme$argb9, jSeedColorScheme$argb10, jSeedColorScheme$argb11, jSeedColorScheme$argb12, jSeedColorScheme$argb13, jSeedColorScheme$argb14, jSeedColorScheme$argb15, jSeedColorScheme$argb16, jSeedColorScheme$argb17, jSeedColorScheme$argb18, jSeedColorScheme$argb19, jSeedColorScheme$argb20, jSeedColorScheme$argb21, jSeedColorScheme$argb22, jSeedColorScheme$argb23, jSeedColorScheme$argb24, jSeedColorScheme$argb25, jSeedColorScheme$argb26, jSeedColorScheme$argb27, jSeedColorScheme$argb28, jSeedColorScheme$argb29, jSeedColorScheme$argb30, jSeedColorScheme$argb31, jSeedColorScheme$argb32, jSeedColorScheme$argb33, jSeedColorScheme$argb34, jSeedColorScheme$argb35, jSeedColorScheme$argb36, jSeedColorScheme$argb37, jSeedColorScheme$argb38, jSeedColorScheme$argb39, jSeedColorScheme$argb40, jSeedColorScheme$argb41, jSeedColorScheme$argb42, jSeedColorScheme$argb43, jSeedColorScheme$argb44, jSeedColorScheme$argb45, jSeedColorScheme$argb46, jSeedColorScheme$argb47, seedColorScheme$argb(schemeTonalSpot, dynamicColorOnTertiaryFixedVariant), null);
    }

    private static final long seedColorScheme$argb(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return ColorKt.Color(dynamicColor.getArgb(dynamicScheme));
    }

    /* JADX INFO: renamed from: toRgbaHex-8_81llA, reason: not valid java name */
    public static final String m12132toRgbaHex8_81llA(long j) {
        int iM7392toArgb8_81llA = ColorKt.m7392toArgb8_81llA(j);
        String str = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(((iM7392toArgb8_81llA >>> 24) & 255) | (iM7392toArgb8_81llA << 8))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final Map<String, String> toTokenMap(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        return MapsKt.mapOf(TuplesKt.to("primary", m12132toRgbaHex8_81llA(colorScheme.getPrimary())), TuplesKt.to("onPrimary", m12132toRgbaHex8_81llA(colorScheme.getOnPrimary())), TuplesKt.to("primaryContainer", m12132toRgbaHex8_81llA(colorScheme.getPrimaryContainer())), TuplesKt.to("onPrimaryContainer", m12132toRgbaHex8_81llA(colorScheme.getOnPrimaryContainer())), TuplesKt.to("inversePrimary", m12132toRgbaHex8_81llA(colorScheme.getInversePrimary())), TuplesKt.to("secondary", m12132toRgbaHex8_81llA(colorScheme.getSecondary())), TuplesKt.to("onSecondary", m12132toRgbaHex8_81llA(colorScheme.getOnSecondary())), TuplesKt.to("secondaryContainer", m12132toRgbaHex8_81llA(colorScheme.getSecondaryContainer())), TuplesKt.to("onSecondaryContainer", m12132toRgbaHex8_81llA(colorScheme.getOnSecondaryContainer())), TuplesKt.to("tertiary", m12132toRgbaHex8_81llA(colorScheme.getTertiary())), TuplesKt.to("onTertiary", m12132toRgbaHex8_81llA(colorScheme.getOnTertiary())), TuplesKt.to("tertiaryContainer", m12132toRgbaHex8_81llA(colorScheme.getTertiaryContainer())), TuplesKt.to("onTertiaryContainer", m12132toRgbaHex8_81llA(colorScheme.getOnTertiaryContainer())), TuplesKt.to("background", m12132toRgbaHex8_81llA(colorScheme.getBackground())), TuplesKt.to("onBackground", m12132toRgbaHex8_81llA(colorScheme.getOnBackground())), TuplesKt.to("surface", m12132toRgbaHex8_81llA(colorScheme.getSurface())), TuplesKt.to("onSurface", m12132toRgbaHex8_81llA(colorScheme.getOnSurface())), TuplesKt.to("surfaceVariant", m12132toRgbaHex8_81llA(colorScheme.getSurfaceVariant())), TuplesKt.to("onSurfaceVariant", m12132toRgbaHex8_81llA(colorScheme.getOnSurfaceVariant())), TuplesKt.to("surfaceTint", m12132toRgbaHex8_81llA(colorScheme.getSurfaceTint())), TuplesKt.to("inverseSurface", m12132toRgbaHex8_81llA(colorScheme.getInverseSurface())), TuplesKt.to("inverseOnSurface", m12132toRgbaHex8_81llA(colorScheme.getInverseOnSurface())), TuplesKt.to("error", m12132toRgbaHex8_81llA(colorScheme.getError())), TuplesKt.to("onError", m12132toRgbaHex8_81llA(colorScheme.getOnError())), TuplesKt.to("errorContainer", m12132toRgbaHex8_81llA(colorScheme.getErrorContainer())), TuplesKt.to("onErrorContainer", m12132toRgbaHex8_81llA(colorScheme.getOnErrorContainer())), TuplesKt.to("outline", m12132toRgbaHex8_81llA(colorScheme.getOutline())), TuplesKt.to("outlineVariant", m12132toRgbaHex8_81llA(colorScheme.getOutlineVariant())), TuplesKt.to("scrim", m12132toRgbaHex8_81llA(colorScheme.getScrim())), TuplesKt.to("surfaceBright", m12132toRgbaHex8_81llA(colorScheme.getSurfaceBright())), TuplesKt.to("surfaceDim", m12132toRgbaHex8_81llA(colorScheme.getSurfaceDim())), TuplesKt.to("surfaceContainer", m12132toRgbaHex8_81llA(colorScheme.getSurfaceContainer())), TuplesKt.to("surfaceContainerHigh", m12132toRgbaHex8_81llA(colorScheme.getSurfaceContainerHigh())), TuplesKt.to("surfaceContainerHighest", m12132toRgbaHex8_81llA(colorScheme.getSurfaceContainerHighest())), TuplesKt.to("surfaceContainerLow", m12132toRgbaHex8_81llA(colorScheme.getSurfaceContainerLow())), TuplesKt.to("surfaceContainerLowest", m12132toRgbaHex8_81llA(colorScheme.getSurfaceContainerLowest())), TuplesKt.to("primaryFixed", m12132toRgbaHex8_81llA(colorScheme.getPrimaryFixed())), TuplesKt.to("primaryFixedDim", m12132toRgbaHex8_81llA(colorScheme.getPrimaryFixedDim())), TuplesKt.to("onPrimaryFixed", m12132toRgbaHex8_81llA(colorScheme.getOnPrimaryFixed())), TuplesKt.to("onPrimaryFixedVariant", m12132toRgbaHex8_81llA(colorScheme.getOnPrimaryFixedVariant())), TuplesKt.to("secondaryFixed", m12132toRgbaHex8_81llA(colorScheme.getSecondaryFixed())), TuplesKt.to("secondaryFixedDim", m12132toRgbaHex8_81llA(colorScheme.getSecondaryFixedDim())), TuplesKt.to("onSecondaryFixed", m12132toRgbaHex8_81llA(colorScheme.getOnSecondaryFixed())), TuplesKt.to("onSecondaryFixedVariant", m12132toRgbaHex8_81llA(colorScheme.getOnSecondaryFixedVariant())), TuplesKt.to("tertiaryFixed", m12132toRgbaHex8_81llA(colorScheme.getTertiaryFixed())), TuplesKt.to("tertiaryFixedDim", m12132toRgbaHex8_81llA(colorScheme.getTertiaryFixedDim())), TuplesKt.to("onTertiaryFixed", m12132toRgbaHex8_81llA(colorScheme.getOnTertiaryFixed())), TuplesKt.to("onTertiaryFixedVariant", m12132toRgbaHex8_81llA(colorScheme.getOnTertiaryFixedVariant())));
    }
}
