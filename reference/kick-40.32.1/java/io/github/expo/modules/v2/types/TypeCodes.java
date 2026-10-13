package io.github.expo.modules.v2.types;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeCodes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087@\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0013J\r\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u0005J\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0*H\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b1\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u0011\u0010\u0019\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000f\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00063"}, d2 = {"Lio/github/expo/modules/v2/types/TypeCodes;", "", "values", "", "constructor-impl", "([I)[I", "getValues", "()[I", ContentDisposition.Parameters.Size, "", "getSize-impl", "([I)I", "isEmpty", "", "isEmpty-impl", "([I)Z", "get", FirebaseAnalytics.Param.INDEX, "get-impl", "([II)I", "kindAt", "Lio/github/expo/modules/v2/types/CppType;", "kindAt-IpqU398", "head", "getHead-z4oZP-Q", "isNullable", "isNullable-impl", "usesBuffer", "getUsesBuffer-impl", "withBufferFlag", "withBufferFlag-pj4Pta4", "contentEquals", "other", "contentEquals-lTxJlvg", "([I[I)Z", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "forEach", "", "block", "Lkotlin/Function1;", "forEach-impl", "([ILkotlin/jvm/functions/Function1;)V", "equals", "equals-impl", "([ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
public final class TypeCodes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int[] values;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TypeCodes m12445boximpl(int[] iArr) {
        return new TypeCodes(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m12446constructorimpl(int[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return values;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m12448equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof TypeCodes) && Intrinsics.areEqual(iArr, ((TypeCodes) obj).m12461unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m12449equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m12455hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public boolean equals(Object obj) {
        return m12448equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m12455hashCodeimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m12461unboximpl() {
        return this.values;
    }

    private /* synthetic */ TypeCodes(int[] iArr) {
        this.values = iArr;
    }

    public final int[] getValues() {
        return this.values;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final int m12453getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m12456isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final int m12451getimpl(int[] iArr, int i) {
        return iArr[i];
    }

    /* JADX INFO: renamed from: kindAt-IpqU398, reason: not valid java name */
    public static final int m12458kindAtIpqU398(int[] iArr, int i) {
        return CppType.m12405constructorimpl(iArr[i] & (-769));
    }

    /* JADX INFO: renamed from: getHead-z4oZP-Q, reason: not valid java name */
    public static final int m12452getHeadz4oZPQ(int[] iArr) {
        return m12458kindAtIpqU398(iArr, 0);
    }

    /* JADX INFO: renamed from: isNullable-impl, reason: not valid java name */
    public static final boolean m12457isNullableimpl(int[] iArr) {
        return (iArr[0] & 256) != 0;
    }

    /* JADX INFO: renamed from: getUsesBuffer-impl, reason: not valid java name */
    public static final boolean m12454getUsesBufferimpl(int[] iArr) {
        return (iArr[0] & 512) != 0;
    }

    /* JADX INFO: renamed from: withBufferFlag-pj4Pta4, reason: not valid java name */
    public static final int[] m12460withBufferFlagpj4Pta4(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        iArrCopyOf[0] = iArrCopyOf[0] | 512;
        return m12446constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: contentEquals-lTxJlvg, reason: not valid java name */
    public static final boolean m12447contentEqualslTxJlvg(int[] iArr, int[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Arrays.equals(iArr, other);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m12459toStringimpl(int[] iArr) {
        return ArraysKt.joinToString$default(iArr, (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    public String toString() {
        return m12459toStringimpl(this.values);
    }

    /* JADX INFO: compiled from: TypeCodes.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00020\u0007\"\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/github/expo/modules/v2/types/TypeCodes$Companion;", "", "<init>", "()V", "of", "Lio/github/expo/modules/v2/types/TypeCodes;", "codes", "", "", "of-DWjln38", "([I)[I", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: of-DWjln38, reason: not valid java name */
        public final int[] m12462ofDWjln38(int... codes) {
            Intrinsics.checkNotNullParameter(codes, "codes");
            return TypeCodes.m12446constructorimpl(codes);
        }
    }

    /* JADX INFO: renamed from: forEach-impl, reason: not valid java name */
    public static final void m12450forEachimpl(int[] iArr, Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (int i : iArr) {
            block.invoke(Integer.valueOf(i));
        }
    }
}
