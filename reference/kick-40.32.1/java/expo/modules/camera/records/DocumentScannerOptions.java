package expo.modules.camera.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: DocumentScannerOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/camera/records/DocumentScannerOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "requestPdf", "", "getRequestPdf$annotations", "getRequestPdf", "()Z", "setRequestPdf", "(Z)V", "quality", "", "getQuality$annotations", "getQuality", "()D", "setQuality", "(D)V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScannerOptions implements Record {
    private double quality = 1.0d;
    private boolean requestPdf;

    @Field
    public static /* synthetic */ void getQuality$annotations() {
    }

    @Field
    public static /* synthetic */ void getRequestPdf$annotations() {
    }

    public final boolean getRequestPdf() {
        return this.requestPdf;
    }

    public final void setRequestPdf(boolean z) {
        this.requestPdf = z;
    }

    public final double getQuality() {
        return this.quality;
    }

    public final void setQuality(double d) {
        this.quality = d;
    }
}
