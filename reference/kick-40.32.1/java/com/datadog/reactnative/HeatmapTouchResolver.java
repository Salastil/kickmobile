package com.datadog.reactnative;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeatmapTouchResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/datadog/reactnative/HeatmapTouchResolver;", "", "viewResolver", "Lkotlin/Function1;", "", "Landroid/view/View;", "telemetry", "Lcom/datadog/reactnative/DdTelemetry;", "<init>", "(Lkotlin/jvm/functions/Function1;Lcom/datadog/reactnative/DdTelemetry;)V", "resolveHeatmapActionData", "Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "reactTag", "positionX", "", "positionY", "viewUrl", "", "clickableVisibleAncestorOf", "view", "elementPathFromRootTo", "", "computeTypeIndex", "parent", "Landroid/view/ViewGroup;", "pathComponentFor", "typeIndex", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeatmapTouchResolver {
    private final DdTelemetry telemetry;
    private final Function1<Integer, View> viewResolver;

    /* JADX WARN: Multi-variable type inference failed */
    public HeatmapTouchResolver() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    static final View _init_$lambda$0(int i) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HeatmapTouchResolver(Function1<? super Integer, ? extends View> viewResolver, DdTelemetry telemetry) {
        Intrinsics.checkNotNullParameter(viewResolver, "viewResolver");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        this.viewResolver = viewResolver;
        this.telemetry = telemetry;
    }

    public /* synthetic */ HeatmapTouchResolver(Function1 function1, DdTelemetry ddTelemetry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: com.datadog.reactnative.HeatmapTouchResolver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeatmapTouchResolver._init_$lambda$0(((Integer) obj).intValue());
            }
        } : function1, (i & 2) != 0 ? new DdTelemetry() : ddTelemetry);
    }

    public final CrossPlatformHeatmapActionData resolveHeatmapActionData(int reactTag, long positionX, long positionY, String viewUrl) {
        Object objM12684constructorimpl;
        CrossPlatformHeatmapActionData crossPlatformHeatmapActionData;
        List<String> list;
        DisplayMetrics displayMetrics;
        Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
        try {
            Result.Companion companion = Result.INSTANCE;
            HeatmapTouchResolver heatmapTouchResolver = this;
            View viewInvoke = this.viewResolver.invoke(Integer.valueOf(reactTag));
            View viewClickableVisibleAncestorOf = viewInvoke != null ? clickableVisibleAncestorOf(viewInvoke) : null;
            List<String> listElementPathFromRootTo = viewClickableVisibleAncestorOf != null ? elementPathFromRootTo(viewClickableVisibleAncestorOf) : null;
            if (viewClickableVisibleAncestorOf == null || (list = listElementPathFromRootTo) == null || list.isEmpty()) {
                crossPlatformHeatmapActionData = null;
            } else {
                Resources resources = viewClickableVisibleAncestorOf.getResources();
                float f = (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1.0f : displayMetrics.density;
                Long lValueOf = Long.valueOf((long) (viewClickableVisibleAncestorOf.getWidth() / f));
                Long l = lValueOf.longValue() > 0 ? lValueOf : null;
                Long lValueOf2 = Long.valueOf((long) (viewClickableVisibleAncestorOf.getHeight() / f));
                crossPlatformHeatmapActionData = new CrossPlatformHeatmapActionData(listElementPathFromRootTo, viewUrl, positionX, positionY, l, lValueOf2.longValue() > 0 ? lValueOf2 : null);
            }
            objM12684constructorimpl = Result.m12684constructorimpl(crossPlatformHeatmapActionData);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            this.telemetry.telemetryError("Failed to resolve heatmap action data", thM12687exceptionOrNullimpl);
        }
        return (CrossPlatformHeatmapActionData) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }

    private final View clickableVisibleAncestorOf(View view) {
        while (view != null) {
            if (view.isClickable() && view.getVisibility() == 0) {
                return view;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private final List<String> elementPathFromRootTo(View view) {
        ArrayList arrayList = new ArrayList();
        while (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            arrayList.add(pathComponentFor(view, viewGroup != null ? computeTypeIndex(view, viewGroup) : 0));
            view = viewGroup;
        }
        CollectionsKt.reverse(arrayList);
        return arrayList;
    }

    private final int computeTypeIndex(View view, ViewGroup parent) {
        Class<?> cls = view.getClass();
        int childCount = parent.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = parent.getChildAt(i2);
            if (childAt != null) {
                if (childAt == view) {
                    break;
                }
                if (childAt.getClass() == cls) {
                    i++;
                }
            }
        }
        return i;
    }

    private final String pathComponentFor(View view, int typeIndex) {
        int id = view.getId();
        if (id != -1) {
            try {
                Resources resources = view.getResources();
                String resourceName = resources != null ? resources.getResourceName(id) : null;
                String str = resourceName;
                if (str != null && str.length() != 0) {
                    return resourceName + "#" + typeIndex;
                }
            } catch (Resources.NotFoundException unused) {
            }
        }
        return "cls:" + view.getClass().getName() + "#" + typeIndex;
    }
}
