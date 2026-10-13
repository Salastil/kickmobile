package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import androidx.core.content.ContextCompat;
import androidx.media3.muxer.WebmConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
public final class setOnLongClickListenerR17701 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int D8871;
    private static int component5;
    public static int component9;
    public static int vD14832N6715;
    private final Context setPivotYN16904;

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r0 = r8 + 10
            int r6 = r6 * 3
            int r6 = r6 + 99
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.setOnLongClickListenerR17701.$$a
            int r7 = r7 * 3
            int r7 = 4 - r7
            byte[] r0 = new byte[r0]
            int r8 = r8 + 9
            r2 = 0
            if (r1 != 0) goto L18
            r3 = r7
            r4 = r2
            goto L2e
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2e:
            int r6 = r6 + r7
            int r6 = r6 + (-23)
            int r7 = r3 + 1
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setOnLongClickListenerR17701.a(int, short, int, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{65, -118, 1, 100, 35, Ascii.NAK, Ascii.SUB, Ascii.SYN, Ascii.SYN, Ascii.SO, 32, Ascii.GS, -36};
        $$b = WebmConstants.MkvEbmlElement.REFERENCE_BLOCK;
    }

    public setOnLongClickListenerR17701(Context context) {
        this.setPivotYN16904 = context;
    }

    public static final /* synthetic */ boolean setPivotYN16904(setOnLongClickListenerR17701 setonlongclicklistenerr17701, String str) {
        int i = 2 % 2;
        int i2 = component5 + 3;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        boolean zD8871 = setonlongclicklistenerr17701.D8871(str);
        if (i3 == 0) {
            int i4 = 3 / 0;
        }
        int i5 = component5 + 73;
        D8871 = i5 % 128;
        int i6 = i5 % 2;
        return zD8871;
    }

    public final List<setOnContextClickListenerE32038> vD14832N6715() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new Function1<Object, List<? extends setOnContextClickListenerE32038>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.setOnLongClickListenerR17701.5
                private static int $setPivotYN16904 = 0;
                private static int $vD14832N6715 = 1;

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ List<? extends setOnContextClickListenerE32038> invoke(Object obj) {
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904;
                    int i4 = (i3 & 7) + (i3 | 7);
                    $vD14832N6715 = i4 % 128;
                    Object obj2 = null;
                    if (i4 % 2 == 0) {
                        D8871$11c1e2f4(obj);
                        obj2.hashCode();
                        throw null;
                    }
                    List<setOnContextClickListenerE32038> listD8871$11c1e2f4 = D8871$11c1e2f4(obj);
                    int i5 = $setPivotYN16904;
                    int i6 = (i5 & GapComposerKt.nodeKey) + (i5 | GapComposerKt.nodeKey);
                    $vD14832N6715 = i6 % 128;
                    if (i6 % 2 != 0) {
                        return listD8871$11c1e2f4;
                    }
                    throw null;
                }

                /* JADX WARN: Code duplicated, block: B:9:0x002b A[PHI: r0
                  0x002b: PHI (r0v5 java.util.List) = (r0v4 java.util.List), (r0v7 java.util.List) binds: [B:8:0x0029, B:5:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
                public final List<setOnContextClickListenerE32038> D8871$11c1e2f4(Object obj) {
                    List listCreateListBuilder;
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 97;
                    $setPivotYN16904 = i3 % 128;
                    int i4 = i3 % 2;
                    setOnLongClickListenerR17701 setonlongclicklistenerr17701 = setOnLongClickListenerR17701.this;
                    if (i4 != 0) {
                        listCreateListBuilder = CollectionsKt.createListBuilder();
                        int i5 = 67 / 0;
                        if (setOnLongClickListenerR17701.setPivotYN16904(setonlongclicklistenerr17701, "android.permission.ACCESS_FINE_LOCATION")) {
                            int i6 = $vD14832N6715;
                            int i7 = (i6 & 21) + (i6 | 21);
                            $setPivotYN16904 = i7 % 128;
                            int i8 = i7 % 2;
                            listCreateListBuilder.add(setOnContextClickListenerE32038.setPivotYN16904.INSTANCE);
                            int i9 = $setPivotYN16904 + 35;
                            $vD14832N6715 = i9 % 128;
                            int i10 = i9 % 2;
                        }
                    } else {
                        listCreateListBuilder = CollectionsKt.createListBuilder();
                        if (setOnLongClickListenerR17701.setPivotYN16904(setonlongclicklistenerr17701, "android.permission.ACCESS_FINE_LOCATION")) {
                            int i11 = $vD14832N6715;
                            int i12 = (i11 & 21) + (i11 | 21);
                            $setPivotYN16904 = i12 % 128;
                            int i13 = i12 % 2;
                            listCreateListBuilder.add(setOnContextClickListenerE32038.setPivotYN16904.INSTANCE);
                            int i14 = $setPivotYN16904 + 35;
                            $vD14832N6715 = i14 % 128;
                            int i15 = i14 % 2;
                        }
                    }
                    if (setOnLongClickListenerR17701.setPivotYN16904(setonlongclicklistenerr17701, "android.permission.ACCESS_COARSE_LOCATION")) {
                        int i16 = $vD14832N6715 + 27;
                        $setPivotYN16904 = i16 % 128;
                        if (i16 % 2 != 0) {
                            listCreateListBuilder.add(setOnContextClickListenerE32038.D8871.INSTANCE);
                            throw null;
                        }
                        listCreateListBuilder.add(setOnContextClickListenerE32038.D8871.INSTANCE);
                    }
                    return CollectionsKt.build(listCreateListBuilder);
                }

                {
                    super(1);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int iResolveSizeAndState = 51 - View.resolveSizeAndState(0, 0, 0);
                char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 1077;
                byte b = (byte) ($$a[2] - 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSizeAndState, packedPositionType, tapTimeout, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            List<setOnContextClickListenerE32038> list = (List) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), CollectionsKt.emptyList());
            int i2 = D8871 + 85;
            component5 = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 64 / 0;
            }
            return list;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private final boolean D8871(String str) {
        int i = 2 % 2;
        int i2 = component5 + 37;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        Context context = this.setPivotYN16904;
        Object obj = null;
        if (i3 == 0) {
            ContextCompat.checkSelfPermission(context, str);
            obj.hashCode();
            throw null;
        }
        if (ContextCompat.checkSelfPermission(context, str) == 0) {
            int i4 = component5 + 107;
            D8871 = i4 % 128;
            return i4 % 2 != 0;
        }
        int i5 = component5;
        int i6 = (i5 ^ 23) + ((i5 & 23) << 1);
        D8871 = i6 % 128;
        if (i6 % 2 != 0) {
            return false;
        }
        obj.hashCode();
        throw null;
    }

    static {
        init$0();
        component5 = 0;
        D8871 = 1;
    }

    public static int setPivotYN16904() {
        int i = vD14832N6715;
        int i2 = i % 9127716;
        vD14832N6715 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        component9 = iElapsedRealtime;
        return iElapsedRealtime;
    }
}
