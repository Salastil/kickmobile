package expo.modules.camera.records;

import androidx.camera.video.Quality;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lexpo/modules/camera/records/VideoQuality;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VIDEO2160P", "VIDEO1080P", "VIDEO720P", "VIDEO480P", "VIDEO4X3", "mapToQuality", "Landroidx/camera/video/Quality;", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum VideoQuality implements Enumerable {
    VIDEO2160P("2160p"),
    VIDEO1080P("1080p"),
    VIDEO720P("720p"),
    VIDEO480P("480p"),
    VIDEO4X3("4:3");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: CameraRecords.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoQuality.values().length];
            try {
                iArr[VideoQuality.VIDEO2160P.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoQuality.VIDEO1080P.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoQuality.VIDEO720P.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoQuality.VIDEO480P.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VideoQuality.VIDEO4X3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<VideoQuality> getEntries() {
        return $ENTRIES;
    }

    VideoQuality(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final Quality mapToQuality() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            Quality UHD = Quality.UHD;
            Intrinsics.checkNotNullExpressionValue(UHD, "UHD");
            return UHD;
        }
        if (i == 2) {
            Quality FHD = Quality.FHD;
            Intrinsics.checkNotNullExpressionValue(FHD, "FHD");
            return FHD;
        }
        if (i == 3) {
            Quality HD = Quality.HD;
            Intrinsics.checkNotNullExpressionValue(HD, "HD");
            return HD;
        }
        if (i == 4) {
            Quality SD = Quality.SD;
            Intrinsics.checkNotNullExpressionValue(SD, "SD");
            return SD;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        Quality LOWEST = Quality.LOWEST;
        Intrinsics.checkNotNullExpressionValue(LOWEST, "LOWEST");
        return LOWEST;
    }
}
