package com.google.android.gms.internal.cloudmessaging;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cloudmessaging.RegisterRequest;
import com.google.android.gms.cloudmessaging.UnregisterRequest;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zze extends zza implements IInterface {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cloudmessaging.internal.ICloudMessagingService");
    }

    public final void zzc(zzg zzgVar, RegisterRequest registerRequest, ApiMetadata apiMetadata) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzgVar);
        zzc.zzb(parcelZza, registerRequest);
        zzc.zzb(parcelZza, apiMetadata);
        zzb(1, parcelZza);
    }

    public final void zzd(IStatusCallback iStatusCallback, UnregisterRequest unregisterRequest, ApiMetadata apiMetadata) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, iStatusCallback);
        zzc.zzb(parcelZza, unregisterRequest);
        zzc.zzb(parcelZza, apiMetadata);
        zzb(2, parcelZza);
    }
}
