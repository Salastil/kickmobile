package io.github.expo.modules.v2.events;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.github.expo.modules.v2.ExpoObject;
import io.github.expo.modules.v2.async.AsyncContext;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.LinkedHashSet;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0010\u0001\n\u0002\b\u0003\u0018\u0000 9*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00019B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00028\u0000¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\u00072\u0006\u0010,\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010-J\u0015\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020#H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020\u00072\u0006\u00100\u001a\u00020#H\u0000¢\u0006\u0002\b3J\r\u00104\u001a\u00020\u0007H\u0000¢\u0006\u0002\b5J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020#0&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0011\u0010(\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b)\u0010\u0010R\u0011\u0010*\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001c¨\u0006:"}, d2 = {"Lio/github/expo/modules/v2/events/Event;", ExifInterface.GPS_DIRECTION_TRUE, "", "owner", "Lio/github/expo/modules/v2/ExpoObject;", "onStartObserving", "Lkotlin/Function0;", "", "onStopObserving", "<init>", "(Lio/github/expo/modules/v2/ExpoObject;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOwner$react_release", "()Lio/github/expo/modules/v2/ExpoObject;", "jsName", "", "getJsName$react_release", "()Ljava/lang/String;", "setJsName$react_release", "(Ljava/lang/String;)V", "descriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "getDescriptor$react_release", "()Lio/github/expo/modules/v2/types/TypeDescriptor;", "setDescriptor$react_release", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)V", "useBuffer", "", "getUseBuffer$react_release", "()Z", "setUseBuffer$react_release", "(Z)V", FirebaseAnalytics.Param.INDEX, "", "observers", "Ljava/util/LinkedHashSet;", "Lio/github/expo/modules/v2/async/AsyncContext;", "Lkotlin/collections/LinkedHashSet;", "observerSnapshot", "", "[Lio/github/expo/modules/v2/async/AsyncContext;", "name", "getName", "isObserved", "emit", "payload", "(Ljava/lang/Object;)V", "invoke", "attach", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "attach$react_release", "detach", "detach$react_release", "detachAll", "detachAll$react_release", "unbound", "", "toString", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Event<T> {
    private static final Companion Companion = new Companion(null);
    private static final AsyncContext[] NO_OBSERVERS = new AsyncContext[0];
    private TypeDescriptor descriptor;
    public int index;
    private String jsName;
    private volatile AsyncContext[] observerSnapshot;
    private final LinkedHashSet<AsyncContext> observers;
    private final Function0<Unit> onStartObserving;
    private final Function0<Unit> onStopObserving;
    private final ExpoObject owner;
    private boolean useBuffer;

    public Event(ExpoObject owner, Function0<Unit> function0, Function0<Unit> function1) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.onStartObserving = function0;
        this.onStopObserving = function1;
        this.index = -1;
        this.observers = new LinkedHashSet<>();
        this.observerSnapshot = NO_OBSERVERS;
    }

    /* JADX INFO: renamed from: getOwner$react_release, reason: from getter */
    public final ExpoObject getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: getJsName$react_release, reason: from getter */
    public final String getJsName() {
        return this.jsName;
    }

    public final void setJsName$react_release(String str) {
        this.jsName = str;
    }

    /* JADX INFO: renamed from: getDescriptor$react_release, reason: from getter */
    public final TypeDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final void setDescriptor$react_release(TypeDescriptor typeDescriptor) {
        this.descriptor = typeDescriptor;
    }

    /* JADX INFO: renamed from: getUseBuffer$react_release, reason: from getter */
    public final boolean getUseBuffer() {
        return this.useBuffer;
    }

    public final void setUseBuffer$react_release(boolean z) {
        this.useBuffer = z;
    }

    public final String getName() {
        String str = this.jsName;
        if (str != null) {
            return str;
        }
        unbound();
        throw new KotlinNothingValueException();
    }

    public final boolean isObserved() {
        boolean z;
        synchronized (EventSupport.INSTANCE.getLock$react_release()) {
            z = !this.observers.isEmpty();
        }
        return z;
    }

    public final void emit(final T payload) {
        final String name = getName();
        final TypeDescriptor typeDescriptor = this.descriptor;
        if (typeDescriptor == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        AsyncContext[] asyncContextArr = this.observerSnapshot;
        if (asyncContextArr.length == 0) {
            return;
        }
        for (final AsyncContext asyncContext : asyncContextArr) {
            asyncContext.getScheduler().postOrExecuteIfOnJsThread(new Runnable() { // from class: io.github.expo.modules.v2.events.Event$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AsyncContext asyncContext2 = asyncContext;
                    Event event = this;
                    EventSupport.INSTANCE.deliver$react_release(asyncContext2, event, name, typeDescriptor, event.useBuffer, payload);
                }
            });
        }
    }

    public final void invoke(T payload) {
        emit(payload);
    }

    public final void attach$react_release(AsyncContext context) {
        boolean z;
        Function0<Unit> function0;
        AsyncContext[] asyncContextArr;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (EventSupport.INSTANCE.getLock$react_release()) {
            boolean zAdd = this.observers.add(context);
            z = false;
            if (zAdd) {
                if (this.observers.size() == 1) {
                    asyncContextArr = new AsyncContext[]{context};
                } else {
                    asyncContextArr = (AsyncContext[]) this.observers.toArray(new AsyncContext[0]);
                }
                this.observerSnapshot = asyncContextArr;
            }
            if (zAdd && this.observers.size() == 1) {
                z = true;
            }
        }
        if (!z || (function0 = this.onStartObserving) == null) {
            return;
        }
        function0.invoke();
    }

    public final void detach$react_release(AsyncContext context) {
        boolean z;
        Function0<Unit> function0;
        AsyncContext[] asyncContextArr;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (EventSupport.INSTANCE.getLock$react_release()) {
            boolean zRemove = this.observers.remove(context);
            z = false;
            if (zRemove) {
                if (this.observers.isEmpty()) {
                    asyncContextArr = NO_OBSERVERS;
                } else {
                    asyncContextArr = (AsyncContext[]) this.observers.toArray(new AsyncContext[0]);
                }
                this.observerSnapshot = asyncContextArr;
            }
            if (zRemove && this.observers.isEmpty()) {
                z = true;
            }
        }
        if (!z || (function0 = this.onStopObserving) == null) {
            return;
        }
        function0.invoke();
    }

    public final void detachAll$react_release() {
        boolean z;
        Function0<Unit> function0;
        synchronized (EventSupport.INSTANCE.getLock$react_release()) {
            if (this.observers.isEmpty()) {
                z = false;
            } else {
                this.observers.clear();
                this.observerSnapshot = NO_OBSERVERS;
                z = true;
            }
        }
        if (!z || (function0 = this.onStopObserving) == null) {
            return;
        }
        function0.invoke();
    }

    private final Void unbound() {
        throw new IllegalStateException("This event of " + this.owner.getClass().getName() + " is not bound to a JavaScript name - declare it as an @Event property, or bind it with EventSupport.bind(event, name, type, useBuffer)");
    }

    public String toString() {
        String str = this.jsName;
        if (str == null) {
            str = "<unbound>";
        }
        return "Event(" + str + " of " + this.owner.getClass().getSimpleName() + ")";
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/github/expo/modules/v2/events/Event$Companion;", "", "<init>", "()V", "NO_OBSERVERS", "", "Lio/github/expo/modules/v2/async/AsyncContext;", "getNO_OBSERVERS", "()[Lio/github/expo/modules/v2/async/AsyncContext;", "[Lio/github/expo/modules/v2/async/AsyncContext;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AsyncContext[] getNO_OBSERVERS() {
            return Event.NO_OBSERVERS;
        }
    }
}
