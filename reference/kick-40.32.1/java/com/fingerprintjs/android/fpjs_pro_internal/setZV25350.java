package com.fingerprintjs.android.fpjs_pro_internal;

import android.util.Base64;
import androidx.appcompat.app.AppCompatDelegate;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setZV25350;", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196;", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;", "p1", "<init>", "(Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro_internal/wX26196$setPivotYN16904;)V", "component9"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class setZV25350 extends wX26196 {
    private static int component5 = 1;

    /* JADX INFO: renamed from: component9, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int vD14832N6715;

    private setZV25350(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.openContextMenu.INSTANCE.component5(), str, setpivotyn16904);
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.setZV25350$component9, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/setZV25350$component9;", "", "<init>", "()V", "Lcom/fingerprintjs/android/fpjs_pro_internal/bj;", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/rV4669;", "p1", "Lcom/fingerprintjs/android/fpjs_pro_internal/setZV25350;", "component5", "(Lcom/fingerprintjs/android/fpjs_pro_internal/bj;Lcom/fingerprintjs/android/fpjs_pro_internal/rV4669;)Lcom/fingerprintjs/android/fpjs_pro_internal/setZV25350;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private static int component5 = 0;
        private static int setPivotYN16904 = 1;

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static setZV25350 component5(bj p0, rV4669 p1) {
            Object objM12684constructorimpl;
            int i = 2 % 2;
            int i2 = component5 + 47;
            setPivotYN16904 = i2 % 128;
            int i3 = i2 % 2;
            String str = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            if (!p1.cW27173()) {
                setZV25350 setzv25350 = new setZV25350(str, wX26196.setPivotYN16904.component5.INSTANCE, objArr4 == true ? 1 : 0);
                int i4 = component5 + 1;
                setPivotYN16904 = i4 % 128;
                int i5 = i4 % 2;
                return setzv25350;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Certificate[] certificateArr = p0.component9;
                Intrinsics.checkNotNull(certificateArr);
                ArrayList arrayList = new ArrayList(certificateArr.length);
                for (Certificate certificate : certificateArr) {
                    int i6 = setPivotYN16904 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    component5 = i6 % 128;
                    int i7 = i6 % 2;
                    Intrinsics.checkNotNull(certificate);
                    byte[] encoded = certificate.getEncoded();
                    Intrinsics.checkNotNull(encoded);
                    arrayList.add(encoded);
                }
                ArrayList<byte[]> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                int i8 = component5;
                int i9 = ((i8 | 35) << 1) - (i8 ^ 35);
                setPivotYN16904 = i9 % 128;
                int i10 = i9 % 2;
                for (byte[] bArr : arrayList2) {
                    int i11 = setPivotYN16904 + 23;
                    component5 = i11 % 128;
                    int i12 = i11 % 2;
                    arrayList3.add(CollectionsKt.listOf((Object[]) new byte[][]{ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(bArr.length).array(), bArr}));
                }
                List listFlatten = CollectionsKt.flatten(arrayList3);
                Iterator it = listFlatten.iterator();
                int i13 = setPivotYN16904;
                int i14 = ((i13 | 89) << 1) - (i13 ^ 89);
                component5 = i14 % 128;
                if (i14 % 2 != 0) {
                    int i15 = 3 / 5;
                }
                int i16 = 0;
                while (it.hasNext()) {
                    int length = ((byte[]) it.next()).length;
                    i16 = ((i16 & length) << 1) + (i16 ^ length);
                    int i17 = setPivotYN16904;
                    int i18 = (i17 ^ 35) + ((i17 & 35) << 1);
                    component5 = i18 % 128;
                    int i19 = i18 % 2;
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i16);
                Iterator it2 = listFlatten.iterator();
                while (it2.hasNext()) {
                    int i20 = setPivotYN16904 + 27;
                    component5 = i20 % 128;
                    if (i20 % 2 != 0) {
                        byteBufferAllocate.put((byte[]) it2.next());
                        int i21 = 3 / 0;
                    } else {
                        byteBufferAllocate.put((byte[]) it2.next());
                    }
                }
                String strEncodeToString = Base64.encodeToString(byteBufferAllocate.array(), 2);
                Intrinsics.checkNotNull(strEncodeToString);
                objM12684constructorimpl = Result.m12684constructorimpl(strEncodeToString);
                int i22 = setPivotYN16904 + 69;
                component5 = i22 % 128;
                int i23 = i22 % 2;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            D8871 pivotYN16904 = bb.setPivotYN16904(objM12684constructorimpl);
            if (pivotYN16904 instanceof vD14832N6715) {
                return new setZV25350((String) ((vD14832N6715) pivotYN16904).setPivotYN16904, wX26196.setPivotYN16904.component13.INSTANCE, objArr3 == true ? 1 : 0);
            }
            if (!(pivotYN16904 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            return new setZV25350(objArr2 == true ? 1 : 0, wX26196.setPivotYN16904.vD14832N6715.INSTANCE, objArr == true ? 1 : 0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i = component5;
        int i2 = (i & 119) + (i | 119);
        vD14832N6715 = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ setZV25350(String str, wX26196.setPivotYN16904 setpivotyn16904, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, setpivotyn16904);
    }
}
