package androidx.camera.lifecycle;

import androidx.camera.core.impl.utils.ContextUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: LifecycleCameraRepositories.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\nJ\r\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/camera/lifecycle/LifecycleCameraRepositories;", "", "<init>", "()V", "repositoryMap", "", "", "Landroidx/camera/lifecycle/LifecycleCameraRepository;", "getInstance", "deviceId", "getInstance$camera_lifecycle", "clear", "", "clear$camera_lifecycle", "camera-lifecycle"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LifecycleCameraRepositories {
    public static final LifecycleCameraRepositories INSTANCE = new LifecycleCameraRepositories();
    private static final Map<Integer, LifecycleCameraRepository> repositoryMap = new LinkedHashMap();

    private LifecycleCameraRepositories() {
    }

    public static /* synthetic */ LifecycleCameraRepository getInstance$camera_lifecycle$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ContextUtil.getDefaultDeviceId();
        }
        return getInstance$camera_lifecycle(i);
    }

    @JvmStatic
    public static final LifecycleCameraRepository getInstance$camera_lifecycle(int deviceId) {
        LifecycleCameraRepository lifecycleCameraRepository;
        Map<Integer, LifecycleCameraRepository> map = repositoryMap;
        synchronized (map) {
            Integer numValueOf = Integer.valueOf(deviceId);
            LifecycleCameraRepository lifecycleCameraRepository2 = map.get(numValueOf);
            if (lifecycleCameraRepository2 == null) {
                lifecycleCameraRepository2 = new LifecycleCameraRepository(deviceId);
                map.put(numValueOf, lifecycleCameraRepository2);
            }
            lifecycleCameraRepository = lifecycleCameraRepository2;
        }
        return lifecycleCameraRepository;
    }

    public final void clear$camera_lifecycle() {
        Map<Integer, LifecycleCameraRepository> map = repositoryMap;
        synchronized (map) {
            map.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
