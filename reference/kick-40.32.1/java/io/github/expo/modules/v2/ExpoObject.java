package io.github.expo.modules.v2;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoObject.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0014J8\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\b\"\u0004\b\u0000\u0010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0018H\u0004R\u0010\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u00010\u0007j\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u0001`\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lio/github/expo/modules/v2/ExpoObject;", "", "<init>", "()V", "objectId", "", "events", "Ljava/util/ArrayList;", "Lio/github/expo/modules/v2/events/Event;", "Lkotlin/collections/ArrayList;", "contextRef", "Ljava/lang/ref/WeakReference;", "Lio/github/expo/modules/v2/ExpoContext;", "contextOrNull", "getContextOrNull", "()Lio/github/expo/modules/v2/ExpoContext;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "getContext", "bindContext", "", "bindContext$react_release", "event", ExifInterface.GPS_DIRECTION_TRUE, "onStartObserving", "Lkotlin/Function0;", "onStopObserving", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ExpoObject {
    private static final Companion Companion = new Companion(null);
    private static final AtomicLong nextObjectId = new AtomicLong(1);
    public volatile WeakReference<ExpoContext> contextRef;
    public ArrayList<io.github.expo.modules.v2.events.Event<?>> events;
    public final long objectId = nextObjectId.getAndIncrement();

    public final ExpoContext getContextOrNull() {
        ExpoContext expoContext;
        WeakReference<ExpoContext> weakReference = this.contextRef;
        if (weakReference == null || (expoContext = weakReference.get()) == null || expoContext.getIsClosed()) {
            return null;
        }
        return expoContext;
    }

    public final ExpoContext getContext() {
        WeakReference<ExpoContext> weakReference = this.contextRef;
        if (weakReference == null) {
            throw new IllegalStateException((getClass().getName() + " is not bound to an ExpoContext yet. A module is bound when it is registered. A shared object made off the JS thread must be constructed with SharedObject(context), or handed to JavaScript first").toString());
        }
        ExpoContext expoContext = weakReference.get();
        if (expoContext != null) {
            if (expoContext.getIsClosed()) {
                expoContext = null;
            }
            if (expoContext != null) {
                return expoContext;
            }
        }
        throw new IllegalStateException(("The ExpoContext of " + getClass().getName() + " is closed").toString());
    }

    public final synchronized void bindContext$react_release(ExpoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ExpoContext contextOrNull = getContextOrNull();
        if (contextOrNull == context) {
            return;
        }
        if (contextOrNull != null) {
            throw new IllegalStateException((getClass().getName() + " already belongs to another ExpoContext. One instance can serve several runtimes only when they share one context").toString());
        }
        this.contextRef = new WeakReference<>(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.github.expo.modules.v2.events.Event event$default(ExpoObject expoObject, Function0 function0, Function0 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: event");
        }
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return expoObject.event(function0, function1);
    }

    protected final <T> io.github.expo.modules.v2.events.Event<T> event(Function0<Unit> onStartObserving, Function0<Unit> onStopObserving) {
        return new io.github.expo.modules.v2.events.Event<>(this, onStartObserving, onStopObserving);
    }

    /* JADX INFO: compiled from: ExpoObject.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lio/github/expo/modules/v2/ExpoObject$Companion;", "", "<init>", "()V", "nextObjectId", "Ljava/util/concurrent/atomic/AtomicLong;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
