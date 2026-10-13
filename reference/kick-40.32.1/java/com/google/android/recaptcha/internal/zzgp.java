package com.google.android.recaptcha.internal;

import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzgp implements zzgx {
    public static final zzgp zza = new zzgp();

    private zzgp() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        String strJoinToString$default;
        String str;
        if (zzueVarArr.length != 1) {
            throw new zzce(4, 3, null);
        }
        Object objZza = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != (objZza instanceof Object)) {
            objZza = null;
        }
        if (objZza == null) {
            throw new zzce(4, 5, null);
        }
        if (objZza instanceof int[]) {
            strJoinToString$default = ArraysKt.joinToString$default((int[]) objZza, (CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        } else {
            if (objZza instanceof byte[]) {
                str = new String((byte[]) objZza, Charsets.UTF_8);
            } else if (objZza instanceof long[]) {
                strJoinToString$default = ArraysKt.joinToString$default((long[]) objZza, (CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            } else if (objZza instanceof short[]) {
                strJoinToString$default = ArraysKt.joinToString$default((short[]) objZza, (CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            } else if (objZza instanceof float[]) {
                strJoinToString$default = ArraysKt.joinToString$default((float[]) objZza, (CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            } else if (objZza instanceof double[]) {
                strJoinToString$default = ArraysKt.joinToString$default((double[]) objZza, WebViewLogEventConsumer.DDTAGS_SEPARATOR, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            } else if (objZza instanceof char[]) {
                str = new String((char[]) objZza);
            } else if (objZza instanceof Object[]) {
                strJoinToString$default = ArraysKt.joinToString$default((Object[]) objZza, WebViewLogEventConsumer.DDTAGS_SEPARATOR, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            } else {
                if (!(objZza instanceof Collection)) {
                    throw new zzce(4, 5, null);
                }
                strJoinToString$default = CollectionsKt.joinToString$default((Iterable) objZza, WebViewLogEventConsumer.DDTAGS_SEPARATOR, "[", "]", 0, null, null, 56, null);
            }
            strJoinToString$default = str;
        }
        zzgdVar.zzc().zze(i, strJoinToString$default);
    }
}
