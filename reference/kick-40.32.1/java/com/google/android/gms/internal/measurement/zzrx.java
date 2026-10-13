package com.google.android.gms.internal.measurement;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.datadog.trace.api.DDSpanTypes;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrx extends zzsy {
    private final Context zza;
    private final zzsx zzb;
    private final Object zzc = new Object();

    @Nullable
    private String zzd;

    /* synthetic */ zzrx(zzrw zzrwVar, byte[] bArr) {
        this.zzb = new zzsd(zzrwVar.zzc());
        this.zza = zzrwVar.zzb();
    }

    public static zzrw zza(Context context) {
        return new zzrw(context, null);
    }

    private final boolean zzh(Uri uri) {
        return (TextUtils.isEmpty(uri.getAuthority()) || this.zza.getPackageName().equals(uri.getAuthority())) ? false : true;
    }

    private static final void zzi() throws zzsg {
        throw new zzsg("Android backend cannot perform remote operations without a remote backend");
    }

    @Override // com.google.android.gms.internal.measurement.zzsy
    protected final zzsx zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final String zzc() {
        return "android";
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final InputStream zzd(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzsl.zzb(zzsc.zza(zzf(uri)));
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsx
    public final boolean zze(Uri uri) throws IOException {
        if (!zzh(uri)) {
            return zzsc.zza(zzf(uri)).exists();
        }
        zzi();
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzsy
    protected final Uri zzf(Uri uri) throws IOException {
        if (zzh(uri)) {
            throw new zzsi("Operation across authorities is not allowed.");
        }
        File fileZzg = zzg(uri);
        zzsb zzsbVar = new zzsb(null);
        zzsbVar.zza(fileZzg);
        return zzsbVar.zzb();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x010f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0116 A[Catch: all -> 0x013e, TryCatch #1 {, blocks: (B:55:0x0112, B:57:0x0116, B:58:0x0128, B:59:0x012a), top: B:80:0x0112 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0136  */
    /* JADX WARN: Code duplicated, block: B:80:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.measurement.zzsx
    public final File zzg(Uri uri) throws IOException {
        File externalFilesDir;
        Account account;
        File file;
        String str;
        if (zzh(uri)) {
            throw new IOException("operation is not permitted in other authorities.");
        }
        Context context = this.zza;
        if (!uri.getScheme().equals("android")) {
            throw new zzsi("Scheme must be 'android'");
        }
        if (uri.getPathSegments().isEmpty()) {
            throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
        }
        if (!TextUtils.isEmpty(uri.getQuery())) {
            throw new zzsi("Did not expect uri to have query");
        }
        ArrayList arrayList = new ArrayList(uri.getPathSegments());
        String str2 = (String) arrayList.get(0);
        switch (str2.hashCode()) {
            case -1820761141:
                if (str2.equals("external")) {
                    externalFilesDir = context.getExternalFilesDir(null);
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzky.zzc(context)) {
                        synchronized (this.zzc) {
                            if (this.zzd == null) {
                                this.zzd = zzry.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                            }
                            str = this.zzd;
                            break;
                        }
                        if (!file.getAbsolutePath().startsWith(str)) {
                            throw new zzsg("Cannot access credential-protected data from direct boot");
                        }
                    }
                    return file;
                }
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
            case 94416770:
                if (str2.equals(DDSpanTypes.CACHE)) {
                    externalFilesDir = context.getCacheDir();
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzky.zzc(context)) {
                        synchronized (this.zzc) {
                            if (this.zzd == null) {
                                this.zzd = zzry.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                            }
                            str = this.zzd;
                            if (!file.getAbsolutePath().startsWith(str)) {
                                throw new zzsg("Cannot access credential-protected data from direct boot");
                            }
                        }
                    }
                    return file;
                }
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
            case 97434231:
                if (str2.equals("files")) {
                    externalFilesDir = zzry.zza(context);
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzky.zzc(context)) {
                        synchronized (this.zzc) {
                            if (this.zzd == null) {
                                this.zzd = zzry.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                            }
                            str = this.zzd;
                            if (!file.getAbsolutePath().startsWith(str)) {
                                throw new zzsg("Cannot access credential-protected data from direct boot");
                            }
                        }
                    }
                    return file;
                }
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
            case 835260319:
                if (str2.equals("managed")) {
                    File file2 = new File(zzry.zza(context), "managed");
                    if (arrayList.size() >= 3) {
                        try {
                            String str3 = (String) arrayList.get(2);
                            Account account2 = zzrv.zza;
                            if ("shared".equals(str3)) {
                                account = zzrv.zza;
                            } else {
                                int iIndexOf = str3.indexOf(58);
                                zzsq.zza(iIndexOf >= 0, "Malformed account", new Object[0]);
                                account = new Account(str3.substring(iIndexOf + 1), str3.substring(0, iIndexOf));
                            }
                            if (!zzrv.zza.equals(account)) {
                                throw new zzsi("AccountManager cannot be null");
                            }
                        } catch (IllegalArgumentException e) {
                            throw new zzsi(e);
                        }
                    }
                    externalFilesDir = file2;
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzky.zzc(context)) {
                        synchronized (this.zzc) {
                            if (this.zzd == null) {
                                this.zzd = zzry.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                            }
                            str = this.zzd;
                            if (!file.getAbsolutePath().startsWith(str)) {
                                throw new zzsg("Cannot access credential-protected data from direct boot");
                            }
                        }
                    }
                    return file;
                }
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
            case 988548496:
                if (str2.equals("directboot-cache")) {
                    externalFilesDir = context.createDeviceProtectedStorageContext().getCacheDir();
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzky.zzc(context)) {
                        synchronized (this.zzc) {
                            if (this.zzd == null) {
                                this.zzd = zzry.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                            }
                            str = this.zzd;
                            if (!file.getAbsolutePath().startsWith(str)) {
                                throw new zzsg("Cannot access credential-protected data from direct boot");
                            }
                        }
                    }
                    return file;
                }
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
            case 991565957:
                if (str2.equals("directboot-files")) {
                    externalFilesDir = context.createDeviceProtectedStorageContext().getFilesDir();
                    file = new File(externalFilesDir, TextUtils.join(File.separator, arrayList.subList(1, arrayList.size())));
                    if (!zzky.zzc(context)) {
                        synchronized (this.zzc) {
                            if (this.zzd == null) {
                                this.zzd = zzry.zza(context.createDeviceProtectedStorageContext()).getParentFile().getAbsolutePath();
                            }
                            str = this.zzd;
                            if (!file.getAbsolutePath().startsWith(str)) {
                                throw new zzsg("Cannot access credential-protected data from direct boot");
                            }
                        }
                    }
                    return file;
                }
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
            default:
                throw new zzsi(String.format("Path must start with a valid logical location: %s", uri));
        }
    }
}
