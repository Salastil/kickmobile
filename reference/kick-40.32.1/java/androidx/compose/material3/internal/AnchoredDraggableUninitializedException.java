package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.DraggableAnchors;
import kotlin.Metadata;

/* JADX INFO: compiled from: DraggableAnchors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/internal/AnchoredDraggableUninitializedException;", "", "isLookingAhead", "", "didLookahead", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "targetValue", "", "<init>", "(ZZLandroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "message", "", "getMessage", "()Ljava/lang/String;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnchoredDraggableUninitializedException extends Throwable {
    public static final int $stable = 8;
    private final String message;

    public AnchoredDraggableUninitializedException(boolean z, boolean z2, DraggableAnchors<?> draggableAnchors, Object obj) {
        this.message = "AnchoredDraggableState was not initialized correctly. isLookingAhead=" + z + ",didLookahead=" + z2 + ",anchors=" + draggableAnchors + ",targetValue=" + obj;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
