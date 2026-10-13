package androidx.camera.viewfinder.core.impl.quirk;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SurfaceViewStretchedQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/camera/viewfinder/core/impl/quirk/SurfaceViewStretchedQuirk;", "Landroidx/camera/viewfinder/core/impl/quirk/Quirk;", "<init>", "()V", SurfaceViewStretchedQuirk.SAMSUNG, "", "GALAXY_Z_FOLD_2", "GALAXY_Z_FOLD_3", SurfaceViewStretchedQuirk.OPPO, "OPPO_FIND_N", SurfaceViewStretchedQuirk.LENOVO, "LENOVO_TAB_P12_PRO", "load", "", "isSamsungFold2OrFold3", "()Z", "isOppoFoldable", "isLenovoTablet", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SurfaceViewStretchedQuirk implements Quirk {
    private static final String GALAXY_Z_FOLD_2 = "F2Q";
    private static final String GALAXY_Z_FOLD_3 = "Q2Q";
    public static final SurfaceViewStretchedQuirk INSTANCE = new SurfaceViewStretchedQuirk();
    private static final String LENOVO = "LENOVO";
    private static final String LENOVO_TAB_P12_PRO = "Q706F";
    private static final String OPPO = "OPPO";
    private static final String OPPO_FIND_N = "OP4E75L1";
    private static final String SAMSUNG = "SAMSUNG";

    private SurfaceViewStretchedQuirk() {
    }

    @JvmStatic
    public static final boolean load() {
        if (Build.VERSION.SDK_INT >= 33) {
            return false;
        }
        SurfaceViewStretchedQuirk surfaceViewStretchedQuirk = INSTANCE;
        return surfaceViewStretchedQuirk.isSamsungFold2OrFold3() || surfaceViewStretchedQuirk.isOppoFoldable() || surfaceViewStretchedQuirk.isLenovoTablet();
    }

    private final boolean isSamsungFold2OrFold3() {
        if (StringsKt.equals(SAMSUNG, Build.MANUFACTURER, true)) {
            return StringsKt.equals(GALAXY_Z_FOLD_2, Build.DEVICE, true) || StringsKt.equals(GALAXY_Z_FOLD_3, Build.DEVICE, true);
        }
        return false;
    }

    private final boolean isOppoFoldable() {
        return StringsKt.equals(OPPO, Build.MANUFACTURER, true) && StringsKt.equals(OPPO_FIND_N, Build.DEVICE, true);
    }

    private final boolean isLenovoTablet() {
        return StringsKt.equals(LENOVO, Build.MANUFACTURER, true) && StringsKt.equals(LENOVO_TAB_P12_PRO, Build.DEVICE, true);
    }
}
