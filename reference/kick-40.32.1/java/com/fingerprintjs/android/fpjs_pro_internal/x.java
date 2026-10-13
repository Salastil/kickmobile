package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class x {
    private static int setPivotYN16904 = 0;
    private static int vD14832N6715 = 1;
    private final String D8871;
    private final PackageManager component5;

    public x(PackageManager packageManager, String str) {
        this.component5 = packageManager;
        this.D8871 = str;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004b A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:11:0x002e, B:13:0x004b, B:16:0x0076, B:19:0x0088, B:21:0x0095, B:24:0x00a7, B:26:0x00c0, B:27:0x00c5), top: B:48:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:18:0x007c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0095 A[Catch: all -> 0x00c6, LOOP:1: B:16:0x0076->B:21:0x0095, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:11:0x002e, B:13:0x004b, B:16:0x0076, B:19:0x0088, B:21:0x0095, B:24:0x00a7, B:26:0x00c0, B:27:0x00c5), top: B:48:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00c0 A[Catch: all -> 0x00c6, TRY_ENTER, TryCatch #0 {all -> 0x00c6, blocks: (B:11:0x002e, B:13:0x004b, B:16:0x0076, B:19:0x0088, B:21:0x0095, B:24:0x00a7, B:26:0x00c0, B:27:0x00c5), top: B:48:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:44:0x010b  */
    /* JADX WARN: Code duplicated, block: B:48:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a7 A[EDGE_INSN: B:49:0x00a7->B:24:0x00a7 BREAK  A[LOOP:0: B:15:0x0075->B:23:0x0099, LOOP_LABEL: LOOP:0: B:15:0x0075->B:23:0x0099], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Multi-variable type inference failed */
    public final D8871<Map<String, Integer>, Unit> vD14832N6715() {
        Object objM12684constructorimpl;
        D8871<Map<String, Integer>, Unit> pivotYN16904;
        int i;
        int i2;
        Object obj;
        int i3;
        String[] strArr;
        int[] iArr;
        ArrayList arrayList;
        Iterator it;
        int i4;
        Object next;
        int i5 = 2 % 2;
        int i6 = setPivotYN16904;
        int i7 = ((i6 | 87) << 1) - (i6 ^ 87);
        vD14832N6715 = i7 % 128;
        int i8 = i7 % 2;
        PackageManager packageManager = this.component5;
        if (i8 == 0) {
            int i9 = 10 / 0;
            if (packageManager != null) {
                int i10 = (i6 & 67) + (i6 | 67);
                vD14832N6715 = i10 % 128;
                int i11 = i10 % 2;
                if (this.D8871 != null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        PackageInfo packageInfo = this.component5.getPackageInfo(this.D8871, 4096);
                        Intrinsics.checkNotNull(packageInfo);
                        strArr = packageInfo.requestedPermissions;
                        Intrinsics.checkNotNull(strArr);
                        iArr = packageInfo.requestedPermissionsFlags;
                        Intrinsics.checkNotNull(iArr);
                        if (strArr.length == iArr.length) {
                            throw new IllegalStateException();
                        }
                        List listZip = CollectionsKt.zip(ArraysKt.toList(strArr), ArraysKt.toList(iArr));
                        arrayList = new ArrayList();
                        it = listZip.iterator();
                        int i12 = setPivotYN16904;
                        i4 = ((i12 | 91) << 1) - (i12 ^ 91);
                        vD14832N6715 = i4 % 128;
                        loop0: while (true) {
                            int i13 = i4 % 2;
                            while (true) {
                                if (it.hasNext()) {
                                    break loop0;
                                }
                                int i14 = vD14832N6715;
                                int i15 = (i14 & 95) + (i14 | 95);
                                setPivotYN16904 = i15 % 128;
                                int i16 = i15 % 2;
                                next = it.next();
                                if (((Pair) next).getFirst() != null) {
                                    arrayList.add(next);
                                } else {
                                    int i17 = vD14832N6715;
                                    i4 = (i17 ^ 85) + ((i17 & 85) << 1);
                                    setPivotYN16904 = i4 % 128;
                                }
                            }
                        }
                        objM12684constructorimpl = Result.m12684constructorimpl(MapsKt.toMap(arrayList));
                        int i18 = setPivotYN16904;
                        int i19 = (i18 & 107) + (i18 | 107);
                        vD14832N6715 = i19 % 128;
                        int i20 = i19 % 2;
                        pivotYN16904 = bb.setPivotYN16904(objM12684constructorimpl);
                        if (pivotYN16904 instanceof vD14832N6715) {
                            if (pivotYN16904 instanceof setPivotYN16904) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return new setPivotYN16904(Unit.INSTANCE);
                        }
                        i = vD14832N6715;
                        i2 = i + 33;
                        setPivotYN16904 = i2 % 128;
                        obj = null;
                        if (i2 % 2 == 0) {
                            throw null;
                        }
                        i3 = (i & 115) + (i | 115);
                        setPivotYN16904 = i3 % 128;
                        if (i3 % 2 == 0) {
                            return pivotYN16904;
                        }
                        obj.hashCode();
                        throw null;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                }
            }
        } else if (packageManager != null) {
            int i110 = (i6 & 67) + (i6 | 67);
            vD14832N6715 = i110 % 128;
            int i111 = i110 % 2;
            if (this.D8871 != null) {
                Result.Companion companion3 = Result.INSTANCE;
                PackageInfo packageInfo2 = this.component5.getPackageInfo(this.D8871, 4096);
                Intrinsics.checkNotNull(packageInfo2);
                strArr = packageInfo2.requestedPermissions;
                Intrinsics.checkNotNull(strArr);
                iArr = packageInfo2.requestedPermissionsFlags;
                Intrinsics.checkNotNull(iArr);
                if (strArr.length == iArr.length) {
                    throw new IllegalStateException();
                }
                List listZip2 = CollectionsKt.zip(ArraysKt.toList(strArr), ArraysKt.toList(iArr));
                arrayList = new ArrayList();
                it = listZip2.iterator();
                int i112 = setPivotYN16904;
                i4 = ((i112 | 91) << 1) - (i112 ^ 91);
                vD14832N6715 = i4 % 128;
                loop0: while (true) {
                    int i113 = i4 % 2;
                    while (true) {
                        if (it.hasNext()) {
                            break loop0;
                            break loop0;
                        }
                        int i114 = vD14832N6715;
                        int i115 = (i114 & 95) + (i114 | 95);
                        setPivotYN16904 = i115 % 128;
                        int i116 = i115 % 2;
                        next = it.next();
                        if (((Pair) next).getFirst() != null) {
                            arrayList.add(next);
                        } else {
                            int i117 = vD14832N6715;
                            i4 = (i117 ^ 85) + ((i117 & 85) << 1);
                            setPivotYN16904 = i4 % 128;
                        }
                    }
                }
                objM12684constructorimpl = Result.m12684constructorimpl(MapsKt.toMap(arrayList));
                int i118 = setPivotYN16904;
                int i119 = (i118 & 107) + (i118 | 107);
                vD14832N6715 = i119 % 128;
                int i21 = i119 % 2;
                pivotYN16904 = bb.setPivotYN16904(objM12684constructorimpl);
                if (pivotYN16904 instanceof vD14832N6715) {
                    if (pivotYN16904 instanceof setPivotYN16904) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new setPivotYN16904(Unit.INSTANCE);
                }
                i = vD14832N6715;
                i2 = i + 33;
                setPivotYN16904 = i2 % 128;
                obj = null;
                if (i2 % 2 == 0) {
                    throw null;
                }
                i3 = (i & 115) + (i | 115);
                setPivotYN16904 = i3 % 128;
                if (i3 % 2 == 0) {
                    return pivotYN16904;
                }
                obj.hashCode();
                throw null;
            }
        }
        return new setPivotYN16904(Unit.INSTANCE);
    }
}
