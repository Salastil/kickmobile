package expo.modules.camera.documentscanner;

import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: DocumentScannerContract.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/camera/documentscanner/DocumentScannerActivityResult;", "", "cancelled", "", "result", "Lcom/google/mlkit/vision/documentscanner/GmsDocumentScanningResult;", "<init>", "(ZLcom/google/mlkit/vision/documentscanner/GmsDocumentScanningResult;)V", "getCancelled", "()Z", "getResult", "()Lcom/google/mlkit/vision/documentscanner/GmsDocumentScanningResult;", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScannerActivityResult {
    private final boolean cancelled;
    private final GmsDocumentScanningResult result;

    public DocumentScannerActivityResult(boolean z, GmsDocumentScanningResult gmsDocumentScanningResult) {
        this.cancelled = z;
        this.result = gmsDocumentScanningResult;
    }

    public final boolean getCancelled() {
        return this.cancelled;
    }

    public final GmsDocumentScanningResult getResult() {
        return this.result;
    }
}
