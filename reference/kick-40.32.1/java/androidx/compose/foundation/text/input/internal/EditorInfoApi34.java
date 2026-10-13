package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.PreferKeepClearNode$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: EditorInfo.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/EditorInfoApi34;", "", "<init>", "()V", "setHandwritingGestures", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class EditorInfoApi34 {
    public static final EditorInfoApi34 INSTANCE = new EditorInfoApi34();

    private EditorInfoApi34() {
    }

    public final void setHandwritingGestures(EditorInfo editorInfo) {
        editorInfo.setSupportedHandwritingGestures(CollectionsKt.listOf((Object[]) new Class[]{PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$2(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$5(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$3(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$4(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$6(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$7(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$8()}));
        editorInfo.setSupportedHandwritingGesturePreviews(SetsKt.setOf((Object[]) new Class[]{PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$2(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$5(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$3(), PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m$4()}));
    }
}
