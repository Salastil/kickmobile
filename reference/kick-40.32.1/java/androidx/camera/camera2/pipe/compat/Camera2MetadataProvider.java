package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraExtensionMetadata;
import androidx.camera.camera2.pipe.CameraMetadata;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Camera2MetadataProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2MetadataProvider;", "", "getCameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraMetadata-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraMetadata", "awaitCameraMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "getCameraExtensionMetadata", "Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "extension", "", "getCameraExtensionMetadata-RzXb1QE", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraExtensionMetadata", "awaitCameraExtensionMetadata-0r8Bogc", "(Ljava/lang/String;I)Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "getSupportedCameraExtensions", "", "getSupportedCameraExtensions-EfqyGwQ", "(Ljava/lang/String;)Ljava/util/Set;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Camera2MetadataProvider {
    /* JADX INFO: renamed from: awaitCameraExtensionMetadata-0r8Bogc */
    CameraExtensionMetadata mo845awaitCameraExtensionMetadata0r8Bogc(String cameraId, int extension);

    /* JADX INFO: renamed from: awaitCameraMetadata-EfqyGwQ */
    CameraMetadata mo846awaitCameraMetadataEfqyGwQ(String cameraId);

    /* JADX INFO: renamed from: getCameraExtensionMetadata-RzXb1QE */
    Object mo847getCameraExtensionMetadataRzXb1QE(String str, int i, Continuation<? super CameraExtensionMetadata> continuation);

    /* JADX INFO: renamed from: getCameraMetadata-0r8Bogc */
    Object mo848getCameraMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation);

    /* JADX INFO: renamed from: getSupportedCameraExtensions-EfqyGwQ */
    Set<Integer> mo849getSupportedCameraExtensionsEfqyGwQ(String cameraId);
}
