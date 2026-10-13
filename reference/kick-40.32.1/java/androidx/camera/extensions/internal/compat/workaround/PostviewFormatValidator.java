package androidx.camera.extensions.internal.compat.workaround;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Quirk;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;
import androidx.camera.extensions.internal.compat.quirk.EnsurePostviewFormatEquivalenceQuirk;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PostviewFormatValidator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/camera/extensions/internal/compat/workaround/PostviewFormatValidator;", "", "<init>", "()V", "quirk", "Landroidx/camera/core/impl/Quirk;", "getPostviewFormatSelector", "Landroidx/camera/core/impl/CameraConfig$PostviewFormatSelector;", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostviewFormatValidator {
    private final Quirk quirk = DeviceQuirks.get(EnsurePostviewFormatEquivalenceQuirk.class);

    public final CameraConfig.PostviewFormatSelector getPostviewFormatSelector() {
        if (this.quirk != null) {
            return new CameraConfig.PostviewFormatSelector() { // from class: androidx.camera.extensions.internal.compat.workaround.PostviewFormatValidator$$ExternalSyntheticLambda0
                @Override // androidx.camera.core.impl.CameraConfig.PostviewFormatSelector
                public final int select(int i, List list) {
                    return PostviewFormatValidator.getPostviewFormatSelector$lambda$0$0(i, list);
                }
            };
        }
        CameraConfig.PostviewFormatSelector DEFAULT_POSTVIEW_FORMAT_SELECTOR = CameraConfig.DEFAULT_POSTVIEW_FORMAT_SELECTOR;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_POSTVIEW_FORMAT_SELECTOR, "DEFAULT_POSTVIEW_FORMAT_SELECTOR");
        return DEFAULT_POSTVIEW_FORMAT_SELECTOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getPostviewFormatSelector$lambda$0$0(int i, List supportedPostviewFormats) {
        Intrinsics.checkNotNullParameter(supportedPostviewFormats, "supportedPostviewFormats");
        if (supportedPostviewFormats.contains(Integer.valueOf(i))) {
            return i;
        }
        return 0;
    }
}
