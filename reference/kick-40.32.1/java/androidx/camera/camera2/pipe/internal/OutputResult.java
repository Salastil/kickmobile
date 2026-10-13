package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.OutputStatus;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: OutputResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u001f*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u001fB\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004¢\u0006\u0004\b\u001a\u0010\u0013J\u0011\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004¢\u0006\u0004\b\u001d\u0010\u001eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u0004\u0018\u00018\u00008Æ\u0002¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002¨\u0006 "}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "result", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "available", "", "getAvailable-impl", "(Ljava/lang/Object;)Z", "failure", "getFailure-impl", "output", "getOutput$annotations", "()V", "getOutput-impl", "status", "Landroidx/camera/camera2/pipe/OutputStatus;", "getStatus-U7r42EA", "(Ljava/lang/Object;)I", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class OutputResult<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Object result;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OutputResult m1037boximpl(Object obj) {
        return new OutputResult(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m1038constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1039equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof OutputResult) && Intrinsics.areEqual(obj, ((OutputResult) obj2).getResult());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1040equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getOutput$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1045hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1046toStringimpl(Object obj) {
        return "OutputResult(result=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m1039equalsimpl(this.result, obj);
    }

    public int hashCode() {
        return m1045hashCodeimpl(this.result);
    }

    public String toString() {
        return m1046toStringimpl(this.result);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Object getResult() {
        return this.result;
    }

    private /* synthetic */ OutputResult(Object obj) {
        this.result = obj;
    }

    /* JADX INFO: renamed from: getAvailable-impl, reason: not valid java name */
    public static final boolean m1041getAvailableimpl(Object obj) {
        return (m1042getFailureimpl(obj) || obj == null) ? false : true;
    }

    /* JADX INFO: renamed from: getFailure-impl, reason: not valid java name */
    public static final boolean m1042getFailureimpl(Object obj) {
        return obj instanceof OutputStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOutput-impl, reason: not valid java name */
    public static final T m1043getOutputimpl(Object obj) {
        if (m1041getAvailableimpl(obj)) {
            return obj;
        }
        return null;
    }

    /* JADX INFO: renamed from: getStatus-U7r42EA, reason: not valid java name */
    public static final int m1044getStatusU7r42EA(Object obj) {
        if (m1041getAvailableimpl(obj)) {
            return OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA();
        }
        if (obj == null) {
            return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
        }
        return ((OutputStatus) obj).m584unboximpl();
    }

    /* JADX INFO: compiled from: OutputResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006H\u0086\b¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0001\u0010\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u00112\u0006\u0010\u0007\u001a\u0002H\u0006H\u0086\b¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u0010\"\u0004\b\u0001\u0010\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u00112\u0006\u0010\u0014\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0017\u001a\u00020\f\"\u0004\b\u0001\u0010\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0018H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001b\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0001\u0010\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0018H\u0086\b¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputResult$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/camera2/pipe/internal/OutputResult;", ExifInterface.GPS_DIRECTION_TRUE, "output", "from-EASlEvA", "(Ljava/lang/Object;)Ljava/lang/Object;", "failure", "failureReason", "Landroidx/camera/camera2/pipe/OutputStatus;", "failure-SpuARzU", "(I)Ljava/lang/Object;", "completeWithOutput", "", "Lkotlinx/coroutines/CompletableDeferred;", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "completeWithFailure", "status", "completeWithFailure-zfbXvnA", "(Lkotlinx/coroutines/CompletableDeferred;I)Z", "outputStatus", "Lkotlinx/coroutines/Deferred;", "outputStatus-NkQ9T_M", "(Lkotlinx/coroutines/Deferred;)I", "outputOrNull", "(Lkotlinx/coroutines/Deferred;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: from-EASlEvA, reason: not valid java name */
        public final <T> Object m1050fromEASlEvA(T output) {
            return OutputResult.m1038constructorimpl(output);
        }

        /* JADX INFO: renamed from: failure-SpuARzU, reason: not valid java name */
        public final <T> Object m1049failureSpuARzU(int failureReason) {
            return OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(failureReason));
        }

        /* JADX INFO: renamed from: outputStatus-NkQ9T_M, reason: not valid java name */
        public final <T> int m1051outputStatusNkQ9T_M(Deferred<? extends OutputResult<? extends T>> outputStatus) {
            Intrinsics.checkNotNullParameter(outputStatus, "$this$outputStatus");
            if (!outputStatus.isCompleted()) {
                return OutputStatus.INSTANCE.m590getPENDINGU7r42EA();
            }
            if (outputStatus.isCancelled()) {
                return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
            }
            Object result = outputStatus.getCompleted().getResult();
            if (OutputResult.m1041getAvailableimpl(result)) {
                return OutputStatus.INSTANCE.m585getAVAILABLEU7r42EA();
            }
            if (result == null) {
                return OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA();
            }
            return ((OutputStatus) result).m584unboximpl();
        }

        public final <T> T outputOrNull(Deferred<? extends OutputResult<? extends T>> deferred) {
            Intrinsics.checkNotNullParameter(deferred, "<this>");
            if (deferred.isCompleted() && !deferred.isCancelled()) {
                T t = (T) deferred.getCompleted().getResult();
                if (OutputResult.m1041getAvailableimpl(t)) {
                    return t;
                }
            }
            return null;
        }

        public final <T> boolean completeWithOutput(CompletableDeferred<OutputResult<T>> completableDeferred, T t) {
            Intrinsics.checkNotNullParameter(completableDeferred, "<this>");
            return completableDeferred.complete(OutputResult.m1037boximpl(OutputResult.m1038constructorimpl(t)));
        }

        /* JADX INFO: renamed from: completeWithFailure-zfbXvnA, reason: not valid java name */
        public final <T> boolean m1048completeWithFailurezfbXvnA(CompletableDeferred<OutputResult<T>> completeWithFailure, int i) {
            Intrinsics.checkNotNullParameter(completeWithFailure, "$this$completeWithFailure");
            return completeWithFailure.complete(OutputResult.m1037boximpl(OutputResult.m1038constructorimpl(OutputStatus.m578boximpl(i))));
        }
    }
}
