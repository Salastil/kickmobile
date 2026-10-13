package com.datadog.android.rum.internal.tracking;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.datadog.android.internal.utils.NumberExtKt;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JetpackViewAttributesProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00060\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/tracking/JetpackViewAttributesProvider;", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "()V", "equals", "", "other", "", "extractAttributes", "", "view", "Landroid/view/View;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "hashCode", "", "isDirectChildOfRecyclerView", "child", "resolveIdOrResourceName", "viewIdAsHexa", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JetpackViewAttributesProvider implements ViewAttributesProvider {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.datadog.android.rum.tracking.ViewAttributesProvider
    public void extractAttributes(View view, Map<String, Object> attributes) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        for (ViewParent parent = view.getParent(); parent != 0; parent = parent.getParent()) {
            if ((parent instanceof RecyclerView) && view != null && isDirectChildOfRecyclerView(view)) {
                attributes.put(RumAttributes.ACTION_TARGET_PARENT_INDEX, Integer.valueOf(((RecyclerView) parent).getChildAdapterPosition(view)));
                attributes.put(RumAttributes.ACTION_TARGET_PARENT_CLASSNAME, parent.getClass().getCanonicalName());
                attributes.put(RumAttributes.ACTION_TARGET_PARENT_RESOURCE_ID, resolveIdOrResourceName((View) parent));
                return;
            }
            view = parent instanceof View ? (View) parent : null;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null);
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    private final boolean isDirectChildOfRecyclerView(View child) {
        return child.getLayoutParams() instanceof RecyclerView.LayoutParams;
    }

    private final String resolveIdOrResourceName(View view) {
        try {
            String resourceEntryName = view.getResources().getResourceEntryName(view.getId());
            return resourceEntryName == null ? viewIdAsHexa(view) : resourceEntryName;
        } catch (Resources.NotFoundException unused) {
            return viewIdAsHexa(view);
        }
    }

    private final String viewIdAsHexa(View view) {
        return "0x" + NumberExtKt.toHexString(view.getId());
    }
}
