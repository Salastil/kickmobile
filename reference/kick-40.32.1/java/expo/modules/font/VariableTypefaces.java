package expo.modules.font;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.os.Build;
import androidx.core.util.HalfKt$$ExternalSyntheticApiModelOutline0;
import com.useinsider.insider.k4$$ExternalSyntheticApiModelOutline0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: VariableTypefaces.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/font/VariableTypefaces;", "", "<init>", "()V", "SYSTEM_FALLBACK", "", "build", "Landroid/graphics/Typeface;", "fontData", "Ljava/nio/ByteBuffer;", "wrapWithSystemFallback", "family", "Landroid/graphics/fonts/FontFamily;", "buildVariableFamily", "buildInstancedFamily", "buildInstancedFamily$expo_font_release", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VariableTypefaces {
    public static final VariableTypefaces INSTANCE = new VariableTypefaces();
    private static final String SYSTEM_FALLBACK = "sans-serif";

    private VariableTypefaces() {
    }

    public final Typeface build(ByteBuffer fontData) throws IOException {
        Intrinsics.checkNotNullParameter(fontData, "fontData");
        FontFamily fontFamilyBuildVariableFamily = buildVariableFamily(fontData);
        if (fontFamilyBuildVariableFamily == null && (fontFamilyBuildVariableFamily = buildInstancedFamily$expo_font_release(fontData)) == null) {
            return null;
        }
        return wrapWithSystemFallback(fontFamilyBuildVariableFamily);
    }

    public final Typeface wrapWithSystemFallback(FontFamily family) {
        Intrinsics.checkNotNullParameter(family, "family");
        Typeface typefaceBuild = HalfKt$$ExternalSyntheticApiModelOutline0.m(family).setSystemFallback("sans-serif").build();
        Intrinsics.checkNotNullExpressionValue(typefaceBuild, "build(...)");
        return typefaceBuild;
    }

    private final FontFamily buildVariableFamily(ByteBuffer fontData) throws IOException {
        if (Build.VERSION.SDK_INT < 35) {
            return null;
        }
        Font fontBuild = k4$$ExternalSyntheticApiModelOutline0.m(fontData).build();
        Intrinsics.checkNotNullExpressionValue(fontBuild, "build(...)");
        return HalfKt$$ExternalSyntheticApiModelOutline0.m10495m(fontBuild).buildVariableFamily();
    }

    public final FontFamily buildInstancedFamily$expo_font_release(ByteBuffer fontData) {
        Intrinsics.checkNotNullParameter(fontData, "fontData");
        IntRange weightAxis = FontVariationAxes.INSTANCE.readWeightAxis(fontData);
        if (weightAxis == null) {
            return null;
        }
        List<Integer> listWeightsFor = FontVariationAxes.INSTANCE.weightsFor(weightAxis);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listWeightsFor, 10));
        Iterator<T> it = listWeightsFor.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            arrayList.add(k4$$ExternalSyntheticApiModelOutline0.m(fontData).setFontVariationSettings("'wght' " + iIntValue).setWeight(iIntValue).build());
        }
        ArrayList arrayList2 = arrayList;
        HalfKt$$ExternalSyntheticApiModelOutline0.m10511m();
        FontFamily.Builder builderM10495m = HalfKt$$ExternalSyntheticApiModelOutline0.m10495m(k4$$ExternalSyntheticApiModelOutline0.m(CollectionsKt.first((List) arrayList2)));
        Iterator it2 = CollectionsKt.drop(arrayList2, 1).iterator();
        while (it2.hasNext()) {
            builderM10495m.addFont(k4$$ExternalSyntheticApiModelOutline0.m(it2.next()));
        }
        return builderM10495m.build();
    }
}
