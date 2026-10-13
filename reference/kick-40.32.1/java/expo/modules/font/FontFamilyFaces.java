package expo.modules.font;

import expo.modules.kotlin.exception.CodedException;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontFamilyFaces.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001c\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¨\u0006\u0011"}, d2 = {"Lexpo/modules/font/FontFamilyFaces;", "", "<init>", "()V", "isItalic", "", "style", "", "assertWeightsInRange", "", "fontFamilyName", "faces", "", "Lexpo/modules/font/FontFaceRecord;", "assertNoDuplicateFaces", "defaultFaceIndex", "", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FontFamilyFaces {
    public static final FontFamilyFaces INSTANCE = new FontFamilyFaces();

    private FontFamilyFaces() {
    }

    private final boolean isItalic(String style) {
        return Intrinsics.areEqual(style, "italic");
    }

    public final void assertWeightsInRange(String fontFamilyName, List<FontFaceRecord> faces) throws CodedException {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(faces, "faces");
        for (FontFaceRecord fontFaceRecord : faces) {
            Integer weight = fontFaceRecord.getWeight();
            int iIntValue = weight != null ? weight.intValue() : 400;
            if (1 > iIntValue || iIntValue >= 1001) {
                throw new CodedException("Font face '" + fontFaceRecord.getLocalUri() + "' for family '" + fontFamilyName + "' declares weight " + iIntValue + ", but weight must be between 1 and 1000. Set the 'weight' of this face to a value in that range.", null, 2, null);
            }
        }
    }

    public final void assertNoDuplicateFaces(String fontFamilyName, List<FontFaceRecord> faces) throws CodedException {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(faces, "faces");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (FontFaceRecord fontFaceRecord : faces) {
            Integer weight = fontFaceRecord.getWeight();
            int iIntValue = weight != null ? weight.intValue() : 400;
            boolean zIsItalic = isItalic(fontFaceRecord.getStyle());
            Pair pair = TuplesKt.to(Integer.valueOf(iIntValue), Boolean.valueOf(zIsItalic));
            String str = (String) linkedHashMap.get(pair);
            if (str != null) {
                throw new CodedException("Font family '" + fontFamilyName + "' declares two faces with weight " + iIntValue + " and style '" + (zIsItalic ? "italic" : "normal") + "': '" + str + "' and '" + fontFaceRecord.getLocalUri() + "'. Give each face of a family a distinct weight or style so the correct file is selected at render time.", null, 2, null);
            }
            linkedHashMap.put(pair, fontFaceRecord.getLocalUri());
        }
    }

    public final int defaultFaceIndex(List<FontFaceRecord> faces) {
        Intrinsics.checkNotNullParameter(faces, "faces");
        int i = 0;
        boolean z = true;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (Object obj : faces) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FontFaceRecord fontFaceRecord = (FontFaceRecord) obj;
            Integer weight = fontFaceRecord.getWeight();
            int iAbs = Math.abs((weight != null ? weight.intValue() : 400) - 400);
            boolean zIsItalic = INSTANCE.isItalic(fontFaceRecord.getStyle());
            if (iAbs < i2 || (iAbs == i2 && z && !zIsItalic)) {
                i = i3;
                z = zIsItalic;
                i2 = iAbs;
            }
            i3 = i4;
        }
        return i;
    }
}
