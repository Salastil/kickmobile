package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzjf {
    String zza(Context context, String str);

    String zzb(Context context, String str, View view, Activity activity);

    String zzc(Context context, String str, String str2, View view, Activity activity);

    void zzd(String str, MotionEvent motionEvent) throws zzkk;
}
