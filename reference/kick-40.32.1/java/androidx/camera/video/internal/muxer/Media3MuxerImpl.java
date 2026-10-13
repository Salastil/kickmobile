package androidx.camera.video.internal.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.internal.utils.MediaFormatExt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.MediaMuxerCompat;
import com.facebook.react.uimanager.ViewProps;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Media3MuxerImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J \u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020$H\u0016J\f\u0010%\u001a\u00020\t*\u00020\tH\u0002J!\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)H\u0002¢\u0006\u0002\u0010*R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/camera/video/internal/muxer/Media3MuxerImpl;", "Landroidx/camera/video/internal/muxer/Muxer;", "<init>", "()V", "mediaMuxerCompat", "Landroidx/media3/muxer/MediaMuxerCompat;", "state", "Landroidx/camera/video/internal/muxer/Media3MuxerImpl$State;", "captureFps", "", "setOutput", "", "path", "", "format", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "setOrientationDegrees", "degrees", "setLocation", "latitude", "", "longitude", "setCaptureFps", "addTrack", "Landroid/media/MediaFormat;", ViewProps.START, "stop", "writeSampleData", "trackIndex", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "isInterruptionResilient", "", "toMediaMuxerCompatFormat", "wrapMuxerException", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "State", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Media3MuxerImpl implements Muxer {
    private int captureFps;
    private MediaMuxerCompat mediaMuxerCompat;
    private State state = State.IDLE;

    /* JADX INFO: compiled from: Media3MuxerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/camera/video/internal/muxer/Media3MuxerImpl$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONFIGURED", "STARTED", "STOPPED", "RELEASED", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private enum State {
        IDLE,
        CONFIGURED,
        STARTED,
        STOPPED,
        RELEASED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public boolean isInterruptionResilient() {
        return true;
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void setOutput(String path, int format) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.state != State.IDLE) {
            throw new IllegalStateException(("Muxer is not idle. Current state: " + this.state).toString());
        }
        this.mediaMuxerCompat = new MediaMuxerCompat(path, toMediaMuxerCompatFormat(format));
        this.state = State.CONFIGURED;
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void setOutput(ParcelFileDescriptor parcelFileDescriptor, int format) throws IOException {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "parcelFileDescriptor");
        if (this.state != State.IDLE) {
            throw new IllegalStateException(("Muxer is not idle. Current state: " + this.state).toString());
        }
        this.mediaMuxerCompat = new MediaMuxerCompat(parcelFileDescriptor.getFileDescriptor(), toMediaMuxerCompatFormat(format));
        parcelFileDescriptor.close();
        this.state = State.CONFIGURED;
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void setOrientationDegrees(int degrees) {
        if (this.state != State.CONFIGURED) {
            throw new IllegalStateException(("Muxer is not configured. Current state: " + this.state).toString());
        }
        MediaMuxerCompat mediaMuxerCompat = this.mediaMuxerCompat;
        Intrinsics.checkNotNull(mediaMuxerCompat);
        mediaMuxerCompat.setOrientationHint(degrees);
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void setLocation(double latitude, double longitude) {
        if (this.state != State.CONFIGURED) {
            throw new IllegalStateException(("Muxer is not configured. Current state: " + this.state).toString());
        }
        MediaMuxerCompat mediaMuxerCompat = this.mediaMuxerCompat;
        Intrinsics.checkNotNull(mediaMuxerCompat);
        mediaMuxerCompat.setLocation((float) latitude, (float) longitude);
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void setCaptureFps(int captureFps) {
        if (this.state != State.CONFIGURED) {
            throw new IllegalStateException(("Muxer is not configured. Current state: " + this.state).toString());
        }
        if (captureFps <= 0) {
            throw new IllegalArgumentException("captureFps must be positive".toString());
        }
        this.captureFps = captureFps;
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public int addTrack(final MediaFormat format) {
        int i;
        Intrinsics.checkNotNullParameter(format, "format");
        if (this.state != State.CONFIGURED) {
            throw new IllegalStateException(("Muxer is not configured. Current state: " + this.state).toString());
        }
        if (MediaFormatExt.INSTANCE.isVideo(format) && (i = this.captureFps) > 0) {
            format.setInteger("capture-rate", i);
        }
        return ((Number) wrapMuxerException(new Function0() { // from class: androidx.camera.video.internal.muxer.Media3MuxerImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(Media3MuxerImpl.addTrack$lambda$1(this.f$0, format));
            }
        })).intValue();
    }

    static final int addTrack$lambda$1(Media3MuxerImpl media3MuxerImpl, MediaFormat mediaFormat) {
        MediaMuxerCompat mediaMuxerCompat = media3MuxerImpl.mediaMuxerCompat;
        Intrinsics.checkNotNull(mediaMuxerCompat);
        return mediaMuxerCompat.addTrack(mediaFormat);
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void start() throws MuxerException {
        if (this.state == State.STARTED) {
            return;
        }
        if (this.state != State.CONFIGURED) {
            throw new IllegalStateException(("Muxer is not configured. Current state: " + this.state).toString());
        }
        wrapMuxerException(new Function0() { // from class: androidx.camera.video.internal.muxer.Media3MuxerImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Media3MuxerImpl.start$lambda$1(this.f$0);
            }
        });
        this.state = State.STARTED;
    }

    static final Unit start$lambda$1(Media3MuxerImpl media3MuxerImpl) {
        MediaMuxerCompat mediaMuxerCompat = media3MuxerImpl.mediaMuxerCompat;
        Intrinsics.checkNotNull(mediaMuxerCompat);
        mediaMuxerCompat.start();
        return Unit.INSTANCE;
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void stop() {
        if (this.state == State.STOPPED) {
            return;
        }
        if (this.state != State.STARTED) {
            throw new IllegalStateException(("Muxer is not started. Current state: " + this.state).toString());
        }
        try {
            wrapMuxerException(new Function0() { // from class: androidx.camera.video.internal.muxer.Media3MuxerImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Media3MuxerImpl.stop$lambda$1(this.f$0);
                }
            });
        } finally {
            this.state = State.STOPPED;
        }
    }

    static final Unit stop$lambda$1(Media3MuxerImpl media3MuxerImpl) {
        MediaMuxerCompat mediaMuxerCompat = media3MuxerImpl.mediaMuxerCompat;
        Intrinsics.checkNotNull(mediaMuxerCompat);
        mediaMuxerCompat.stop();
        return Unit.INSTANCE;
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void writeSampleData(final int trackIndex, final ByteBuffer byteBuffer, final MediaCodec.BufferInfo bufferInfo) throws MuxerException {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        Intrinsics.checkNotNullParameter(bufferInfo, "bufferInfo");
        if (this.state != State.STARTED) {
            throw new IllegalStateException(("Muxer is not started. Current state: " + this.state).toString());
        }
        wrapMuxerException(new Function0() { // from class: androidx.camera.video.internal.muxer.Media3MuxerImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Media3MuxerImpl.writeSampleData$lambda$1(this.f$0, trackIndex, byteBuffer, bufferInfo);
            }
        });
    }

    static final Unit writeSampleData$lambda$1(Media3MuxerImpl media3MuxerImpl, int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        MediaMuxerCompat mediaMuxerCompat = media3MuxerImpl.mediaMuxerCompat;
        Intrinsics.checkNotNull(mediaMuxerCompat);
        mediaMuxerCompat.writeSampleData(i, byteBuffer, bufferInfo);
        return Unit.INSTANCE;
    }

    @Override // androidx.camera.video.internal.muxer.Muxer
    public void release() {
        Unit unit;
        if (this.state == State.RELEASED) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Media3MuxerImpl media3MuxerImpl = this;
            MediaMuxerCompat mediaMuxerCompat = this.mediaMuxerCompat;
            if (mediaMuxerCompat != null) {
                mediaMuxerCompat.release();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m12684constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        this.mediaMuxerCompat = null;
        this.state = State.RELEASED;
    }

    private final int toMediaMuxerCompatFormat(int i) {
        if (i == 0 || i == 2) {
            return 0;
        }
        throw new IllegalArgumentException("Unsupported format: " + i);
    }

    private final <T> T wrapMuxerException(Function0<? extends T> block) throws MuxerException {
        try {
            return block.invoke();
        } catch (Exception e) {
            throw new MuxerException("MediaMuxer operation failed", e);
        }
    }
}
