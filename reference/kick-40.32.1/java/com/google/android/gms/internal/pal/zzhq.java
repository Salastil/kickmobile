package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzhq extends zzhr {
    zzhq(int i, String str, String str2, String str3) {
        super(1, str, str2, str3, null);
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzd())) ? bundle.getString("com.google.android.gms.ads.flag.".concat(zzd())) : (String) zze();
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzb(JSONObject jSONObject) {
        return jSONObject.optString(zzd(), (String) zze());
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(zzd(), (String) zze());
    }
}
