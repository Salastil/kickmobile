package expo.modules.kotlin.views;

import android.view.View;
import androidx.compose.ui.R;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostingViewSaveableState.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/views/HostingViewSaveableState;", "", "<init>", "()V", "nextNamespace", "Ljava/util/concurrent/atomic/AtomicInteger;", "assignNamespace", "", "view", "Landroid/view/View;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HostingViewSaveableState {
    public static final HostingViewSaveableState INSTANCE = new HostingViewSaveableState();
    private static final AtomicInteger nextNamespace = new AtomicInteger();
    public static final int $stable = 8;

    private HostingViewSaveableState() {
    }

    public final void assignNamespace(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R.id.compose_view_saveable_id_tag, "Host:" + nextNamespace.getAndIncrement());
    }
}
