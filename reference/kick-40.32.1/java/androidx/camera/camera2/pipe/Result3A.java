package androidx.camera.camera2.pipe;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraControls.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/Result3A;", "", "status", "Landroidx/camera/camera2/pipe/Result3A$Status;", "frameMetadata", "Landroidx/camera/camera2/pipe/FrameMetadata;", "<init>", "(ILandroidx/camera/camera2/pipe/FrameMetadata;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStatus-JvTi9ms", "()I", "I", "getFrameMetadata", "()Landroidx/camera/camera2/pipe/FrameMetadata;", "component1", "component1-JvTi9ms", "component2", "copy", "copy-XT8YZL4", "(ILandroidx/camera/camera2/pipe/FrameMetadata;)Landroidx/camera/camera2/pipe/Result3A;", "equals", "", "other", "hashCode", "", "toString", "", "Status", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Result3A {
    private final FrameMetadata frameMetadata;
    private final int status;

    public /* synthetic */ Result3A(int i, FrameMetadata frameMetadata, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, frameMetadata);
    }

    /* JADX INFO: renamed from: copy-XT8YZL4$default, reason: not valid java name */
    public static /* synthetic */ Result3A m722copyXT8YZL4$default(Result3A result3A, int i, FrameMetadata frameMetadata, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = result3A.status;
        }
        if ((i2 & 2) != 0) {
            frameMetadata = result3A.frameMetadata;
        }
        return result3A.m724copyXT8YZL4(i, frameMetadata);
    }

    /* JADX INFO: renamed from: component1-JvTi9ms, reason: not valid java name and from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FrameMetadata getFrameMetadata() {
        return this.frameMetadata;
    }

    /* JADX INFO: renamed from: copy-XT8YZL4, reason: not valid java name */
    public final Result3A m724copyXT8YZL4(int status, FrameMetadata frameMetadata) {
        return new Result3A(status, frameMetadata, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Result3A)) {
            return false;
        }
        Result3A result3A = (Result3A) other;
        return Status.m729equalsimpl0(this.status, result3A.status) && Intrinsics.areEqual(this.frameMetadata, result3A.frameMetadata);
    }

    public int hashCode() {
        int iM730hashCodeimpl = Status.m730hashCodeimpl(this.status) * 31;
        FrameMetadata frameMetadata = this.frameMetadata;
        return iM730hashCodeimpl + (frameMetadata == null ? 0 : frameMetadata.hashCode());
    }

    public String toString() {
        return "Result3A(status=" + ((Object) Status.m731toStringimpl(this.status)) + ", frameMetadata=" + this.frameMetadata + ')';
    }

    private Result3A(int i, FrameMetadata frameMetadata) {
        this.status = i;
        this.frameMetadata = frameMetadata;
    }

    public /* synthetic */ Result3A(int i, FrameMetadata frameMetadata, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : frameMetadata, null);
    }

    public final FrameMetadata getFrameMetadata() {
        return this.frameMetadata;
    }

    /* JADX INFO: renamed from: getStatus-JvTi9ms, reason: not valid java name */
    public final int m725getStatusJvTi9ms() {
        return this.status;
    }

    /* JADX INFO: compiled from: CameraControls.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/Result3A$Status;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class Status {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int OK = m727constructorimpl(0);
        private static final int FRAME_LIMIT_REACHED = m727constructorimpl(1);
        private static final int TIME_LIMIT_REACHED = m727constructorimpl(2);
        private static final int SUBMIT_CANCELLED = m727constructorimpl(3);
        private static final int SUBMIT_FAILED = m727constructorimpl(4);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Status m726boximpl(int i) {
            return new Status(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m727constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m728equalsimpl(int i, Object obj) {
            return (obj instanceof Status) && i == ((Status) obj).m732unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m729equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m730hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m731toStringimpl(int i) {
            return "Status(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m728equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m730hashCodeimpl(this.value);
        }

        public String toString() {
            return m731toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m732unboximpl() {
            return this.value;
        }

        /* JADX INFO: compiled from: CameraControls.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/Result3A$Status$Companion;", "", "<init>", "()V", "OK", "Landroidx/camera/camera2/pipe/Result3A$Status;", "getOK-JvTi9ms", "()I", "I", "FRAME_LIMIT_REACHED", "getFRAME_LIMIT_REACHED-JvTi9ms", "TIME_LIMIT_REACHED", "getTIME_LIMIT_REACHED-JvTi9ms", "SUBMIT_CANCELLED", "getSUBMIT_CANCELLED-JvTi9ms", "SUBMIT_FAILED", "getSUBMIT_FAILED-JvTi9ms", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getOK-JvTi9ms, reason: not valid java name */
            public final int m734getOKJvTi9ms() {
                return Status.OK;
            }

            /* JADX INFO: renamed from: getFRAME_LIMIT_REACHED-JvTi9ms, reason: not valid java name */
            public final int m733getFRAME_LIMIT_REACHEDJvTi9ms() {
                return Status.FRAME_LIMIT_REACHED;
            }

            /* JADX INFO: renamed from: getTIME_LIMIT_REACHED-JvTi9ms, reason: not valid java name */
            public final int m737getTIME_LIMIT_REACHEDJvTi9ms() {
                return Status.TIME_LIMIT_REACHED;
            }

            /* JADX INFO: renamed from: getSUBMIT_CANCELLED-JvTi9ms, reason: not valid java name */
            public final int m735getSUBMIT_CANCELLEDJvTi9ms() {
                return Status.SUBMIT_CANCELLED;
            }

            /* JADX INFO: renamed from: getSUBMIT_FAILED-JvTi9ms, reason: not valid java name */
            public final int m736getSUBMIT_FAILEDJvTi9ms() {
                return Status.SUBMIT_FAILED;
            }
        }

        private /* synthetic */ Status(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
