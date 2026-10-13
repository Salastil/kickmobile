package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzay;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzd extends AsyncTask {
    private static final Logger zza = new Logger("FetchBitmapTask");
    private final zzg zzb;
    private final zzb zzc;

    public zzd(Context context, int i, int i2, boolean z, long j, int i3, int i4, int i5, zzb zzbVar) {
        this.zzc = zzbVar;
        this.zzb = zzay.zze(context.getApplicationContext(), this, new zzc(this, null), i, i2, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Uri uri;
        zzg zzgVar;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length != 1 || (uri = uriArr[0]) == null || (zzgVar = this.zzb) == null) {
            return null;
        }
        try {
            return zzgVar.zze(uri);
        } catch (RemoteException e) {
            zza.d(e, "Unable to call %s on %s.", "doFetch", "zzg");
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        zzb zzbVar = this.zzc;
        Bitmap bitmap = (Bitmap) obj;
        if (zzbVar != null) {
            zzbVar.zzd(bitmap);
        }
    }
}
