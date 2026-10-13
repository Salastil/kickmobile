package com.swmansion.rnscreens.gamma.modals.formsheet;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FormSheetDetents.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\rH\u0000¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002J/\u0010#\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\rH\u0000¢\u0006\u0002\b$R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDetents;", "", "rawDetents", "", "", "<init>", "(Ljava/util/List;)V", "detents", "isFitToContents", "", "isFitToContents$react_native_screens_release", "()Z", "count", "", "getCount$react_native_screens_release", "()I", "heightFractionAt", FirebaseAnalytics.Param.INDEX, "heightAt", "containerHeight", "firstHeight", "firstHeight$react_native_screens_release", "maxAllowedHeight", "maxAllowedHeight$react_native_screens_release", "maxAllowedHeightForFitToContents", "contentHeight", "bottomInset", "maxAllowedHeightForFitToContents$react_native_screens_release", "halfExpandedRatio", "", "halfExpandedRatio$react_native_screens_release", "expandedOffsetFromTop", "topInset", "expandedOffsetFromTop$react_native_screens_release", "largestDetentTopOffset", "sheetContainerHeight", "sheetContainerHeight$react_native_screens_release", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetDetents {
    public static final double FIT_TO_CONTENTS_DETENT_VALUE = -1.0d;
    public static final int MAX_DETENTS = 3;
    private final List<Double> detents;

    public FormSheetDetents(List<Double> rawDetents) {
        Intrinsics.checkNotNullParameter(rawDetents, "rawDetents");
        List<Double> list = CollectionsKt.toList(rawDetents);
        this.detents = list;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("[RNScreens] At least one detent must be provided.".toString());
        }
        if (list.size() > 3) {
            throw new IllegalArgumentException(("[RNScreens] Maximum of 3 detents supported, got " + list.size() + ".").toString());
        }
        if (isFitToContents$react_native_screens_release()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            double dDoubleValue = ((Number) it.next()).doubleValue();
            if (0.0d > dDoubleValue || dDoubleValue > 1.0d) {
                throw new IllegalArgumentException(("[RNScreens] Detent values must be within 0.0 and 1.0, got " + dDoubleValue + ".").toString());
            }
        }
        List<Double> list2 = this.detents;
        if (!Intrinsics.areEqual(list2, CollectionsKt.sorted(CollectionsKt.distinct(list2)))) {
            throw new IllegalArgumentException("[RNScreens] Detents must be sorted in strictly ascending order.".toString());
        }
    }

    public final boolean isFitToContents$react_native_screens_release() {
        return this.detents.size() == 1 && this.detents.get(0).doubleValue() == -1.0d;
    }

    public final int getCount$react_native_screens_release() {
        return this.detents.size();
    }

    private final double heightFractionAt(int index) {
        return this.detents.get(index).doubleValue();
    }

    private final int heightAt(int index, int containerHeight) {
        return (int) (heightFractionAt(index) * ((double) containerHeight));
    }

    public final int firstHeight$react_native_screens_release(int containerHeight) {
        return heightAt(0, containerHeight);
    }

    public final int maxAllowedHeight$react_native_screens_release(int containerHeight) {
        return heightAt(getCount$react_native_screens_release() - 1, containerHeight);
    }

    public final int maxAllowedHeightForFitToContents$react_native_screens_release(int containerHeight, int contentHeight, int bottomInset) {
        return contentHeight <= 0 ? containerHeight : RangesKt.coerceAtMost(contentHeight + bottomInset, containerHeight);
    }

    public final float halfExpandedRatio$react_native_screens_release() {
        if (getCount$react_native_screens_release() != 3) {
            throw new IllegalStateException("[RNScreens] Exactly 3 detents are required for halfExpandedRatio.".toString());
        }
        return (float) (heightFractionAt(1) / heightFractionAt(2));
    }

    public static /* synthetic */ int expandedOffsetFromTop$react_native_screens_release$default(FormSheetDetents formSheetDetents, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return formSheetDetents.expandedOffsetFromTop$react_native_screens_release(i, i2);
    }

    public final int expandedOffsetFromTop$react_native_screens_release(int containerHeight, int topInset) {
        if (getCount$react_native_screens_release() != 3) {
            throw new IllegalStateException("[RNScreens] Exactly 3 detents are required for expandedOffsetFromTop.".toString());
        }
        return ((int) ((1.0d - heightFractionAt(2)) * ((double) containerHeight))) + topInset;
    }

    private final int largestDetentTopOffset(int containerHeight) {
        return containerHeight - maxAllowedHeight$react_native_screens_release(containerHeight);
    }

    public static /* synthetic */ int sheetContainerHeight$react_native_screens_release$default(FormSheetDetents formSheetDetents, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return formSheetDetents.sheetContainerHeight$react_native_screens_release(i, i2, i3, i4);
    }

    public final int sheetContainerHeight$react_native_screens_release(int containerHeight, int topInset, int bottomInset, int contentHeight) {
        if (!isFitToContents$react_native_screens_release()) {
            return RangesKt.coerceAtLeast((maxAllowedHeight$react_native_screens_release(containerHeight) - RangesKt.coerceAtLeast(topInset - largestDetentTopOffset(containerHeight), 0)) - bottomInset, 0);
        }
        if (contentHeight <= 0) {
            return RangesKt.coerceAtLeast((containerHeight - topInset) - bottomInset, 0);
        }
        return RangesKt.coerceAtMost(contentHeight, containerHeight);
    }
}
