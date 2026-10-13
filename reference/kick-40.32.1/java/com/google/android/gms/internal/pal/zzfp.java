package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfp extends zzgo {
    private static final zzgp zzh = new zzgp();
    private final zzaa zzi;
    private final Context zzj;
    private final zzcr zzk;

    public zzfp(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, Context context, zzt zztVar, zzaa zzaaVar, zzcr zzcrVar) {
        super(zzfbVar, "Y4Si1UCd8xFA1yCw6ohazV+GUSwhVa9ffV9ZnN++nWMAkqLsgU7cmmd4wBpbGVgj", "1k+Az7ZOHMkdpE7lGA2cF/gUEsamDqjjLqQDV0dmR3A=", zzadVar, i, 27);
        this.zzj = context;
        this.zzi = zzaaVar;
        this.zzk = zzcrVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzco zzc() throws IllegalAccessException, InvocationTargetException {
        String str;
        zzhr zzhrVar = zzia.zzo;
        int iZzb = (((Integer) zzhi.zzc().zzc(zzhrVar)).intValue() <= 0 || ((Integer) zzhi.zzc().zzc(zzhrVar)).intValue() >= this.zzi.zzb()) ? this.zzi.zzb() : ((Integer) zzhi.zzc().zzc(zzhrVar)).intValue();
        zzco zzcoVar = new zzco((String) this.zze.invoke(null, this.zzj, false, ""));
        zzcr zzcrVar = this.zzk;
        if (zzcrVar == null || zzcrVar.zza() == null) {
            str = ExifInterface.LONGITUDE_EAST;
        } else {
            try {
                str = (String) zzcrVar.zza().get(iZzb, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                str = ExifInterface.LONGITUDE_EAST;
            }
        }
        zzcoVar.zza = str;
        return zzcoVar;
    }

    private final String zzd() {
        try {
            zzfb zzfbVar = this.zza;
            if (zzfbVar.zzm() != null) {
                zzfbVar.zzm().get();
            }
            zzbd zzbdVarZzl = zzfbVar.zzl();
            if (zzbdVarZzl == null || !zzbdVarZzl.zza()) {
                return null;
            }
            return zzbdVarZzl.zzb();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i;
        zzco zzcoVarZzc;
        zzco zzcoVar;
        zzgp zzgpVar = zzh;
        Context context = this.zzj;
        AtomicReference atomicReferenceZza = zzgpVar.zza(context.getPackageName());
        synchronized (atomicReferenceZza) {
            zzco zzcoVar2 = (zzco) atomicReferenceZza.get();
            if (zzcoVar2 == null || zzfe.zzc(zzcoVar2.zza) || zzcoVar2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzcoVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                boolean z = false;
                if (zzfe.zzc(null)) {
                    (!zzfe.zzc(null) ? false : false).booleanValue();
                    i = 3;
                } else {
                    i = 5;
                }
                if (this.zzk != null) {
                    zzcoVarZzc = zzc();
                } else {
                    if (i == 3 && !this.zzi.zza()) {
                        z = true;
                    }
                    Boolean boolValueOf = Boolean.valueOf(z);
                    Boolean bool = (Boolean) zzhi.zzc().zzc(zzia.zze);
                    String strZzb = ((Boolean) zzhi.zzc().zzc(zzia.zzd)).booleanValue() ? zzb() : null;
                    if (bool.booleanValue() && this.zza.zzi() && zzfe.zzc(strZzb)) {
                        strZzb = zzd();
                    }
                    zzco zzcoVar3 = new zzco((String) this.zze.invoke(null, context, boolValueOf, strZzb));
                    String str = zzcoVar3.zza;
                    if (zzfe.zzc(str) || str.equals(ExifInterface.LONGITUDE_EAST)) {
                        int i2 = i - 1;
                        if (i2 == 3) {
                            String strZzd = zzd();
                            if (!zzfe.zzc(strZzd)) {
                                zzcoVar3.zza = strZzd;
                            }
                        } else if (i2 == 4) {
                            throw null;
                        }
                    }
                    zzcoVarZzc = zzcoVar3;
                }
                atomicReferenceZza.set(zzcoVarZzc);
            }
            zzcoVar = (zzco) atomicReferenceZza.get();
        }
        zzad zzadVar = this.zzd;
        synchronized (zzadVar) {
            if (zzcoVar != null) {
                zzadVar.zzo(zzcoVar.zza);
                zzadVar.zzu(zzcoVar.zzb);
                zzadVar.zzt(zzcoVar.zzc);
                zzadVar.zzD(zzcoVar.zzd);
                zzadVar.zzE(zzcoVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] bArrZzb = zzfe.zzb((String) zzhi.zzc().zzc(zzia.zzf));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzb)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzfe.zzb((String) zzhi.zzc().zzc(zzia.zzg)))));
            }
            Context context = this.zzj;
            return zzgr.zza(context, context.getPackageName(), arrayList, this.zza.zzd());
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
