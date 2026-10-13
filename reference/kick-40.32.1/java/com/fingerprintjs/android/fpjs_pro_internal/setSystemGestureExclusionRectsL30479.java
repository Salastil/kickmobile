package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class setSystemGestureExclusionRectsL30479 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int $14 = 0;
    private static int $15 = 1;
    private static int $16 = 0;
    private static int $17 = 1;
    private static byte[] ENTRIES;
    public static final Map INSTANCE;
    private static Object N11182;
    private static byte[] W15084;
    private static int component12;
    private static int component4S4936;
    private static long getExplicitStyle;
    private static long hY16199;
    private static Object lN31375;
    private static int setContentDescriptionR23122;
    private static int setScrollXT29053;
    private static boolean tR25644;
    private static int xQ31420;
    public static final Map yY18494;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    private static java.lang.String $$c(short r8, short r9, short r10) {
        /*
            r0 = 2
            int r1 = r0 % r0
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479.$$a
            int r2 = 82 - r10
            int r8 = 1298 - r8
            int r9 = 119 - r9
            byte[] r2 = new byte[r2]
            int r10 = 81 - r10
            r3 = 0
            if (r1 != 0) goto L15
            r5 = r10
            r4 = r3
            goto L30
        L15:
            r4 = r3
        L16:
            byte r5 = (byte) r9
            int r8 = r8 + 1
            r2[r4] = r5
            if (r4 != r10) goto L23
            java.lang.String r8 = new java.lang.String
            r8.<init>(r2, r3)
            return r8
        L23:
            int r4 = r4 + 1
            r5 = r1[r8]
            int r6 = com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479.$17
            int r6 = r6 + 115
            int r7 = r6 % 128
            com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479.$16 = r7
            int r6 = r6 % r0
        L30:
            int r5 = -r5
            int r9 = r9 + r5
            int r9 = r9 + (-3)
            int r5 = com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479.$16
            int r5 = r5 + 107
            int r6 = r5 % 128
            com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479.$17 = r6
            int r5 = r5 % r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479.$$c(short, short, short):java.lang.String");
    }

    static void init$0() {
        int i = 2 % 2;
        int i2 = $11;
        int i3 = (i2 ^ 71) + ((i2 & 71) << 1);
        $10 = i3 % 128;
        int i4 = i3 % 2;
        byte[] bArr = new byte[1310];
        System.arraycopy(",»ÿUð\u0007ï\u0000\u0003\u00023¶þ\bú;×Ø\u0006\bþ\u000bòòô\rñÿú\u0001\u0004ê!â&×ú\u000bêñÿ;Æúø\u0004ÿðÿû\u0006ø÷\u0007ôAËð\u0007ï\u0000\u0003\u00022Æó\u0003ô\u0011ìû\u0000\róø÷\fð\u0001\nò:æ\u0012üýþöâýñÿ<Åúø\u0004ÿðÿû\u0006ø÷\u0007ôBÊð\u0007ï\u0000\u0003\u00023Åó\u0003ô\u0011ìû\u0000ð\u0007ï\u0000\u0003\u00023Êîý?êÛì\bð\nòø\"éó\n\u0001úë\u0000ý\nô÷0Îý\u0001\u0000\u0003ÿê\b÷þð\u0007ï\u0000\u0003\u00023Êîý?êÎý&Øú\nþòöÿî(Ø\u0002ò\b\u0005ò(Îý\u0001\u0000\u0003ÿê\b÷þÿî+Úú\u0004ï,Øôÿî.Ñ\bü\u001fßûø\u0000\u001eØôÿî.ßûø\u0000\u001eØôÈ\u0000ê\u0010/È\u0000ê\u0010/\u0006è\u00120Â÷>åÚú\u0004\u0006è\u00120Â÷>·\u0004ú\tøô\u0006è\u00120¿\bð\u00046Ø×\u0003ü\fõÿî!Û\u0000ü\bðûøñ\bü\u0003ùÿûø\u0000ð\u0007ï\u0000\u0003\u00023¼ùBéÊ\tú\u0005=Ë\u000eðü\u0007÷þ\föé\u0013ø÷ÿð\u0014â\u0006ò\f\u0012÷\u0013õ\u0006è\u00120Â÷>â÷\u0007Ê\u0012ûòù\b÷þë\u0000ý\nô÷\u001dèù\u0005\u0015áúý\u0000ó\u0006è\u00120Â÷>åÚú\u0004\u0013×þ\u0001øþ\u001eÜÿ\n\u0001ñôúù\u000b\u0012ú\u0010õËëý\u000bîþAÉñÿ;Æúø\u0004ÿðÿû\u0006ø÷\u0007ôAËð\u0007ï\u0000\u0003\u00022Æó\u0003ô\u0011ìû\u0000\róø÷\fð\u0001\nò:È)Óùþ*\u0005úùÿ\u0002Ë'ýÿÒý1ÿî\u001fêï\u0001÷\u0000\fû\u0006è\u00120½\u0006îCÖ\u0000\u0003ÿî!ìê\t\u0006è\u00120Â÷>éÊ\fýþð\nþ\u0018Øûøþ\u001eÜÿ\n\u0001ñ\u0006è\u00120Â÷>âØûøþ\u001eÜÿ\n\u0001ñ\u0006è\u00120Â÷>çàê\u0010\u0015Øûøþ\u001eÜÿ\n\u0001ñ\n\u0001ú\u001bÎ\u0006ýð\u0006è\u00120Â÷>éÆ\u0002\f!Ìý\u000eå-Øûøþ\u001eÜÿ\n\u0001ññÿ<Åúø\u0004ÿðÿû\u0006ø÷\u0007ôBÊð\u0007ï\u0000\u0003\u00023Åó\u0003ô\u0011ìû\u0000\róø÷\fð\u0001\nò;Èúñÿ<Åúø\u0004ÿðÿû\u0006ø÷\u0007ôBÊð\u0007ï\u0000\u0003\u00023Åó\u0003ô\u0011ìû\u0000\róø÷\fð\u0001\nò;å\u0012üýþöâýñÿúþþ\u0006ô÷<\u0005ÿö\n\u0001ú\u000bî\u001fê\u0001ú\u0012Þÿð\u0012ù\u0011õ\u0002\u0006ò\fÿî+ÿ\u0006è\u00120Â÷>åÚú\u0004\u001eÜï\rî\u0006öù\u0002ú÷\b\b\u0000òó\nû:¸÷\u0003ü\fõ<çÜê/Úú\u0004ú\u000bú\u001dÜêÿî0Üì\u0001\u0000ôþ\f\u0012ìê\tüö\u0004î\fÿî.Ô\bëý$Ú\u000búüð\u0006è\u00120¶þ\bú;±\u000eö?Ñîö$Øûøþ\u001eÜÿ\n\u0001ñÿî#æê\u0001,Ô÷ÿö\u0006è\u00120¶þ\bú;±\u000eö?Ñîö(Ô÷ÿöÿî\u001eçì\u0012\u0006è\u00120½\u0002÷>éÆ\u0002\f Ê\fýþðòýú\tÿê\f\u001eØô\nÿìøþ\u0006è\u00120Â÷>èÔúù\u000b\u0001üó\u0004\u0000òó\nû:¸÷\u0003ü\fõ<âØ\u001eåõûúö2Üê2Ô\bëý$Ú\u000búüð\u0006è\u00120¿\bð\u00046èÔ\bëý$Ú\u000búüðþù\u0007ò\b÷þ\u0000òó\nû:¸÷\u0003ü\fõ<éÞë\u000b\u001eÜê2Ô\bëý$Ú\u000búüð\fê\t\u0019àóü\nê\bð\u000e\u0016à\u0004í\u000eìö2Øô\nÿì\u0002ú\u0006\u0001ï\nê\bð\u000e\u0016à\u0004í\u000eìö&ìê\t Ö\u0004õ\u0005ô÷þÿî.Ñÿúþþ\u0006ô÷\u001dØ\u0006\b\u0012õ\u0015õú\u000bú\u001eÔ\bëýñÿ;Æúø\u0004ÿðÿû\u0006ø÷\u0007ôAËð\u0007ï\u0000\u0003\u00022Æó\u0003ô\u0011ìû\u0000\róø÷\fð\u0001\nò:¹\u000bî\u001e×\u0003ü\fõ#ßïüü\u0000\n\u001dÊ\u0012ôôÿ\u0007÷þ\u0019êÿìþ$\u0016\u0000ùúû\u0012¼Ëëý\u000bîþAÉñÿ;Æúø\u0004ÿðÿû\u0006ø÷\u0007ôAËð\u0007ï\u0000\u0003\u00022Æó\u0003ô\u0011ìû\u0000\róø÷\fð\u0001\nò:úû\u0000Ìþ.úøÒû,Î.ùÐ/Î2\u0012ö\u0014õ·üL·\u0002òý\u0007þûõõP±\u0004üïH\u000bî!äð\u0004ø\u0018\b\u001aøú\u0006ù/\u0010úù\u0002þá\u0015ü\u0003ù".getBytes("ISO-8859-1"), 0, bArr, 0, 1310);
        $$a = bArr;
        $$b = 204;
        int i5 = $10;
        int i6 = (i5 & 33) + (i5 | 33);
        $11 = i6 % 128;
        int i7 = i6 % 2;
    }

    private setSystemGestureExclusionRectsL30479() {
    }

    public static Object component5(int i) {
        int i2 = 2 % 2;
        int i3 = ~i;
        Process.myTid();
        Map map = INSTANCE;
        int i4 = setScrollXT29053;
        Object obj = map.get(Integer.valueOf((i & (~i4)) | (i3 & i4)));
        int i5 = $11 + 77;
        $10 = i5 % 128;
        int i6 = i5 % 2;
        return obj;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 65501. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    static {
        /*
            Method dump skipped, instruction units count: 6550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479.<clinit>():void");
    }

    public static Object vD14832N6715(int i, char c, int i2, int i3, boolean z, String str, Class[] clsArr) throws Throwable {
        Object method;
        int i4 = 2 % 2;
        int i5 = $10;
        int i6 = (i5 & 97) + (i5 | 97);
        $11 = i6 % 128;
        int i7 = i6 % 2;
        Map map = INSTANCE;
        Object obj = map.get(Integer.valueOf(i3));
        if (obj != null) {
            return obj;
        }
        Integer numValueOf = Integer.valueOf(i3);
        Object obj2 = lN31375;
        int i8 = $10 + 49;
        $11 = i8 % 128;
        int i9 = i8 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i), Character.valueOf(c), Integer.valueOf(i2)};
            byte[] bArr = $$a;
            Class cls = (Class) Class.forName($$c((short) 644, bArr[339], bArr[227]), true, (ClassLoader) N11182).getMethod($$c(bArr[325], bArr[30], bArr[499]), Integer.TYPE, Character.TYPE, Integer.TYPE).invoke(obj2, objArr);
            if (str == null) {
                int i10 = $10;
                int i11 = (i10 ^ 11) + ((i10 & 11) << 1);
                $11 = i11 % 128;
                int i12 = i11 % 2;
                if (z) {
                    method = cls.getDeclaredConstructor(clsArr);
                    int i13 = $11 + 33;
                    $10 = i13 % 128;
                    int i14 = i13 % 2;
                } else {
                    method = cls.getConstructor(clsArr);
                }
                int i15 = $10;
                int i16 = (i15 & 35) + (i15 | 35);
                $11 = i16 % 128;
                int i17 = i16 % 2;
            } else if (clsArr == null) {
                int i18 = $10;
                int i19 = (i18 & 45) + (i18 | 45);
                $11 = i19 % 128;
                int i20 = i19 % 2;
                if (z) {
                    int i21 = (i18 & 83) + (i18 | 83);
                    $11 = i21 % 128;
                    int i22 = i21 % 2;
                    method = cls.getDeclaredField(str);
                } else {
                    method = cls.getField(str);
                    int i23 = $11;
                    int i24 = ((i23 | 121) << 1) - (i23 ^ 121);
                    $10 = i24 % 128;
                    int i25 = i24 % 2;
                }
                int i26 = $10;
                int i27 = (i26 ^ 59) + ((i26 & 59) << 1);
                $11 = i27 % 128;
                int i28 = i27 % 2;
            } else if (z) {
                int i29 = $11;
                int i30 = (i29 & 73) + (i29 | 73);
                $10 = i30 % 128;
                int i31 = i30 % 2;
                method = cls.getDeclaredMethod(str, clsArr);
            } else {
                method = cls.getMethod(str, clsArr);
            }
            map.put(numValueOf, method);
            return method;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int vD14832N6715(int i) throws Throwable {
        int i2 = 2 % 2;
        int i3 = $10;
        int i4 = ((i3 | 123) << 1) - (i3 ^ 123);
        $11 = i4 % 128;
        if (i4 % 2 == 0) {
            throw null;
        }
        Object obj = lN31375;
        int i5 = i3 + 57;
        int i6 = i5 % 128;
        $11 = i6;
        int i7 = i5 % 2;
        int i8 = i6 + 3;
        $10 = i8 % 128;
        int i9 = i8 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i)};
            byte[] bArr = $$a;
            int iIntValue = ((Integer) Class.forName($$c((short) 644, bArr[339], bArr[227]), true, (ClassLoader) N11182).getMethod($$c(bArr[325], bArr[30], bArr[499]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i10 = $10 + 89;
            $11 = i10 % 128;
            if (i10 % 2 != 0) {
                return iIntValue;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int component5(Object obj) throws Throwable {
        int i = 2 % 2;
        int i2 = $10 + 61;
        int i3 = i2 % 128;
        $11 = i3;
        int i4 = i2 % 2;
        Object obj2 = lN31375;
        int i5 = ((i3 | 61) << 1) - (i3 ^ 61);
        $10 = i5 % 128;
        int i6 = i5 % 2;
        int i7 = i3 + 59;
        $10 = i7 % 128;
        int i8 = i7 % 2;
        try {
            byte[] bArr = $$a;
            int iIntValue = ((Integer) Class.forName($$c((short) 644, bArr[339], bArr[227]), true, (ClassLoader) N11182).getMethod($$c(bArr[7], bArr[29], (short) 70), Object.class).invoke(obj2, obj)).intValue();
            int i9 = $11;
            int i10 = (i9 & 49) + (i9 | 49);
            $10 = i10 % 128;
            if (i10 % 2 != 0) {
                int i11 = 52 / 0;
            }
            return iIntValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static Object component5(int i, char c, int i2) throws Throwable {
        int i3 = 2 % 2;
        int i4 = $10 + 25;
        int i5 = i4 % 128;
        $11 = i5;
        int i6 = i4 % 2;
        Object obj = lN31375;
        int i7 = (i5 ^ 47) + ((i5 & 47) << 1);
        int i8 = i7 % 128;
        $10 = i8;
        int i9 = i7 % 2;
        int i10 = ((i8 | 47) << 1) - (i8 ^ 47);
        $11 = i10 % 128;
        int i11 = i10 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i), Character.valueOf(c), Integer.valueOf(i2)};
            byte[] bArr = $$a;
            return Class.forName($$c((short) 644, bArr[339], bArr[227]), true, (ClassLoader) N11182).getMethod($$c(bArr[325], bArr[30], bArr[499]), Integer.TYPE, Character.TYPE, Integer.TYPE).invoke(obj, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
