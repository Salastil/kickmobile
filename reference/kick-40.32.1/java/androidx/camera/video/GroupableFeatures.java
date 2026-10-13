package androidx.camera.video;

import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.feature.VideoStabilizationFeature;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import androidx.camera.video.featuregroup.RecordingQualityFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupableFeatures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/camera/video/GroupableFeatures;", "", "<init>", "()V", "SD_RECORDING", "Landroidx/camera/core/featuregroup/GroupableFeature;", "HD_RECORDING", "FHD_RECORDING", "UHD_RECORDING", "VIDEO_STABILIZATION", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupableFeatures {
    public static final GroupableFeature FHD_RECORDING;
    public static final GroupableFeature HD_RECORDING;
    public static final GroupableFeatures INSTANCE = new GroupableFeatures();
    public static final GroupableFeature SD_RECORDING;
    public static final GroupableFeature UHD_RECORDING;
    public static final GroupableFeature VIDEO_STABILIZATION;

    private GroupableFeatures() {
    }

    static {
        Quality SD = Quality.SD;
        Intrinsics.checkNotNullExpressionValue(SD, "SD");
        SD_RECORDING = new RecordingQualityFeature(SD);
        Quality HD = Quality.HD;
        Intrinsics.checkNotNullExpressionValue(HD, "HD");
        HD_RECORDING = new RecordingQualityFeature(HD);
        Quality FHD = Quality.FHD;
        Intrinsics.checkNotNullExpressionValue(FHD, "FHD");
        FHD_RECORDING = new RecordingQualityFeature(FHD);
        Quality UHD = Quality.UHD;
        Intrinsics.checkNotNullExpressionValue(UHD, "UHD");
        UHD_RECORDING = new RecordingQualityFeature(UHD);
        VIDEO_STABILIZATION = new VideoStabilizationFeature(VideoStabilization.ON);
    }
}
