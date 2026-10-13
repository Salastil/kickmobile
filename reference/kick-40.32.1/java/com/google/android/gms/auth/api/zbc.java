package com.google.android.gms.auth.api;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.5.0 */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class zbc {
    protected Boolean zba;
    protected String zbb;

    public zbc() {
        this.zba = false;
    }

    public final zbc zba(String str) {
        this.zbb = str;
        return this;
    }

    public zbc(zbd zbdVar) {
        this.zba = false;
        this.zba = Boolean.valueOf(zbdVar.zbb());
        this.zbb = zbdVar.zbc();
    }
}
