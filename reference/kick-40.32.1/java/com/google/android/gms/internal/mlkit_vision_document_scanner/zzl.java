package com.google.android.gms.internal.mlkit_vision_document_scanner;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import io.ktor.http.LinkHeader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzl {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        zzc = new String[]{LinkHeader.Parameters.Media, (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("ranchu")) ? "androidx.test.services.storage.runfiles" : ""};
        zzd = new String[]{Build.VERSION.SDK_INT <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : "", Build.VERSION.SDK_INT <= 25 ? "com.google.android.inputmethod.latin.dev.inputcontent" : "", "com.google.android.apps.docs.storage.legacy"};
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01bc A[Catch: IOException -> 0x0204, FileNotFoundException -> 0x0213, TryCatch #3 {FileNotFoundException -> 0x0213, IOException -> 0x0204, blocks: (B:68:0x0115, B:71:0x0134, B:73:0x013c, B:75:0x0144, B:77:0x014c, B:79:0x0154, B:81:0x015d, B:110:0x01ce, B:112:0x01d4, B:87:0x0179, B:89:0x017f, B:91:0x0185, B:94:0x0190, B:96:0x019d, B:98:0x01a1, B:101:0x01ac, B:102:0x01af, B:104:0x01bc, B:106:0x01c0, B:109:0x01cb, B:84:0x016a, B:114:0x01da, B:115:0x01e7, B:116:0x01e8, B:117:0x01f5, B:118:0x01f6, B:119:0x0203), top: B:133:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01c0 A[Catch: IOException -> 0x0204, FileNotFoundException -> 0x0213, TryCatch #3 {FileNotFoundException -> 0x0213, IOException -> 0x0204, blocks: (B:68:0x0115, B:71:0x0134, B:73:0x013c, B:75:0x0144, B:77:0x014c, B:79:0x0154, B:81:0x015d, B:110:0x01ce, B:112:0x01d4, B:87:0x0179, B:89:0x017f, B:91:0x0185, B:94:0x0190, B:96:0x019d, B:98:0x01a1, B:101:0x01ac, B:102:0x01af, B:104:0x01bc, B:106:0x01c0, B:109:0x01cb, B:84:0x016a, B:114:0x01da, B:115:0x01e7, B:116:0x01e8, B:117:0x01f5, B:118:0x01f6, B:119:0x0203), top: B:133:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x01d4 A[Catch: IOException -> 0x0204, FileNotFoundException -> 0x0213, TryCatch #3 {FileNotFoundException -> 0x0213, IOException -> 0x0204, blocks: (B:68:0x0115, B:71:0x0134, B:73:0x013c, B:75:0x0144, B:77:0x014c, B:79:0x0154, B:81:0x015d, B:110:0x01ce, B:112:0x01d4, B:87:0x0179, B:89:0x017f, B:91:0x0185, B:94:0x0190, B:96:0x019d, B:98:0x01a1, B:101:0x01ac, B:102:0x01af, B:104:0x01bc, B:106:0x01c0, B:109:0x01cb, B:84:0x016a, B:114:0x01da, B:115:0x01e7, B:116:0x01e8, B:117:0x01f5, B:118:0x01f6, B:119:0x0203), top: B:133:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x01af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x01ac A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x01cb A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0179 A[Catch: IOException -> 0x0204, FileNotFoundException -> 0x0213, TryCatch #3 {FileNotFoundException -> 0x0213, IOException -> 0x0204, blocks: (B:68:0x0115, B:71:0x0134, B:73:0x013c, B:75:0x0144, B:77:0x014c, B:79:0x0154, B:81:0x015d, B:110:0x01ce, B:112:0x01d4, B:87:0x0179, B:89:0x017f, B:91:0x0185, B:94:0x0190, B:96:0x019d, B:98:0x01a1, B:101:0x01ac, B:102:0x01af, B:104:0x01bc, B:106:0x01c0, B:109:0x01cb, B:84:0x016a, B:114:0x01da, B:115:0x01e7, B:116:0x01e8, B:117:0x01f5, B:118:0x01f6, B:119:0x0203), top: B:133:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0190 A[Catch: IOException -> 0x0204, FileNotFoundException -> 0x0213, TryCatch #3 {FileNotFoundException -> 0x0213, IOException -> 0x0204, blocks: (B:68:0x0115, B:71:0x0134, B:73:0x013c, B:75:0x0144, B:77:0x014c, B:79:0x0154, B:81:0x015d, B:110:0x01ce, B:112:0x01d4, B:87:0x0179, B:89:0x017f, B:91:0x0185, B:94:0x0190, B:96:0x019d, B:98:0x01a1, B:101:0x01ac, B:102:0x01af, B:104:0x01bc, B:106:0x01c0, B:109:0x01cb, B:84:0x016a, B:114:0x01da, B:115:0x01e7, B:116:0x01e8, B:117:0x01f5, B:118:0x01f6, B:119:0x0203), top: B:133:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x019d A[Catch: IOException -> 0x0204, FileNotFoundException -> 0x0213, TryCatch #3 {FileNotFoundException -> 0x0213, IOException -> 0x0204, blocks: (B:68:0x0115, B:71:0x0134, B:73:0x013c, B:75:0x0144, B:77:0x014c, B:79:0x0154, B:81:0x015d, B:110:0x01ce, B:112:0x01d4, B:87:0x0179, B:89:0x017f, B:91:0x0185, B:94:0x0190, B:96:0x019d, B:98:0x01a1, B:101:0x01ac, B:102:0x01af, B:104:0x01bc, B:106:0x01c0, B:109:0x01cb, B:84:0x016a, B:114:0x01da, B:115:0x01e7, B:116:0x01e8, B:117:0x01f5, B:118:0x01f6, B:119:0x0203), top: B:133:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01a1 A[Catch: IOException -> 0x0204, FileNotFoundException -> 0x0213, TryCatch #3 {FileNotFoundException -> 0x0213, IOException -> 0x0204, blocks: (B:68:0x0115, B:71:0x0134, B:73:0x013c, B:75:0x0144, B:77:0x014c, B:79:0x0154, B:81:0x015d, B:110:0x01ce, B:112:0x01d4, B:87:0x0179, B:89:0x017f, B:91:0x0185, B:94:0x0190, B:96:0x019d, B:98:0x01a1, B:101:0x01ac, B:102:0x01af, B:104:0x01bc, B:106:0x01c0, B:109:0x01cb, B:84:0x016a, B:114:0x01da, B:115:0x01e7, B:116:0x01e8, B:117:0x01f5, B:118:0x01f6, B:119:0x0203), top: B:133:0x0115 }] */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
    
        if (r13.zzd == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        if (r13.zzd != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.InputStream zza(final android.content.Context r11, android.net.Uri r12, com.google.android.gms.internal.mlkit_vision_document_scanner.zzk r13) throws java.io.FileNotFoundException {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_document_scanner.zzl.zza(android.content.Context, android.net.Uri, com.google.android.gms.internal.mlkit_vision_document_scanner.zzk):java.io.InputStream");
    }

    private static String zzb(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith(DomExceptionUtils.SEPARATOR) ? String.valueOf(canonicalPath).concat(DomExceptionUtils.SEPARATOR) : canonicalPath;
    }

    private static void zzc(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            fileNotFoundException.addSuppressed(e);
        }
    }

    private static File[] zzd(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
