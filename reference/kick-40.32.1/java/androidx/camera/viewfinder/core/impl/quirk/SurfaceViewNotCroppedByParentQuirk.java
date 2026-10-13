package androidx.camera.viewfinder.core.impl.quirk;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SurfaceViewNotCroppedByParentQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/camera/viewfinder/core/impl/quirk/SurfaceViewNotCroppedByParentQuirk;", "Landroidx/camera/viewfinder/core/impl/quirk/Quirk;", "<init>", "()V", SurfaceViewNotCroppedByParentQuirk.XIAOMI, "", "RED_MI_NOTE_10_MODEL", "load", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SurfaceViewNotCroppedByParentQuirk implements Quirk {
    public static final SurfaceViewNotCroppedByParentQuirk INSTANCE = new SurfaceViewNotCroppedByParentQuirk();
    private static final String RED_MI_NOTE_10_MODEL = "M2101K7AG";
    private static final String XIAOMI = "XIAOMI";

    private SurfaceViewNotCroppedByParentQuirk() {
    }

    @JvmStatic
    public static final boolean load() {
        return StringsKt.equals(XIAOMI, Build.MANUFACTURER, true) && StringsKt.equals(RED_MI_NOTE_10_MODEL, Build.MODEL, true);
    }
}
