package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.os.SystemClock;
import android.view.ViewConfiguration;
import androidx.compose.runtime.GapComposerKt;
import java.io.File;
import java.lang.reflect.Method;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class getEntries {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int component5;
    private static int setPivotYN16904;

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.getEntries.$$a
            int r8 = r8 * 3
            int r8 = 99 - r8
            int r7 = r7 * 3
            int r1 = r7 + 10
            int r6 = r6 * 3
            int r6 = 3 - r6
            byte[] r1 = new byte[r1]
            int r7 = r7 + 9
            r2 = 0
            if (r0 != 0) goto L19
            r8 = r6
            r3 = r7
            r4 = r2
            goto L30
        L19:
            r3 = r2
        L1a:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L30:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-25)
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getEntries.a(short, short, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{51, -107, 109, -75, -37, -23, -28, -24, -24, -16, -34, -31, 38};
        $$b = 249;
    }

    public static D8871<String, Throwable> component9() throws Throwable {
        int i = 2 % 2;
        int i2 = component5;
        int i3 = (i2 & GapComposerKt.nodeKey) + (i2 | GapComposerKt.nodeKey);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        try {
            Object[] objArr = {0L, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getEntries.3
                private static int $component5 = 0;
                private static int $component9 = 1;
                private static int $setPivotYN16904 = 0;
                private static int $vD14832N6715 = 1;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i5 = 2 % 2;
                    int i6 = $component9;
                    int i7 = (i6 ^ 99) + ((i6 & 99) << 1);
                    $component5 = i7 % 128;
                    int i8 = i7 % 2;
                    String strComponent5 = component5();
                    int i9 = $component5;
                    int i10 = (i9 ^ 37) + ((i9 & 37) << 1);
                    $component9 = i10 % 128;
                    int i11 = i10 % 2;
                    return strComponent5;
                }

                public final String component5() {
                    int i5 = 2 % 2;
                    String string = StringsKt.trim((CharSequence) new String(FilesKt.readBytes(new File(I30900.getLeftK29400.INSTANCE.component5())), Charsets.UTF_8)).toString();
                    int i6 = $component5;
                    int i7 = ((i6 | 113) << 1) - (i6 ^ 113);
                    $component9 = i7 % 128;
                    if (i7 % 2 != 0) {
                        return string;
                    }
                    throw null;
                }

                static {
                    int i5 = $vD14832N6715 + 61;
                    $setPivotYN16904 = i5 % 128;
                    int i6 = i5 % 2;
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int i5 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 50;
                char cBlue = (char) Color.blue(0);
                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1077;
                Object[] objArr2 = new Object[1];
                a((short) 0, (short) 0, (short) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i5, cBlue, maximumDrawingCacheSize, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<String, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i6 = component5 + 97;
            setPivotYN16904 = i6 % 128;
            int i7 = i6 % 2;
            return d8871;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static {
        init$0();
        component5 = 0;
        setPivotYN16904 = 1;
    }
}
