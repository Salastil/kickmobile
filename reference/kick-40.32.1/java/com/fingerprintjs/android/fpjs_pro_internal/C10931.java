package com.fingerprintjs.android.fpjs_pro_internal;

import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.view.ViewConfiguration;
import androidx.media3.muxer.WebmConstants;
import com.fingerprintjs.android.fpjs_pro.raw_signal_providers.file_timestamps.FileTimestamps;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class C10931 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int component9;
    private static int setPivotYN16904;
    private final List<I30900> component5 = CollectionsKt.listOf((Object[]) new I30900[]{I30900.ap.INSTANCE, I30900.ar.INSTANCE, I30900.as.INSTANCE, I30900.A27299Q27368.INSTANCE, I30900.qF23579.INSTANCE, I30900.C0110I30900.INSTANCE, I30900.K5264.INSTANCE, I30900.component6.INSTANCE, I30900.jC6584.INSTANCE, I30900.P28427.INSTANCE, I30900.getContextMenuInfoA21117.INSTANCE, I30900.nL14774.INSTANCE, I30900.N14078.INSTANCE, I30900.iF17194E13054.INSTANCE, I30900.C10931.INSTANCE, I30900.lI23295.INSTANCE, I30900.hO26224.INSTANCE, I30900.sB6055.INSTANCE, I30900.P29109.INSTANCE, I30900.qU20128.INSTANCE, I30900.setOnClickListenerO2383.INSTANCE, I30900.copy.INSTANCE, I30900.F16286.INSTANCE, I30900.getEntries.INSTANCE, I30900.setOnContextClickListenerE32038.INSTANCE, I30900.setOnLongClickListenerR17701.INSTANCE, I30900.M3232.INSTANCE, I30900.K17305.INSTANCE, I30900.component4.INSTANCE, I30900.getContext.INSTANCE, I30900.getXH31455G12819.INSTANCE, I30900.gG25166.INSTANCE, I30900.T9586V28869.INSTANCE, I30900.fQ24217.INSTANCE, I30900.pC2922.INSTANCE, I30900.pV7834.INSTANCE, I30900.getSystemGestureExclusionRects.INSTANCE, I30900.W6392.INSTANCE, I30900.toString.INSTANCE, I30900.setBottomR12227.INSTANCE, I30900.getAutofillType.INSTANCE, I30900.component7.INSTANCE, I30900.oN11246.INSTANCE, I30900.tM9319B53.INSTANCE, I30900.B9336.INSTANCE, I30900.H16981.INSTANCE, I30900.component7X12099.INSTANCE, I30900.X26477.INSTANCE, I30900.component3.INSTANCE, I30900.G8931.INSTANCE, I30900.setScrollYX30569T8767.INSTANCE, I30900.cM3232.INSTANCE, I30900.getContentDescriptionT29053.INSTANCE, I30900.mK14988T27556.INSTANCE, I30900.W29288.INSTANCE, I30900.U18116.INSTANCE, I30900.setOnTouchListener.INSTANCE, I30900.c.INSTANCE, I30900.B22527.INSTANCE, I30900.d.INSTANCE, I30900.a.INSTANCE, I30900.b.INSTANCE, I30900.e.INSTANCE, I30900.i.INSTANCE, I30900.h.INSTANCE, I30900.f.INSTANCE, I30900.g.INSTANCE, I30900.wB2645.INSTANCE, I30900.k.INSTANCE, I30900.m.INSTANCE, I30900.n.INSTANCE, I30900.j.INSTANCE, I30900.l.INSTANCE, I30900.q.INSTANCE, I30900.o.INSTANCE, I30900.r.INSTANCE, I30900.p.INSTANCE, I30900.fO27287.INSTANCE, I30900.getRightG17489.INSTANCE, I30900.ca.INSTANCE, I30900.bw.INSTANCE});
    private final as vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 2
            int r5 = r5 + 10
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.C10931.$$a
            int r7 = r7 * 3
            int r7 = 99 - r7
            int r6 = r6 * 2
            int r6 = r6 + 4
            byte[] r1 = new byte[r5]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r5
            r7 = r6
            r3 = r2
            goto L29
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r5) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L27:
            r4 = r0[r6]
        L29:
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-25)
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.C10931.a(byte, short, byte, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{74, -125, 38, 125, 37, Ascii.ETB, Ascii.FS, Ascii.CAN, Ascii.CAN, Ascii.DLE, 34, Ascii.US, -38};
        $$b = WebmConstants.MkvEbmlElement.TIMESTAMP;
    }

    public C10931(as asVar) {
        this.vD14832N6715 = asVar;
    }

    public static final /* synthetic */ List component5(C10931 c10931) {
        int i = 2 % 2;
        int i2 = component9;
        int i3 = (i2 ^ 115) + ((i2 & 115) << 1);
        int i4 = i3 % 128;
        setPivotYN16904 = i4;
        int i5 = i3 % 2;
        List<I30900> list = c10931.component5;
        int i6 = (i4 & 65) + (i4 | 65);
        component9 = i6 % 128;
        int i7 = i6 % 2;
        return list;
    }

    public static final /* synthetic */ as component9(C10931 c10931) {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 47;
        component9 = i2 % 128;
        int i3 = i2 % 2;
        as asVar = c10931.vD14832N6715;
        if (i3 != 0) {
            return asVar;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.C10931$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0000H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "", "", "vD14832N6715", "()Ljava/util/Map;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, Long[]>> {
        private static int $D8871 = 1;
        private static int $component5;
        public static int component9;
        public static int setPivotYN16904;

        @Override // kotlin.jvm.functions.Function0
        public final /* synthetic */ Map<String, Long[]> invoke() {
            int i = 2 % 2;
            int i2 = $D8871 + 5;
            $component5 = i2 % 128;
            int i3 = i2 % 2;
            Map<String, Long[]> mapVD14832N6715 = vD14832N6715();
            int i4 = $component5;
            int i5 = (i4 ^ 121) + ((i4 & 121) << 1);
            $D8871 = i5 % 128;
            if (i5 % 2 == 0) {
                int i6 = 5 / 0;
            }
            return mapVD14832N6715;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x00b1 A[PHI: r4
          0x00b1: PHI (r4v6 java.lang.String) = (r4v5 java.lang.String), (r4v11 java.lang.String) binds: [B:12:0x0066, B:9:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
        public final Map<String, Long[]> vD14832N6715() {
            setPivotYN16904 setpivotyn16904;
            String strValueOf;
            FileTimestamps fileTimestampsComponent9;
            Long[] lArr;
            int i = 2 % 2;
            C10931 c10931 = C10931.this;
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = C10931.component5(c10931).iterator();
                while (it.hasNext()) {
                    int i2 = $component5;
                    int i3 = ((i2 | 113) << 1) - (i2 ^ 113);
                    $D8871 = i3 % 128;
                    if (i3 % 2 == 0) {
                        I30900 i30900 = (I30900) it.next();
                        strValueOf = String.valueOf(i30900.D8871());
                        fileTimestampsComponent9 = C10931.component9(c10931).component9(i30900.component5());
                        int i4 = 5 / 0;
                        if (fileTimestampsComponent9 != null) {
                            int iComponent9 = ak.AnonymousClass1.component9();
                            lArr = new Long[]{Long.valueOf(((Long) FileTimestamps.D8871(ak.AnonymousClass1.component9(), -1863356373, new Object[]{fileTimestampsComponent9}, 1863356375, ak.AnonymousClass1.component9(), ak.AnonymousClass1.component9(), iComponent9)).longValue()), Long.valueOf(fileTimestampsComponent9.component9()), Long.valueOf(fileTimestampsComponent9.component5())};
                            int i5 = $D8871;
                            int i6 = (i5 & 83) + (i5 | 83);
                            $component5 = i6 % 128;
                            int i7 = i6 % 2;
                        } else {
                            int i8 = $component5;
                            int i9 = ((i8 | 47) << 1) - (i8 ^ 47);
                            $D8871 = i9 % 128;
                            int i10 = i9 % 2;
                            lArr = null;
                        }
                    } else {
                        I30900 i30901 = (I30900) it.next();
                        strValueOf = String.valueOf(i30901.D8871());
                        fileTimestampsComponent9 = C10931.component9(c10931).component9(i30901.component5());
                        if (fileTimestampsComponent9 != null) {
                            int iComponent10 = ak.AnonymousClass1.component9();
                            lArr = new Long[]{Long.valueOf(((Long) FileTimestamps.D8871(ak.AnonymousClass1.component9(), -1863356373, new Object[]{fileTimestampsComponent9}, 1863356375, ak.AnonymousClass1.component9(), ak.AnonymousClass1.component9(), iComponent10)).longValue()), Long.valueOf(fileTimestampsComponent9.component9()), Long.valueOf(fileTimestampsComponent9.component5())};
                            int i11 = $D8871;
                            int i12 = (i11 & 83) + (i11 | 83);
                            $component5 = i12 % 128;
                            int i13 = i12 % 2;
                        } else {
                            int i14 = $component5;
                            int i15 = ((i14 | 47) << 1) - (i14 ^ 47);
                            $D8871 = i15 % 128;
                            int i16 = i15 % 2;
                            lArr = null;
                        }
                    }
                    linkedHashMap.put(strValueOf, lArr);
                    int i17 = $D8871 + 107;
                    $component5 = i17 % 128;
                    int i18 = i17 % 2;
                }
                setpivotyn16904 = new vD14832N6715(linkedHashMap);
            } catch (Throwable th) {
                setpivotyn16904 = new setPivotYN16904(th);
            }
            Map<String, Long[]> map = (Map) component9.component9(setpivotyn16904);
            int i19 = $D8871;
            int i20 = ((i19 | 87) << 1) - (i19 ^ 87);
            $component5 = i20 % 128;
            int i21 = i20 % 2;
            return map;
        }

        public static int D8871() {
            int i = component9;
            int i2 = i % 7895132;
            component9 = i + 1;
            if (i2 != 0) {
                return setPivotYN16904;
            }
            int iMyUid = Process.myUid();
            setPivotYN16904 = iMyUid;
            return iMyUid;
        }

        AnonymousClass1() {
            super(0);
        }
    }

    public final D8871<Map<String, Long[]>, Throwable> component9() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new AnonymousClass1(), 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 51;
                char c = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int i2 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1076;
                Object[] objArr2 = new Object[1];
                a((byte) 0, (short) 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(keyRepeatDelay, c, i2, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<Map<String, Long[]>, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i3 = setPivotYN16904 + 43;
            component9 = i3 % 128;
            int i4 = i3 % 2;
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
        setPivotYN16904 = 0;
        component9 = 1;
    }
}
