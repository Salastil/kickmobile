package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/compat/ObjectUnavailableException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "<init>", "(Ljava/lang/Throwable;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObjectUnavailableException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectUnavailableException(Throwable e) {
        super(e);
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
