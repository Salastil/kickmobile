package androidx.camera.core.impl.stabilization;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VideoStabilization.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Landroidx/camera/core/impl/stabilization/VideoStabilization;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "OFF", "ON", "PREVIEW", "Companion", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum VideoStabilization {
    UNSPECIFIED,
    OFF,
    ON,
    PREVIEW;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<VideoStabilization> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: VideoStabilization.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/camera/core/impl/stabilization/VideoStabilization$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "previewStabilizationMode", "", "videoStabilizationMode", "from$camera_core", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ VideoStabilization from$camera_core$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return companion.from$camera_core(i, i2);
        }

        @JvmStatic
        public final VideoStabilization from$camera_core(int previewStabilizationMode, int videoStabilizationMode) {
            if (previewStabilizationMode == 1 || videoStabilizationMode == 1) {
                return VideoStabilization.OFF;
            }
            if (previewStabilizationMode == 2) {
                return VideoStabilization.PREVIEW;
            }
            if (videoStabilizationMode == 2) {
                return VideoStabilization.ON;
            }
            return VideoStabilization.UNSPECIFIED;
        }
    }
}
