package com.fingerprintjs.android.fpjs_pro_internal;

import com.fingerprintjs.android.fpjs_pro.Error;
import com.fingerprintjs.android.fpjs_pro.UnknownError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/A27299Q27368;", "", "<init>", "()V", "", "p0", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "vD14832N6715", "(Ljava/lang/Throwable;)Lcom/fingerprintjs/android/fpjs_pro/Error;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class A27299Q27368 {
    public static final A27299Q27368 INSTANCE = new A27299Q27368();

    private A27299Q27368() {
    }

    public static Error vD14832N6715(Throwable p0) {
        StringBuilder sb = new StringBuilder("Internal unexpected error occurred. Please contact support.\n");
        sb.append(p0.toString());
        sb.append('\n');
        sb.append(ay.setPivotYN16904(p0));
        sb.append('\n');
        return new UnknownError(null, sb.toString(), 1, null);
    }
}
