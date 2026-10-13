package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import androidx.media3.muxer.WebmConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class al implements ag {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int D8871;
    private static int component9;
    private final UserManager vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 4
            int r7 = r7 * 4
            int r7 = r7 + 10
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.al.$$a
            int r9 = r9 * 4
            int r9 = r9 + 99
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r7
            r9 = r8
            r4 = r2
            goto L2d
        L15:
            r3 = r2
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            int r8 = r8 + 1
            r1[r3] = r5
            if (r4 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r6
        L2d:
            int r3 = r3 + r8
            int r8 = r3 + (-23)
            r3 = r9
            r9 = r8
            r8 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.al.a(short, int, short, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{62, 106, 120, -80, 35, Ascii.NAK, Ascii.SUB, Ascii.SYN, Ascii.SYN, Ascii.SO, 32, Ascii.GS, -36};
        $$b = WebmConstants.MkvEbmlElement.PREV_SIZE;
    }

    public al(UserManager userManager) {
        this.vD14832N6715 = userManager;
    }

    public static final /* synthetic */ UserManager setPivotYN16904(al alVar) {
        int i = 2 % 2;
        int i2 = component9 + 21;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        UserManager userManager = alVar.vD14832N6715;
        if (i3 == 0) {
            int i4 = 13 / 0;
        }
        return userManager;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.al$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/fingerprintjs/android/fpjs_pro_internal/ai;", "component5$6fed0fa6", "(Ljava/lang/Object;)Lcom/fingerprintjs/android/fpjs_pro_internal/ai;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<Object, ai> {
        private static int $component5 = 0;
        private static int $component9 = 1;
        public static int D8871;
        public static int setPivotYN16904;

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ ai invoke(Object obj) {
            int i = 2 % 2;
            int i2 = $component9 + 61;
            $component5 = i2 % 128;
            int i3 = i2 % 2;
            ai aiVarComponent5$6fed0fa6 = component5$6fed0fa6(obj);
            int i4 = $component5 + 43;
            $component9 = i4 % 128;
            if (i4 % 2 != 0) {
                return aiVarComponent5$6fed0fa6;
            }
            Object obj2 = null;
            obj2.hashCode();
            throw null;
        }

        public final ai component5$6fed0fa6(Object obj) {
            Boolean boolValueOf;
            int i = 2 % 2;
            int i2 = $component5;
            int i3 = (i2 & 83) + (i2 | 83);
            $component9 = i3 % 128;
            int i4 = i3 % 2;
            UserManager pivotYN16904 = al.setPivotYN16904(al.this);
            Intrinsics.checkNotNull(pivotYN16904);
            int size = pivotYN16904.getUserProfiles().size();
            Object obj2 = null;
            if (Build.VERSION.SDK_INT >= 30) {
                int i5 = $component5;
                int i6 = (i5 & 57) + (i5 | 57);
                $component9 = i6 % 128;
                int i7 = i6 % 2;
                al alVar = al.this;
                if (i7 == 0) {
                    Boolean.valueOf(al.setPivotYN16904(alVar).isManagedProfile());
                    obj2.hashCode();
                    throw null;
                }
                boolValueOf = Boolean.valueOf(al.setPivotYN16904(alVar).isManagedProfile());
                int i8 = $component9;
                int i9 = ((i8 | 73) << 1) - (i8 ^ 73);
                $component5 = i9 % 128;
                int i10 = i9 % 2;
            } else {
                int i11 = $component9 + 111;
                $component5 = i11 % 128;
                int i12 = i11 % 2;
                boolValueOf = null;
            }
            int i13 = $component9;
            int i14 = ((i13 | 117) << 1) - (i13 ^ 117);
            $component5 = i14 % 128;
            int i15 = i14 % 2;
            al alVar2 = al.this;
            if (i15 == 0) {
                return new ai(Integer.valueOf(size), boolValueOf, Boolean.valueOf(al.setPivotYN16904(alVar2).isSystemUser()));
            }
            Boolean.valueOf(al.setPivotYN16904(alVar2).isSystemUser());
            throw null;
        }

        public static int D8871() {
            int i = D8871;
            int i2 = i % 9948957;
            D8871 = i + 1;
            if (i2 != 0) {
                return setPivotYN16904;
            }
            int iNextInt = new Random().nextInt(1055974324);
            setPivotYN16904 = iNextInt;
            return iNextInt;
        }

        AnonymousClass1() {
            super(1);
        }
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.ag
    public final ai component5() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new AnonymousClass1(), 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(874323074);
            if (objComponent5 == null) {
                int iIndexOf = 50 - TextUtils.indexOf((CharSequence) "", '0');
                char gidForName = (char) ((-1) - Process.getGidForName(""));
                int packedPositionChild = 1076 - ExpandableListView.getPackedPositionChild(0L);
                Object[] objArr2 = new Object[1];
                a((short) 0, -1, (short) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, gidForName, packedPositionChild, 1722308833, false, (String) objArr2[0], new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function1.class, Integer.TYPE, Object.class});
            }
            ai aiVar = (ai) component9.component9((D8871) ((Method) objComponent5).invoke(null, objArr), new ai(null, null, null));
            int i2 = D8871;
            int i3 = (i2 ^ 91) + ((i2 & 91) << 1);
            component9 = i3 % 128;
            int i4 = i3 % 2;
            return aiVar;
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
        component9 = 0;
        D8871 = 1;
    }
}
