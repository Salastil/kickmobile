package expo.modules.font;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FontVariationAxes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0016\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0013J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0014\u0010\u001d\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0014\u0010\u001f\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lexpo/modules/font/FontVariationAxes;", "", "<init>", "()V", "TAG_FVAR", "", "TAG_WGHT", "SFNT_VERSIONS", "", "OFFSET_TABLE_SIZE", "TABLE_RECORD_SIZE", "AXIS_RECORD_SIZE", "VALID_WEIGHTS", "Lkotlin/ranges/IntRange;", "MAX_TABLES", "TABLE_DIRECTORY_LIMIT", "declaresVariations", "", "prefix", "Ljava/nio/ByteBuffer;", "weightsFor", "", "axis", "readWeightAxis", "buffer", "findFvarTable", ContentType.Font.TYPE, "(Ljava/nio/ByteBuffer;)Ljava/lang/Integer;", "fvarOffset", "getUInt16", FirebaseAnalytics.Param.INDEX, "getFixed", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FontVariationAxes {
    private static final int AXIS_RECORD_SIZE = 20;
    private static final int MAX_TABLES = 255;
    private static final int OFFSET_TABLE_SIZE = 12;
    public static final int TABLE_DIRECTORY_LIMIT = 4092;
    private static final int TABLE_RECORD_SIZE = 16;
    private static final int TAG_FVAR = 1719034226;
    private static final int TAG_WGHT = 2003265652;
    public static final FontVariationAxes INSTANCE = new FontVariationAxes();
    private static final int[] SFNT_VERSIONS = {65536, 1330926671};
    private static final IntRange VALID_WEIGHTS = new IntRange(1, 1000);

    private FontVariationAxes() {
    }

    public final boolean declaresVariations(ByteBuffer prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        ByteBuffer byteBufferOrder = prefix.duplicate().order(ByteOrder.BIG_ENDIAN);
        if (byteBufferOrder.limit() < 12) {
            return false;
        }
        try {
            Intrinsics.checkNotNull(byteBufferOrder);
            return findFvarTable(byteBufferOrder) != null;
        } catch (IndexOutOfBoundsException unused) {
            return true;
        }
    }

    public final List<Integer> weightsFor(IntRange axis) {
        Intrinsics.checkNotNullParameter(axis, "axis");
        IntProgression intProgressionStep = RangesKt.step(new IntRange(100, 900), 100);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intProgressionStep, 10));
        Iterator<Integer> it = intProgressionStep.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(RangesKt.coerceIn(((IntIterator) it).nextInt(), (ClosedRange<Integer>) axis)));
        }
        return CollectionsKt.distinct(arrayList);
    }

    public final IntRange readWeightAxis(ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer byteBufferOrder = buffer.duplicate().order(ByteOrder.BIG_ENDIAN);
        try {
            Intrinsics.checkNotNull(byteBufferOrder);
            Integer numFindFvarTable = findFvarTable(byteBufferOrder);
            if (numFindFvarTable != null) {
                return readWeightAxis(byteBufferOrder, numFindFvarTable.intValue());
            }
        } catch (IndexOutOfBoundsException unused) {
        }
        return null;
    }

    private final Integer findFvarTable(ByteBuffer font) {
        if (!ArraysKt.contains(SFNT_VERSIONS, font.getInt(0))) {
            return null;
        }
        int uInt16 = getUInt16(font, 4);
        for (int i = 0; i < uInt16; i++) {
            int i2 = i * 16;
            if (font.getInt(i2 + 12) == TAG_FVAR) {
                return Integer.valueOf(font.getInt(i2 + 20));
            }
        }
        return null;
    }

    private final IntRange readWeightAxis(ByteBuffer font, int fvarOffset) {
        int uInt16 = getUInt16(font, fvarOffset + 4);
        int uInt17 = getUInt16(font, fvarOffset + 8);
        int uInt18 = getUInt16(font, fvarOffset + 10);
        if (uInt18 < 20) {
            return null;
        }
        for (int i = 0; i < uInt17; i++) {
            int i2 = fvarOffset + uInt16 + (i * uInt18);
            if (font.getInt(i2) == TAG_WGHT) {
                int fixed = getFixed(font, i2 + 4);
                int fixed2 = getFixed(font, i2 + 12);
                IntRange intRange = new IntRange(fixed, fixed2);
                IntRange intRange2 = VALID_WEIGHTS;
                int first = intRange2.getFirst();
                if (fixed > intRange2.getLast() || first > fixed) {
                    break;
                    break;
                }
                int first2 = intRange2.getFirst();
                if (fixed2 > intRange2.getLast() || first2 > fixed2 || fixed > fixed2) {
                    break;
                }
                return intRange;
            }
        }
        return null;
    }

    private final int getUInt16(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    private final int getFixed(ByteBuffer byteBuffer, int i) {
        return Math.round(byteBuffer.getInt(i) / 65536.0f);
    }
}
