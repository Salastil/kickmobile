package com.google.mlkit.vision.documentscanner;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes8.dex */
public class GmsDocumentScannerOptions {
    public static final int CAPTURE_MODE_AUTO = 1;
    public static final int CAPTURE_MODE_MANUAL = 2;
    public static final GmsDocumentScannerOptions DEFAULT_OPTIONS = new Builder().build();
    public static final int RESULT_FORMAT_JPEG = 101;
    public static final int RESULT_FORMAT_PDF = 102;
    public static final int SCANNER_MODE_BASE = 3;
    public static final int SCANNER_MODE_BASE_WITH_FILTER = 2;
    public static final int SCANNER_MODE_FULL = 1;
    private final boolean zzd;
    private final int zze;
    private final int[] zzf;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final List zza = null;
    private final int zzb = 1;
    private final boolean zzc = true;
    private final zzj zzg = null;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
    public static class Builder {
        private boolean zza = true;
        private int zzb = -1;
        private int[] zzc = {101};
        private boolean zzd = true;
        private boolean zze = true;
        private boolean zzf = true;
        private boolean zzg = true;

        public GmsDocumentScannerOptions build() {
            return new GmsDocumentScannerOptions(this, null);
        }

        public Builder setGalleryImportAllowed(boolean z) {
            this.zza = z;
            return this;
        }

        public Builder setPageLimit(int i) {
            Preconditions.checkArgument(i > 0, "pageLimit should be be greater than or equal to 1");
            this.zzb = i;
            return this;
        }

        public Builder setResultFormats(int i, int... iArr) {
            Preconditions.checkArgument(iArr != null, "moreFormats cannot be null");
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
            this.zzc = iArrCopyOf;
            iArrCopyOf[length] = i;
            return this;
        }

        public Builder setScannerMode(int i) {
            if (i == 1) {
                this.zzd = true;
                this.zze = true;
                this.zzf = true;
                this.zzg = true;
                return this;
            }
            if (i == 2) {
                this.zzd = false;
                this.zze = true;
                this.zzf = true;
                this.zzg = false;
                return this;
            }
            if (i != 3) {
                throw new IllegalArgumentException("Invalid scanner mode: " + i);
            }
            this.zzd = false;
            this.zze = false;
            this.zzf = false;
            this.zzg = false;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
    @Retention(RetentionPolicy.CLASS)
    public @interface CaptureMode {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ResultFormat {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ScannerMode {
    }

    /* synthetic */ GmsDocumentScannerOptions(Builder builder, zzk zzkVar) {
        this.zzd = builder.zza;
        this.zze = builder.zzb;
        this.zzf = builder.zzc;
        this.zzh = builder.zzd;
        this.zzi = builder.zze;
        this.zzj = builder.zzf;
        this.zzk = builder.zzg;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GmsDocumentScannerOptions)) {
            return false;
        }
        GmsDocumentScannerOptions gmsDocumentScannerOptions = (GmsDocumentScannerOptions) obj;
        List list = gmsDocumentScannerOptions.zza;
        if (Objects.equal(null, null)) {
            int i = gmsDocumentScannerOptions.zzb;
            boolean z = gmsDocumentScannerOptions.zzc;
            if (this.zzd == gmsDocumentScannerOptions.zzd && this.zze == gmsDocumentScannerOptions.zze && Arrays.equals(this.zzf, gmsDocumentScannerOptions.zzf)) {
                zzj zzjVar = gmsDocumentScannerOptions.zzg;
                if (Objects.equal(null, null) && this.zzh == gmsDocumentScannerOptions.zzh && this.zzi == gmsDocumentScannerOptions.zzi && this.zzj == gmsDocumentScannerOptions.zzj && this.zzk == gmsDocumentScannerOptions.zzk) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(null, 1, true, Boolean.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), null, Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk));
    }

    public final int zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzh;
    }

    public final boolean zzc() {
        return this.zzi;
    }

    public final boolean zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzk;
    }

    public final int[] zzg() {
        return this.zzf;
    }
}
