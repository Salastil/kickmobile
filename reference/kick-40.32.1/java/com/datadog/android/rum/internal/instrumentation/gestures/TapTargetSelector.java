package com.datadog.android.rum.internal.instrumentation.gestures;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTargetSelector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J(\u0010\u0010\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001c\u0010\u0013\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u001c\u0010\u0016\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0014\u0010\u0018\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e*\u00020\u0006H\u0002¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/TapTargetSelector;", "", "()V", "shouldSelectCandidate", "", "currentHostView", "Landroid/view/View;", "candidateHostView", "childIndexOf", "", "Landroid/view/ViewGroup;", "child", "(Landroid/view/ViewGroup;Landroid/view/View;)Ljava/lang/Integer;", "commonPathSizeWith", "", "otherPath", "isBranchDrawnOnTopOf", "candidatePath", "commonPathSize", "isDrawnOnTopOf", "candidateView", "parent", "isLaterChild", "candidateChild", "isPreferredOver", "pathFromRoot", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TapTargetSelector {
    public final boolean shouldSelectCandidate(View currentHostView, View candidateHostView) {
        Intrinsics.checkNotNullParameter(candidateHostView, "candidateHostView");
        return currentHostView == null || !isPreferredOver(currentHostView, candidateHostView);
    }

    private final boolean isPreferredOver(View view, View view2) {
        List<View> listPathFromRoot = pathFromRoot(view);
        List<View> listPathFromRoot2 = pathFromRoot(view2);
        int iCommonPathSizeWith = commonPathSizeWith(listPathFromRoot, listPathFromRoot2);
        boolean z = iCommonPathSizeWith == 0;
        boolean z2 = iCommonPathSizeWith == listPathFromRoot.size();
        boolean z3 = iCommonPathSizeWith == listPathFromRoot2.size();
        if (z || z2) {
            return false;
        }
        if (z3) {
            return true;
        }
        return isBranchDrawnOnTopOf(listPathFromRoot, listPathFromRoot2, iCommonPathSizeWith);
    }

    private final int commonPathSizeWith(List<? extends View> list, List<? extends View> list2) {
        int iMin = Math.min(list.size(), list2.size());
        int i = 0;
        while (i < iMin && list.get(i) == list2.get(i)) {
            i++;
        }
        return i;
    }

    private final boolean isBranchDrawnOnTopOf(List<? extends View> list, List<? extends View> list2, int i) {
        View view = list.get(i - 1);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return false;
        }
        return isDrawnOnTopOf(list.get(i), list2.get(i), viewGroup);
    }

    private final boolean isDrawnOnTopOf(View view, View view2, ViewGroup viewGroup) {
        if (view.getZ() > view2.getZ()) {
            return true;
        }
        if (view.getZ() < view2.getZ()) {
            return false;
        }
        return isLaterChild(viewGroup, view, view2);
    }

    private final boolean isLaterChild(ViewGroup viewGroup, View view, View view2) {
        Integer numChildIndexOf = childIndexOf(viewGroup, view);
        Integer numChildIndexOf2 = childIndexOf(viewGroup, view2);
        return (numChildIndexOf == null || numChildIndexOf2 == null || numChildIndexOf.intValue() <= numChildIndexOf2.intValue()) ? false : true;
    }

    private final Integer childIndexOf(ViewGroup viewGroup, View view) {
        try {
            int iIndexOfChild = viewGroup.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                return Integer.valueOf(iIndexOfChild);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final List<View> pathFromRoot(View view) {
        ArrayList arrayList = new ArrayList();
        while (view != null) {
            arrayList.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        CollectionsKt.reverse(arrayList);
        return arrayList;
    }
}
