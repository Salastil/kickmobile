package expo.modules.camera;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlashShutter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"flashShutter", "", "view", "Landroid/view/View;", "expo-camera_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FlashShutterKt {
    public static final void flashShutter(final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getRootView().postDelayed(new Runnable() { // from class: expo.modules.camera.FlashShutterKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlashShutterKt.flashShutter$lambda$1(view);
            }
        }, 100L);
    }

    static final void flashShutter$lambda$1(View view) {
        final View rootView = view.getRootView();
        rootView.setForeground(new ColorDrawable(-1));
        rootView.postDelayed(new Runnable() { // from class: expo.modules.camera.FlashShutterKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                rootView.setForeground(null);
            }
        }, 50L);
    }
}
