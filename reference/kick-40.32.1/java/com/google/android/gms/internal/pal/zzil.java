package com.google.android.gms.internal.pal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzil extends zzgx implements zzim {
    public zzil() {
        super("com.google.android.gms.ads.signalsdk.ISignalSdkCallback");
    }

    @Override // com.google.android.gms.internal.pal.zzgx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            Bundle bundle = (Bundle) zzgy.zza(parcel, Bundle.CREATOR);
            zzgy.zzd(parcel);
            zzb(bundle);
        } else {
            if (i != 2) {
                return false;
            }
            int i3 = parcel.readInt();
            zzgy.zzd(parcel);
            zzc(i3);
        }
        return true;
    }
}
