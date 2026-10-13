package com.google.android.gms.internal.pal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zztq implements FilenameFilter {
    private final Pattern zza;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return this.zza.matcher(str).matches();
    }

    public zztq(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }
}
