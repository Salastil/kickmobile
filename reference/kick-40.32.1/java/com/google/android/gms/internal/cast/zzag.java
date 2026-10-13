package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.devicesuggestions.DeviceSuggestionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzag extends zzb implements zzah {
    public zzag() {
        super("com.google.android.gms.cast.framework.devicesuggestions.internal.IDeviceSuggestionsCallback");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            DeviceSuggestionResult deviceSuggestionResult = (DeviceSuggestionResult) zzc.zzb(parcel, DeviceSuggestionResult.CREATOR);
            zzc.zzf(parcel);
            zzb(deviceSuggestionResult);
        } else {
            if (i != 2) {
                return false;
            }
            DeviceSuggestionResult deviceSuggestionResult2 = (DeviceSuggestionResult) zzc.zzb(parcel, DeviceSuggestionResult.CREATOR);
            zzc.zzf(parcel);
            zzc(deviceSuggestionResult2);
        }
        return true;
    }
}
