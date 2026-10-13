package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes6.dex */
public final class setTopP6481 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static int N14263A23323;
    private static char[] component5;
    private static int component8;
    private static long sG29839;
    private final String D8871;
    private final String component9;
    private final IntRange setPivotYN16904;
    private final String vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, int r7, short r8) {
        /*
            int r8 = r8 * 3
            int r0 = r8 + 1
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.setTopP6481.$$c
            int r6 = r6 * 3
            int r6 = r6 + 98
            int r7 = r7 * 2
            int r7 = 3 - r7
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r6 = r7
            r4 = r8
            r3 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L23:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r7 = r7 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setTopP6481.$$e(short, int, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.setTopP6481.$$a
            int r7 = r7 * 3
            int r1 = 4 - r7
            int r6 = 99 - r6
            int r8 = r8 * 3
            int r8 = r8 + 4
            byte[] r1 = new byte[r1]
            int r7 = 3 - r7
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2d
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2d:
            int r8 = r8 + r6
            int r6 = r8 + 6
            int r8 = r3 + 1
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setTopP6481.b(short, int, int, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{Ascii.SYN, Ascii.EM, 71, 62, 6, -5, 3};
        $$b = 146;
    }

    static void init$1() {
        $$c = new byte[]{49, 0, -7, -45};
        $$d = 175;
    }

    public setTopP6481(String str, String str2, String str3, IntRange intRange) {
        this.vD14832N6715 = str;
        this.component9 = str2;
        this.D8871 = str3;
        this.setPivotYN16904 = intRange;
    }

    public final String D8871() throws Throwable {
        int i = 2 % 2;
        int i2 = component8;
        int i3 = ((i2 | 1) << 1) - (i2 ^ 1);
        N14263A23323 = i3 % 128;
        int i4 = i3 % 2;
        Uri uri = Uri.parse(String.format(this.vD14832N6715, Arrays.copyOf(new Object[]{Integer.valueOf(ba.component9(this.setPivotYN16904, this.component9)), this.component9}, 2)));
        Intrinsics.checkNotNull(uri);
        Uri.Builder builderBuildUpon = uri.buildUpon();
        Intrinsics.checkNotNull(builderBuildUpon);
        String strComponent5 = I30900.uH18377.INSTANCE.component5();
        component8 component8Var = component8.INSTANCE;
        builderBuildUpon.appendQueryParameter(strComponent5, component8.D8871(this.D8871));
        String string = builderBuildUpon.build().toString();
        int i5 = N14263A23323;
        int i6 = (i5 & 121) + (i5 | 121);
        component8 = i6 % 128;
        int i7 = i6 % 2;
        return string;
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3;
        long j;
        int i4 = 2 % 2;
        ck ckVar = new ck();
        long[] jArr = new long[i2];
        ckVar.setPivotYN16904 = 0;
        while (ckVar.setPivotYN16904 < i2) {
            int i5 = ckVar.setPivotYN16904;
            try {
                Object[] objArr2 = {Integer.valueOf(component5[i + i5])};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                if (objComponent5 == null) {
                    int iResolveSize = View.resolveSize(0, 0) + 51;
                    char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                    int i6 = 5905 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte b = (byte) ($$d & 1);
                    i3 = -720328195;
                    byte b2 = $$c[1];
                    j = 0;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveSize, capsMode, i6, -173582907, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                } else {
                    i3 = -720328195;
                    j = 0;
                }
                Long l = (Long) ((Method) objComponent5).invoke(null, objArr2);
                l.longValue();
                Object[] objArr3 = {l, Long.valueOf(i5), Long.valueOf(sG29839), Integer.valueOf(c)};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                if (objComponent6 == null) {
                    int i7 = (ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1)) + 53;
                    char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    int i8 = 5059 - (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1));
                    byte b3 = $$c[1];
                    byte b4 = b3;
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(i7, minimumFlingVelocity, i8, 2120479290, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                }
                jArr[i5] = ((Long) ((Method) objComponent6).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {ckVar, ckVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(ImageFormat.getBitsPerPixel(0) + 52, (char) Gravity.getAbsoluteGravity(0, 0), (KeyEvent.getMaxKeyCode() >> 16) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr = new char[i2];
        ckVar.setPivotYN16904 = 0;
        while (ckVar.setPivotYN16904 < i2) {
            int i9 = $10 + 39;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
            Object[] objArr5 = {ckVar, ckVar};
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-720328195);
            if (objComponent8 == null) {
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getLongPressTimeout() >> 16) + 51, (char) (ViewConfiguration.getPressedStateDuration() >> 16), ExpandableListView.getPackedPositionType(0L) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
        }
        String str = new String(cArr);
        int i11 = $10 + 67;
        $11 = i11 % 128;
        int i12 = i11 % 2;
        objArr[0] = str;
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        N14263A23323 = 0;
        component8 = 1;
        char[] cArr = new char[1959];
        ByteBuffer.wrap("^Ô{\u009e\u0014\u009c1\u008eÊÐç\u0099\u0080\u0092]\u0090v\u0097\u0013\u0094,\u0098É\u0083â\u009f¿©X\u0094u\u0090\u000e\u008f+\u0098Ä\u008cá\u009bº\u009cW±p\u009e\r\u009c&\u0082Ã\u0081\u009c\u0084\u000f¤*îEì`þ\u009b ¶éÑâ\fà'çBä}è\u0098ó³ïîÙ\tõ$í_ëzÿ\u0095Æ°üëï\u0006ì!þ\\èw÷ôuÑ?¾=\u009b/`qM8*3÷1Ü6¹5\u00869c\"H>\u0015\bò'ß,¤$\u0081(÷ÝÒ\u0080½\u0089\u0098\u0082cÙN\u009a)\u009bô\u0091ß\u008fº\u0097\u0085\u009d`ÖK\u0099\u0016\u0090ñ\u0090Ü\u0099§\u0084\u0082\u008am\u0093H\u0089\u0013¹þ\u0085Ù\u0085¤\u0091\u008f\u009ej\u008e5\u009a\u0010\u0090^Ô{\u009f\u0014\u008d1\u009bÊÐç\u009a\u0080\u009a]Òv\u0083\u0013\u0080,\u009eÉ\u0080æ°Ãû¬é\u0089ÿr´_é8ðåõÎ¹«æ\u0094çqûZã^Ô{\u0089\u0014\u009d1\u009bÊ\u009eç\u008c\u0080\u0099]Óv¡\u0013´,¼É\u009fâ\u0081¿\u0093X±u\u0095\u000e\u009f+\u008bÁ?äu\u008bs®gUux:\u001f8Âtéh\u008cl³sVu}z r\u001a\u0018?\u0004PFu\u000b\u008e\u0001£\u0000Ä\u0018\u0019C2\u0010W\u0006h\u0004\u008d\u0013¦\tû\u000e\u001c\u00001:J\u0014o\u001e\u0080\f¥&þ\u001a\u0013\u00114\u000fILÕ\fð\u0010\u009fRº\u001fA\u0015l\u0014\u000b\fÖWý\u0004\u0098\u0012§\u0010B\u0007i\u001d4\u001aÓ\u0014þ.\u0085\u0000 \nO\u0018j21\u000eÜ\u0005û\u001b\u0086[^Ô{\u0089\u0014\u00801\u008bÊ\u008bç\u009b\u0080\u0090]Óv\u009f\u0013\u009b,\u0093Éßâ\u009b¿\u009fX\u0097u\u009a\u000e\u0089+ÄÄ\u009aá\u0087i\u001bL\u0011#\u001c\u0006\u0014ý\u0012Ð\u0004^Ô{\u0089\u0014\u00801\u008bÊ\u008bç\u009b\u0080\u0090]Óv\u0091\u0013\u009b,\u009fÉßâ\u0099¿\u0093X\u0098u\u0081\u000e½+§ÄÄá\u0086º\u008aW\u0083p\u0098\rÁ&\u0080Ã\u008d\u009c\u008f¹\u0094R\u0095o\u0089\b\u00895\u0003\u0010^\u007fWZ\\¡\\\u008cLëG6\u0004\u001dFxLGH¢\b\u0089NÔD3O\u001eVej@p¯\u0013\u008aOÑJ<V\u001bJ¥ß\u0080\u0082ï\u008bÊ\u00801\u0080\u001c\u0090{\u009b¦Ø\u008d\u0094è\u0090×\u00982Ô\u0019\u0090D\u0094£\u009c\u008e\u0091õ\u0085Ð\u008c?\u0097\u001aµA©¬\u0095\u008b\u0094ö\u0088Ý\u00988Çg\u0099B\u0084^Ô{\u009e\u0014\u009c1\u008eÊÐç\u0090\u0080\u0098]\u0091v\u0086\u0013\u0095,\u0084É\u0095â\u0084¿\u0082\u0080B¥^Ê\u001cïQ\u0014A9\\^Z\u0083S¨\u0016ÍQòU\u0017H<Hù¢Ü¨³¯\u0096¼m\u00ad@ç'¤ú®Ñ°^Ô{\u008a\u0014\u008b1\u0097Ê\u009cçÑ\u0080\u009b]\u0095v\u009f\u0013\u0097,\u0082É\u0089â\u0084¿\u0082X\u0090u\u0099\u000e\u0098\u0004\u008b!\u0081N\u008ak\u0093\u0090\u0092½\u0086^\u0089{\u0095\u0014×1\u0088Ê\u008dç\u0091\u0080\u0099]\u0089v\u0090\u0013\u0086,ßÉ\u009dâ\u0096¿\u0098X\u0080u\u0092\u000e\u008a+\u0089Ä\u009dá\u009dº\u009dW\u008bp\u009f^\u009c{\u009f\u0014\u00971\u0081\u0085û ïÏûêû\u0011æ<ý[ù\u0086¢\u00adðÈû÷ò\u0012®9ådâ\u0083«®àÕþðø\u001fì:ÿa±\u008cù«íÖéý½\u0018ôGðbû\u0089ò´ÉÓòþä%Þ@õoÛ\u008aÍ±ÁÜÊûÈ&ÞMÆhÐÚ\\ÿH\u0090\\µ\\NAcZ\u0004^Ù\u0005òW\u0097\\¨UM\tfB;EÜ\fñG\u008aY¯_@KeX>\u0016Ó^ôJ\u0089N¢\u001aGS\u0018W=\\ÖUën\u008cU¡Czy\u001fR0xÕjîf\u0083m¤eyy^\u008b{\u009f\u0014\u008b1\u008bÊ\u0096ç\u008d\u0080\u0089]Òv\u0080\u0013\u008b,\u0082ÉÞâ\u0095¿\u0092XÛu\u0090\u000e\u008e+\u0088Ä\u009cá\u008fºÁW\u009cp\u0082\rÂ&\u0080Ã\u0093\u009c\u0088^\u008b{\u009f\u0014\u008b1\u008bÊ\u0096ç\u008d\u0080\u0089]Òv\u0080\u0013\u008b,\u0082ÉÞâ\u0095¿\u0092XÛu\u0090\u000e\u008e+\u0088Ä\u009cá\u008fºÁW\u009cp\u0082\rÂ&\u008fÃ\u0083\u009c\u0082ò}×i¸}\u009d}f`K{,\u007fñ$Úv¿}\u0080te(Nc\u0013dô-Ùf¢x\u0087~hjMy\u00167ûjÜt¡4\u008axow0t^\u008b{\u009f\u0014\u008b1\u008bÊ\u0096ç\u008d\u0080\u0089]Òv\u0080\u0013\u008b,\u0082ÉÞâ\u0095¿\u0092XÛu\u0090\u000e\u008e+\u0088Ä\u009cá\u008fºÁW\u009cp\u0082\rÂ&\u008eÃ\u008c\u009c\u0082gfBs-}\bkógÞs\u0086Ò£ÎPEu\u001b\u001a\u001a?\u0006Ä\ré@\u008e\u0001S\u0002x\u0006\u001d\u0016\"\fÇ\u0004ì\u00157±\u0012¤}ªX¼£¤\u008e·é¤4³\u001f»LÛiø\u0006ð#æØõõö\u0092îOòdû\u0001ûÓ`öz\u0099|¼xG~jg\r}X1};\u0012\"7>Ì;á>\u0086![8\u0002ã'ÿH½mâ\u0096ç»ûÜó\u0001ã*úOìpµ\u0095þ¾øãê\u0004ö)ýRäL¥i°\u0006¾#¨Øïõà\u0092¥-1\b2g:B0¹ \u0094:ó3\u0082î§íÈåíï\u0016ÿ;å\\ì\u0081ÑªùÏ¸ðµÛ\u0006þ\u0005\u0091\r´\u0007O\u0017b\r\u0005\u0004Ø9ó\u0011\u0096P©]L5g[:Xé¦Ìº£ø\u0086§}¢P¾7¶ê¦Á¿¤©\u009bð~²U·\b½ï¿Â·fuCc,o^\u009e{\u0097\u0014\u008c1\u0094Ê\u009eç\u008a\u0080\u0092]\u008eÅ/à\u001f\u008f\u001cªMQ8|\u001e\u001b\u0006Æ\u001dí\u000f\u0088\n·\u0001REy\u0004$\fÃ\u0012îA\u0095=°\u0017_\u000ez\u0012!\u0017Ì\u001eÙ«ü\u0085\u0093\u008c¶\u009bM\u0081`\u0086\u0007\u0088ÚÍñ±\u0094§««NÁe\u00848\u0092ß\u008dò\u0089\u0089\u008e¬ÛC\u009ef\u0096=\u008cÐß÷\u0084\u008aÅ¡Ä^º{\u0094\u0014\u009d1\u008aÊ\u0090ç\u0097\u0080\u0099]Üv \u0013¶,ºÉÐâ\u0095¿\u0083X\u009cu\u0098\u000e\u009f+ÊÄ\u008fá\u0087º\u009dWÎp\u0095\rÔ&ÕÃ½\u009c×¹Ô£8\u0086$éfÌ!7/\u001a=}( :\u008b#î1Ñ%^\u009c{\u0095\u0014\u00951\u009cÊ\u0099ç\u0097\u0080\u008e]\u0094{ò^ç1é\u0014ÿï¸Â·^\u0089{\u009b\u0014\u00971\u009bÊ\u0097ç\u008b^\u0089{\u0095\u0014×1\u0088Ê\u008dç\u0091\u0080\u0099]\u0089v\u0090\u0013\u0086,ßÉ\u0092â\u0085¿\u0097X\u009bu\u0090Á ä<\u008b~®:U3x%\u001f:Â0é6\u008cu³)V<}3 *^Ê\u0007s\"oM-hq\u0093`¾gÙr\u0004t/l!B^\u0089{\u0095\u0014×1\u009aÊ\u008aç\u0097\u0080\u0091]\u0098vÝ\u0013\u0082,\u0083É\u009fâ\u0093¿\u0083X\u0096u\u0080õ\u0093Ð\u0081¿\u009b\u009a\u009aa®L\u0088+ËöÄ^\u0089{\u0095\u0014×1\u009aÊ\u008aç\u0097\u0080\u0091]\u0098vÝ\u0013\u0094,\u0098É\u009eâ\u0090¿\u0093X\u0087u\u0084\u000e\u0099+\u0083Ä\u0087á\u009cWßrÜ\u001dÔ8ÞÃÎîÔ\u0089ÝT\u0090\u007fÃ\u001aÕ%ÙÀ\u009cëÓ¶ÐQØ|Ò\u0007Ú\"ÀÍÉ^\u009c{\u009f\u0014\u00971\u009dÊ\u008dç\u0097\u0080\u009e]£v\u008b\u0013Ê,ÇÉßâ\u0084¿\u0092X\u009eu«\u000e\u0093+ÒÄßáÇº\u0088W\u008bp\u0083\r\u0089&\u0091Ã\u008b\u009c\u0082¹¿R\u009foÞ\bÓã\u000eÆ\r©\u0005\u008c\u000fw\u001fZ\u0005=\fàAË\u0006®\u000f\u0091\ft\u0005_\t\u0002\u0001å8È\u0015³\u001d\u0096\u0013yT\\\u001d\u0007\u0018ê\u0012Í\u001a°\f\u009b\u0018~\u0013TÉqÊ\u001eÂ;ÈÀØíÂ\u008aËW\u0086|Ð\u0019Å&ËÃÝè\u009aµ\u0095RÐ\u007f\u008e\u0004È!ÝÎÓëÅ°\u0082]\u008dzÈ³H\u0096AùBÜK'G\nOm\u0006°[\u009bCþMÁz$C\u000fSRJµN\u0098NãZÆa)E\f\u0004W\rº\u0015\u009d^à]ËY.SqGT]¿P\u0082måIÈ\b\u00139¿\u0097\u009a\u008bõÉÐ\u0084+\u008e\u0006\u008fa\u0097¼\u008e\u0097\u0082ò\u008dÍ\u008b(\u008b\u0003\u009b^\u0089{\u0095\u0014×1\u009aÊ\u0090ç\u0091\u0080\u0089]\u0095v\u009e\u0013\u0093,\u0096É\u0095âÙ¿\u0094X\u0080u\u009d\u000e\u0087+\u008eÄÇá\u008eº\u0086W\u0080p\u008a\r\u0089&\u0091Ã\u0092\u009c\u0093¹\u0089R\u0089o\u0092^º{\u0094\u0014\u009d1\u008aÊ\u0090ç\u0097\u0080\u0099]Ñv\u008b\u0013Ê,Ç?9\u001a%ugP*«:\u0086'á!<(\u0017mr&M(¨3\u00837Þ*9$\u0014=ouJ3¥=Û*þ:\u0091/´)Ow^\u0092{\u0094\u0014\u00901\u008cÊÑç\u008d\u0080\u008b]\u009fvÝ\u0013\u0083,\u0094É\u009dâ\u0082¿ÛX\u0085u\u0086\u000e\u0084+\u009aÄ\u009aâîÇû¨ð\u008dévµ[ò<îá¶Êú¯÷\u0090üuú^ø\u0003÷äèÉãSÂv×\u0019Ü<ÅÇ\u0099êÅ\u008dÓP\u009a{Ý\u001eÛ!ÒÄÝïà²ÝUÜxÑ\u0003Æ&ÐÉÀ\u000e8+-D&a?\u009ac·?Ð)\r`&-C#|'\u0099\u001d²!ï!\b)%5^0{,\u0094\"9¸\u001c¤sæV¢\u00ad«\u0080½ç¢:¨\u0011®tíK¡®¯\u0085¢Øµ?«\u0012¬i¾Lõ£©\u0086¼Ý³0ª\u0017¸^\u0089{\u0095\u0014×1\u009aÊ\u0090ç\u0091\u0080\u0089]Òv\u0082\u0013\u0097,\u009cÉ\u0085âÙ¿\u0097X\u0083u\u0090\u000e´+\u0084Ä\u0088á\u0085º\u008a^\u0089{\u0095\u0014×1\u0097Ê\u009bç\u0093\u0080Ó]\u009ev\u0086\u0013\u009b,\u009dÉ\u0094âÙ¿\u0090X\u009cu\u009a\u000e\u008c+\u008fÄ\u009bá\u0098º\u009dW\u0087p\u0083\r\u0098^\u0089{\u0095\u0014×1\u0088Ê\u008dç\u0091\u0080\u0099]\u0089v\u0090\u0013\u0086,ßÉ\u0092â\u0082¿\u009fX\u0099u\u0090\u000eÅ+\u008cÄ\u0080á\u0086º\u0088W\u008bp\u009f\r\u009c&\u0091Ã\u008b\u009c\u008f¹\u0094¼B\u0099^ö\u001cÓ@(M\u0005FbB¿R\u0094Uñ\u0017ÎX+N\u0000U]QºZ\u0097\u0011ìFÉH&L\u0003DXAµW\u0092VïUÄA!G~^Ã\u009bæ\u0087\u0089Å¬\u0099W\u0094z\u009f\u001d\u009bÀ\u008bë\u008c\u008e¿±\u0086T\u009a\u007f\u0091\"ÊÅ\u0085è\u0093\u0093\u0090¶\u0094Y\u009f|Ô'\u009bÊ\u0095í\u0091\u0090\u0099»\u0094^\u0082\u0001\u0083$\u0080Ï\u009cò\u009a\u0095\u0083%z\u0000fo$J}±i\u009ccûj&`\rrh/W`²v\u0099mÄi#b\u000e)u~Pp¿t\u009a|Áy,o\u000bnvm]y¸\u007fçf^\u0089{\u0095\u0014×1\u008eÊ\u009aç\u0090\u0080\u0099]\u0093v\u0081\u0013\u00ad,\u0095É\u009câ\u009c¿\u009bXÛu\u0096\u000e\u009e+\u0083Ä\u0085á\u008cºÁW\u0088p\u0084\r\u0082&\u0084Ã\u0087\u009c\u0093¹\u0090R\u0095o\u008f\b\u008b%\u0090^Á^Ô{\u009e\u0014\u009c1\u008eÊÐç\u008f\u0080\u0098]\u0091v\u0086\u0013\u00ad,\u0081É\u0099â\u0087¿\u0093'\u008e\u0002ÄmÆHÔ³\u008a\u009e×ùÈ$Å\u000fÂjÍUß°\u0085\u009bÏÆÍ!Ü\fËwÓRÑ½Ý\u0098ÖÃê.Ó\tÒtØ_ÀºÜ\u0006h#\"L i2\u0092l¿1Ø.\u0005#.$K+t9\u0091cº,ç/\u0000'-1V3^Ô{\u009e\u0014\u009c1\u008eÊÐç\u008d\u0080\u0092]\u009fv\u0098\u0013\u0097,\u0085Éßâ\u0086¿\u0093X\u0098u\u0081\u000e\u008f^Ô{\u0089\u0014\u00801\u008bÊÐç\u008f\u0080\u0098]\u0091v\u0086\u0013\u00ad,\u0085É\u0082â\u0096¿\u0095X\u00907[\u0012\u0006}\u000fX\u0004£\u0004\u008e\u0014é\u001f4\\\u001f\u0010z\u0014E\u001c P\u008b\u0014Ö\u00101\u0018\u001c\u0018g;B\b\u00ad\u0007\u0088\u000bÓ\f>\u000e\u0019\u0001d<O\bª\bõ\fÐ\u001a;\u000f\u00066a\u001bL\u000e\u00979ò Ýx8$\u0003?3¤\u0016îyì\\þ§ \u008aìíþ0ø\u001bÜ~åAñ¤ógãB©-«\b¹óçÞ«¹¹d¿O\u009b*±\u0015¯ðªÛ¥\u001c´9þVüsî\u0088°¥íÂò\u001fÿ4øQ÷nå\u008b¿ õýå\u001aá7òLäiæ\u0086í£íøý\u0015êR\u0017wJ\u0018C=HÆHëX\u008cSQ\u0010z\\\u001fX PÅ\u001cîX³\\TTyU\u0002[']ÈLíD¶@[I|K\u0001]*\u007fÏK\u0090LµJ^\ncV\u0004I^Ô{\u009e\u0014\u009c1\u008eÊÐç\u009c\u0080\u008e]\u0088v\u0092\u0013\u0091,\u0092É\u0095\u001134y[{~i\u00857¨{Ïi\u0012o9s\\lcd\u0086x\u0012\u001b7QXS}A\u0086\u001f«SÌA\u0011G:Q_X`Y\u0085Q=¦\u0018ìwîRü©¢\u0084îãü>ú\u0015îpòOêªçÐðõº\u009a¸¿ªDôi¸\u000eªÓ¬ø¡\u009d»¢¦G³^Ô{\u009e\u0014\u009c1\u008eÊÐç\u009c\u0080\u008e]\u0088v\u0083\u0013\u0095,\u0090É\u0099â\u0087¿\u0095^Ô{\u009e\u0014\u009c1\u008eÊÐç\u009c\u0080\u008e]\u0088v¬\u0013\u009b,\u009cÉ\u0095ïEÊ\u000f¥\t\u0080\u001d{\u000fV@1\bì\u0002Ç\u0015¢\r\u009d\fx\u000eS\u0007\u000e\u0003é\u0017ÄJ¿T\u009a\u0003u\u001aPV\u000b\u001cæ\fÁ\b¼\u0016^Ô{\u0097\u0014\u00971\u008cÊÐç\u0089\u0080\u0094]\u0092v\u0097\u0013\u009d,\u0086É\u0083âØ¿´X\u0086u\u0080\u000e¸+\u0082Ä\u0088á\u009aº\u008aW\u008ap«\r\u0083&\u008fÃ\u0086\u009c\u0084¹\u0092^Ô{\u008a\u0014\u008b1\u0097Ê\u009cçÑ\u0080\u0094]\u0093v\u0083\u0013\u009d,\u0083É\u0084â\u0084\u0089Ì¬\u009bÃ\u0098æß\u001dÂ^Ô{\u008a\u0014\u008b1\u0097Ê\u009cçÑ\u0080\u008e]\u0099v\u009f\u0013\u0094,ÞÉ\u009dâ\u0096¿\u0086X\u0086^\u009c{\u0088\u0014\u00981\u0094Ê\u0093ç\u0091\u0080\u009e]Òv\u0094\u0013\u009d,\u009dÉ\u0094â\u0091¿\u009fX\u0086u\u009c\u000eÅ+\u0099Ä\u0086^\u0097{\u0093\u0014\u009b1¿Ê³ç»\u0080®]£v\u0091\u0013\u0081,\u0085ÉÞâ\u0084¿\u0099Xü}·\u0012¥7³Ìøá»\u0086°[°p²\u0015»*\u0086Ï»ä°¹º^¸s¿\b°-ìÂ¹ç\u00ad¼«eÂ@Í/×\nÆñ×ÜÑ»ÇfÄMÃ(Ú^Ô{\u009f\u0014\u008d1\u009bÊÐç\u0093\u0080\u0092]\u0089v\u009d\u0013\u0086,\u0082FØc\u0092\f\u0094)\u0080Ò\u0092ÿÝ\u0098\u0095E\u009fn\u0088\u000b\u00904\u0091Ñ\u0093ú\u009a§\u009e@\u008am×\u0016É3\u0082Ü\u0095ùË¢\u0082O\u0092h\u0091\u0015\u0093>ÁÛ\u0096\u0084\u0080¡\u0080¸Ì\u009d\u0092ò\u0093×\u008f,\u0084\u0001Éf\u0086»\u0094\u0090\u009eõ\u0083Ê\u0087/\u008e\u0004\u0080/Q\nxex@q»t\u0096zñc,y^Ô{\u009e\u0014\u00981\u008cÊ\u009eçÑ\u0080\u0090]\u0095v\u0080\u0013\u0091,ÞÉ\u0080â\u0085¿\u0099X\u0093u\u009d\u000e\u0087+\u008fÄ\u009aáÇº\u008cW\u009bp\u009f\rÃ&ÓÃÍ\u009c\u0082¹\u008fR\u008aoÈ\b\u0088%\u008dþ¸\u009b¨´¶Q®j¶\u0007¬ ©ýò\u0096¾³·L¼i¥\u0002¾ß»ø°".getBytes("ISO-8859-1")).asCharBuffer().get(cArr, 0, 1959);
        component5 = cArr;
        sG29839 = -8258129005105480710L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] vD14832N6715(android.content.Context r61, int r62, int r63, int r64) {
        /*
            Method dump skipped, instruction units count: 14998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setTopP6481.vD14832N6715(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
