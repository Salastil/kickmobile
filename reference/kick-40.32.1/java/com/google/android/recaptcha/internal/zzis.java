package com.google.android.recaptcha.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzis extends Lambda implements Function0 {
    public static final zzis zza = new zzis();

    public zzis() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzbd {
        int i = zzav.zza;
        Object objZzb = zzau.zza().zzb(915034909);
        if (objZzb != null) {
            return (zzjd) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
