package androidx.camera.camera2.pipe.compat;

import android.view.Surface;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surfaces", "", "getSurfaces", "()Ljava/util/List;", "addSurface", "", "removeSurface", "physicalCameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getPhysicalCameraId-1LO98Z0", "()Ljava/lang/String;", "surfaceSharing", "", "getSurfaceSharing", "()Z", "maxSharedSurfaceCount", "", "getMaxSharedSurfaceCount", "()I", "surfaceGroupId", "getSurfaceGroupId", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OutputConfigurationWrapper extends UnsafeWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int SURFACE_GROUP_ID_NONE = -1;

    void addSurface(Surface surface);

    int getMaxSharedSurfaceCount();

    /* JADX INFO: renamed from: getPhysicalCameraId-1LO98Z0 */
    String mo814getPhysicalCameraId1LO98Z0();

    Surface getSurface();

    int getSurfaceGroupId();

    boolean getSurfaceSharing();

    List<Surface> getSurfaces();

    void removeSurface(Surface surface);

    /* JADX INFO: compiled from: Configuration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper$Companion;", "", "<init>", "()V", "SURFACE_GROUP_ID_NONE", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int SURFACE_GROUP_ID_NONE = -1;

        private Companion() {
        }
    }
}
