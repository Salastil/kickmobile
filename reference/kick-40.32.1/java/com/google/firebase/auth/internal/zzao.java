package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzao extends MultiFactorSession {
    public static final Parcelable.Creator<zzao> CREATOR = new zzan();
    private String zza;
    private String zzb;
    private List<PhoneMultiFactorInfo> zzc;
    private List<TotpMultiFactorInfo> zzd;
    private zzad zze;

    public final zzad zza() {
        return this.zze;
    }

    public static zzao zza(String str, zzad zzadVar) {
        Preconditions.checkNotEmpty(str);
        zzao zzaoVar = new zzao();
        zzaoVar.zza = str;
        zzaoVar.zze = zzadVar;
        return zzaoVar;
    }

    public static zzao zza(List<MultiFactorInfo> list, String str) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotEmpty(str);
        zzao zzaoVar = new zzao();
        zzaoVar.zzc = new ArrayList();
        zzaoVar.zzd = new ArrayList();
        for (MultiFactorInfo multiFactorInfo : list) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzaoVar.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                zzaoVar.zzd.add((TotpMultiFactorInfo) multiFactorInfo);
            } else {
                throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + multiFactorInfo.getFactorId());
            }
        }
        zzaoVar.zzb = str;
        return zzaoVar;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    private zzao() {
    }

    zzao(String str, String str2, List<PhoneMultiFactorInfo> list, List<TotpMultiFactorInfo> list2, zzad zzadVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
        this.zzd = list2;
        this.zze = zzadVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zzd() {
        return this.zza != null;
    }
}
