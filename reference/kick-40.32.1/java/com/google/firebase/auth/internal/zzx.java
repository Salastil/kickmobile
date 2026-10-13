package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzx implements AuthResult {
    public static final Parcelable.Creator<zzx> CREATOR = new zzaa();
    private zzad zza;
    private zzv zzb;
    private com.google.firebase.auth.zzc zzc;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.zza;
    }

    public zzx(zzad zzadVar) {
        zzad zzadVar2 = (zzad) Preconditions.checkNotNull(zzadVar);
        this.zza = zzadVar2;
        List<zzz> listZzj = zzadVar2.zzj();
        this.zzb = null;
        for (int i = 0; i < listZzj.size(); i++) {
            if (!TextUtils.isEmpty(listZzj.get(i).zza())) {
                this.zzb = new zzv(listZzj.get(i).getProviderId(), listZzj.get(i).zza(), zzadVar.zzk());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzv(zzadVar.zzk());
        }
        this.zzc = zzadVar.zzh();
    }

    zzx(zzad zzadVar, zzv zzvVar, com.google.firebase.auth.zzc zzcVar) {
        this.zza = zzadVar;
        this.zzb = zzvVar;
        this.zzc = zzcVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
