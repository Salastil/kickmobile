package com.fingerprintjs.android.fpjs_pro;

import android.content.Context;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.media3.muxer.WebmConstants;
import androidx.work.WorkInfo;
import com.fingerprintjs.android.fpjs_pro.Configuration;
import com.fingerprintjs.android.fpjs_pro_internal.getContextMenuInfo;
import com.fingerprintjs.android.fpjs_pro_internal.getLeftK29400;
import com.fingerprintjs.android.fpjs_pro_internal.getXH31455;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/FingerprintJSFactory;", "", "Landroid/content/Context;", "applicationContext", "<init>", "(Landroid/content/Context;)V", "Lcom/fingerprintjs/android/fpjs_pro/Configuration;", "configuration", "Lcom/fingerprintjs/android/fpjs_pro/FingerprintJS;", "createInstance", "(Lcom/fingerprintjs/android/fpjs_pro/Configuration;)Lcom/fingerprintjs/android/fpjs_pro/FingerprintJS;", "Lcom/fingerprintjs/android/fpjs_pro_internal/getXH31455;", "delegate", "Lcom/fingerprintjs/android/fpjs_pro_internal/getXH31455;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FingerprintJSFactory {
    private final getXH31455 delegate;

    public FingerprintJSFactory(Context context) {
        this.delegate = new getXH31455(context);
    }

    public final FingerprintJS createInstance(final Configuration configuration) {
        final getXH31455 getxh31455 = this.delegate;
        return new getContextMenuInfo(new Function0<getLeftK29400>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.getXH31455.3
            private static final byte[] $$a = null;
            private static final int $$b = 0;
            private static final byte[] $$c = null;
            private static final int $$d = 0;
            private static int $10;
            private static int $11;
            private static int $D8871;
            private static int $component9;
            private static long component5;
            private /* synthetic */ Configuration $vD14832N6715;

            /* JADX WARN: Code duplicated, block: B:10:0x0026  */
            /* JADX WARN: Code duplicated, block: B:8:0x0020  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r7, byte r8, short r9) {
                /*
                    int r9 = r9 * 4
                    int r9 = 3 - r9
                    int r7 = r7 * 4
                    int r7 = r7 + 1
                    byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.getXH31455.AnonymousClass3.$$c
                    int r8 = r8 * 2
                    int r8 = r8 + 104
                    byte[] r1 = new byte[r7]
                    r2 = 0
                    r3 = r9
                    if (r0 != 0) goto L16
                    r5 = r2
                    goto L2e
                L16:
                    r9 = r8
                    r8 = r3
                    r3 = r2
                L19:
                    byte r4 = (byte) r9
                    int r5 = r3 + 1
                    r1[r3] = r4
                    if (r5 != r7) goto L26
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    return r7
                L26:
                    int r8 = r8 + 1
                    r3 = r0[r8]
                    r6 = r9
                    r9 = r8
                    r8 = r3
                    r3 = r6
                L2e:
                    int r8 = -r8
                    int r8 = r8 + r3
                    r3 = r9
                    r9 = r8
                    r8 = r3
                    r3 = r5
                    goto L19
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getXH31455.AnonymousClass3.$$e(int, byte, short):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0023  */
            /* JADX WARN: Code duplicated, block: B:8:0x001a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0027). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(int r5, int r6, short r7, java.lang.Object[] r8) {
                /*
                    int r5 = r5 + 4
                    int r0 = r6 + 1
                    byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.getXH31455.AnonymousClass3.$$a
                    int r7 = 115 - r7
                    byte[] r0 = new byte[r0]
                    r2 = -1
                    if (r1 != 0) goto L10
                    r7 = r5
                    r3 = r6
                    goto L27
                L10:
                    r4 = r7
                    r7 = r5
                    r5 = r4
                L13:
                    int r2 = r2 + 1
                    byte r3 = (byte) r5
                    r0[r2] = r3
                    if (r2 != r6) goto L23
                    java.lang.String r5 = new java.lang.String
                    r6 = 0
                    r5.<init>(r0, r6)
                    r8[r6] = r5
                    return
                L23:
                    int r7 = r7 + 1
                    r3 = r1[r7]
                L27:
                    int r3 = -r3
                    int r5 = r5 + r3
                    int r5 = r5 + (-5)
                    goto L13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getXH31455.AnonymousClass3.b(int, int, short, java.lang.Object[]):void");
            }

            static void init$0() {
                $$a = new byte[]{33, 84, 42, -62, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9, 7, -5, -4, 1, -17, -6, -14};
                $$b = WebmConstants.MkvEbmlElement.BLOCK_MORE;
            }

            static void init$1() {
                $$c = new byte[]{58, -40, 114, 119};
                $$d = 209;
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ getLeftK29400 invoke() throws Throwable {
                int i = 2 % 2;
                int i2 = $D8871 + 69;
                $component9 = i2 % 128;
                int i3 = i2 % 2;
                getLeftK29400 pivotYN16904 = setPivotYN16904();
                int i4 = $D8871 + 37;
                $component9 = i4 % 128;
                int i5 = i4 % 2;
                return pivotYN16904;
            }

            public final getLeftK29400 setPivotYN16904() throws Throwable {
                int i = 2 % 2;
                component8T18414 component8t18414 = new component8T18414(getXH31455.setPivotYN16904(getXH31455.this), CollectionsKt.plus((Collection) CollectionsKt.listOf(configuration.getEndpointUrl()), (Iterable) configuration.getFallbackEndpointUrls()), configuration.getApiKey(), configuration.getExtendedResponseFormat(), configuration.getIntegrationInfo(), configuration.getAllowUseOfLocationData(), configuration.getLocationTimeoutMillis(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, 65535, null);
                List<String> list = component8t18414.component10;
                String str = component8t18414.component9;
                boolean z = component8t18414.setTopP6481U32634;
                List<Pair<String, String>> list2 = component8t18414.C20232;
                String str2 = component8t18414.vD14832N6715;
                boolean z2 = component8t18414.setTopP6481U32634;
                setAutofillHintsI14457 setautofillhintsi14457 = component8t18414.getExplicitStyle;
                bv bvVar = new bv(component8t18414.cW27173, component8t18414.cW27173, true);
                bq.Companion companion = bq.INSTANCE;
                try {
                    Object[] objArr = {new cW27173(bq.Companion.setPivotYN16904(setautofillhintsi14457, bvVar), z2), list, str, component8t18414.A29214, str2, Boolean.valueOf(z), list2};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1955282514);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(79 - (KeyEvent.getMaxKeyCode() >> 16), (char) (54959 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 171 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -641628723, false, null, new Class[]{rP23717.class, List.class, String.class, String.class, String.class, Boolean.TYPE, List.class});
                    }
                    Object objNewInstance = ((Constructor) objComponent5).newInstance(objArr);
                    component6.vD14832N6715 vd14832n6715 = new component6.vD14832N6715(new r(component8t18414.component4S4936), new getContextMenuInfoA21117(component8t18414.A22588, component8t18414.component8), new al(component8t18414.K15285), component8t18414.vD14832N6715, component8t18414.iA15411, component8t18414.Y16199, new iF17194E13054(new F16286()), new am(component8t18414.setTopP6481), new getEntries(), new copy(component8t18414.setTopP6481), component8t18414.component8, component8t18414.getPivotYV11332, component8t18414.xQ31420, component8t18414.getKeepScreenOn, component8t18414.INSTANCE, component8t18414.ENTRIES, component8t18414.N11182, component8t18414.getContentSensitivity, component8t18414.setContentDescriptionR23122, component8t18414.setContentSensitivity, component8t18414.component12, component8t18414.F2572, component8t18414.component11, component8t18414.setOnLongClickListener, component8t18414.component13);
                    setAutofillHintsI14457 setautofillhintsi14458 = component8t18414.getExplicitStyle;
                    bq.Companion companion2 = bq.INSTANCE;
                    Object[] objArr2 = {bq.Companion.setPivotYN16904(setautofillhintsi14458, null), new setTopP6481(component8t18414.kC4266, component8t18414.component9, component8t18414.A29214, component8t18414.rP23717)};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(69586646);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(55 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), Color.alpha(0) + 60, 1452313269, false, null, new Class[]{bn.class, setTopP6481.class});
                    }
                    Object objNewInstance2 = ((Constructor) objComponent6).newInstance(objArr2);
                    an anVar = component8t18414.yY18494;
                    Object[] objArr3 = {component8t18414.cW27173};
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2147068643);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getDoubleTapTimeout() >> 16) + 52, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 58264), 2102 - ((Process.getThreadPriority(0) + 20) >> 6), 760016512, false, null, new Class[]{bt.class});
                    }
                    getYJ21310 getyj21310 = new getYJ21310(objNewInstance, vd14832n6715, new zI26963(objNewInstance2, anVar, new uH18377((ca) ((Constructor) objComponent7).newInstance(objArr3)), component8t18414.component8, component8t18414.sG29839), component8t18414.getExplicitStyle, component8t18414.setContentDescriptionR23122);
                    int i2 = $D8871 + 53;
                    $component9 = i2 % 128;
                    int i3 = i2 % 2;
                    return getyj21310;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }

            private static void a(String str, int i, Object[] objArr) throws Throwable {
                int i2;
                int i3;
                int i4 = 2 % 2;
                char[] charArray = str != null ? str.toCharArray() : str;
                cb cbVar = new cb();
                cbVar.setPivotYN16904 = i;
                int length = charArray.length;
                long[] jArr = new long[length];
                cbVar.D8871 = 0;
                int i5 = $11 + 35;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                while (cbVar.D8871 < charArray.length) {
                    int i7 = cbVar.D8871;
                    try {
                        Object[] objArr2 = {Integer.valueOf(charArray[cbVar.D8871]), cbVar, cbVar};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                        if (objComponent5 == null) {
                            i2 = 55223;
                            i3 = 2106881226;
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getWindowTouchSlop() >> 8) + 52, (char) (AndroidCharacter.getMirror('0') + 60645), TextUtils.lastIndexOf("", '0', 0) + 5956, 148978589, false, $$e(0, (byte) 1, (short) 0), new Class[]{Integer.TYPE, Object.class, Object.class});
                        } else {
                            i2 = 55223;
                            i3 = 2106881226;
                        }
                        jArr[i7] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (component5 ^ (-1805496993403714128L));
                        Object[] objArr3 = {cbVar, cbVar};
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                        if (objComponent6 == null) {
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 51, (char) (TextUtils.indexOf("", "") + i2), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3269, 790704297, false, $$e(0, (byte) 0, (short) 0), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent6).invoke(null, objArr3);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                char[] cArr = new char[length];
                cbVar.D8871 = 0;
                while (cbVar.D8871 < charArray.length) {
                    cArr[cbVar.D8871] = (char) jArr[cbVar.D8871];
                    Object[] objArr4 = {cbVar, cbVar};
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 52, (char) (55223 - KeyEvent.getDeadChar(0, 0)), (ViewConfiguration.getLongPressTimeout() >> 16) + 3269, 790704297, false, $$e(0, (byte) 0, (short) 0), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent7).invoke(null, objArr4);
                }
                String str2 = new String(cArr);
                int i8 = $10 + 73;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    throw null;
                }
                objArr[0] = str2;
            }

            static {
                init$1();
                $10 = 0;
                $11 = 1;
                init$0();
                $D8871 = 0;
                $component9 = 1;
                component5 = 2927917093208566005L;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v74, types: [int] */
            /* JADX WARN: Type inference failed for: r7v40 */
            /* JADX WARN: Type inference failed for: r7v41 */
            /* JADX WARN: Type inference failed for: r7v55 */
            /* JADX WARN: Type inference failed for: r7v56 */
            /* JADX WARN: Type inference failed for: r7v57 */
            /* JADX WARN: Type inference failed for: r7v58 */
            /* JADX WARN: Type inference failed for: r7v59 */
            /* JADX WARN: Type inference failed for: r7v60 */
            /* JADX WARN: Type inference failed for: r7v66, types: [int] */
            /* JADX WARN: Type inference failed for: r7v68 */
            /* JADX WARN: Type inference failed for: r7v69 */
            /* JADX WARN: Type inference failed for: r7v71, types: [int] */
            /* JADX WARN: Type inference failed for: r7v72 */
            /* JADX WARN: Type inference failed for: r7v73 */
            /* JADX WARN: Type inference failed for: r7v84 */
            /* JADX WARN: Type inference failed for: r7v90 */
            /* JADX WARN: Type inference failed for: r7v91 */
            /* JADX WARN: Type inference failed for: r7v92 */
            /* JADX WARN: Type inference failed for: r7v93 */
            /* JADX WARN: Type inference failed for: r7v94 */
            /* JADX WARN: Type inference failed for: r7v95 */
            /* JADX WARN: Type inference failed for: r7v96 */
            /* JADX WARN: Type inference failed for: r7v97 */
            /* JADX WARN: Type inference failed for: r7v98 */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
                	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] D8871(android.content.Context r32, int r33, int r34, int r35) {
                /*
                    Method dump skipped, instruction units count: 2189
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getXH31455.AnonymousClass3.D8871(android.content.Context, int, int, int):java.lang.Object[]");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3() {
                super(0);
                configuration = configuration;
            }
        });
    }
}
