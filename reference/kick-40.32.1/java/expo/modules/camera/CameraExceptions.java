package expo.modules.camera;

import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"Lexpo/modules/camera/CameraExceptions;", "", "<init>", "()V", "ImageCaptureFailed", "VideoRecordingFailed", "ImageRetrievalException", "BarcodeScanningCancelledException", "BarcodeScanningFailedException", "MLKitUnavailableException", "GooglePlayServicesUnavailableException", "WriteImageException", "DocumentScannerUnavailableException", "DocumentScanningFailedException", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CameraExceptions {

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/CameraExceptions$ImageCaptureFailed;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ImageCaptureFailed extends CodedException {
        public ImageCaptureFailed() {
            super("Failed to capture image", null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/camera/CameraExceptions$VideoRecordingFailed;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "", "<init>", "(Ljava/lang/String;)V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class VideoRecordingFailed extends CodedException {
        public VideoRecordingFailed(String str) {
            super("Video recording failed: " + str, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/camera/CameraExceptions$ImageRetrievalException;", "Lexpo/modules/kotlin/exception/CodedException;", ImagesContract.URL, "", "<init>", "(Ljava/lang/String;)V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ImageRetrievalException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageRetrievalException(String url) {
            super("Could not get the image from given url: '" + url + "'", null, 2, null);
            Intrinsics.checkNotNullParameter(url, "url");
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/CameraExceptions$BarcodeScanningCancelledException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BarcodeScanningCancelledException extends CodedException {
        public BarcodeScanningCancelledException() {
            super("Barcode scanning was cancelled", null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/CameraExceptions$BarcodeScanningFailedException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BarcodeScanningFailedException extends CodedException {
        public BarcodeScanningFailedException() {
            super("Barcode scanning failed", null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/CameraExceptions$MLKitUnavailableException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MLKitUnavailableException extends CodedException {
        public MLKitUnavailableException() {
            super("MLKit is not available on this device. Barcode scanning requires Google Play Services.", null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/CameraExceptions$GooglePlayServicesUnavailableException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GooglePlayServicesUnavailableException extends CodedException {
        public GooglePlayServicesUnavailableException() {
            super("Google Play Services is not available on this device. This feature requires Google Play Services.", null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/camera/CameraExceptions$WriteImageException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "", "<init>", "(Ljava/lang/String;)V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class WriteImageException extends CodedException {
        public WriteImageException(String str) {
            super("Writing image has failed: " + str, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/CameraExceptions$DocumentScannerUnavailableException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DocumentScannerUnavailableException extends CodedException {
        public DocumentScannerUnavailableException() {
            super("Document scanning is unavailable. It requires Google Play Services and the ML Kit document scanner module. Check `CameraView.isDocumentScannerAvailable` before calling `scanDocumentAsync`.", null, 2, null);
        }
    }

    /* JADX INFO: compiled from: CameraExceptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/camera/CameraExceptions$DocumentScanningFailedException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "", "<init>", "(Ljava/lang/String;)V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DocumentScanningFailedException extends CodedException {
        public DocumentScanningFailedException(String str) {
            super("Document scanning failed: " + str, null, 2, null);
        }
    }
}
