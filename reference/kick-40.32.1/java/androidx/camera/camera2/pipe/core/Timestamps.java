package androidx.camera.camera2.pipe.core;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Timestamps.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b*\u00020\fH\u0086\b¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u000b*\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\n\u001a\u00020\u000b*\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0014\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0015\u0010\u000eJ\u001e\u0010\u0016\u001a\u00020\f*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/core/Timestamps;", "", "<init>", "()V", "now", "Landroidx/camera/camera2/pipe/core/TimestampNs;", "timeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "now-GvorZiw", "(Landroidx/camera/camera2/pipe/core/TimeSource;)J", "formatNs", "", "Landroidx/camera/camera2/pipe/core/DurationNs;", "formatNs-zYRVrok", "(J)Ljava/lang/String;", "formatMs", "decimals", "", "formatMs-t8DbYm4", "(JI)Ljava/lang/String;", "formatNs-mxdxgDo", "formatMs-mxdxgDo", "measureNow", "measureNow-BzyuS-k", "(JLandroidx/camera/camera2/pipe/core/TimeSource;)J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Timestamps {
    public static final Timestamps INSTANCE = new Timestamps();

    private Timestamps() {
    }

    /* JADX INFO: renamed from: now-GvorZiw, reason: not valid java name */
    public final long m944nowGvorZiw(TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        return timeSource.mo927nowvQl9yQU();
    }

    /* JADX INFO: renamed from: formatNs-zYRVrok, reason: not valid java name */
    public final String m942formatNszYRVrok(long j) {
        return ((Object) DurationNs.m924toStringimpl(j)) + " ns";
    }

    /* JADX INFO: renamed from: formatMs-t8DbYm4$default, reason: not valid java name */
    public static /* synthetic */ String m937formatMst8DbYm4$default(Timestamps timestamps, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3;
        }
        String str = String.format(null, "%." + i + "f ms", Arrays.copyOf(new Object[]{Double.valueOf(j / 1000000.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: renamed from: formatMs-t8DbYm4, reason: not valid java name */
    public final String m940formatMst8DbYm4(long j, int i) {
        String str = String.format(null, "%." + i + "f ms", Arrays.copyOf(new Object[]{Double.valueOf(j / 1000000.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: renamed from: formatNs-mxdxgDo, reason: not valid java name */
    public final String m941formatNsmxdxgDo(long j) {
        return ((Object) TimestampNs.m935toStringimpl(j)) + " ns";
    }

    /* JADX INFO: renamed from: formatMs-mxdxgDo, reason: not valid java name */
    public final String m939formatMsmxdxgDo(long j) {
        return (j / 1000000) + " ms";
    }

    /* JADX INFO: renamed from: measureNow-BzyuS-k$default, reason: not valid java name */
    public static /* synthetic */ long m938measureNowBzyuSk$default(Timestamps timestamps, long j, TimeSource timeSource, int i, Object obj) {
        if ((i & 1) != 0) {
            timeSource = new SystemTimeSource();
        }
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        return DurationNs.m917constructorimpl(timeSource.mo927nowvQl9yQU() - j);
    }

    /* JADX INFO: renamed from: measureNow-BzyuS-k, reason: not valid java name */
    public final long m943measureNowBzyuSk(long j, TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        return DurationNs.m917constructorimpl(timeSource.mo927nowvQl9yQU() - j);
    }
}
