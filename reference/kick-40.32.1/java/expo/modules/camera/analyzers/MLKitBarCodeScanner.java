package expo.modules.camera.analyzers;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import expo.modules.camera.utils.BarCodeScannerResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MLKitBarcodeAnalyzer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/camera/analyzers/MLKitBarCodeScanner;", "", "<init>", "()V", "barCodeTypes", "", "", "barcodeScannerOptions", "Lcom/google/mlkit/vision/barcode/BarcodeScannerOptions;", "barcodeScanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "scan", "Lexpo/modules/camera/utils/BarCodeScannerResult;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSettings", "", "formats", "areNewAndOldBarCodeTypesEqual", "", "newBarCodeTypes", "Companion", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MLKitBarCodeScanner {
    private static final String TAG = "MLKitBarCodeScanner";
    private List<Integer> barCodeTypes;
    private BarcodeScanner barcodeScanner;
    private BarcodeScannerOptions barcodeScannerOptions;

    public MLKitBarCodeScanner() {
        BarcodeScannerOptions barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(0, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
        this.barcodeScannerOptions = barcodeScannerOptionsBuild;
        BarcodeScanner client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.barcodeScanner = client;
    }

    /* JADX INFO: renamed from: expo.modules.camera.analyzers.MLKitBarCodeScanner$scan$2, reason: invalid class name */
    /* JADX INFO: compiled from: MLKitBarcodeAnalyzer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/camera/utils/BarCodeScannerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.analyzers.MLKitBarCodeScanner$scan$2", f = "MLKitBarcodeAnalyzer.kt", i = {0}, l = {28}, m = "invokeSuspend", n = {"inputImage"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BarCodeScannerResult>>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        Object L$0;
        int label;
        final /* synthetic */ MLKitBarCodeScanner this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Bitmap bitmap, MLKitBarCodeScanner mLKitBarCodeScanner, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.this$0 = mLKitBarCodeScanner;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$bitmap, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends BarCodeScannerResult>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<BarCodeScannerResult>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<BarCodeScannerResult>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InputImage inputImage;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InputImage inputImageFromBitmap = InputImage.fromBitmap(this.$bitmap, 0);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
                    Task<List<Barcode>> taskProcess = this.this$0.barcodeScanner.process(inputImageFromBitmap);
                    Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
                    this.L$0 = inputImageFromBitmap;
                    this.label = 1;
                    Object objAwait = MLKitBarcodeAnalyzerKt.await(taskProcess, this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objAwait;
                    inputImage = inputImageFromBitmap;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    inputImage = (InputImage) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Intrinsics.checkNotNullExpressionValue(obj, "await(...)");
                List list = (List) obj;
                ArrayList arrayList = new ArrayList();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(BarCodeScannerResultSerializer.INSTANCE.parseBarcodeScanningResult((Barcode) it.next(), inputImage));
                    }
                }
                return arrayList;
            } catch (Exception e) {
                Log.e(MLKitBarCodeScanner.TAG, "Failed to detect barcode: " + e.getMessage());
                return CollectionsKt.emptyList();
            }
        }
    }

    public final Object scan(Bitmap bitmap, Continuation<? super List<BarCodeScannerResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(bitmap, this, null), continuation);
    }

    public final void setSettings(List<Integer> formats) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        if (areNewAndOldBarCodeTypesEqual(formats)) {
            return;
        }
        Iterator<T> it = formats.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = Integer.valueOf(((Number) next).intValue() | ((Number) it.next()).intValue());
        }
        int iIntValue = ((Number) next).intValue();
        this.barCodeTypes = formats;
        BarcodeScannerOptions barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(iIntValue, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
        this.barcodeScannerOptions = barcodeScannerOptionsBuild;
        BarcodeScanner client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.barcodeScanner = client;
    }

    private final boolean areNewAndOldBarCodeTypesEqual(List<Integer> newBarCodeTypes) {
        List<Integer> list = this.barCodeTypes;
        return Intrinsics.areEqual(list != null ? CollectionsKt.toSet(list) : null, CollectionsKt.toSet(newBarCodeTypes));
    }
}
