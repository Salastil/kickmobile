package io.github.expo.modules.v2.events;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.github.expo.modules.v2.core.ExpoModulesV2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: EventSupport.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J&\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nJ+\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0083 J)\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0083 ¨\u0006\u0010"}, d2 = {"Lio/github/expo/modules/v2/events/EventNatives;", "", "<init>", "()V", "emit", "", "runtimePointer", "", "objectId", FirebaseAnalytics.Param.INDEX, "", "value", "emitBuffered", "payloadLength", "nativeEmit", "nativeEmitBuffered", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventNatives {
    public static final EventNatives INSTANCE = new EventNatives();

    @JvmStatic
    private static final native void nativeEmit(long runtimePointer, long objectId, int index, Object value);

    @JvmStatic
    private static final native void nativeEmitBuffered(long runtimePointer, long objectId, int index, int payloadLength);

    private EventNatives() {
    }

    static {
        ExpoModulesV2.INSTANCE.load();
    }

    public final void emit(long runtimePointer, long objectId, int index, Object value) {
        nativeEmit(runtimePointer, objectId, index, value);
    }

    public final void emitBuffered(long runtimePointer, long objectId, int index, int payloadLength) {
        nativeEmitBuffered(runtimePointer, objectId, index, payloadLength);
    }
}
