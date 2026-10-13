package androidx.camera.camera2.compat.quirk;

import androidx.camera.core.impl.Quirk;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Nexus4AndroidLTargetAspectRatioQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/compat/quirk/Nexus4AndroidLTargetAspectRatioQuirk;", "Landroidx/camera/core/impl/Quirk;", "<init>", "()V", "getCorrectedAspectRatio", "", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Nexus4AndroidLTargetAspectRatioQuirk implements Quirk {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> DEVICE_MODELS = CollectionsKt.listOf("NEXUS 4");

    public final int getCorrectedAspectRatio() {
        return 2;
    }

    /* JADX INFO: compiled from: Nexus4AndroidLTargetAspectRatioQuirk.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/Nexus4AndroidLTargetAspectRatioQuirk$Companion;", "", "<init>", "()V", "DEVICE_MODELS", "", "", "isEnabled", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isEnabled() {
            Device.INSTANCE.isGoogleDevice();
            return false;
        }
    }
}
