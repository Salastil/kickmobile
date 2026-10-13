package com.google.android.gms.internal.p000authapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.5.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zbbk extends zbbj {
    static final zbbj zba = new zbbk(new Object[0], 0);
    final transient Object[] zbb;
    private final transient int zbc;

    zbbk(Object[] objArr, int i) {
        this.zbb = objArr;
        this.zbc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zbbd.zba(i, this.zbc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zbb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    final Object[] zbb() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    final int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    final int zbd() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    final boolean zbf() {
        return false;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbj, com.google.android.gms.internal.p000authapi.zbbg
    final int zbg(Object[] objArr, int i) {
        Object[] objArr2 = this.zbb;
        int i2 = this.zbc;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }
}
