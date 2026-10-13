package io.github.expo.kolibri;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NativeObject.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/github/expo/kolibri/NativeObject;", "", "pointer", "Lio/github/expo/kolibri/NativePointer;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "nativePointer", "", "cleanable", "Lio/github/expo/kolibri/Cleanable;", "destroy", "", "Companion", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class NativeObject {
    private static final Companion Companion;
    private static final Cleaner.PointerFree destroyer;
    private final Cleanable cleanable;
    public volatile long nativePointer;

    public /* synthetic */ NativeObject(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeDestroy(long j);

    private NativeObject(long j) {
        this.nativePointer = j;
        this.cleanable = NativeCleaner.INSTANCE.getCleaner().registerPointer(this, this.nativePointer, destroyer);
    }

    public final void destroy() {
        synchronized (this) {
            this.cleanable.clean();
            this.nativePointer = 0L;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: NativeObject.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0083 R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/github/expo/kolibri/NativeObject$Companion;", "", "<init>", "()V", "nativeDestroy", "", "pointer", "", "destroyer", "Lio/github/expo/kolibri/Cleaner$PointerFree;", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeDestroy(long pointer) {
            NativeObject.nativeDestroy(pointer);
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        Kolibri.INSTANCE.load();
        destroyer = new NativeObject$Companion$destroyer$1(companion);
    }
}
