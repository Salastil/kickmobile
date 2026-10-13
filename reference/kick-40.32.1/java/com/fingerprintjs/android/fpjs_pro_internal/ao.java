package com.fingerprintjs.android.fpjs_pro_internal;

import android.text.AndroidCharacter;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/ao;", "Lcom/fingerprintjs/android/fpjs_pro_internal/an;", "", "p0", "<init>", "(Ljava/lang/String;)V", "Lcom/fingerprintjs/android/fpjs_pro_internal/D8871;", "", "Lcom/fingerprintjs/android/fpjs_pro_internal/an$component9;", "D8871", "(Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro_internal/D8871;", "p1", "", "", "vD14832N6715", "([BLjava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro_internal/D8871;", "component9", "Ljava/lang/String;", "component5"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ao implements an {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final String D8871;
    private final String component9;

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r8 = r8 * 2
            int r8 = r8 + 10
            int r9 = r9 * 4
            int r9 = r9 + 99
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.ao.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r7
            r4 = r2
            goto L30
        L16:
            r3 = r9
            r9 = r7
            r7 = r3
            r3 = r2
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r8) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L30:
            int r7 = r7 + r9
            int r7 = r7 + (-25)
            r9 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ao.a(short, byte, byte, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{82, -87, 110, -103, 37, Ascii.ETB, Ascii.FS, Ascii.CAN, Ascii.CAN, Ascii.DLE, 34, Ascii.US, -38};
        $$b = 72;
    }

    public ao(String str) {
        String str2;
        if (str != null) {
            str2 = str + DomExceptionUtils.SEPARATOR + D8871;
        } else {
            str2 = null;
        }
        this.component9 = str2;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.an
    public final synchronized D8871<Unit, Throwable> vD14832N6715(final byte[] p0, final String p1) {
        Object[] objArr;
        Object objComponent5;
        try {
            objArr = new Object[]{0L, new Function0<Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.ao.4
                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Unit invoke() throws IOException {
                    vD14832N6715();
                    return Unit.INSTANCE;
                }

                public final void vD14832N6715() throws IOException {
                    String str = ao.this.component9;
                    Intrinsics.checkNotNull(str);
                    ao.component5(str);
                    File file = new File(ao.this.component9 + DomExceptionUtils.SEPARATOR + p1);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FilesKt.writeBytes(file, p0);
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }
            }, 1, null};
            objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 51;
                char c = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                int mirror = 1125 - AndroidCharacter.getMirror('0');
                Object[] objArr2 = new Object[1];
                a((short) 0, (byte) 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(touchSlop, c, mirror, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
        return (D8871) ((Method) objComponent5).invoke(null, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fingerprintjs.android.fpjs_pro_internal.an
    public final synchronized D8871<byte[], an.component9> D8871(final String p0) {
        try {
            Object[] objArr = {0L, new Function0<D8871<? extends byte[], ? extends FileNotFoundException>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.ao.2
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: D8871, reason: merged with bridge method [inline-methods] */
                public final D8871<byte[], FileNotFoundException> invoke() {
                    String str = ao.this.component9;
                    Intrinsics.checkNotNull(str);
                    File file = new File(str + DomExceptionUtils.SEPARATOR + p0);
                    if (!file.exists()) {
                        return new setPivotYN16904(new FileNotFoundException());
                    }
                    return new vD14832N6715(FilesKt.readBytes(file));
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int iResolveSizeAndState = 51 - View.resolveSizeAndState(0, 0, 0);
                char modifierMetaStateMask = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 1077;
                Object[] objArr2 = new Object[1];
                a((short) 0, (byte) 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSizeAndState, modifierMetaStateMask, scrollBarSize, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<byte[], an.component9> d8871Component9 = bb.component9((D8871) ((Method) objComponent5).invoke(null, objArr));
            if (d8871Component9 instanceof vD14832N6715) {
                return d8871Component9;
            }
            if (d8871Component9 instanceof setPivotYN16904) {
                return new setPivotYN16904(((Throwable) ((setPivotYN16904) d8871Component9).setPivotYN16904) instanceof FileNotFoundException ? an.component9.component5.INSTANCE : an.component9.C0111component9.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
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
        INSTANCE = new Companion(null);
        D8871 = I30900.z.INSTANCE.component5();
    }

    public static final /* synthetic */ void component5(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
