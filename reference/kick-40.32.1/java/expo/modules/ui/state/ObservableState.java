package expo.modules.ui.state;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.sharedobjects.SharedObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ObservableState.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u0002H\u0016¢\u0006\u0002\u0010\u0018R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005¨\u0006\u0019"}, d2 = {"Lexpo/modules/ui/state/ObservableState;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "initialValue", "", "<init>", "(Ljava/lang/Object;)V", "_state", "Landroidx/compose/runtime/MutableState;", "onChange", "Lexpo/modules/ui/state/WorkletCallback;", "getOnChange$expo_ui_release", "()Lexpo/modules/ui/state/WorkletCallback;", "setOnChange$expo_ui_release", "(Lexpo/modules/ui/state/WorkletCallback;)V", "isNotifying", "", "v", "value", "getValue", "()Ljava/lang/Object;", "setValue", "binding", ExifInterface.GPS_DIRECTION_TRUE, "fallback", "(Ljava/lang/Object;)Ljava/lang/Object;", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ObservableState extends SharedObject {
    public static final int $stable = 8;
    private final MutableState<Object> _state;
    private boolean isNotifying;
    private WorkletCallback onChange;

    /* JADX WARN: Illegal instructions before constructor call */
    public ObservableState() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public ObservableState(Object obj) {
        super(null, 1, null);
        this._state = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
    }

    public /* synthetic */ ObservableState(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    /* JADX INFO: renamed from: getOnChange$expo_ui_release, reason: from getter */
    public final WorkletCallback getOnChange() {
        return this.onChange;
    }

    public final void setOnChange$expo_ui_release(WorkletCallback workletCallback) {
        this.onChange = workletCallback;
    }

    public final Object getValue() {
        return this._state.getValue();
    }

    public final void setValue(Object obj) {
        this._state.setValue(obj);
        if (this.isNotifying) {
            return;
        }
        this.isNotifying = true;
        try {
            WorkletCallback workletCallback = this.onChange;
            if (workletCallback != null) {
                workletCallback.invoke(obj);
            }
        } finally {
            this.isNotifying = false;
        }
    }

    public final <T> T binding(T fallback) {
        T t = (T) this._state.getValue();
        if (t == null) {
            t = null;
        }
        return t == null ? fallback : t;
    }
}
