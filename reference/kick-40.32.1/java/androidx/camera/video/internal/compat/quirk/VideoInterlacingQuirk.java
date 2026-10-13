package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VideoInterlacingQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\nH\u0007R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/camera/video/internal/compat/quirk/VideoInterlacingQuirk;", "Landroidx/camera/core/internal/compat/quirk/SurfaceProcessingQuirk;", "<init>", "()V", "DEVICE_MODELS", "", "", "getDEVICE_MODELS", "()Ljava/util/List;", "isSamsungS6", "", "()Z", "load", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoInterlacingQuirk implements SurfaceProcessingQuirk {
    public static final VideoInterlacingQuirk INSTANCE = new VideoInterlacingQuirk();

    private VideoInterlacingQuirk() {
    }

    private final List<String> getDEVICE_MODELS() {
        return CollectionsKt.listOf("SM-N9208");
    }

    private final boolean isSamsungS6() {
        if (!StringsKt.equals(Build.BRAND, "Samsung", true)) {
            return false;
        }
        String PRODUCT = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
        return StringsKt.startsWith(PRODUCT, "zeroflte", true);
    }

    @JvmStatic
    public static final boolean load() {
        VideoInterlacingQuirk videoInterlacingQuirk = INSTANCE;
        List<String> device_models = videoInterlacingQuirk.getDEVICE_MODELS();
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = MODEL.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return device_models.contains(upperCase) || videoInterlacingQuirk.isSamsungS6();
    }
}
