package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzhn extends zzhr {
    zzhn(int i, String str, Integer num, Integer num2) {
        super(1, str, num, num2, null);
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzd())) ? Integer.valueOf(bundle.getInt("com.google.android.gms.ads.flag.".concat(zzd()))) : (Integer) zze();
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzb(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zzd(), ((Integer) zze()).intValue()));
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zzd(), ((Integer) zze()).intValue()));
    }
}
