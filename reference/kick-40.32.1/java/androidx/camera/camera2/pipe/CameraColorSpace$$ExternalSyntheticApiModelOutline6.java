package androidx.camera.camera2.pipe;

import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraExtensionSession$ExtensionCaptureCallback;
import android.hardware.camera2.CameraExtensionSession$StateCallback;
import android.hardware.camera2.params.ColorSpaceProfiles;
import android.hardware.camera2.params.ExtensionSessionConfiguration;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MultiResolutionStreamConfigurationMap;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.ImageReader;
import android.util.Size;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CameraColorSpace$$ExternalSyntheticApiModelOutline6 {
    public static /* bridge */ /* synthetic */ ColorSpace.Named m(Object obj) {
        return (ColorSpace.Named) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CameraExtensionCharacteristics m255m(Object obj) {
        return (CameraExtensionCharacteristics) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CameraExtensionSession$ExtensionCaptureCallback m256m(Object obj) {
        return (CameraExtensionSession$ExtensionCaptureCallback) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CameraExtensionSession$StateCallback m257m(Object obj) {
        return (CameraExtensionSession$StateCallback) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ColorSpaceProfiles m258m(Object obj) {
        return (ColorSpaceProfiles) obj;
    }

    public static /* synthetic */ ExtensionSessionConfiguration m(int i, List list, Executor executor, CameraExtensionSession$StateCallback cameraExtensionSession$StateCallback) {
        return new ExtensionSessionConfiguration(i, list, executor, cameraExtensionSession$StateCallback);
    }

    public static /* synthetic */ InputConfiguration m(Collection collection, int i) {
        return new InputConfiguration(collection, i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ MultiResolutionStreamConfigurationMap m259m(Object obj) {
        return (MultiResolutionStreamConfigurationMap) obj;
    }

    public static /* synthetic */ MultiResolutionStreamInfo m(int i, int i2, String str) {
        return new MultiResolutionStreamInfo(i, i2, str);
    }

    public static /* synthetic */ OutputConfiguration m(int i, Size size) {
        return new OutputConfiguration(i, size);
    }

    public static /* synthetic */ OutputConfiguration m(Size size, Class cls) {
        return new OutputConfiguration(size, cls);
    }

    public static /* synthetic */ SessionConfiguration m(int i, List list) {
        return new SessionConfiguration(i, list);
    }

    public static /* synthetic */ SessionConfiguration m(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        return new SessionConfiguration(i, list, executor, stateCallback);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SessionConfiguration m260m(Object obj) {
        return (SessionConfiguration) obj;
    }

    public static /* synthetic */ ImageReader.Builder m(int i, int i2) {
        return new ImageReader.Builder(i, i2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m261m() {
        return HardwareBuffer.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m265m() {
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m273m$1() {
        return CameraExtensionCharacteristics.class;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m274m$1() {
    }

    /* JADX INFO: renamed from: m$2, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m277m$2() {
        return ColorSpaceProfiles.class;
    }
}
