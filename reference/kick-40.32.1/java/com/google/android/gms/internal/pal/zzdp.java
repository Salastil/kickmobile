package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzdp {
    boolean zze();

    boolean zzf();

    void zzg(MotionEvent motionEvent);

    @Deprecated
    void zzh(int i, int i2, int i3);

    String zzi(Context context, String str, View view, Activity activity);

    void zzj(View view);

    String zzk(Context context, View view, Activity activity);

    String zzl(Context context);

    @Deprecated
    String zzm(Context context, byte[] bArr);
}
