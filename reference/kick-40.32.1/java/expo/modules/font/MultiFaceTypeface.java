package expo.modules.font;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import androidx.core.util.HalfKt$$ExternalSyntheticApiModelOutline0;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.useinsider.insider.k4$$ExternalSyntheticApiModelOutline0;
import expo.modules.kotlin.exception.CodedException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MultiFaceTypeface.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\fH\u0002J*\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002R$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lexpo/modules/font/MultiFaceTypeface;", "", "<init>", "()V", "build", "Landroid/graphics/Typeface;", "fontFamilyName", "", "faces", "", "Lexpo/modules/font/FontFaceRecord;", "sources", "Lexpo/modules/font/FontSource;", "styleKey", "Lkotlin/Pair;", "", "Landroid/graphics/fonts/Font;", "getStyleKey", "(Landroid/graphics/fonts/Font;)Lkotlin/Pair;", "buildFace", "Lexpo/modules/font/MultiFaceTypeface$BuiltFace;", OptionalModuleUtils.FACE, "source", "instance", "fontData", "Ljava/nio/ByteBuffer;", "axisWeight", "weight", "style", "slantFor", "BuiltFace", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultiFaceTypeface {
    public static final MultiFaceTypeface INSTANCE = new MultiFaceTypeface();

    private MultiFaceTypeface() {
    }

    public final Typeface build(String fontFamilyName, List<FontFaceRecord> faces, List<? extends FontSource> sources) throws CodedException {
        String str;
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(faces, "faces");
        Intrinsics.checkNotNullParameter(sources, "sources");
        List<FontFaceRecord> list = faces;
        List<Pair> listZip = CollectionsKt.zip(list, sources);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZip, 10));
        for (Pair pair : listZip) {
            FontFaceRecord fontFaceRecord = (FontFaceRecord) pair.component1();
            try {
                arrayList.add(INSTANCE.buildFace(fontFaceRecord, (FontSource) pair.component2()));
            } catch (IOException e) {
                throw new CodedException("Could not read font face '" + fontFaceRecord.getLocalUri() + "' for family '" + fontFamilyName + "'. The file may be corrupted or in a format Android can't parse. Open it in a font editor to check it, or replace it with a valid .ttf or .otf file.", e);
            }
        }
        ArrayList<BuiltFace> arrayList2 = arrayList;
        List<Pair> listZip2 = CollectionsKt.zip(list, arrayList2);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listZip2, 10));
        for (Pair pair2 : listZip2) {
            FontFaceRecord fontFaceRecord2 = (FontFaceRecord) pair2.component1();
            BuiltFace builtFace = (BuiltFace) pair2.component2();
            String localUri = fontFaceRecord2.getLocalUri();
            Integer numValueOf = Integer.valueOf(builtFace.getPrimary().getStyle().getWeight());
            if (builtFace.getPrimary().getStyle().getSlant() == 1) {
                str = "italic";
            } else {
                str = "normal";
            }
            arrayList3.add(new FontFaceRecord(localUri, numValueOf, str));
        }
        FontFamilyFaces.INSTANCE.assertNoDuplicateFaces(fontFamilyName, arrayList3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList4 = new ArrayList();
        for (BuiltFace builtFace2 : arrayList2) {
            linkedHashSet.add(getStyleKey(builtFace2.getPrimary()));
            arrayList4.add(builtFace2.getPrimary());
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator<Font> it2 = ((BuiltFace) it.next()).getInstances().iterator();
            while (it2.hasNext()) {
                Font fontM = k4$$ExternalSyntheticApiModelOutline0.m((Object) it2.next());
                if (linkedHashSet.add(getStyleKey(fontM))) {
                    arrayList4.add(fontM);
                }
            }
        }
        HalfKt$$ExternalSyntheticApiModelOutline0.m10511m();
        FontFamily.Builder builderM10495m = HalfKt$$ExternalSyntheticApiModelOutline0.m10495m(k4$$ExternalSyntheticApiModelOutline0.m(arrayList4.get(0)));
        Iterator it3 = CollectionsKt.drop(arrayList4, 1).iterator();
        while (it3.hasNext()) {
            try {
                builderM10495m.addFont(k4$$ExternalSyntheticApiModelOutline0.m(it3.next()));
            } catch (IllegalArgumentException e2) {
                throw new CodedException("expo-font couldn't build the font family '" + fontFamilyName + "' because of an internal error. Please report this at https://github.com/expo/expo/issues.", e2);
            }
        }
        VariableTypefaces variableTypefaces = VariableTypefaces.INSTANCE;
        FontFamily fontFamilyBuild = builderM10495m.build();
        Intrinsics.checkNotNullExpressionValue(fontFamilyBuild, "build(...)");
        return variableTypefaces.wrapWithSystemFallback(fontFamilyBuild);
    }

    /* JADX INFO: compiled from: MultiFaceTypeface.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/font/MultiFaceTypeface$BuiltFace;", "", "primary", "Landroid/graphics/fonts/Font;", "instances", "", "<init>", "(Landroid/graphics/fonts/Font;Ljava/util/List;)V", "getPrimary", "()Landroid/graphics/fonts/Font;", "getInstances", "()Ljava/util/List;", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BuiltFace {
        private final List<Font> instances;
        private final Font primary;

        public BuiltFace(Font primary, List<Font> instances) {
            Intrinsics.checkNotNullParameter(primary, "primary");
            Intrinsics.checkNotNullParameter(instances, "instances");
            this.primary = primary;
            this.instances = instances;
        }

        public /* synthetic */ BuiltFace(Font font, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(font, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<Font> getInstances() {
            return this.instances;
        }

        public final Font getPrimary() {
            return this.primary;
        }
    }

    private final Pair<Integer, Integer> getStyleKey(Font font) {
        return TuplesKt.to(Integer.valueOf(font.getStyle().getWeight()), Integer.valueOf(font.getStyle().getSlant()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final BuiltFace buildFace(FontFaceRecord face, FontSource source) throws IOException {
        ByteBuffer forInstancing = source.readForInstancing();
        Object next = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        IntRange weightAxis = forInstancing != null ? FontVariationAxes.INSTANCE.readWeightAxis(forInstancing) : null;
        int i = 2;
        if (weightAxis == null) {
            Font.Builder builderNewFontBuilder = source.newFontBuilder();
            Integer weight = face.getWeight();
            if (weight != null) {
                builderNewFontBuilder.setWeight(weight.intValue());
            }
            String style = face.getStyle();
            if (style != null) {
                builderNewFontBuilder.setSlant(INSTANCE.slantFor(style));
            }
            Font fontBuild = builderNewFontBuilder.build();
            Intrinsics.checkNotNullExpressionValue(fontBuild, "build(...)");
            return new BuiltFace(fontBuild, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (face.getWeight() != null) {
            return new BuiltFace(instance(forInstancing, RangesKt.coerceIn(face.getWeight().intValue(), (ClosedRange<Integer>) weightAxis), face.getWeight().intValue(), face.getStyle()), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        List<Integer> listWeightsFor = FontVariationAxes.INSTANCE.weightsFor(weightAxis);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listWeightsFor, 10));
        Iterator<T> it = listWeightsFor.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            arrayList.add(INSTANCE.instance(forInstancing, iIntValue, iIntValue, face.getStyle()));
        }
        ArrayList arrayList2 = arrayList;
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int iAbs = Math.abs(k4$$ExternalSyntheticApiModelOutline0.m(next).getStyle().getWeight() - 400);
                do {
                    Object next2 = it2.next();
                    int iAbs2 = Math.abs(k4$$ExternalSyntheticApiModelOutline0.m(next2).getStyle().getWeight() - 400);
                    if (iAbs > iAbs2) {
                        next = next2;
                        iAbs = iAbs2;
                    }
                } while (it2.hasNext());
            }
        }
        Intrinsics.checkNotNull(next);
        return new BuiltFace(k4$$ExternalSyntheticApiModelOutline0.m(next), arrayList2);
    }

    private final Font instance(ByteBuffer fontData, int axisWeight, int weight, String style) throws IOException {
        Font.Builder weight2 = k4$$ExternalSyntheticApiModelOutline0.m(fontData).setFontVariationSettings("'wght' " + axisWeight).setWeight(weight);
        Intrinsics.checkNotNullExpressionValue(weight2, "setWeight(...)");
        if (style != null) {
            weight2.setSlant(INSTANCE.slantFor(style));
        }
        Font fontBuild = weight2.build();
        Intrinsics.checkNotNullExpressionValue(fontBuild, "build(...)");
        return fontBuild;
    }

    private final int slantFor(String style) {
        return Intrinsics.areEqual(style, "italic") ? 1 : 0;
    }
}
