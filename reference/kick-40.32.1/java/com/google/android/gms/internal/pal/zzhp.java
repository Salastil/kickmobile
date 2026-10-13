package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzhp extends zzhr {
    zzhp(int i, String str, Float f, Float f2) {
        super(1, str, f, f2, null);
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzd())) ? Float.valueOf(bundle.getFloat("com.google.android.gms.ads.flag.".concat(zzd()))) : (Float) zze();
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzb(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(zzd(), ((Float) zze()).floatValue()));
    }

    @Override // com.google.android.gms.internal.pal.zzhr
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(zzd(), ((Float) zze()).floatValue()));
    }
}
