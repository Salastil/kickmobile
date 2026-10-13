package expo.modules.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNHostView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"detachForReuse", "", "wrapper", "Landroid/view/View;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RNHostViewKt {
    public static final void detachForReuse(View wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        ViewParent parent = wrapper.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(wrapper);
        }
        wrapper.layout(0, 0, 0, 0);
    }
}
