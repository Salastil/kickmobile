package androidx.camera.viewfinder.core.impl.quirk;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: DeviceQuirksLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/camera/viewfinder/core/impl/quirk/DeviceQuirksLoader;", "", "<init>", "()V", "loadQuirks", "", "Landroidx/camera/viewfinder/core/impl/quirk/Quirk;", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceQuirksLoader {
    public static final DeviceQuirksLoader INSTANCE = new DeviceQuirksLoader();

    private DeviceQuirksLoader() {
    }

    @JvmStatic
    public static final List<Quirk> loadQuirks() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (SurfaceViewStretchedQuirk.load()) {
            listCreateListBuilder.add(SurfaceViewStretchedQuirk.INSTANCE);
        }
        if (SurfaceViewNotCroppedByParentQuirk.load()) {
            listCreateListBuilder.add(SurfaceViewNotCroppedByParentQuirk.INSTANCE);
        }
        return CollectionsKt.build(listCreateListBuilder);
    }
}
