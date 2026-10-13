package com.facebook.imagepipeline.producers;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.logging.FLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BaseConsumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001f\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000bH$¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH$J\b\u0010\u0016\u001a\u00020\bH$J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0018\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bH\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/imagepipeline/producers/BaseConsumer;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/imagepipeline/producers/Consumer;", "<init>", "()V", "isFinished", "", "onNewResult", "", "newResult", "status", "", "(Ljava/lang/Object;I)V", "onFailure", "t", "", "onCancellation", "onProgressUpdate", "progress", "", "onNewResultImpl", "onFailureImpl", "onCancellationImpl", "onProgressUpdateImpl", "onUnhandledException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseConsumer<T> implements Consumer<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean isFinished;

    @JvmStatic
    public static final boolean isLast(int i) {
        return INSTANCE.isLast(i);
    }

    @JvmStatic
    public static final boolean isNotLast(int i) {
        return INSTANCE.isNotLast(i);
    }

    @JvmStatic
    public static final int simpleStatusForIsLast(boolean z) {
        return INSTANCE.simpleStatusForIsLast(z);
    }

    @JvmStatic
    public static final boolean statusHasAnyFlag(int i, int i2) {
        return INSTANCE.statusHasAnyFlag(i, i2);
    }

    @JvmStatic
    public static final boolean statusHasFlag(int i, int i2) {
        return INSTANCE.statusHasFlag(i, i2);
    }

    @JvmStatic
    public static final int turnOffStatusFlag(int i, int i2) {
        return INSTANCE.turnOffStatusFlag(i, i2);
    }

    @JvmStatic
    public static final int turnOnStatusFlag(int i, int i2) {
        return INSTANCE.turnOnStatusFlag(i, i2);
    }

    protected abstract void onCancellationImpl();

    protected abstract void onFailureImpl(Throwable t);

    protected abstract void onNewResultImpl(T newResult, int status);

    protected void onProgressUpdateImpl(float progress) {
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onNewResult(T newResult, int status) {
        if (this.isFinished) {
            return;
        }
        this.isFinished = INSTANCE.isLast(status);
        try {
            onNewResultImpl(newResult, status);
        } catch (Exception e) {
            onUnhandledException(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onFailure(Throwable t) {
        if (this.isFinished) {
            return;
        }
        this.isFinished = true;
        if (t == null) {
            try {
                t = new Throwable("null throwable");
            } catch (Exception e) {
                onUnhandledException(e);
            }
        }
        onFailureImpl(t);
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onCancellation() {
        if (this.isFinished) {
            return;
        }
        this.isFinished = true;
        try {
            onCancellationImpl();
        } catch (Exception e) {
            onUnhandledException(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onProgressUpdate(float progress) {
        if (this.isFinished) {
            return;
        }
        try {
            onProgressUpdateImpl(progress);
        } catch (Exception e) {
            onUnhandledException(e);
        }
    }

    protected final void onUnhandledException(Exception e) {
        FLog.wtf(getClass(), "unhandled exception", e);
    }

    /* JADX INFO: compiled from: BaseConsumer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/producers/BaseConsumer$Companion;", "", "<init>", "()V", "isLast", "", "status", "", "isNotLast", "turnOnStatusFlag", "flag", "turnOffStatusFlag", "statusHasFlag", "statusHasAnyFlag", "simpleStatusForIsLast", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isLast(int status) {
            return (status & 1) == 1;
        }

        @JvmStatic
        public final int simpleStatusForIsLast(boolean isLast) {
            return isLast ? 1 : 0;
        }

        @JvmStatic
        public final boolean statusHasAnyFlag(int status, int flag) {
            return (status & flag) != 0;
        }

        @JvmStatic
        public final boolean statusHasFlag(int status, int flag) {
            return (status & flag) == flag;
        }

        @JvmStatic
        public final int turnOffStatusFlag(int status, int flag) {
            return (~flag) & status;
        }

        @JvmStatic
        public final int turnOnStatusFlag(int status, int flag) {
            return status | flag;
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isNotLast(int status) {
            return !isLast(status);
        }
    }
}
