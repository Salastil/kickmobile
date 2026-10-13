package com.google.mlkit.vision.documentscanner.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzaa;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzlq;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzmk;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzml;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzmm;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zznu;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrk;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrm;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrn;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.documentscanner.GmsDocumentScanner;
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzb implements GmsDocumentScanner {
    private static boolean zza;
    private static int zzb;
    private final GmsDocumentScannerOptions zzc;
    private final Feature[] zzd;
    private final zzlq zze;
    private final zzrk zzf;
    private final zzrm zzg;

    public zzb(GmsDocumentScannerOptions gmsDocumentScannerOptions) {
        zzrk zzrkVarZzb = zzrv.zzb("play-services-mlkit-document-scanner");
        zzrm zzrmVarZza = zzrm.zza(MlKitContext.getInstance().getApplicationContext());
        this.zzc = gmsDocumentScannerOptions;
        this.zze = zzf.zzb(gmsDocumentScannerOptions);
        this.zzg = zzrmVarZza;
        this.zzf = zzrkVarZzb;
        zzaa zzaaVar = new zzaa();
        zzaaVar.zza(OptionalModuleUtils.FEATURE_DOCSCAN_UI);
        if (gmsDocumentScannerOptions.zze()) {
            zzaaVar.zza(OptionalModuleUtils.FEATURE_DOCSCAN_SHADOW_REMOVAL);
        }
        if (gmsDocumentScannerOptions.zzf()) {
            zzaaVar.zza(OptionalModuleUtils.FEATURE_DOCSCAN_STAIN_REMOVAL);
        }
        this.zzd = (Feature[]) zzaaVar.zzb().toArray(new Feature[0]);
    }

    private static void zza(String str) {
        if (Log.isLoggable("GmsDocumentScannerImpl", 3)) {
            Log.d("GmsDocumentScannerImpl", str);
        }
    }

    private final void zzb(zzmk zzmkVar, long j, long j2) throws Throwable {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzmm zzmmVar = new zzmm();
        zznu zznuVar = new zznu();
        zznuVar.zzc(Long.valueOf(jElapsedRealtime - j));
        zznuVar.zzd(zzmkVar);
        zznuVar.zze(this.zze);
        zzmmVar.zzd(zznuVar.zzg());
        this.zzf.zzc(zzrn.zze(zzmmVar), zzml.ON_DEVICE_DOCUMENT_SCANNER_UI_FINISH);
        this.zzg.zzc(24335, zzmkVar.zza(), j2, jCurrentTimeMillis);
    }

    @Override // com.google.android.gms.common.api.OptionalModuleApi
    public final Feature[] getOptionalFeatures() {
        return this.zzd;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x007f  */
    /* JADX WARN: Code duplicated, block: B:14:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:16:0x00be  */
    /* JADX WARN: Code duplicated, block: B:17:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:20:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:21:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:8:0x007b  */
    @Override // com.google.mlkit.vision.documentscanner.GmsDocumentScanner
    public final Task<IntentSender> getStartScanIntent(Activity activity) throws Throwable {
        int apkVersion;
        Task<IntentSender> taskForException;
        boolean z;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context applicationContext = activity.getApplicationContext();
        zzmm zzmmVar = new zzmm();
        zznu zznuVar = new zznu();
        zznuVar.zze(this.zze);
        zzmmVar.zzc(zznuVar.zzg());
        this.zzf.zzc(zzrn.zze(zzmmVar), zzml.ON_DEVICE_DOCUMENT_SCANNER_UI_CREATE);
        ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
        if (activityManager == null) {
            if (!zza) {
                OptionalModuleUtils.requestDownload(applicationContext, this.zzd);
                zza = true;
            }
            apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext);
            zza("gmsVersion=" + apkVersion);
            if (apkVersion < 233900000) {
                zzb(zzmk.GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, jElapsedRealtime, jCurrentTimeMillis);
                taskForException = Tasks.forException(new MlKitException("Feature not available in the current version of the Google Play services", 14));
            } else {
                if (new Intent().setPackage("com.google.android.gms").setAction("com.google.android.gms.mlkit.ACTION_SCAN_DOCUMENT").resolveActivity(applicationContext.getPackageManager()) != null) {
                    z = true;
                } else {
                    z = false;
                }
                zza("isDocScanActivityAvailable=" + z);
                if (z) {
                    taskForException = null;
                } else {
                    zzb(zzmk.GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, jElapsedRealtime, jCurrentTimeMillis);
                    taskForException = Tasks.forException(new MlKitException("Feature not available in the current version of the Google Play services", 14));
                }
            }
        } else {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            float f = memoryInfo.totalMem;
            StringBuilder sb = new StringBuilder("total RAM (GB) = ");
            float f2 = ((f / 1024.0f) / 1024.0f) / 1024.0f;
            sb.append(f2);
            zza(sb.toString());
            if (f2 < 1.7f) {
                zzb(zzmk.LOW_MEMORY, jElapsedRealtime, jCurrentTimeMillis);
                taskForException = Tasks.forException(new MlKitException("Device RAM is below the minimal requirement for this feature: 1.7 GB", 18));
            } else {
                if (!zza) {
                    OptionalModuleUtils.requestDownload(applicationContext, this.zzd);
                    zza = true;
                }
                apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext);
                zza("gmsVersion=" + apkVersion);
                if (apkVersion < 233900000) {
                    zzb(zzmk.GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, jElapsedRealtime, jCurrentTimeMillis);
                    taskForException = Tasks.forException(new MlKitException("Feature not available in the current version of the Google Play services", 14));
                } else {
                    if (new Intent().setPackage("com.google.android.gms").setAction("com.google.android.gms.mlkit.ACTION_SCAN_DOCUMENT").resolveActivity(applicationContext.getPackageManager()) != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zza("isDocScanActivityAvailable=" + z);
                    if (z) {
                        taskForException = null;
                    } else {
                        zzb(zzmk.GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, jElapsedRealtime, jCurrentTimeMillis);
                        taskForException = Tasks.forException(new MlKitException("Feature not available in the current version of the Google Play services", 14));
                    }
                }
            }
        }
        if (taskForException != null) {
            return taskForException;
        }
        zza zzaVar = new zza(this);
        Bundle bundle = new Bundle();
        bundle.putBinder("bundle_binder_extra_callbacks", zzaVar);
        Intent intentPutExtra = new Intent(activity, (Class<?>) GmsDocumentScanningDelegateActivity.class).putExtra("boolean_extra_request_uris_in_result_intent", true);
        GmsDocumentScannerOptions gmsDocumentScannerOptions = this.zzc;
        Intent intentPutExtra2 = intentPutExtra.putExtras(new Intent().putParcelableArrayListExtra("uri_array_extra_initial_image_uris", null).putExtra("int_extra_default_capture_mode", 1).putExtra("boolean_extra_flash_mode_change_allowed", true).putExtra("boolean_extra_gallery_import_allowed", gmsDocumentScannerOptions.zzd()).putExtra("int_extra_page_limit_max", gmsDocumentScannerOptions.zza()).putExtra("boolean_extra_page_edit_listener_enabled", false).putExtra("int_array_extra_result_formats", gmsDocumentScannerOptions.zzg()).putExtra("boolean_extra_enable_all_new_features_by_default", gmsDocumentScannerOptions.zzb()).putExtra("boolean_extra_filter_allowed", gmsDocumentScannerOptions.zzc()).putExtra("boolean_extra_shadow_removal_allowed", gmsDocumentScannerOptions.zze()).putExtra("boolean_extra_stain_removal_allowed", gmsDocumentScannerOptions.zzf())).setFlags(1).putExtra("bundle_binder_extra_callbacks", bundle);
        if (applicationContext.getPackageName().equals("com.google.android.gms")) {
            intentPutExtra2 = GmsDocumentScanningDelegateActivity.zza(applicationContext, intentPutExtra2).setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.mlkit.docscan.ui.DocumentScanningActivity"));
        }
        int i = zzb;
        zzb = i + 1;
        PendingIntent pendingIntentZza = com.google.android.gms.internal.mlkit_vision_document_scanner.zzd.zza(activity, i, intentPutExtra2, 67108864, 0);
        if (pendingIntentZza != null) {
            return Tasks.forResult(pendingIntentZza.getIntentSender());
        }
        zzb(zzmk.UNKNOWN_ERROR, jElapsedRealtime, jCurrentTimeMillis);
        return Tasks.forException(new MlKitException("Failed to create IntentSender", 13));
    }
}
