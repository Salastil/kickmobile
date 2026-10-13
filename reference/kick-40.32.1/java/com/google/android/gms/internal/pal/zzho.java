package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzho extends zzhr {
    zzho(int i, String str, Long l, Long l2) {
        super(1, str, l, l2, null);
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzd())) ? Long.valueOf(bundle.getLong("com.google.android.gms.ads.flag.".concat(zzd()))) : (Long) zze();
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzb(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(zzd(), ((Long) zze()).longValue()));
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(zzd(), ((Long) zze()).longValue()));
    }
}
