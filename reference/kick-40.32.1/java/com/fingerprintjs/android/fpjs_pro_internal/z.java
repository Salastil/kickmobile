package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.compose.runtime.GapComposerKt;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes6.dex */
public final class z {
    private static int D8871 = 0;
    private static int vD14832N6715 = 1;

    public static D8871<List<y>, Throwable> setPivotYN16904(String str) {
        Object objM12684constructorimpl;
        int i = 2 % 2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.map(Regex.findAll$default(new Regex(I30900.ag.INSTANCE.component5()), str, 0, 2, null), new Function1<MatchResult, MatchResult.Destructured>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.z.4
                private static int $D8871 = 1;
                private static int $component5 = 0;
                private static int $component9 = 1;
                private static int $vD14832N6715;

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ MatchResult.Destructured invoke(MatchResult matchResult) {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + GapComposerKt.nodeKey;
                    $D8871 = i3 % 128;
                    MatchResult matchResult2 = matchResult;
                    if (i3 % 2 != 0) {
                        return setPivotYN16904(matchResult2);
                    }
                    setPivotYN16904(matchResult2);
                    throw null;
                }

                public final MatchResult.Destructured setPivotYN16904(MatchResult matchResult) {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 15;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    MatchResult.Destructured destructured = matchResult.getDestructured();
                    if (i4 == 0) {
                        int i5 = 0 / 0;
                    }
                    int i6 = $vD14832N6715 + 31;
                    $D8871 = i6 % 128;
                    int i7 = i6 % 2;
                    return destructured;
                }

                static {
                    int i2 = $component9 + 59;
                    $component5 = i2 % 128;
                    if (i2 % 2 != 0) {
                        throw null;
                    }
                }
            }), new Function1<MatchResult.Destructured, y>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.z.5
                private static int $component5 = 0;
                private static int $component9 = 1;
                private static int $setPivotYN16904 = 1;
                private static int $vD14832N6715;

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ y invoke(MatchResult.Destructured destructured) {
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904 + 1;
                    $vD14832N6715 = i3 % 128;
                    int i4 = i3 % 2;
                    y yVarComponent5 = component5(destructured);
                    int i5 = $vD14832N6715;
                    int i6 = (i5 & 123) + (i5 | 123);
                    $setPivotYN16904 = i6 % 128;
                    if (i6 % 2 != 0) {
                        return yVarComponent5;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                public final y component5(MatchResult.Destructured destructured) {
                    Object objM12684constructorimpl2;
                    int i2 = 2 % 2;
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new y(destructured.getMatch().getGroupValues().get(1), destructured.getMatch().getGroupValues().get(2)));
                        int i3 = $vD14832N6715;
                        int i4 = ((i3 | 33) << 1) - (i3 ^ 33);
                        $setPivotYN16904 = i4 % 128;
                        int i5 = i4 % 2;
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                    return (y) component9.component9(bb.setPivotYN16904(objM12684constructorimpl2), null);
                }

                static {
                    int i2 = $component5 + 45;
                    $component9 = i2 % 128;
                    if (i2 % 2 != 0) {
                        return;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
            })));
            int i2 = vD14832N6715;
            int i3 = (i2 & 21) + (i2 | 21);
            D8871 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return bb.setPivotYN16904(objM12684constructorimpl);
    }
}
