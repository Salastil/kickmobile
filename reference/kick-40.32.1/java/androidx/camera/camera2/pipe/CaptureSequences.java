package androidx.camera.camera2.pipe;

import android.os.Trace;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072 \b\u0004\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\tH\u0086\bø\u0001\u0000J:\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000fH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/CaptureSequences;", "", "<init>", "()V", "invokeOnRequests", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/CaptureSequence;", "fn", "Lkotlin/Function3;", "Landroidx/camera/camera2/pipe/RequestMetadata;", "", "Landroidx/camera/camera2/pipe/Request$Listener;", "invokeOnRequest", "request", "Lkotlin/Function1;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureSequences {
    public static final CaptureSequences INSTANCE = new CaptureSequences();

    private CaptureSequences() {
    }

    public final <T> void invokeOnRequests(CaptureSequence<? extends T> captureSequence, Function3<? super RequestMetadata, ? super Integer, ? super Request.Listener, ? extends Object> fn) {
        Intrinsics.checkNotNullParameter(captureSequence, "<this>");
        Intrinsics.checkNotNullParameter(fn, "fn");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = captureSequence.getCaptureMetadataList().size();
        for (int i = 0; i < size; i++) {
            RequestMetadata requestMetadata = captureSequence.getCaptureMetadataList().get(i);
            int size2 = captureSequence.getListeners().size();
            for (int i2 = 0; i2 < size2; i2++) {
                fn.invoke(requestMetadata, Integer.valueOf(i), captureSequence.getListeners().get(i2));
            }
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug3 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size3 = captureSequence.getCaptureMetadataList().size();
        for (int i3 = 0; i3 < size3; i3++) {
            RequestMetadata requestMetadata2 = captureSequence.getCaptureMetadataList().get(i3);
            int size4 = requestMetadata2.getRequest().getListeners().size();
            for (int i4 = 0; i4 < size4; i4++) {
                fn.invoke(requestMetadata2, Integer.valueOf(i3), requestMetadata2.getRequest().getListeners().get(i4));
            }
        }
        Debug debug4 = Debug.INSTANCE;
        Trace.endSection();
    }

    public final <T> void invokeOnRequest(CaptureSequence<? extends T> captureSequence, RequestMetadata request, Function1<? super Request.Listener, ? extends Object> fn) {
        Intrinsics.checkNotNullParameter(captureSequence, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(fn, "fn");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = captureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            fn.invoke(captureSequence.getListeners().get(i));
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug3 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = request.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            fn.invoke(request.getRequest().getListeners().get(i2));
        }
        Debug debug4 = Debug.INSTANCE;
        Trace.endSection();
    }
}
