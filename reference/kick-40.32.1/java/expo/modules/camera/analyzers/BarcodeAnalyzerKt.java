package expo.modules.camera.analyzers;

import androidx.camera.core.ImageProxy;
import expo.modules.camera.records.BarcodeType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BarcodeAnalyzer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¨\u0006\n"}, d2 = {"toByteArray", "", "", "Landroidx/camera/core/ImageProxy$PlaneProxy;", "([Landroidx/camera/core/ImageProxy$PlaneProxy;)[B", "barcodeFormats", "", "formats", "", "Lexpo/modules/camera/records/BarcodeType;", "expo-camera_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BarcodeAnalyzerKt {
    public static final byte[] toByteArray(ImageProxy.PlaneProxy[] planeProxyArr) {
        Intrinsics.checkNotNullParameter(planeProxyArr, "<this>");
        int iRemaining = 0;
        for (ImageProxy.PlaneProxy planeProxy : planeProxyArr) {
            iRemaining += planeProxy.getBuffer().remaining();
        }
        byte[] bArr = new byte[iRemaining];
        int i = 0;
        for (ImageProxy.PlaneProxy planeProxy2 : planeProxyArr) {
            ByteBuffer buffer = planeProxy2.getBuffer();
            Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
            int iRemaining2 = buffer.remaining();
            buffer.get(bArr, i, iRemaining2);
            i += iRemaining2;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int barcodeFormats(List<? extends BarcodeType> list) {
        if (list.isEmpty()) {
            return 0;
        }
        List<? extends BarcodeType> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((BarcodeType) it.next()).mapToBarcode()));
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = Integer.valueOf(((Number) next).intValue() | ((Number) it2.next()).intValue());
        }
        return ((Number) next).intValue();
    }
}
