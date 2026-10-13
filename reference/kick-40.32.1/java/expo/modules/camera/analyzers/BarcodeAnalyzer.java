package expo.modules.camera.analyzers;

import android.graphics.Point;
import android.media.Image;
import android.util.Log;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import expo.modules.camera.records.BarcodeType;
import expo.modules.camera.utils.BarCodeScannerResult;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BarcodeAnalyzer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nB+\b\u0016\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lexpo/modules/camera/analyzers/BarcodeAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "Ljava/io/Closeable;", "barcodeScanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "onComplete", "Lkotlin/Function1;", "Lexpo/modules/camera/utils/BarCodeScannerResult;", "", "<init>", "(Lcom/google/mlkit/vision/barcode/BarcodeScanner;Lkotlin/jvm/functions/Function1;)V", "formats", "", "Lexpo/modules/camera/records/BarcodeType;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getOnComplete", "()Lkotlin/jvm/functions/Function1;", "analyze", "imageProxy", "Landroidx/camera/core/ImageProxy;", "close", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BarcodeAnalyzer implements ImageAnalysis.Analyzer, Closeable {
    private final BarcodeScanner barcodeScanner;
    private final Function1<BarCodeScannerResult, Unit> onComplete;

    /* JADX WARN: Multi-variable type inference failed */
    public BarcodeAnalyzer(BarcodeScanner barcodeScanner, Function1<? super BarCodeScannerResult, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(barcodeScanner, "barcodeScanner");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.barcodeScanner = barcodeScanner;
        this.onComplete = onComplete;
    }

    public final Function1<BarCodeScannerResult, Unit> getOnComplete() {
        return this.onComplete;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BarcodeAnalyzer(List<? extends BarcodeType> formats, Function1<? super BarCodeScannerResult, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        BarcodeScanner client = BarcodeScanning.getClient(new BarcodeScannerOptions.Builder().setBarcodeFormats(BarcodeAnalyzerKt.barcodeFormats(formats), new int[0]).build());
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this(client, onComplete);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(final ImageProxy imageProxy) {
        final int width;
        final int height;
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image != null) {
            int rotationDegrees = imageProxy.getImageInfo().getRotationDegrees();
            InputImage inputImageFromMediaImage = InputImage.fromMediaImage(image, rotationDegrees);
            Intrinsics.checkNotNullExpressionValue(inputImageFromMediaImage, "fromMediaImage(...)");
            boolean z = rotationDegrees == 90 || rotationDegrees == 270;
            if (z) {
                width = imageProxy.getHeight();
            } else {
                width = imageProxy.getWidth();
            }
            if (z) {
                height = imageProxy.getWidth();
            } else {
                height = imageProxy.getHeight();
            }
            Task<List<Barcode>> taskProcess = this.barcodeScanner.process(inputImageFromMediaImage);
            final Function1 function1 = new Function1() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BarcodeAnalyzer.analyze$lambda$4(this.f$0, height, width, (List) obj);
                }
            };
            Intrinsics.checkNotNull(taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    BarcodeAnalyzer.analyze$lambda$6(exc);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.camera.analyzers.BarcodeAnalyzer$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    BarcodeAnalyzer.analyze$lambda$7(imageProxy, task);
                }
            }));
            return;
        }
        imageProxy.close();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    static final Unit analyze$lambda$4(BarcodeAnalyzer barcodeAnalyzer, int i, int i2, List list) {
        String str;
        ArrayList arrayList;
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(list);
        Barcode barcode = (Barcode) CollectionsKt.first(list);
        String rawValue = barcode.getRawValue();
        if (rawValue != null) {
            str = rawValue;
        } else {
            byte[] rawBytes = barcode.getRawBytes();
            if (rawBytes != null) {
                str = new String(rawBytes, Charsets.UTF_8);
            } else {
                rawValue = null;
                str = rawValue;
            }
        }
        Point[] cornerPoints = barcode.getCornerPoints();
        if (cornerPoints != null) {
            int[] iArr = new int[cornerPoints.length * 2];
            int length = cornerPoints.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                Point point = cornerPoints[i3];
                int i5 = i4 + 1;
                int i6 = i4 * 2;
                iArr[i6] = point.x;
                iArr[i6 + 1] = point.y;
                i3++;
                i4 = i5;
            }
            arrayList = ArraysKt.toMutableList(iArr);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
        } else {
            arrayList = new ArrayList();
        }
        List list2 = arrayList;
        BarCodeScannerResultSerializer barCodeScannerResultSerializer = BarCodeScannerResultSerializer.INSTANCE;
        Intrinsics.checkNotNull(barcode);
        barcodeAnalyzer.onComplete.invoke(new BarCodeScannerResult(barcode.getFormat(), barcode.getDisplayValue(), str, barCodeScannerResultSerializer.parseExtraDate(barcode), list2, i, i2));
        return Unit.INSTANCE;
    }

    static final void analyze$lambda$6(Exception it) {
        String message;
        Intrinsics.checkNotNullParameter(it, "it");
        Throwable cause = it.getCause();
        if (cause == null || (message = cause.getMessage()) == null) {
            message = "Barcode scanning failed";
        }
        Log.d("SCANNER", message);
    }

    static final void analyze$lambda$7(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.barcodeScanner.close();
    }
}
