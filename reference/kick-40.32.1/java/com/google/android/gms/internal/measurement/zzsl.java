package com.google.android.gms.internal.measurement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsl extends zzsn implements zzsf {
    private final FileInputStream zza;
    private final File zzb;

    private zzsl(FileInputStream fileInputStream, File file) {
        super(fileInputStream);
        this.zza = fileInputStream;
        this.zzb = file;
    }

    public static zzsl zzb(File file) throws FileNotFoundException {
        return new zzsl(new FileInputStream(file), file);
    }

    @Override // com.google.android.gms.internal.measurement.zzsf
    public final File zza() {
        return this.zzb;
    }
}
