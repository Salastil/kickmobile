package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfl extends zzgo {
    private final Activity zzh;
    private final View zzi;

    public zzfl(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, View view, Activity activity) {
        super(zzfbVar, "9TfyKlP5TIIt3OrlcGubA3YBpCoy+oB4k/WnZndRDloYkwzEaKKPovjffC4zkV4k", "3uxZ+FD025vJO7qOv296UhrdOlNsopGnz6EvxCliHP4=", zzadVar, i, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzi;
        if (view == null) {
            return;
        }
        Boolean bool = (Boolean) zzhi.zzc().zzc(zzia.zzm);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, view, this.zzh, bool);
        zzad zzadVar = this.zzd;
        synchronized (zzadVar) {
            zzadVar.zzP(((Long) objArr[0]).longValue());
            zzadVar.zzQ(((Long) objArr[1]).longValue());
            if (zBooleanValue) {
                zzadVar.zzR((String) objArr[2]);
            }
        }
    }
}
