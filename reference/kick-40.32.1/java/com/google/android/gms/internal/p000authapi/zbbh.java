package com.google.android.gms.internal.p000authapi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.5.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zbbh extends zbbf {
    private final zbbj zba;

    zbbh(zbbj zbbjVar, int i) {
        super(zbbjVar.size(), i);
        this.zba = zbbjVar;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbf
    protected final Object zba(int i) {
        return this.zba.get(i);
    }
}
