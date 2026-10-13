package expo.modules.camera.records;

import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: CameraRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lexpo/modules/camera/records/VideoStabilizationMode;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OFF", "STANDARD", "CINEMATIC", "AUTO", "isEnabled", "", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum VideoStabilizationMode implements Enumerable {
    OFF(DebugKt.DEBUG_PROPERTY_VALUE_OFF),
    STANDARD(Constants.COLLATION_STANDARD),
    CINEMATIC("cinematic"),
    AUTO("auto");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<VideoStabilizationMode> getEntries() {
        return $ENTRIES;
    }

    VideoStabilizationMode(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isEnabled() {
        return this != OFF;
    }
}
