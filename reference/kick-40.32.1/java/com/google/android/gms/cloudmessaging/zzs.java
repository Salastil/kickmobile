package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzs {
    final int zza;
    final TaskCompletionSource zzb = new TaskCompletionSource();
    final int zzc;
    final Bundle zzd;

    zzs(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    public final String toString() {
        int i = this.zzc;
        int length = String.valueOf(i).length();
        int i2 = this.zza;
        int length2 = String.valueOf(i2).length();
        boolean zZza = zza();
        StringBuilder sb = new StringBuilder(length + 19 + length2 + 8 + String.valueOf(zZza).length() + 1);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(zZza);
        sb.append("}");
        return sb.toString();
    }

    abstract boolean zza();

    abstract void zzb(Bundle bundle);

    final void zzc(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String string = toString();
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(string.length() + 16 + String.valueOf(strValueOf).length());
            sb.append("Finishing ");
            sb.append(string);
            sb.append(" with ");
            sb.append(strValueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.zzb.setResult(obj);
    }

    final void zzd(zzt zztVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String string = toString();
            String string2 = zztVar.toString();
            StringBuilder sb = new StringBuilder(string.length() + 14 + string2.length());
            sb.append("Failing ");
            sb.append(string);
            sb.append(" with ");
            sb.append(string2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.zzb.setException(zztVar);
    }
}
