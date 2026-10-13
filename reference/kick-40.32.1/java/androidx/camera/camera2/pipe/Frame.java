package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.core.AutoCloseables;
import androidx.camera.camera2.pipe.media.OutputImage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.NotImplementedError;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Frame.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000  2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0002\u001f J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0017\u0010\rJ\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/Frame;", "Landroidx/camera/camera2/pipe/FrameReference;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "awaitFrameInfo", "Landroidx/camera/camera2/pipe/FrameInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFrameInfo", "awaitImage", "Landroidx/camera/camera2/pipe/media/OutputImage;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "awaitImage-NYG5g8E", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImage", "getImage-aKI5c8E", "(I)Landroidx/camera/camera2/pipe/media/OutputImage;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "awaitImage-A9nWXxg", "getImage-iYJqvbA", "awaitImages", "", "awaitImages-NYG5g8E", "getImages", "getImages-aKI5c8E", "(I)Ljava/util/List;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/Frame$Listener;", "Listener", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Frame extends FrameReference, AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Frame.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0003H&J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/Frame$Listener;", "", "onFrameStarted", "", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "frameTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "onFrameStarted-cfZT-5Y", "(JJ)V", "onFrameInfoAvailable", "onImageAvailable", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "onImageAvailable-aKI5c8E", "(I)V", "onImagesAvailable", "onFrameComplete", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Listener {
        void onFrameComplete();

        void onFrameInfoAvailable();

        /* JADX INFO: renamed from: onFrameStarted-cfZT-5Y, reason: not valid java name */
        void m516onFrameStartedcfZT5Y(long frameNumber, long frameTimestamp);

        /* JADX INFO: renamed from: onImageAvailable-aKI5c8E, reason: not valid java name */
        default void m517onImageAvailableaKI5c8E(int streamId) {
        }

        void onImagesAvailable();
    }

    /* JADX INFO: renamed from: awaitImage-NYG5g8E$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m499awaitImageNYG5g8E$suspendImpl(Frame frame, int i, Continuation<? super OutputImage> continuation) {
        return null;
    }

    void addListener(Listener listener);

    Object awaitFrameInfo(Continuation<? super FrameInfo> continuation);

    /* JADX INFO: renamed from: awaitImage-A9nWXxg, reason: not valid java name */
    default Object mo501awaitImageA9nWXxg(int i, Continuation<? super OutputImage> continuation) {
        return m498awaitImageA9nWXxg$suspendImpl(this, i, continuation);
    }

    /* JADX INFO: renamed from: awaitImage-NYG5g8E, reason: not valid java name */
    default Object mo502awaitImageNYG5g8E(int i, Continuation<? super OutputImage> continuation) {
        return m499awaitImageNYG5g8E$suspendImpl(this, i, continuation);
    }

    /* JADX INFO: renamed from: awaitImages-NYG5g8E, reason: not valid java name */
    default Object mo503awaitImagesNYG5g8E(int i, Continuation<? super List<? extends OutputImage>> continuation) {
        return m500awaitImagesNYG5g8E$suspendImpl(this, i, continuation);
    }

    FrameInfo getFrameInfo();

    /* JADX INFO: renamed from: getImage-aKI5c8E, reason: not valid java name */
    default OutputImage mo504getImageaKI5c8E(int streamId) {
        return null;
    }

    /* JADX INFO: compiled from: Frame.kt */
    @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: imageStatus-BWjvHWQ, reason: not valid java name */
        public static int m515imageStatusBWjvHWQ(Frame frame, int i) {
            return Frame.super.mo543imageStatusBWjvHWQ(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: awaitImage-NYG5g8E, reason: not valid java name */
        public static Object m510awaitImageNYG5g8E(Frame frame, int i, Continuation<? super OutputImage> continuation) {
            return Frame.super.mo502awaitImageNYG5g8E(i, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: getImage-aKI5c8E, reason: not valid java name */
        public static OutputImage m512getImageaKI5c8E(Frame frame, int i) {
            return Frame.super.mo504getImageaKI5c8E(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: awaitImage-A9nWXxg, reason: not valid java name */
        public static Object m509awaitImageA9nWXxg(Frame frame, int i, Continuation<? super OutputImage> continuation) {
            return Frame.super.mo501awaitImageA9nWXxg(i, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: getImage-iYJqvbA, reason: not valid java name */
        public static OutputImage m513getImageiYJqvbA(Frame frame, int i) {
            return Frame.super.mo505getImageiYJqvbA(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: awaitImages-NYG5g8E, reason: not valid java name */
        public static Object m511awaitImagesNYG5g8E(Frame frame, int i, Continuation<? super List<? extends OutputImage>> continuation) {
            return Frame.super.mo503awaitImagesNYG5g8E(i, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: getImages-aKI5c8E, reason: not valid java name */
        public static List<OutputImage> m514getImagesaKI5c8E(Frame frame, int i) {
            return Frame.super.mo506getImagesaKI5c8E(i);
        }
    }

    /* JADX INFO: renamed from: awaitImage-A9nWXxg$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m498awaitImageA9nWXxg$suspendImpl(Frame frame, int i, Continuation<? super OutputImage> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: renamed from: getImage-iYJqvbA, reason: not valid java name */
    default OutputImage mo505getImageiYJqvbA(int outputId) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: renamed from: awaitImages-NYG5g8E$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m500awaitImagesNYG5g8E$suspendImpl(Frame frame, int i, Continuation<? super List<? extends OutputImage>> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: renamed from: getImages-aKI5c8E, reason: not valid java name */
    default List<OutputImage> mo506getImagesaKI5c8E(int streamId) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX INFO: compiled from: Frame.kt */
    @kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\r\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\r\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0011J*\u0010\u0015\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00060\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0019H\u0086\bø\u0001\u0000J0\u0010\u001a\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00060\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u001bH\u0086\bø\u0001\u0000R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\t\u001a\u00020\n*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/Frame$Companion;", "", "<init>", "()V", "request", "Landroidx/camera/camera2/pipe/Request;", "Landroidx/camera/camera2/pipe/Frame;", "getRequest", "(Landroidx/camera/camera2/pipe/Frame;)Landroidx/camera/camera2/pipe/Request;", "isFrameInfoAvailable", "", "Landroidx/camera/camera2/pipe/FrameReference;", "(Landroidx/camera/camera2/pipe/FrameReference;)Z", "isImageAvailable", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "isImageAvailable-vKMW96A", "(Landroidx/camera/camera2/pipe/FrameReference;I)Z", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "isImageAvailable-og7wgUk", "useEach", "", "", "action", "Lkotlin/Function1;", "useEachIndexed", "Lkotlin/Function2;", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Request getRequest(Frame frame) {
            Intrinsics.checkNotNullParameter(frame, "<this>");
            return frame.getRequestMetadata().getRequest();
        }

        public final boolean isFrameInfoAvailable(FrameReference frameReference) {
            Intrinsics.checkNotNullParameter(frameReference, "<this>");
            return OutputStatus.m581equalsimpl0(frameReference.mo540getFrameInfoStatusU7r42EA(), OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA());
        }

        /* JADX INFO: renamed from: isImageAvailable-vKMW96A, reason: not valid java name */
        public final boolean m508isImageAvailablevKMW96A(FrameReference isImageAvailable, int i) {
            Intrinsics.checkNotNullParameter(isImageAvailable, "$this$isImageAvailable");
            return OutputStatus.m581equalsimpl0(isImageAvailable.mo544imageStatusOo2lJfM(i), OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA());
        }

        /* JADX INFO: renamed from: isImageAvailable-og7wgUk, reason: not valid java name */
        public final boolean m507isImageAvailableog7wgUk(FrameReference isImageAvailable, int i) {
            Intrinsics.checkNotNullParameter(isImageAvailable, "$this$isImageAvailable");
            return OutputStatus.m581equalsimpl0(isImageAvailable.mo543imageStatusBWjvHWQ(i), OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA());
        }

        public final void useEach(List<? extends Frame> list, Function1<? super Frame, Unit> action) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(action, "action");
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            int i = 0;
            while (i < list.size()) {
                try {
                    Frame frame = list.get(i);
                    i++;
                    try {
                        action.invoke(frame);
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(frame, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            AutoCloseableKt.closeFinally(frame, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        while (i < list.size()) {
                            int i2 = i + 1;
                            try {
                                UByte$$ExternalSyntheticBackport0.m12761m((Object) list.get(i));
                            } catch (Throwable th5) {
                                ExceptionsKt.addSuppressed(th3, th5);
                            }
                            i = i2;
                        }
                        throw th4;
                    }
                }
            }
            while (i < list.size()) {
                int i3 = i + 1;
                try {
                    UByte$$ExternalSyntheticBackport0.m12761m((Object) list.get(i));
                } catch (Throwable unused) {
                }
                i = i3;
            }
        }

        public final void useEachIndexed(List<? extends Frame> list, Function2<? super Integer, ? super Frame, Unit> action) {
            int i;
            Throwable th;
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(action, "action");
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            int i2 = 0;
            while (i2 < list.size()) {
                try {
                    Frame frame = list.get(i2);
                    i = i2 + 1;
                    try {
                        action.invoke(Integer.valueOf(i2), frame);
                        Unit unit = Unit.INSTANCE;
                        try {
                            AutoCloseableKt.closeFinally(frame, null);
                            i2 = i;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                while (i < list.size()) {
                                    int i3 = i + 1;
                                    try {
                                        UByte$$ExternalSyntheticBackport0.m12761m((Object) list.get(i));
                                    } catch (Throwable th4) {
                                        ExceptionsKt.addSuppressed(th, th4);
                                    }
                                    i = i3;
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            throw th5;
                        } catch (Throwable th6) {
                            AutoCloseableKt.closeFinally(frame, th5);
                            throw th6;
                        }
                    }
                } catch (Throwable th7) {
                    i = i2;
                    th = th7;
                }
            }
            while (i2 < list.size()) {
                int i4 = i2 + 1;
                try {
                    UByte$$ExternalSyntheticBackport0.m12761m((Object) list.get(i2));
                } catch (Throwable unused) {
                }
                i2 = i4;
            }
        }
    }
}
