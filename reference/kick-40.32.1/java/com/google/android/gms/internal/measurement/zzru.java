package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.slf4j.Marker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzru {
    private final Map zza;
    private final Map zzb;
    private final List zzc;

    public zzru(List list) {
        List<zztc> list2 = Collections.EMPTY_LIST;
        List list3 = Collections.EMPTY_LIST;
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzsx zzsxVar = (zzsx) it.next();
            if (TextUtils.isEmpty(zzsxVar.zzc())) {
                Log.w("MobStore.FileStorage", "Cannot register backend, name empty");
            } else {
                zzsx zzsxVar2 = (zzsx) this.zza.put(zzsxVar.zzc(), zzsxVar);
                if (zzsxVar2 != null) {
                    String canonicalName = zzsxVar2.getClass().getCanonicalName();
                    String canonicalName2 = zzsxVar.getClass().getCanonicalName();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(canonicalName2).length());
                    sb.append("Cannot override Backend ");
                    sb.append(canonicalName);
                    sb.append(" with ");
                    sb.append(canonicalName2);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        for (zztc zztcVar : list2) {
            if (TextUtils.isEmpty(zztcVar.zza())) {
                Log.w("MobStore.FileStorage", "Cannot register transform, name empty");
            } else {
                zztc zztcVar2 = (zztc) this.zzb.put(zztcVar.zza(), zztcVar);
                if (zztcVar2 != null) {
                    String canonicalName3 = zztcVar2.getClass().getCanonicalName();
                    String canonicalName4 = zztcVar.getClass().getCanonicalName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName3).length() + 35 + String.valueOf(canonicalName4).length());
                    sb2.append("Cannot to override Transform ");
                    sb2.append(canonicalName3);
                    sb2.append(" with ");
                    sb2.append(canonicalName4);
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        this.zzc.addAll(list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzrs zze(Uri uri) throws IOException {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        String encodedFragment = uri.getEncodedFragment();
        ImmutableList immutableListOf = (TextUtils.isEmpty(encodedFragment) || !encodedFragment.startsWith("transform=")) ? ImmutableList.of() : ImmutableList.copyOf(Splitter.on(Marker.ANY_NON_NULL_MARKER).omitEmptyStrings().split(encodedFragment.substring(10)));
        int size = immutableListOf.size();
        for (int i = 0; i < size; i++) {
            builder2.add(zzsp.zza((String) immutableListOf.get(i)));
        }
        ImmutableList immutableListBuild = builder2.build();
        int size2 = immutableListBuild.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str = (String) immutableListBuild.get(i2);
            zztc zztcVar = (zztc) this.zzb.get(str);
            if (zztcVar == null) {
                String strValueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(strValueOf).length());
                sb.append("Requested transform isn't registered: ");
                sb.append(str);
                sb.append(": ");
                sb.append(strValueOf);
                throw new zzsk(sb.toString());
            }
            builder.add(zztcVar);
        }
        ImmutableList immutableListReverse = builder.build().reverse();
        zzrr zzrrVar = new zzrr(null);
        String scheme = uri.getScheme();
        zzsx zzsxVar = (zzsx) this.zza.get(scheme);
        if (zzsxVar == null) {
            throw new zzsk(String.format("Requested backend isn't registered: %s", scheme));
        }
        zzrrVar.zza(zzsxVar);
        zzrrVar.zzc(this.zzc);
        zzrrVar.zzb(immutableListReverse);
        zzrrVar.zze(uri);
        if (!immutableListReverse.isEmpty()) {
            ArrayList arrayList = new ArrayList(uri.getPathSegments());
            if (!arrayList.isEmpty() && !uri.getPath().endsWith(DomExceptionUtils.SEPARATOR)) {
                String str2 = (String) arrayList.get(arrayList.size() - 1);
                ListIterator<E> listIterator = immutableListReverse.listIterator(immutableListReverse.size());
                while (listIterator.hasPrevious()) {
                }
                arrayList.set(arrayList.size() - 1, str2);
                uri = uri.buildUpon().path(TextUtils.join(DomExceptionUtils.SEPARATOR, arrayList)).encodedFragment(null).build();
            }
        }
        zzrrVar.zzd(uri);
        return new zzrs(zzrrVar);
    }

    public final Object zza(Uri uri, zzrt zzrtVar) throws IOException {
        return zzrtVar.zza(zze(uri));
    }

    public final void zzb(Uri uri) throws IOException {
        zzrs zzrsVarZze = zze(uri);
        zzrsVarZze.zza().zzk(zzrsVarZze.zzb());
    }

    public final boolean zzc(Uri uri) throws IOException {
        zzrs zzrsVarZze = zze(uri);
        return zzrsVarZze.zza().zze(zzrsVarZze.zzb());
    }

    public final void zzd(Uri uri, Uri uri2) throws IOException {
        zzrs zzrsVarZze = zze(uri);
        zzrs zzrsVarZze2 = zze(uri2);
        if (zzrsVarZze.zza() != zzrsVarZze2.zza()) {
            throw new zzsk("Cannot rename file across backends");
        }
        zzrsVarZze.zza().zzl(zzrsVarZze.zzb(), zzrsVarZze2.zzb());
    }
}
