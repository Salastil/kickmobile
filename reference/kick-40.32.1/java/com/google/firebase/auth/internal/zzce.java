package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzaaw;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzce {
    private Context zza;
    private String zzb;
    private SharedPreferences zzc;
    private Logger zzd;

    public final FirebaseUser zza() {
        String strZzc = zzc("com.google.firebase.auth.FIREBASE_USER");
        if (TextUtils.isEmpty(strZzc)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strZzc);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zza(jSONObject);
            }
        } catch (Exception unused) {
            this.zzd.i("Failed to restore user data from persistent storage.", new Object[0]);
        }
        return null;
    }

    public final zzaia zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String strZzc = zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
        if (strZzc == null) {
            return null;
        }
        try {
            return zzaia.zzb(strZzc);
        } catch (zzaaw unused) {
            this.zzd.i("Failed to restore token data from persistent storage.", new Object[0]);
            return null;
        }
    }

    public final zzaia zza(String str) {
        String strZzc = zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE_REGIONALIZED_AUTH.%s", str));
        if (strZzc == null) {
            return null;
        }
        try {
            return zzaia.zzb(strZzc);
        } catch (zzaaw unused) {
            this.zzd.i("Failed to restore token data from persistent storage.", new Object[0]);
            return null;
        }
    }

    private final zzad zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        MultiFactorInfo multiFactorInfoZza;
        zzaf zzafVarZza;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = ExifInterface.GPS_MEASUREMENT_2D;
            String string3 = jSONObject.getString("version");
            if (string3 != null) {
                str = string3;
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzz.zza(jSONArray3.getString(i)));
            }
            zzad zzadVar = new zzad(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzadVar.zza(zzaia.zzb(string));
            }
            if (!z) {
                zzadVar.zzb();
            }
            zzadVar.zza(str);
            if (jSONObject.has("userMetadata") && (zzafVarZza = zzaf.zza(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzadVar.zza(zzafVarZza);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i2));
                    String strOptString = jSONObject2.optString(MultiFactorInfo.FACTOR_ID_KEY);
                    if ("phone".equals(strOptString)) {
                        multiFactorInfoZza = PhoneMultiFactorInfo.zza(jSONObject2);
                    } else {
                        multiFactorInfoZza = Objects.equals(strOptString, TotpMultiFactorGenerator.FACTOR_ID) ? TotpMultiFactorInfo.zza(jSONObject2) : null;
                    }
                    arrayList2.add(multiFactorInfoZza);
                }
                zzadVar.zzc(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList3.add(com.google.firebase.auth.zzao.zza(new JSONObject(jSONArray.getString(i3))));
                }
                zzadVar.zzb(arrayList3);
            }
            return zzadVar;
        } catch (zzaaw | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            this.zzd.wtf(e);
            return null;
        }
    }

    private final String zzc(String str) {
        String string = this.zzc.getString(str, null);
        if (string != null) {
            return string.startsWith("ENCRYPTED:") ? zzcb.zza(this.zza, this.zzb).zza(string.substring(10)) : string;
        }
        return null;
    }

    private final String zzd(FirebaseUser firebaseUser) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (!(firebaseUser instanceof zzad)) {
            return null;
        }
        zzad zzadVar = (zzad) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzadVar.zze());
            jSONObject.put("applicationName", zzadVar.zza().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzadVar.zzj() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzz> listZzj = zzadVar.zzj();
                int size = listZzj.size();
                if (listZzj.size() > 30) {
                    this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(listZzj.size()));
                    size = 30;
                }
                int i = 0;
                boolean z2 = false;
                while (true) {
                    z = true;
                    if (i >= size) {
                        break;
                    }
                    zzz zzzVar = listZzj.get(i);
                    if (zzzVar.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                        z2 = true;
                    }
                    if (i == size - 1 && !z2) {
                        break;
                    }
                    jSONArray.put(zzzVar.zzb());
                    i++;
                }
                if (!z2) {
                    int i2 = size - 1;
                    while (true) {
                        if (i2 >= listZzj.size() || i2 < 0) {
                            z = z2;
                            break;
                        }
                        zzz zzzVar2 = listZzj.get(i2);
                        if (zzzVar2.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                            jSONArray.put(zzzVar2.zzb());
                            break;
                        }
                        if (i2 == listZzj.size() - 1) {
                            jSONArray.put(zzzVar2.zzb());
                        }
                        i2++;
                    }
                    if (!z) {
                        this.zzd.w("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(listZzj.size()), Integer.valueOf(size));
                        if (listZzj.size() < 5) {
                            StringBuilder sb = new StringBuilder("Provider user info list:\n");
                            Iterator<zzz> it = listZzj.iterator();
                            while (it.hasNext()) {
                                sb.append(String.format("Provider - %s\n", it.next().getProviderId()));
                            }
                            this.zzd.w(sb.toString(), new Object[0]);
                        }
                    }
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzadVar.isAnonymous());
            jSONObject.put("version", ExifInterface.GPS_MEASUREMENT_2D);
            if (zzadVar.getMetadata() != null) {
                jSONObject.put("userMetadata", ((zzaf) zzadVar.getMetadata()).zza());
            }
            List<MultiFactorInfo> enrolledFactors = ((zzah) zzadVar.getMultiFactor()).getEnrolledFactors();
            if (enrolledFactors != null && !enrolledFactors.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < enrolledFactors.size(); i3++) {
                    jSONArray2.put(enrolledFactors.get(i3).toJson());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            List<com.google.firebase.auth.zzao> listZzf = zzadVar.zzf();
            if (listZzf != null && !listZzf.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i4 = 0; i4 < listZzf.size(); i4++) {
                    jSONArray3.put(com.google.firebase.auth.zzao.zza(listZzf.get(i4)));
                }
                jSONObject.put("passkeyInfo", jSONArray3);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.zzd.wtf("Failed to turn object into JSON", e, new Object[0]);
            throw new zzaaw(e);
        }
    }

    public zzce(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zza = context.getApplicationContext();
        this.zzc = this.zza.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.zzb), 0);
        this.zzd = new Logger("StorageHelpers", new String[0]);
    }

    private final void zzd(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzb() {
        zzd("com.google.firebase.auth.FIREBASE_USER");
    }

    public final void zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        zzd(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
    }

    public final void zzb(String str) {
        zzd(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE_REGIONALIZED_AUTH.%s", str));
    }

    private final void zza(String str, String str2) {
        String strZzb = zzcb.zza(this.zza, this.zzb).zzb(str2);
        if (strZzb != null) {
            this.zzc.edit().putString(str, "ENCRYPTED:" + strZzb).apply();
        }
    }

    public final void zzc(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String strZzd = zzd(firebaseUser);
        if (TextUtils.isEmpty(strZzd)) {
            return;
        }
        zza("com.google.firebase.auth.FIREBASE_USER", strZzd);
    }

    public final void zza(FirebaseUser firebaseUser, zzaia zzaiaVar) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzaiaVar);
        zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), zzaiaVar.zzf());
    }
}
