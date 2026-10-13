package com.amazon.mediatailorsdk.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BinarySearch.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u007f\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u0002H\u00012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\fj\b\u0012\u0004\u0012\u0002H\u0002`\r2F\u0010\u000e\u001aB\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u000f¢\u0006\u0002\u0010\u0010\u001a\u007f\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u0002H\u00012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\fj\b\u0012\u0004\u0012\u0002H\u0002`\r2F\u0010\u000e\u001aB\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u000f¢\u0006\u0002\u0010\u0010\u001a\u007f\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u0002H\u00012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\fj\b\u0012\u0004\u0012\u0002H\u0002`\r2F\u0010\u000e\u001aB\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u000f¢\u0006\u0002\u0010\u0010*v\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\u001a\u0004\b\u0001\u0010\u0002\"2\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u000322\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¨\u0006\u0013"}, d2 = {"BinarySearchComparator", ExifInterface.GPS_DIRECTION_TRUE, "D", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", TypedValues.Attributes.S_TARGET, "item", "", "binarySearchExact", "", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "comparator", "Lcom/amazon/mediatailorsdk/utils/BinarySearchComparator;", "(Ljava/lang/Object;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;)I", "binarySearchExactOrRightBelow", "binarySearchExactOrRightAbove", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BinarySearchKt {
    public static final <T, D> int binarySearchExact(T t, ArrayList<D> list, Function2<? super T, ? super D, Double> comparator) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int i = size - 1;
        int i2 = 0;
        while (i2 <= i) {
            int iCeil = (int) Math.ceil(((double) (i2 + i)) / 2.0d);
            double dDoubleValue = comparator.invoke(t, list.get(iCeil)).doubleValue();
            if (dDoubleValue == 0.0d) {
                return iCeil;
            }
            if (dDoubleValue > 0.0d) {
                i2 = iCeil + 1;
            } else {
                i = iCeil - 1;
            }
        }
        return -1;
    }

    public static final <T, D> int binarySearchExactOrRightBelow(T t, ArrayList<D> list, Function2<? super T, ? super D, Double> comparator) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int i = size - 1;
        int i2 = 0;
        while (i2 < i) {
            int iCeil = (int) Math.ceil(((double) (i2 + i)) / 2.0d);
            double dDoubleValue = comparator.invoke(t, list.get(iCeil)).doubleValue();
            if (dDoubleValue == 0.0d) {
                return iCeil;
            }
            if (dDoubleValue > 0.0d) {
                i2 = iCeil;
            } else {
                i = iCeil - 1;
            }
        }
        if (i2 > 0 || comparator.invoke(t, list.get(i2)).doubleValue() >= 0.0d) {
            return i2;
        }
        return -1;
    }

    public static final <T, D> int binarySearchExactOrRightAbove(T t, ArrayList<D> list, Function2<? super T, ? super D, Double> comparator) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int iBinarySearchExactOrRightBelow = binarySearchExactOrRightBelow(t, list, comparator);
        if (iBinarySearchExactOrRightBelow < 0) {
            return 0;
        }
        if (comparator.invoke(t, list.get(iBinarySearchExactOrRightBelow)).doubleValue() == 0.0d) {
            return iBinarySearchExactOrRightBelow;
        }
        int i = iBinarySearchExactOrRightBelow + 1;
        if (i < size) {
            return i;
        }
        return -1;
    }
}
