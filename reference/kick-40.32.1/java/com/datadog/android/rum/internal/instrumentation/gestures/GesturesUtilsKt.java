package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.internal.utils.NumberExtKt;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.Node;
import com.datadog.android.rum.tracking.ViewTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GesturesUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"idAsStringHexa", "", "id", "", "resolveTargetName", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", TypedValues.Attributes.S_TARGET, "", "resolveViewTargetName", "Lcom/datadog/android/rum/tracking/ViewTarget;", "resourceIdName", "Landroid/content/Context;", "targetClassName", "Landroid/view/View;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GesturesUtilsKt {
    public static final String resolveViewTargetName(InteractionPredicate interactionPredicate, ViewTarget target) {
        String strResolveTargetName;
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(target, "target");
        View view = target.getViewRef().get();
        if (view != null && (strResolveTargetName = resolveTargetName(interactionPredicate, view)) != null) {
            return strResolveTargetName;
        }
        Node node = target.getNode();
        return node != null ? node.getName() : "";
    }

    public static final String resolveTargetName(InteractionPredicate interactionPredicate, Object target) {
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(target, "target");
        String targetName = interactionPredicate.getTargetName(target);
        String str = targetName;
        return (str == null || str.length() == 0) ? "" : targetName;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    public static final String resourceIdName(Context context, int i) {
        String resourceEntryName;
        if (context != null) {
            try {
                Resources resources = context.getResources();
                if (resources != null) {
                    resourceEntryName = resources.getResourceEntryName(i);
                } else {
                    resourceEntryName = null;
                }
            } catch (Resources.NotFoundException unused) {
                return idAsStringHexa(i);
            }
        } else {
            resourceEntryName = null;
        }
        return resourceEntryName == null ? idAsStringHexa(i) : resourceEntryName;
    }

    public static final String targetClassName(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        String canonicalName = view.getClass().getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        String simpleName = view.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    private static final String idAsStringHexa(int i) {
        return "0x" + NumberExtKt.toHexString(i);
    }
}
