package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgg extends zzgo {
    private final StackTraceElement[] zzh;

    public zzgg(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzfbVar, "X/GUPFxOS4avlKtq36LXcZb7PXup/zZuW1HHrjvnbrOdArq87fiVHm1/XdqEH3+6", "yUIicuApz/OaGeh0f0RdAIADq1zJ0l0UU+b4jbryt0s=", zzadVar, i, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzes zzesVar = new zzes((String) this.zze.invoke(null, stackTraceElementArr));
            zzad zzadVar = this.zzd;
            synchronized (zzadVar) {
                zzadVar.zzC(zzesVar.zza.longValue());
                if (zzesVar.zzb.booleanValue()) {
                    zzadVar.zzab(true != zzesVar.zzc.booleanValue() ? 2 : 1);
                } else {
                    zzadVar.zzab(3);
                }
            }
        }
    }
}
