package androidx.camera.video.internal.utils;

import android.media.MediaFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MediaFormatExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000b*\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/video/internal/utils/MediaFormatExt;", "", "<init>", "()V", "KEY_CSD_0", "", "KEY_CSD_1", "KEY_CSD_2", "KEY_TIMELAPSE_ENABLED", "KEY_TIMELAPSE_FPS", "isVideo", "", "Landroid/media/MediaFormat;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaFormatExt {
    public static final MediaFormatExt INSTANCE = new MediaFormatExt();
    public static final String KEY_CSD_0 = "csd-0";
    public static final String KEY_CSD_1 = "csd-1";
    public static final String KEY_CSD_2 = "csd-2";
    public static final String KEY_TIMELAPSE_ENABLED = "time-lapse-enable";
    public static final String KEY_TIMELAPSE_FPS = "time-lapse-fps";

    private MediaFormatExt() {
    }

    public final boolean isVideo(MediaFormat mediaFormat) {
        Intrinsics.checkNotNullParameter(mediaFormat, "<this>");
        String string = mediaFormat.getString("mime");
        if (string != null) {
            return StringsKt.startsWith$default(string, "video/", false, 2, (Object) null);
        }
        return false;
    }
}
