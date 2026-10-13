package io.github.expo.modules.v2.events;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.github.expo.modules.v2.ExpoObject;
import io.github.expo.modules.v2.args.Bridge;
import io.github.expo.modules.v2.args.Trampoline;
import io.github.expo.modules.v2.async.AsyncContext;
import io.github.expo.modules.v2.logging.PlatformLoggerKt;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventSupport.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0007JC\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u001dR\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, d2 = {"Lio/github/expo/modules/v2/events/EventSupport;", "", "<init>", "()V", "lock", "getLock$react_release", "()Ljava/lang/Object;", "bind", "Lio/github/expo/modules/v2/events/Event;", ExifInterface.GPS_DIRECTION_TRUE, "event", "jsName", "", "descriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "useBuffer", "", "observe", "", "instance", "Lio/github/expo/modules/v2/ExpoObject;", FirebaseAnalytics.Param.INDEX, "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/async/AsyncContext;", "observing", "deliver", "name", "payload", "deliver$react_release", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventSupport {
    public static final EventSupport INSTANCE = new EventSupport();
    private static final Object lock = new Object();

    private EventSupport() {
    }

    public final Object getLock$react_release() {
        return lock;
    }

    public static /* synthetic */ Event bind$default(Event event, String str, TypeDescriptor typeDescriptor, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return bind(event, str, typeDescriptor, z);
    }

    @JvmStatic
    public static final <T> Event<T> bind(Event<T> event, String jsName, TypeDescriptor descriptor, boolean useBuffer) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (event.getJsName() != null) {
            throw new IllegalStateException((event + " is already bound").toString());
        }
        ExpoObject owner$react_release = event.getOwner();
        ArrayList<Event<?>> arrayList = owner$react_release.events;
        if (arrayList == null) {
            arrayList = new ArrayList<>(2);
            owner$react_release.events = arrayList;
        }
        ArrayList<Event<?>> arrayList2 = arrayList;
        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((Event) it.next()).getJsName(), jsName)) {
                    throw new IllegalArgumentException((owner$react_release.getClass().getName() + " declares two events named '" + jsName + "'").toString());
                }
            }
        }
        event.setJsName$react_release(jsName);
        event.setDescriptor$react_release(descriptor);
        event.setUseBuffer$react_release(useBuffer);
        event.index = arrayList.size();
        arrayList.add(event);
        return event;
    }

    @JvmStatic
    public static final void observe(ExpoObject instance, int index, AsyncContext context, boolean observing) {
        Event event;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<Event<?>> arrayList = instance.events;
        if (arrayList == null || (event = (Event) CollectionsKt.getOrNull(arrayList, index)) == null) {
            return;
        }
        if (observing) {
            event.attach$react_release(context);
        } else {
            event.detach$react_release(context);
        }
    }

    public final void deliver$react_release(AsyncContext context, Event<?> event, String name, TypeDescriptor descriptor, boolean useBuffer, Object payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        long runtimePointer = context.getRuntimePointer();
        if (runtimePointer == 0) {
            return;
        }
        ExpoObject owner$react_release = event.getOwner();
        try {
            if (useBuffer) {
                EventNatives.INSTANCE.emitBuffered(runtimePointer, owner$react_release.objectId, event.index, Trampoline.writeResult(payload, descriptor));
            } else {
                EventNatives.INSTANCE.emit(runtimePointer, owner$react_release.objectId, event.index, Bridge.toJni(payload, descriptor));
            }
        } catch (Throwable th) {
            PlatformLoggerKt.getPlatformLogger().error("emitting '" + name + "' on " + owner$react_release.getClass().getName() + " failed", th);
        }
    }
}
