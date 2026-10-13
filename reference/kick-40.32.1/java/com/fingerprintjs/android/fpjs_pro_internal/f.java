package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00028\u00008'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\r\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/f;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "setPivotYN16904", "()Ljava/lang/Object;", "Lcom/fingerprintjs/android/fpjs_pro_internal/b;", "Lcom/fingerprintjs/android/fpjs_pro_internal/d;", "Lcom/fingerprintjs/android/fpjs_pro_internal/i;", "Lcom/fingerprintjs/android/fpjs_pro_internal/e;", "Lcom/fingerprintjs/android/fpjs_pro_internal/g;", "Lcom/fingerprintjs/android/fpjs_pro_internal/h;", "Lcom/fingerprintjs/android/fpjs_pro_internal/k;", "Lcom/fingerprintjs/android/fpjs_pro_internal/l;", "Lcom/fingerprintjs/android/fpjs_pro_internal/j;", "Lcom/fingerprintjs/android/fpjs_pro_internal/m;", "Lcom/fingerprintjs/android/fpjs_pro_internal/n;", "Lcom/fingerprintjs/android/fpjs_pro_internal/o;", "Lcom/fingerprintjs/android/fpjs_pro_internal/s;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class f<T> {
    public static int component13;
    public static int sG29839;

    public abstract T setPivotYN16904();

    private f() {
    }

    public static int D8871() {
        int i = sG29839;
        int i2 = i % 9356862;
        sG29839 = i + 1;
        if (i2 != 0) {
            return component13;
        }
        int iNextInt = new Random().nextInt(224186036);
        component13 = iNextInt;
        return iNextInt;
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
