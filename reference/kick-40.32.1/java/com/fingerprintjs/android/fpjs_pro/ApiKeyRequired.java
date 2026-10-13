package com.fingerprintjs.android.fpjs_pro;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.fingerprintjs.android.fpjs_pro_internal.ck;
import com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/ApiKeyRequired;", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "requestId", "errorDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ApiKeyRequired extends Error {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static int component5;
    private static long component9;
    private static char[] setPivotYN16904;
    private static int vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, byte r6, byte r7) {
        /*
            int r5 = r5 * 4
            int r5 = 3 - r5
            int r6 = r6 * 3
            int r6 = r6 + 98
            int r7 = r7 * 2
            int r0 = 1 - r7
            byte[] r1 = com.fingerprintjs.android.fpjs_pro.ApiKeyRequired.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L19
            r6 = r5
            r4 = r7
            r3 = r2
            goto L2e
        L19:
            r3 = r6
            r6 = r5
            r5 = r3
            r3 = r2
        L1d:
            byte r4 = (byte) r5
            r0[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L2a
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L2a:
            int r3 = r3 + 1
            r4 = r1[r6]
        L2e:
            int r4 = -r4
            int r5 = r5 + r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro.ApiKeyRequired.$$e(short, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 99 - r8
            int r6 = r6 * 3
            int r6 = 7 - r6
            int r7 = r7 * 3
            int r0 = r7 + 1
            byte[] r1 = com.fingerprintjs.android.fpjs_pro.ApiKeyRequired.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L15
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2b
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r1[r6]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r5
        L2b:
            int r6 = -r6
            int r3 = r3 + r6
            int r6 = r3 + 6
            int r8 = r8 + 1
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro.ApiKeyRequired.b(short, short, int, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{124, 59, 115, Ascii.VT, -6, 5, -3};
        $$b = 168;
    }

    static void init$1() {
        $$c = new byte[]{3, -60, 87, 80};
        $$d = 209;
    }

    public ApiKeyRequired(String str, String str2) {
        super(str, str2, null);
    }

    private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3;
        int i4 = 2 % 2;
        ck ckVar = new ck();
        long[] jArr = new long[i2];
        ckVar.setPivotYN16904 = 0;
        while (ckVar.setPivotYN16904 < i2) {
            int i5 = ckVar.setPivotYN16904;
            try {
                Object[] objArr2 = {Integer.valueOf(setPivotYN16904[i + i5])};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((Process.getThreadPriority(0) + 20) >> 6), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 5904, -173582907, false, $$e((short) 0, (byte) 1, (byte) 0), new Class[]{Integer.TYPE});
                }
                Long l = (Long) ((Method) objComponent5).invoke(null, objArr2);
                l.longValue();
                Object[] objArr3 = {l, Long.valueOf(i5), Long.valueOf(component9), Integer.valueOf(c)};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                if (objComponent6 == null) {
                    i3 = -720328195;
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 53, (char) TextUtils.indexOf("", "", 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 5057, 2120479290, false, $$e((short) 0, (byte) 0, (byte) 0), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                } else {
                    i3 = -720328195;
                }
                jArr[i5] = ((Long) ((Method) objComponent6).invoke(null, objArr3)).longValue();
                Object[] objArr4 = {ckVar, ckVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollDefaultDelay() >> 16) + 51, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1)) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i6 = $10 + 83;
                $11 = i6 % 128;
                int i7 = i6 % 2;
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
        int i8 = $10 + 85;
        $11 = i8 % 128;
        int i9 = i8 % 2;
        while (ckVar.setPivotYN16904 < i2) {
            cArr[ckVar.setPivotYN16904] = (char) jArr[ckVar.setPivotYN16904];
            Object[] objArr5 = {ckVar, ckVar};
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-720328195);
            if (objComponent8 == null) {
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(((byte) KeyEvent.getModifierMetaStateMask()) + 52, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), (KeyEvent.getMaxKeyCode() >> 16) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        component5 = 0;
        vD14832N6715 = 1;
        char[] cArr = new char[1959];
        ByteBuffer.wrap("^Ô0\u008b\u0082¶\u0014±æ\u0084xøÊì\\\u001b.?\u0080)\u0012ZäTvcÉ [\u0082-³¿ß\u0011ÝãöuôÇ\u0018Y\u0000+0½G\u000fzálp\u0096×ö¹©\u000b\u0094\u009d\u0093o¦ñÚCÎÕ9§\u001d\t\u000b\u009bxmvÿA@\u0082Ò±¤\u009c6é\u0098èjîüÁN9Ð\u000f¢\u00024a\u0086]a\n\u000fU½h+oÙZG&õ2cÅ\u0011á¿÷-\u0084Û\u008aI½ö~dN\u0012p\u0080\u000b.\u0012\u0005\u0083kËÙýOã½Ó#¥\u0091»\u0007DuyÛtI\u0001¿_-;\u0092Ç\u0000Øvää\u008aJ\u0091¸·.¸\u009cc\u0002jpuæ\u0014T8º=+Ö\u0099Éåq\u008b/9\u0002¯\u0001]!Ã^qAçü\u0095\u008e;\u0098©ù_òÏV¡\b\u0013%\u0085&w\u0006én[hÍ\u0098¿÷\u0011½\u0083ÃuÊçù^Ô0\u009c\u0082·\u0014¤æÊxíÊç\\X.\t\u0080\t\u0012~äHv}É\u009a[§-¶¿Ï\u0011Î^Ô0\u008b\u0082²\u0014³æÊx°Ê\u00ad\\\u0014.+\u0080:\u0012ZäIvmÉ\u0090^\u00890\u0080\u0082ý\u0014¥æÄxðÊ÷\\Y.)\u0080*\u0012WäUvdÉ\u0096[\u0087-\u0088¿Õ\u0011ÊãçuØÇ\u000fY1+0½\u0006Ä8ª1\u0018L\u008e\u0014|uâAPFÆè´\u0098\u001a\u009b\u0088æ~äìÕS'Á6·9%d\u008b{yVïi]¾Ã\u0080±\u0081'´÷P\u0099\u0018+.½0O[Ñ~cjõÜ\u0087³)¢»ÕM\u008cßã`\u0012ò\u0005\u0084=\u0016]¸\u0005JdÜl\u001f\u000fq\u0010Ã\"U?§R9q^Ô0\u009c\u0082ª\u0014´æßxúÊî\\X.9\u0080&\u0012]ä\bveÉ\u009a[\u008e-¢¿í\u0011âã¾uéÇ\u000eY2+6½\u001a\u000fxá`p\u009dÂ\u0093T¹&Ð¸ÏóÔ\u009d\u009c/ª¹´KßÕúgîñX\u00839-&¿]I\bÛed\u009aö\u008e\u0080¢\u0012í¼âN¾Ø÷j\u0019ô0\u00863^Ô0\u009c\u0082ª\u0014´æßxúÊî\\X.7\u0080&\u0012Qä\bvgÉ\u0096[\u0081-¹¿Þ\u0011ÂãæuÑÇ&Y/+1½X\u000fká!p\u0080Â\u0088SÆ=\u0099\u008f¤\u0019£ë\u0096uãÇôQ\b#<\u008d:\u001fTéP{jÄ\u0099W\u008a9\u0083\u008bþ\u001d¦ïÝqõÃìU\u0010'v\u0089$\u001b_íW\u007f|^\u00950\u008a\u0082²\u0014´æÎx±Êí\\\u0012./Ã2\u00ady\u001fG\u0089N{.åVW\u0003Áø³Ñ\u001dÌ\u008f¦y¸ë\u009eTmÆ`°\\\".^\u00950\u008a\u0082¾\u0014²æØxù<ñRøà\u0085vÏ\u0084¡\u001a\u0088¨\u009f>zL@âCpe\u00862\u0014\u0012«é9îOÉÝ¢s´\u0081\u009f\u0017\u008a¥a;BII^\u009c0\u008a\u0082½\u0014¾^\u008b0\u008a\u0082¡\u0014´æÂxìÊ÷\\Y.(\u00806\u0012@ä\tviÉ\u009b[Í-³¿Þ\u0011ÍãæuàÇEY8+3½B\u000f5áip\u0092Â\u008cT®&à¸Ä\nç\u009c\u000en0À!R\"$E¶{\bf\u009b\u0085m¾ÿ½èw\u0086v4]¢HP>Î\u0010|\u000bê¥\u0098Ô6Ê¤¼RõÀ\u0095\u007fgí1\u009bO\t\"§1U\u001aÃ\u001cq¹ïÄ\u009dÏ\u000b¾¹ÉW\u0095ÆntpâR\u0090\u001c\u000e8¼\u001b*òØÌvÙäÞ\u0092¹\u0000\u0087¾\u0090-y^\u008b0\u008a\u0082¡\u0014´æÂxìÊ÷\\Y.(\u00806\u0012@ä\tviÉ\u009b[Í-³¿Þ\u0011ÍãæuàÇEY-+,½\u0019\u000fxá~p\u009a<\u000bR\nà!v4\u0084B\u001al¨w>ÙL¨â¶pÀ\u0086\u0089\u0014é«\u001b9MO3Ý^sM\u0081f\u0017`¥Å;\u00adI¬ß\u0099m÷\u0083î\u0012\u0010dð\nñ¸Ú.ÏÜ¹B\u0097ð\u008cf\"\u0014SºM(;ÞrL\u0012óàa¶\u0017È\u0085¥+¶Ù\u009dO\u009bý>cV\u0011W\u0087b5\rÛ\u0017Jë^\u008b0\u008a\u0082¡\u0014´æÂxìÊ÷\\Y.(\u00806\u0012@ä\tviÉ\u009b[Í-³¿Þ\u0011ÍãæuàÇEY-+,½\u0019\u000fváap\u0090*¢D¢ö\u0093`\u0090\u0092÷\fÖ^§0®ÿ\u0005\u0091N#pµyG\u0019Ùak?ýÉ\u008fî!ë³\u008eE\u0093×©£þÍþ\u007fÏéÌ\u001b¿\u0085\u00997\u0095¡wÓ\\¬\u0005Â3p\u0004æ\u0007\u0014\u007f\u008aI8N®§Ü\u008dr\u0098^\u008e0\u0081\u0082¸\u0014©æÄxèÊí^\u00980\u0087\u0082¡\u0014¨æÆxöÊö\\\u001a^\u00890\u0080\u0082ý\u0014·æÙxðÊç\\\u0002.8\u0080;\u0012\u001däCvnÉ\u0089[\u008a-´¿Þvõ\u0018õªÄ<ÇÎëPÑâ\u008b(¦F°ô\u0087b\u0098\u0090ã\u000eÌ¼Ú¸\u0088Ö\u009ed©ò¶\u0000Í\u009eâ,ôº<È7fcô\u0011\u0002ml{ÞLHSº($\u0007\u0096\u0011\u0000ÙrÒÜ\u0086Nô¸\u0089*Ì\u0095:^\u00890\u0080\u0082ý\u0014·æÙxðÊç\\\u0002.8\u0080;\u0012\u001däJvdÉ\u009b[\u0086-»^\u00880\u008b\u0082¸\u0090\u0099þ\u0085L¡Ú¬(Í¶ì\u0004ë\u0092\u0002^º0\u009f\u0082£\u0014çæùxêÊí\\\u0003.2\u0080\"\u0012Vä\u0007vmÉ\u0090[\u0091-÷¿ø\u0011ÇãáuèÇ\u0006Y:Ò\u0019¼\"\u000e\u0014\u0098\u0016jgôUFDÐô¢«\f¨\u009eÛh¤úÊE)×)¡\u00183l\u009d,oVùKKºÕÜ§\u00981¬\u0083\u008e#uMNÿxiz\u009b\u000b\u00059·(!\u0098SÇýÄo·\u0099È\u000b¦´E&EPtÂ\u0000l@\u009e:\b'ºÖ$°VôÀÀrâ\u009c\u009f\r\n¿\u001c^\u00890\u0080\u0082ý\u0014¯æÊxíÊç\\\u0000.:\u0080=\u0012VsE\u001dY¯f9zË\u0014U/ç)qÆªôÄôvÅàÆ\u0012ê\u008cÐ^\u00890\u008e\u0082½\u0014¤æÃxê>\u0010P\u0019âdt.\u0086@\u0018iª~<\u009bN¡à¢r\u0084\u0084Ü\u0016à©\u0007;\u0014M*o*\u0001#³^%\u000f×mINûNm±\u001f\u0094±Â#áÕáGÅø)^Ê\u0094\u0007ú\u000eHsÞ:,@²r\u0000x\u0096\u008bä°^Ë^\u00890\u0080\u0082ý\u0014¥æÞxöÊï\\\u0013.u\u0080?\u0012AäHvoÉ\u008a[\u0080-£^\u009d0\u009a\u0082¿\u0014«æôxçÊ»\\A\u000e«`¢ÒßD\u0087¶ü(Ô\u009aÍ\f1~WÐ\u000bBx´k&N\u0099¸\u000b³}\u0085ïëAä³ß%Ñ^\u009c0\u008a\u0082½\u0014¢æÙxöÊà\\X.(\u0080+\u0012Xä\bvlÉ\u009a[\u008d-²¿É\u0011Æãð\u0013\u009d}\u008bÏ¼Y£«Ø5÷\u0087á\u0011)c\"Ív_\u0004©\t;y\u0084\u009a\u0016\u0089`\u0089òÂ\\\u0096®¤8©\u008a\r\u0014;f,ðSBh¬g=\u0091\u008f¹\u0019²k\u0086õ\u0094\u0091áÿ÷MÀÛß)¤·\u008b\u0005\u009d\u0093%áAO]Ý!+=¹\u001a\u0006ç\u0094ÁâÙp¢Þ¹,Áº\u009d\bs\u0096Lä[r8À\u000f.\u0011±§ß±m\u0086û\u0099\tâ\u0097Í%Û³cÁ\u0016o\u0016ýg\u000bd\u0099\b&ò´¨ÂÃPöþö\fÇ\u009aÄ(h¶RÄ\b^\u009c0\u0080\u0082¼\u0014 æÇxúÊ¬\\\u0004.?\u0080$\u0012lä@v{É\u0097[\u008c-¹¿Þ\u0011ðãëu¿Ç]Yp+$½R\u000fuájp\u0081Â\u008eT¨&à¸Û\n¯\u009cMLI\"@\u0090=\u0006eô\u0004j0Ø7NÛ<ô\u0092î\u0000\u0097ö\u0082d¹&ÒHÛú¦lþ\u009e\u009f\u0000«²¬$EVmøuj\u000f\u009c\u0019\u000e~±Æ#ÍUåÇ\u008ci\u0090\u009bæ\rº¿Y!jS\u007fÅ\tw2\u0099$\bÚºÕ,þ^\u0090v`\u0018[ªm<oÎ\u001eP,â=t\u0080\u0006ù¨\u00ad:ß^\u00890\u0080\u0082ý\u0014¥æÞxöÊï\\\u0013.u\u0080+\u0012ZäTv{É\u0093[\u0082-®¿\u0095\u0011Æã÷^\u008f0\u008a\u0082 \u0014³æ\u0086^\u00920\u0081\u0082º\u0014³æ\u0085xìÊõ\\\u0014.u\u0080>\u0012VäJv~ÉÒ[\u0093-¥¿Ô\u0011ßãà^\u008a0\u008a\u0082¾\u0014²æ\u0085x÷Êô\\Y.6\u0080.\u0012ZäIv`É\u009a[\u009a-¤QN?N\u008dz\u001bvéAw(Å!S\u009d!ù\u008fê\u001d\u009cë\u0086y\u0090ÆXTF\"~°\u001a\u001e\u0019ì6^\u008a0\u008a\u0082¾\u0014²æ\u0085xìÊå\\Y.7\u0080,\u0012WäxvoÉ\u009a[\u008d-¤¿Ò\u0011ÛãêÏÛ¡Ò\u0013¯\u0085þw\u009cé¿[¿Í@¿e\u00113\u0083\u0000u\u001bç=XßÊÞ¼ì.\u008d\u0080Ór°ä°VTÈxºu^\u00890\u0080\u0082ý\u0014¥æÄxðÊ÷\\Y.*\u0080*\u0012^äRv%É\u009e[\u0095-³¿ä\u0011ÁãòuêÇ\u000e3\u0081]\u0088ïõy \u008bÇ\u0015ú§¥1\u001dC&í.\u007fW\u0089K\u001b-¤\u00916\u0082@±ÒÔ|Â\u008eé\u0018ÿª\u00114>F%ÐK^\u00890\u0080\u0082ý\u0014·æÙxðÊç\\\u0002.8\u0080;\u0012\u001däEv~É\u0096[\u008f-³¿\u0095\u0011ÉãúuéÇ\fY:+1½G\u000fiáfp\u009dÂ\u0093ÿ\u001e\u0091\u0017#jµ#GEÙ{k`ý\u0085\u008f¡!ö³ÆEÅ×õh\u0004ú\u0010\u008cn\u001eJ°QBjÔwf\u0099øº\u008a¤\u001cÒ®å@öÑ\u0010ÍÎ£Ç\u0011º\u0087óu\u0095ë«Y°ÏU½q\u0013W\u0081\u0011w\u0018å8Z\u0096ÈÆ¾å,\u0095\u0082\u0084p°æîTJÊq¸j.\u0017\u009c9r:ãÄQÒÇåµ\u0096+\u0090^\u00890\u0080\u0082ý\u0014±æÎxñÊç\\\u0018.)\u0080a\u0012QäRvbÉ\u0093[\u0087-ù¿Ý\u0011ÆãýuàÇ\u000eY-+3½E\u000fráap\u0087\u00ad\u0002Ã\u000bqvç:\u0015E\u008bz9l¯\u0093Ý¢s\u009báÜ\u0017À\u0085ë:\u0019¨FÞ>LEâM\u0010t\u0086h4Îª²Ø¡NÒü÷\u0012á\u0083\n1\u001c§2Õ]KFùh+`N< c\u0092^\u0004Yölh\u0006Ú\u000eLò>Æ\u0090ø\u0002«ô¦f\u0093Ùr^Ô0\u008b\u0082¶\u0014±æ\u0084xìÊì\\\u0014.0\u0080*\u0012Gä\bviÉ\u009e[\u0090-²¿Ù\u0011ÎãýuãÇ4Y8+&½Y\u000fbák=\u0098SÇáúwý\u0085È\u001b © ?XM|ãfq\u000b\u0087D\u0015 ªÖ8ÁNâÜ\u0093<\u0095RÊà÷vð\u0084Å\u001a\u00ad¨\u00ad>ULqâkp\u0006\u0086I\u0014;«Û9ÏOãÝ\u009e^Ô0\u009c\u0082ª\u0014´æ\u0084xîÊæ\\\u001a..\u0080\u0010\u0012GäUvjÉ\u009c[\u0086^Ô0\u009c\u0082ª\u0014´æßxúÊî\\X.7\u0080&\u0012Qä\bvgÉ\u0096[\u0081-´¿ä\u0011ÂãòuëÇ\u0007Y0+ ½h\u000f\u007fájp\u0091Â\u0092T¬&à¸Ò\nò\u009c\u0016n\u001aÀ}R4$D^Ô0\u008b\u0082¶\u0014±æ\u0084xýÊð\\\u0003.\u0004\u0080(\u0012CäT^Ô0\u008b\u0082¶\u0014±æ\u0084xýÊð\\\u0003.\u0004\u0080;\u0012ZäJvn^Ô0\u008b\u0082¶\u0014±æ\u0084xìÊì\\\u0014.0\u0080*\u0012Gä\bviÉ\u008c[\u0097-±¿Ô\u0011Ãã÷uâÇ\u0019Y;^Ô0\u009c\u0082ª\u0014´æßxúÊî\\X.7\u0080&\u0012Qä\bvgÉ\u0096[\u0081-µ¿È\u0011ÛãõuèÇ\u0007Y;+&½E\u000fDáep\u009dÂ\u008eTå&Ì¸Ì^Ô0\u008b\u0082¶\u0014±æ\u0084xýÊð\\\u0003.:\u0080,\u0012PäB^Ô0\u008b\u0082¶\u0014±æ\u0084xýÊð\\\u0003.<\u00806\u0012AäH^Ô0\u008b\u0082¶\u0014±æ\u0084xýÊð\\\u0003.6\u0080*\u0012TäI^Ô0\u008b\u0082¶\u0014±æ\u0084xýÊð\\\u0003.4\u0080=\u0012ZäB#ÔM\u008bÿ¶i±\u009b\u0084\u0005ý·ð!\u0003S-ý\"o@\u0099@\u0096\røRJoÜh.]°$\u0002)\u0094ÚæòHñÚ\u008b,\u0097¾¢\u0001E^Ô0\u008b\u0082¶\u0014±æ\u0084xýÊð\\\u0003.\u0004\u0080&\u0012^äBç \u0089\u007f;F\u00adG_>ÁDs\u0013åì\u0097Ø9Õ««]¼Ï\u009epoâd\u0094\f\u0006a¨#Z\u0005Ì\\~ýàØ\u0092Ã\u0004¨^Ô0\u0082\u0082½\u0014³æ\u0084xèÊê\\\u0019.?\u0080 \u0012DäTv$É½[\u0090-£¿è\u0011ÇãòuõÇ\u000eY;+\u0005½X\u000fwákp\u0096Â\u0095¸ÔÖ\u009fd¡ò¨\u0000È\u009e°,êº\u0018È+f ôA\u0002S\u0090x`ß\u000e\u009d¼¡*óØ\u0085iú\u0007±µ\u008f#\u0086ÑæO\u009eýÞk<\u0019\u0019·\u0007%2ÓdADþ¡l¾Ë³¥²\u0017\u009d\u0081\u0084sèíß_ÏÉv»\u0013\u0015\u000f\u0087pqlãB\\¹Î¿¸\u0090*º\u0084óvÓ^\u00970\u0086\u0082±\u0014\u0080æçxÚÊÐ\\(.9\u0080<\u0012Gä\tvxÉ\u00903\u0005][ïvyu\u008bU\u0015#§71ÂCãíÿ\u007f½\u0089\u0095\u001bµ¤J6W@eÒ\u0019|P\u008e:\u0018;ªÖ@V.L\u009ci\nmø\u0017f$Ô-BÛ0ÿ\u009eó^Ô0\u008a\u0082§\u0014¤æ\u0084xòÊì\\\u0002.5\u0080;\u0012@^Ô0\u008b\u0082²\u0014³æÊx°Êç\\\u0018.,\u0080!\u0012_äHvjÉ\u009b[\u0090-ø¿\u0095\u0011Ëããu¨Ç\nY/+3½D\u000f5áwp\u009eÂ\u008b±\u0090ßÛmåûì\t\u008c\u0097ô%¤³CÁjobý\u0019\u000b\u0005\u0099 \u000f@a|ÓCE_·1)\n\u009b\f\rãÏ9¡f\u0013_\u0085^w'é][\u0003Íó¿Å\u0011Á\u0083ñuºç\u0094X}Êh¼S.:\u0080'r\räEVåÈÇºÜ,õ\u009eÆpÍá}SeÅK·|)#\u009b\u0013\rõÿðQÑÃÜµ¯'\u0080\u0099\u009a\n4ü[nGÀ3²?$\u000f\u0096ÿ\bë".getBytes("ISO-8859-1")).asCharBuffer().get(cArr, 0, 1959);
        setPivotYN16904 = cArr;
        component9 = -8363369443440316177L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] vD14832N6715(android.content.Context r65, int r66, int r67, int r68) {
        /*
            Method dump skipped, instruction units count: 15672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro.ApiKeyRequired.vD14832N6715(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
