package com.google.mlkit.vision.documentscanner.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzlq;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzmk;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzml;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzmm;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zznu;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrk;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrm;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrn;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzrv;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public class GmsDocumentScanningDelegateActivity extends ComponentActivity {
    private final zzrk zza = zzrv.zzb("play-services-mlkit-document-scanner");
    private final zzrm zzb = zzrm.zza(MlKitContext.getInstance().getApplicationContext());
    private zzlq zzc;
    private long zzd;
    private long zze;

    static Intent zza(Context context, Intent intent) {
        Intent action = new Intent().setPackage("com.google.android.gms").setAction("com.google.android.gms.mlkit.ACTION_SCAN_DOCUMENT");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return action.putExtra("string_extra_calling_app_name", i != 0 ? context.getString(i) : context.getPackageManager().getApplicationLabel(applicationInfo).toString()).putExtras(intent).setFlags(1);
    }

    private final void zzd() throws Throwable {
        setResult(0);
        zze(zzmk.CANCELLED, 0);
        finish();
    }

    private final void zze(zzmk zzmkVar, int i) throws Throwable {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzmm zzmmVar = new zzmm();
        zznu zznuVar = new zznu();
        zznuVar.zzc(Long.valueOf(jElapsedRealtime - this.zzd));
        zznuVar.zzd(zzmkVar);
        zznuVar.zze(this.zzc);
        zznuVar.zzf(Integer.valueOf(i));
        zzmmVar.zzd(zznuVar.zzg());
        this.zza.zzc(zzrn.zze(zzmmVar), zzml.ON_DEVICE_DOCUMENT_SCANNER_UI_FINISH);
        this.zzb.zzc(24335, zzmkVar.zza(), this.zze, jCurrentTimeMillis);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        this.zzc = zzf.zza(getIntent());
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.google.mlkit.vision.documentscanner.internal.zze
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                final GmsDocumentScanningDelegateActivity gmsDocumentScanningDelegateActivity = this.zza;
                ActivityResult activityResult = (ActivityResult) obj;
                zzh.zzc(gmsDocumentScanningDelegateActivity.getApplicationContext()).zzb(activityResult.getResultCode(), activityResult.getData()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.mlkit.vision.documentscanner.internal.zzc
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj2) throws Throwable {
                        gmsDocumentScanningDelegateActivity.zzb((GmsDocumentScanningResult) obj2);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.google.mlkit.vision.documentscanner.internal.zzd
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) throws Throwable {
                        gmsDocumentScanningDelegateActivity.zzc(exc);
                    }
                });
            }
        });
        if (bundle != null) {
            this.zzd = bundle.getLong("elapsedStartTimeMsKey");
            this.zze = bundle.getLong("epochStartTimeMsKey");
            return;
        }
        this.zzd = SystemClock.elapsedRealtime();
        this.zze = System.currentTimeMillis();
        zzrk zzrkVar = this.zza;
        zzmm zzmmVar = new zzmm();
        zznu zznuVar = new zznu();
        zznuVar.zze(this.zzc);
        zzmmVar.zze(zznuVar.zzg());
        zzrkVar.zzc(zzrn.zze(zzmmVar), zzml.ON_DEVICE_DOCUMENT_SCANNER_UI_START);
        activityResultLauncherRegisterForActivityResult.launch(zza(this, getIntent()));
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("elapsedStartTimeMsKey", this.zzd);
        bundle.putLong("epochStartTimeMsKey", this.zze);
    }

    final /* synthetic */ void zzb(GmsDocumentScanningResult gmsDocumentScanningResult) throws Throwable {
        int pageCount;
        if (gmsDocumentScanningResult == null) {
            zzd();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_scanning_result", gmsDocumentScanningResult);
        setResult(-1, intent);
        List<GmsDocumentScanningResult.Page> pages = gmsDocumentScanningResult.getPages();
        GmsDocumentScanningResult.Pdf pdf = gmsDocumentScanningResult.getPdf();
        if (pages != null) {
            pageCount = pages.size();
        } else {
            pageCount = pdf != null ? pdf.getPageCount() : 0;
        }
        zze(zzmk.NO_ERROR, pageCount);
        finish();
    }

    final /* synthetic */ void zzc(Exception exc) throws Throwable {
        if (Log.isLoggable("GmsDocScanDelAct", 6)) {
            Log.e("GmsDocScanDelAct", "Failed to handle scanning result", exc);
        }
        zzd();
    }
}
