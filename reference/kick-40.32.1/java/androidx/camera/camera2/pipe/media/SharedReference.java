package androidx.camera.camera2.pipe.media;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: SharedReference.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/media/SharedReference;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "defaultFinalizer", "Landroidx/camera/camera2/pipe/media/Finalizer;", "<init>", "(Ljava/lang/Object;Landroidx/camera/camera2/pipe/media/Finalizer;)V", "Ljava/lang/Object;", "count", "Lkotlinx/atomicfu/AtomicInt;", "currentFinalizer", "Lkotlinx/atomicfu/AtomicRef;", "acquireOrNull", "()Ljava/lang/Object;", "decrement", "", "setFinalizer", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharedReference<T> {
    private final AtomicInt count;
    private AtomicRef<Finalizer<T>> currentFinalizer;
    private final T value;

    public SharedReference(T t, Finalizer<? super T> defaultFinalizer) {
        Intrinsics.checkNotNullParameter(defaultFinalizer, "defaultFinalizer");
        this.value = t;
        this.count = AtomicFU.atomic(1);
        this.currentFinalizer = AtomicFU.atomic(defaultFinalizer);
    }

    public final T acquireOrNull() {
        int value;
        int i;
        AtomicInt atomicInt = this.count;
        do {
            value = atomicInt.getValue();
            i = value == 0 ? 0 : value + 1;
        } while (!atomicInt.compareAndSet(value, i));
        if (i != 0) {
            return this.value;
        }
        return null;
    }

    public final void decrement() {
        if (this.count.decrementAndGet() == 0) {
            Finalizer<T> andSet = this.currentFinalizer.getAndSet(null);
            Intrinsics.checkNotNull(andSet);
            andSet.finalize(this.value);
        }
    }

    public final void setFinalizer(Finalizer<? super T> value) {
        Finalizer<T> value2;
        Finalizer<T> finalizer;
        Intrinsics.checkNotNullParameter(value, "value");
        AtomicRef<Finalizer<T>> atomicRef = this.currentFinalizer;
        do {
            value2 = atomicRef.getValue();
            finalizer = value2;
        } while (!atomicRef.compareAndSet(value2, finalizer == null ? null : value));
        if (finalizer != null) {
            finalizer.finalize(null);
        } else {
            value.finalize(null);
        }
    }
}
